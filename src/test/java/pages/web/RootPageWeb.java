package pages.web;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

/**
 * Страница админки в браузере
 */
public class RootPageWeb {
    private SelenideAppiumElement employeeLink;
    private final SelenideAppiumElement titleText = $(By.cssSelector("h1"));
    private final SelenideAppiumElement searchField = $(By.cssSelector("input[title=\"Что-нибудь - название, имя, емэйл\"]"));
    private final SelenideAppiumElement submit = $(By.cssSelector("div.field.search-submit-button > button"));


    public RootPageWeb() {
        titleText.shouldBe(visible);
    }

    @Step("Переход из админки на главную страницу акаунта пользователя")
    public SchedulePageWeb goToEmployee(String searchText, String nameEmployee) {
        employeeLink = $(By.linkText(nameEmployee));
        searchField.sendKeys(searchText);
        submit.click();
        employeeLink.click();
        return new SchedulePageWeb();
    }
}
