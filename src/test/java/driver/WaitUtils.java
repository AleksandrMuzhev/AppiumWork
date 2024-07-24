package driver;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 Вспомогательный класс для использования явного ожидания действий над элементами
*/
public class WaitUtils extends EmulatorDriver {

    // Метод для явного ожидания видимости элемента
    public static SelenideElement waitForElementVisibility(SelenideElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(EmulatorDriver.driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    // Метод для явного ожидания кликабельности элемента
    public static SelenideElement waitForElementToBeClickable(SelenideElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(EmulatorDriver.driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
