package driver;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;

import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import tests.BaseTest;

/**
 * Класс помощник для переключения драйвера на Web версию и открытие браузера (например, chrome)
 */
public class WebDriverHelper extends BaseTest {
    public static void setWebDriver() {
        // Установка версии браузера через System.setProperty
        System.setProperty("selenide.browserVersion", "114.0.5735.199");

        SelenideConfig config = new SelenideConfig()
                .browser("chrome")
                .browserVersion(System.getProperty("selenide.browserVersion"));

        // Дополнительные настройки, как указано ранее
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        config.browserCapabilities().setCapability(ChromeOptions.CAPABILITY, options);

        SelenideDriver driver = new SelenideDriver(config);
        WebDriverRunner.setWebDriver(driver.getAndCheckWebDriver());


//        // Используем WebDriverManager для управления драйверами
//        WebDriverManager.chromedriver().setup();
//
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//
//        Configuration.browserCapabilities = capabilities;
    }
}