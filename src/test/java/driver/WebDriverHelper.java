package driver;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;

import tests.BaseTest;

/**
 * Класс помощник для переключения драйвера на Web версию и открытие браузера (например, chrome)
 */
public class WebDriverHelper extends BaseTest {
    public static void setWebDriver() {
        SelenideConfig config = new SelenideConfig().browser("chrome").browserSize("1680x1050");
        SelenideDriver driver = new SelenideDriver(config);
        WebDriverRunner.setWebDriver(driver.getAndCheckWebDriver());
    }
}