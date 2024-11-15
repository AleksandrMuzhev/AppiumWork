package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

/**
 * Bottomsheet (всплывающая страница) Выбор склада
 */
public class SelectStoragePage {
    private SelenideAppiumElement textTitle = elementByXpathText("Выбор склада");

    public SelectStoragePage() {
        textTitle.shouldBe(visible, Duration.ofSeconds(5));
    }
}
