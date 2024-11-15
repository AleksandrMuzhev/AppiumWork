package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByClass;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

/**
 * Bottomsheet(всплывающее окно) "Выбор товара"
 */
public class SelectCommodityPage {
    private final SelenideAppiumElement textTitle = elementByXpathText("Выбор товара");
    private final SelenideAppiumCollection btnIcons = collectionByResourceId("icon-button");
    private final SelenideAppiumElement fieldSearch = elementByClass("android.widget.EditText");

    public SelectCommodityPage() {
        textTitle.shouldBe(visible, Duration.ofSeconds(5));
    }

    public AddCommodity goToAddCommodity(String name) {
        fieldSearch.sendKeys(name);
        btnIcons.get(4).click();
        return new AddCommodity();
    }

}
