package driver;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;

import javax.xml.crypto.Data;

import helper.DataHelper;
import pages.web.LoginPageWeb;

/**
 * Класс помощник для переключения драйвера на Web версию, открытие и закрытие браузера (например, chrome)
 */
public class WebDriverHelper {

    public static LoginPageWeb setWebDriver() {
        SelenideConfig config = new SelenideConfig().browser("chrome").browserSize("1680x1050");
        SelenideDriver driver = new SelenideDriver(config);
        WebDriverRunner.setWebDriver(driver.getAndCheckWebDriver());
        open(DataHelper.getUrlInfo().getUrl());
        return new LoginPageWeb();
    }

    public static void tearDownWeb() {
        WebDriverRunner.getWebDriver().close();
    }
}