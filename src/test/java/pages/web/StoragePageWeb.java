package pages.web;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

/**
 * Страница Склады в браузере
 */
public class StoragePageWeb {
    private final SelenideAppiumElement titlePage = $(By.cssSelector("div.content-title"));
    private final SelenideAppiumElement nameType = $(By.cssSelector("input[title='Название']"));
    private final SelenideAppiumElement btnEnter = $(By.cssSelector("button.ibutton_outline"));
    private final SelenideAppiumElement serviceName = $(By.cssSelector("tr:nth-child(1) > td:nth-child(3) span > span"));

    public StoragePageWeb() {
        titlePage.shouldBe(visible);
    }

    @Step("Проверяем добавленный склад в справочнике браузера")
    public StoragePageWeb checkStorageVisible(String name) {
        nameType.sendKeys(name);
        btnEnter.click();
        serviceName.shouldHave(text(name));
        return this;
    }
}
