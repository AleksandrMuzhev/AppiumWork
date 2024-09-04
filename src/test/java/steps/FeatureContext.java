package steps;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static driver.WebDriverHelper.setWebDriver;
import static pages.AuthPage.authRegisterDate;

import com.codeborne.selenide.WebDriverRunner;

import org.openqa.selenium.By;

import java.time.Duration;

import driver.EmulatorDriver;
import driver.EmulatorHelper;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import tests.BaseTest;

public class FeatureContext extends BaseTest {

    @Допустим("открываю приложение")
    @Before
    public void setUp() {
        if (driver == null) {
            driver = (AppiumDriver) new EmulatorDriver().createDriver(null);
            WebDriverRunner.setWebDriver(driver);
        }
    }

    @Допустим("открываю браузер")
    public void switchBrowser() {
        setWebDriver();
    }

    @Затем("закрываю приложение")
    @After
    public void tearDown() {
        driver.quit();
    }

    @Пусть("кликаю на {string}")
    public void iClickOnButton(String string) {
        $(By.xpath("//*[contains(@text, '" + string + "')]")).shouldBe(visible, Duration.ofSeconds(5)).click();
    }

    @И("пользователь авторизуется с зарегистрированным данными")
    public void sendKeysToElement() {
        authRegisterDate();
    }

    @И("возвращаюсь назад")
    public void goBack() {
        EmulatorHelper.goBack();
    }

}
