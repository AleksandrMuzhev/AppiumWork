package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

/**
 * Страница Онлайн-запись
 */
public class BookingSettingPage {
    private final SelenideAppiumCollection btnIcons = collectionByResourceId("icon-button");
    private final SelenideAppiumElement textTitle = elementByXpathText("Онлайн-запись");
    private final SelenideAppiumElement toggleSwitch = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");

    public BookingSettingPage() {
        textTitle.shouldBe(visible, Duration.ofSeconds(5));
    }

    public BookingSettingPage iClickSwitchToggle() {
        toggleSwitch.click();
        return this;
    }

}
