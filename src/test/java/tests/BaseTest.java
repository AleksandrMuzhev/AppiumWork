package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static helper.Constants.SCREENSHOT_TO_SAVE_FOLDER;
import static helper.DeviceHelper.executeBash;
import static helper.RunHelper.runHelper;
import static io.qameta.allure.Allure.step;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import config.ConfigReader;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import listeners.AllureListener;

/**
 * Базовый тестовый класс
 */
@ExtendWith(AllureListener.class) //Расширяем класс с помощью класса AllureListener
public class BaseTest { //Базовый класс для Android-эмулятора

    @BeforeAll //Аннотация для выполнения метода 1 раз перед запуском всех тестов
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); //В SelenideLogger добавляем новую прослушку для логирования всех действия в Allure (в степах будут указаны действия, время и скриншот)

        //папка для сохранения скриншотов selenide
        Configuration.reportsFolder = SCREENSHOT_TO_SAVE_FOLDER; //Папка для сохранения исходного кода страниц или картинок была кастомной и не происходило перемещение в .gradle & .idea
        //Инициализация AndroidDriver, напрямую нигде не взаимодействуем. runHelper возвращает конструктор по-умолчанию и вызывает getDriverClass и получаем название device
        Configuration.browser = runHelper().getDriverClass().getName();
        Configuration.startMaximized = false; //Эмулятор не будет стартовать на весь экран
        Configuration.browserSize = null; //Не указываем размер, так как зависеть будет от устройства
        Configuration.timeout = 10000; //Ограничение по времени для взаимодействия с элементом
        disableAnimationOnEmulator(); //Вызываем метод в связи с тем, что ПК при запуске эмулятора может подвиснуть. При отключении настроек анимации проблема решается
    }

    /**
     * Отключение анимаций на эмуляторе чтобы не лагало
     */
    private static void disableAnimationOnEmulator() { //С помощью работы данного метода и указанных команд происходит ускорение работы эмулятора
        executeBash("adb -s shell settings put global transition_animation_scale 0.0"); //Отключаем анимацию
        executeBash("adb -s shell settings put global window_animation_scale 0.0"); //Отключаем анимацию при переключении в окнах
        executeBash("adb -s shell settings put global animator_duration_scale 0.0"); //Отключаем длительность этой анимации
    }

    /**
     * Проверка скриншота с эталоном для проверки верстки
     *
     * @param actualScreenshot актуальный скриншот
     * @param expectedFileName название файла для сравнений
     */
    public void assertScreenshot(File actualScreenshot, String expectedFileName) { //Метод для сравнения актуального и ожидаемого скриншота для проверки верстки экрана
        //в метод передается всегда название тестового метода, поэтому меняем скобки на файл с расширением для дальнейшего сохранения
        expectedFileName = expectedFileName.replace("()", ".png"); //Удаляем пустые скобки и добавляем расширение файла .png
        //папка для хранения эталонных скриншотов
        String expectedScreensDir = "src/test/resources/expectedScreenshots"; //Указываем папку, где будут храниться скриншоты, которые эталонные
        //если скриншоты надо обновить
        if (ConfigReader.testConfig.isScreenshotsNeedToUpdate()) { //Читаем настройки из тестового конфига (читаем ключ updateScreenshots)
            try {
                //перемещаем текущий скрншот в папку с эталоном и заменяем файл
                Files.move(actualScreenshot.toPath(), new File(expectedScreensDir + expectedFileName).toPath(), StandardCopyOption.REPLACE_EXISTING); //От существующего скриншота получаем путь, с помощью метода move перемещаем в папку, которая находится в expectedScreensDir
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return; //После обновления скриншотов завершаем метод
        }

        //если скриншот надо сравнить
        //Загружаем ожидаемое изображение для сравнения, если условие try не выполняется
        BufferedImage expectedImage = ImageComparisonUtil
                .readImageFromResources(expectedScreensDir + expectedFileName);

        //Загружаем актуальный скриншот, получили во время теста
        BufferedImage actualImage = ImageComparisonUtil
                .readImageFromResources(SCREENSHOT_TO_SAVE_FOLDER + actualScreenshot.getName());

        //Где будем хранить скриншот с различиями в случае падения теста, будет создан новый файл в виде картинки
        File resultDestination = new File("diff/diff_" + expectedFileName);

        //Сравниваем.
        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage, resultDestination) //Через утилиту создаем экземпляр сравнения, где указываем ожидаемое изображение, актуальное и куда будем сохранять сравнение
                .compareImages();

        //если скриншоты отличаются
        if (imageComparisonResult.getImageComparisonState().equals(ImageComparisonState.MISMATCH)) { //Условие используется, если картинки не получилось сравнить
            try {
                //добавляем скриншот с отличиями к аллюр отчету в виде степа
                byte[] diffImageBytes = Files.readAllBytes(resultDestination.toPath()); //Читаем картинки сравнения, которое нам генерирует библиотека
                AllureListener.saveScreenshot(diffImageBytes); //Прикрепляем скриншот к степу какому-то
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //сравниваем скриншоты
        assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState()); //Ожидаем, что результат будет совпадение и сравниваем, что получаем
    }

    /**
     * Перед каждый тестом открываем приложение
     */
    @BeforeEach
    public void startDriver() {
        step("Открыть приложение", (Allure.ThrowableRunnableVoid) Selenide::open);
    }

    /**
     * После каждого теста закрываем AndroidDriver чтобы тест атомарным был
     */
    @AfterEach //После каждого теста выполняем
    public void afterEach() {
        step("Закрыть приложение", Selenide::closeWebDriver);
    }


}
