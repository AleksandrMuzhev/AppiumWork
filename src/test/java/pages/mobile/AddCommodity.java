package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByClass;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

import io.qameta.allure.Step;

/**
 * Страница Добавить товар
 */
public class AddCommodity {
    private final SelenideAppiumCollection btnIcons = collectionByResourceId("icon-button");
    private final SelenideAppiumElement textTitle = elementByXpathText("Товар");
    private final SelenideAppiumCollection fieldsEditText = collectionByClass("android.widget.EditText");
    private final SelenideAppiumElement btnAddCommdodity = elementByContentDesc("Добавить товар");

    public AddCommodity() {
        textTitle.shouldBe(visible, Duration.ofSeconds(5));
    }

    @Step("Добавление товара в документ создания нового поступления")
    public NewArrivalInvoicePage addCommodityInNewArrival() {
        btnIcons.get(6).click();
        btnAddCommdodity.click();
        return new NewArrivalInvoicePage();
    }
}
