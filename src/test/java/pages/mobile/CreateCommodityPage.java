package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByClass;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

import io.qameta.allure.Step;

/**
 * Форма создания товара
 */
public class CreateCommodityPage {
    private final SelenideAppiumElement textTitle = elementByXpathText("Товар");
    private final SelenideAppiumCollection fieldsCollection = collectionByClass("android.widget.EditText");
    private final SelenideAppiumElement countNameForSale = elementByXpathText("штука шт");
    private final SelenideAppiumElement btnSave = elementByContentDesc("Сохранить");

    public CreateCommodityPage() {
        textTitle.shouldBe(visible, Duration.ofSeconds(5));
    }

    @Step("Создание случайного товара")
    public CommodityPage createRandomCommodity(String text) {
        fieldsCollection.get(0).sendKeys(text);
        fieldsCollection.get(4).sendKeys("100");
        fieldsCollection.get(5).click();
        countNameForSale.should(visible, Duration.ofSeconds(5)).click();
        fieldsCollection.get(6).click();
        countNameForSale.should(visible, Duration.ofSeconds(5)).click();
        fieldsCollection.get(7).sendKeys("1");
        btnSave.click();
        return new CommodityPage();
    }
}
