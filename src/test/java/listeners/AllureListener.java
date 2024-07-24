package listeners;

import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;

import java.lang.reflect.Method;

import io.qameta.allure.Attachment;

/**
 * Кастомный листенер для переопределения логики завершения теста
 */
public class AllureListener implements AfterTestExecutionCallback { //Имплементация прослушки теста

    /**
     * Метод добавления скриншота в аллюра отчета через аннотацию
     *
     * @param screenShot байты скриншотов
     * @return
     */
    @Attachment(value = "Page screenshot", type = "image/png")
    //Сохраняем байты в виде .png и называем Page screenshot
    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot; //Возвращаем скриншот в случае падения теста (логика данного метода зашита в аннотации
    }

    /**
     * Переопределение логики завершения тестов у juni5
     *
     * @param context контекст теста
     */
    @Override
    public void afterTestExecution(ExtensionContext context) { //Метод, который смотрит на логику завершения теста, который получает контекст текущего теста
        Method testMethod = context.getRequiredTestMethod(); //Получаем тестовый метод
        String testName = testMethod.getName(); //Извлекаем из тестового метода название
        boolean testFailed = context.getExecutionException().isPresent(); //Проверяем упал тест или нет
        if (testFailed) {
            if (!testName.contains("Screenshot")) { //Если тест упал и не содержит слово "скриншот", то делаем скриншот и прикрепляем его к allure
                saveScreenshot(Selenide.screenshot(OutputType.BYTES));
            }
        }
    }
}
