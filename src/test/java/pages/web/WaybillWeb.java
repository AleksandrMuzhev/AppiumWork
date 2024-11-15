package pages.web;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

/**
 * Страница Перемещение товаров в браузере
 */
public class WaybillWeb {
    private final SelenideAppiumElement titlePage = $(By.cssSelector("div.content-title"));
    private final SelenideAppiumElement submitFilter = $(By.cssSelector(".ibutton_svg-filter"));
    private final SelenideAppiumElement nameType = $(By.cssSelector("input[title='Товар']"));
    private final SelenideAppiumElement btnEnter = $(By.cssSelector("button.ibutton_outline"));
    private final SelenideAppiumElement textModalCommodity = $(By.cssSelector("tr.updateable-part td.commodityID a > span"));
    private final SelenideAppiumElement linkDocumentResult = $(By.cssSelector("tr.r1.checkable > td:nth-child(2) > a"));

    public WaybillWeb() {
        titlePage.shouldBe(visible);
    }

    @Step("Проверяем добавленный документ перемещения и товар в нем в справочнике браузера")
    public WaybillWeb checkWaybillWeb(String name) {
        submitFilter.click();
        nameType.sendKeys(name);
        btnEnter.click();
        linkDocumentResult.click();
        textModalCommodity.shouldHave(text(name));
        return this;
    }
}
