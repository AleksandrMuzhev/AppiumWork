package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumElement;

/**
 * Попап выбора сотрудника
 */
public class SelectEmployeePage {
    private final SelenideAppiumElement textTitleSelectEmployee = elementByXpathText("Выберите сотрудника");

    public SelectEmployeePage() {
        textTitleSelectEmployee.shouldBe(visible);
    }
}
