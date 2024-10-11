package pages.web;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

/**
 * Страница админки в браузере
 */
public class RootPageWeb {
    //    private final String employee = DataHelper.getUserInfoWeb().getUser();
    private final SelenideAppiumElement titleText = $(By.cssSelector("h1"));
    private final SelenideAppiumElement searchField = $(By.cssSelector("input[title=\"Что-нибудь - название, имя, емэйл\"]"));
    private final SelenideAppiumElement submit = $(By.cssSelector("div.field.search-submit-button > button"));


    public RootPageWeb() {
        titleText.shouldBe(visible);
    }

    public SchedulePageWeb goToEmployee(String email, String nameEmployee) {
        SelenideAppiumElement employeeLink = $(By.linkText(nameEmployee));
        searchField.sendKeys(email);
        submit.click();
        employeeLink.click();
        return new SchedulePageWeb();
    }
}
