package pages.web;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

import helper.DataHelper;
import io.qameta.allure.Step;

/**
 * Страница авторизации "root" в браузере
 */
public class LoginPageWeb {
    private final SelenideAppiumElement titleText = $(By.cssSelector("h1"));
    private final SelenideAppiumElement loginType = $(By.cssSelector("#RootLoginForm_login"));
    private final SelenideAppiumElement passType = $(By.cssSelector("#RootLoginForm_password"));
    private final SelenideAppiumElement submit = $(By.cssSelector("input[type=submit]"));

    public LoginPageWeb() {
        titleText.shouldBe(visible);
    }

    @Step("заполнение формы логина зарегистрированными данными и переход в админку")
    public RootPageWeb validLogin() {
        var autoInfo = DataHelper.getUserInfoWeb();
        loginType.sendKeys(autoInfo.getLogin());
        passType.sendKeys(autoInfo.getPassword());
        submit.click();
        return new RootPageWeb();
    }
}
