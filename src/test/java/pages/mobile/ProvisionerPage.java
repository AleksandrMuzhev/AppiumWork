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
 * Страница Поставщик
 */
public class ProvisionerPage {
    private final SelenideAppiumElement textTitle = elementByXpathText("Поставщик");
    private final SelenideAppiumElement btnSearch = elementByContentDesc("Найти");
    private final SelenideAppiumCollection fieldsEditText = collectionByClass("android.widget.EditText");
    private final SelenideAppiumElement btnSave = elementByContentDesc("Сохранить");

    public ProvisionerPage() {
        textTitle.shouldBe(visible, Duration.ofSeconds(5));
    }

    @Step("Сохранение страницы Поставщик")
    public NewArrivalInvoicePage saveProvisioner(String name) {
        fieldsEditText.get(0).sendKeys(name);
        btnSave.click();
        return new NewArrivalInvoicePage();
    }
}
