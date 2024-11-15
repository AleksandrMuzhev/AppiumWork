package pages.web;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

/**
 * Справочник Визиты в браузере
 */
public class VisitPageWeb {
    private final SelenideAppiumElement titlePage = $(By.cssSelector("div.content-title"));
    private final SelenideAppiumElement submitFilter = $(By.cssSelector(".ibutton_svg-filter"));
    private final SelenideAppiumElement nameTypeS = $(By.cssSelector("input[title='Пациент']"));
    private final SelenideAppiumElement nameTypeA = $(By.cssSelector("input[title='Клиент']"));
    private final SelenideAppiumElement btnEnter = $(By.cssSelector("button.ibutton_outline"));
    private final SelenideAppiumElement fullNameClient = $(By.cssSelector("td.fullname.ng-binding"));

    public VisitPageWeb() {
        titlePage.shouldBe(visible);
    }

    public SelenideAppiumElement getNameType() {
        if (arnica) {
            return nameTypeA;
        } else if (sqns) {
            return nameTypeS;
        }
        return null;
    }

    @Step("Проверяем ФИО клиента созданного визита в справочнике браузера")
    public VisitPageWeb checkNameNewVisitVisible(String name) {
        submitFilter.click();
        getNameType().sendKeys(name);
        btnEnter.click();
        fullNameClient.shouldHave(text(name));
        return this;
    }
}
