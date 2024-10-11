package pages.web;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

/**
 * Страница Товары в браузере
 */
public class CommodityPageWeb {
    private final SelenideAppiumElement titlePage = $(By.cssSelector("div.content-title"));
    private final SelenideAppiumElement submitFilter = $(By.cssSelector(".ibutton_svg-filter"));
    private final SelenideAppiumElement nameType = $(By.cssSelector("input[title='Наименование/артикул']"));
    private final SelenideAppiumElement btnEnter = $(By.cssSelector("button.ibutton_outline"));
    private final SelenideAppiumElement commodityName = $(By.cssSelector("tr:nth-child(1) > td:nth-child(3) span > span"));

    public CommodityPageWeb() {
        titlePage.shouldBe(visible);
    }

    @Step("Проверяем ФИО добавленного сотрудника в справочнике браузера")
    public CommodityPageWeb checkCommodityVisible(String name) {
        submitFilter.click();
        nameType.sendKeys(name);
        btnEnter.click();
        commodityName.shouldHave(text(name));
        return this;
    }
}
