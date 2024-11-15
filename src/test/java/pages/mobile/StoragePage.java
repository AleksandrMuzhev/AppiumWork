package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByResourceId;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

/**
 * Страница Склады
 */
public class StoragePage {
    private final SelenideAppiumCollection btnIcons = collectionByResourceId("icon-button");
    private final SelenideAppiumElement textTitle = elementByXpathText("Склады");
    private final SelenideAppiumElement btnPlus = elementByResourceId("plus-button");

    public StoragePage() {
        textTitle.shouldBe(visible, Duration.ofSeconds(5));
    }

}
