package pages.web;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

/**
 * Страница Поступление товаров в браузере
 */
public class ArrivalInvoiceWeb {
    private final SelenideAppiumElement titlePage = $(By.cssSelector("div.content-title"));
    private final SelenideAppiumElement submitFilter = $(By.cssSelector(".ibutton_svg-filter"));
    private final SelenideAppiumElement nameType = $(By.cssSelector("input[title='Контрагент']"));
    private final SelenideAppiumElement btnEnter = $(By.cssSelector("button.ibutton_outline"));
    private final SelenideAppiumElement counterParty = $(By.cssSelector("tr.checkable.ng-scope.r1 > td:nth-child(5)"));

    public ArrivalInvoiceWeb() {
        titlePage.shouldBe(visible);
    }

    @Step("Проверяем добавленный документ поступления в справочнике браузера")
    public ArrivalInvoiceWeb checkArrivalInvoice(String name) {
        submitFilter.click();
        nameType.sendKeys(name);
        btnEnter.click();
        counterParty.shouldHave(text(name));
        return this;
    }
}
