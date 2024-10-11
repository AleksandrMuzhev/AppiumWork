package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByResourceId;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

/**
 * Страница Сотрудники
 */
public class EmployeesPage {
    private final SelenideAppiumCollection btnIcons = collectionByResourceId("icon-button");
    private final SelenideAppiumElement textTitle = elementByXpathText("Сотрудники");
    private final SelenideAppiumElement btnSearch = elementByResourceId("magnify-button");
    private final SelenideAppiumElement btnPlus = elementByResourceId("plus-button");
    private final SelenideAppiumElement fieldSearch = elementByResourceId("search-bar");

    public EmployeesPage() {
        textTitle.shouldBe(visible, Duration.ofSeconds(5));
    }
}
