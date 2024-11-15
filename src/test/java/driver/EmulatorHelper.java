package driver;
//Взаимодействуем с драйвером через методы

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;
import static com.codeborne.selenide.appium.SelenideAppium.$x;
import static org.openqa.selenium.By.xpath;
import static config.ConfigReader.platformAndroid;
import static config.ConfigReader.platformIOS;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Класс помощник для Page страниц
 */
public class EmulatorHelper extends EmulatorDriver { //Наследуемся от класса EmulatorDriver, поэтому есть доступ к переменной driver

    //Приватный конструктор, который предотвращает создание экземпляров.
    private EmulatorHelper() {
    }

    /**
     * Нажимает кнопку назад
     */
    public static void goBack() { //Метод для перехода назад
        driver.navigate().back();
    }

    /**
     * Закрывает клавиатуру если она есть
     */
    public static void closeKeyBoard() { //Метод для закрытия клавиатуры
        if (platformAndroid) {
            AndroidDriver androidDriver = (AndroidDriver) driver;
            if (androidDriver.isKeyboardShown()) { //Если клавиатура открыта, то далее закрываем ее
                androidDriver.hideKeyboard();
            }
        } else if (platformIOS) {
            IOSDriver iosDriver = (IOSDriver) driver;
            if (iosDriver.isKeyboardShown()) { //Если клавиатура открыта, то далее закрываем ее
                iosDriver.hideKeyboard();
            }
        }
    }

    /**
     * Вводит текст и нажимает Enter (Enter при необходимости; можно также и другие команды подставить)
     *
     * @param element поле для ввода
     * @param text    текст
     */
    public static void sendKeysAndFind(SelenideElement element, String text) { //Метод для ввода данных в поля
        element.sendKeys(text);
//        driver.pressKey(new KeyEvent(AndroidKey.ENTER)); //Вызываем метод для нажатия кнопки ENTER
    }

    /**
     * Листает к элементу по его тексту без нажатия
     *
     * @param text текст на элементе
     */
    public static void androidScrollToAnElementByText(SelenideAppiumElement element, String text) { // Метод для скроллинга к методу, который определен по тексту
// Получаем границы элемента
        Rectangle bounds = element.getRect();

// Вычисляем центр элемента
        int centerX = bounds.getX() + bounds.getWidth() / 2;
        int centerY = bounds.getY() + bounds.getHeight() / 2;

// Находим элемент с указанным текстом
        SelenideElement textElement = element.$(By.xpath(".//*[contains(@text, '" + text + "')]")).as(String.valueOf(SelenideAppiumElement.class));

// Вычисляем смещение для свайпа к элементу с текстом
        int offsetX = textElement.getWrappedElement().getRect().getX() - centerX;
        int offsetY = textElement.getWrappedElement().getRect().getY() - centerY;

// Определяем направление свайпа
        String direction = offsetY > 0 ? "down" : "up";

        String elementId = ((RemoteWebElement) textElement.getWrappedElement()).getId();

// Свайпаем к элементу с текстом
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", elementId);
        params.put("percentage", 0.5); // процент смещения
        params.put("direction", direction);

        driver.executeScript("gesture: swipe", params);
    }

    /**
     * Имитирует свайп для обновления страницы (например, потянуть вниз).
     * Для использования передаем: xpath-локатор элемента в параметры; направление: right, left, down, up; процент смахивания относительно ширины или высоты
     */
    public static void swipe(SelenideAppiumElement element, String direction, int percent) {
        String elementId = ((RemoteWebElement) element.getWrappedElement()).getId();

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", elementId);
        params.put("percentage", percent);
        params.put("direction", direction);

        // Выполняем свайп
        driver.executeScript("gesture: swipe", params);
    }

    /**
     * Метод для клика с задержкой
     */
    public static void slowClick(SelenideAppiumElement element) {
        actions().moveToElement(element).pause(5000).click().perform(); // Задержка в 5 секунд (5000 миллисекунд)
    }

    /**
     * Метод для обращения по xpath
     *
     * @param xpath
     * @return
     */
    public static SelenideAppiumElement elementByXpath(String xpath) {
        return $x(xpath);
    }

    /**
     * Метод для обращения по коллекции xpath
     *
     * @param xpath
     * @return
     */
    public static SelenideAppiumCollection collectionByXpath(String xpath) {
        return $$(xpath(xpath));
    }

    /**
     * Метод для обращения по xpath(resourceId)
     *
     * @param resourceId
     * @return
     */
    public static SelenideAppiumElement elementByResourceId(String resourceId) {
        return $x("//*[@resource-id='" + resourceId + "']");
    }

    /**
     * Метод для обращения по коллекции xpath(resourceId)
     *
     * @param resourceId
     * @return
     */
    public static SelenideAppiumCollection collectionByResourceId(String resourceId) {
        return $$(xpath("//*[@resource-id='" + resourceId + "']"));
    }


    /**
     * Метод для обращения по className
     *
     * @param className
     * @return
     */
    public static SelenideAppiumElement elementByClass(String className) {
        return $x("//" + className);
    }

    /**
     * Метод для обращения по коллекции className
     *
     * @param className
     * @return
     */
    public static SelenideAppiumCollection collectionByClass(String className) {
        return $$(xpath("//" + className));
    }

    /**
     * Метод для обращения по xpath(text)
     *
     * @param text
     * @return
     */
    public static SelenideAppiumElement elementByXpathText(String text) {
        return $x("//*[@text='" + text + "']");
    }

    /**
     * Метод для обращения по коллекции xpath(text)
     *
     * @param text
     * @return
     */
    public static SelenideAppiumCollection collectionByXpathText(String text) {
        return $$(xpath("//*[@text='" + text + "']"));
    }

    /**
     * Метод для обращения по xpath(contentDesc)
     *
     * @param contentDesc
     * @return
     */
    public static SelenideAppiumElement elementByContentDesc(String contentDesc) {
        return $x("//*[@content-desc='" + contentDesc + "']");
    }

    /**
     * Метод для обращения по коллекции content-desc
     *
     * @param contentDesc
     * @return
     */
    public static SelenideAppiumCollection collectionByContentDesc(String contentDesc) {
        return $$(xpath("//*[@content-desc='" + contentDesc + "']"));
    }

    /**
     * Метод для обращения по id
     *
     * @param id
     * @return
     */
    public static SelenideAppiumElement elementById(String id) {
        return $(By.id(id));
    }
}
