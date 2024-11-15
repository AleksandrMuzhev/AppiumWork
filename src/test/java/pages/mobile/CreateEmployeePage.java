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
 * Форма создания сотрудника
 */
public class CreateEmployeePage {
    private final SelenideAppiumCollection btnIcons = collectionByResourceId("icon-button");
    private final SelenideAppiumElement textTitle = elementByXpathText("Услуга");
    private final SelenideAppiumCollection fieldsCollection = collectionByClass("android.widget.EditText");
    private final SelenideAppiumElement btnSave = elementByContentDesc("Сохранить");

    public CreateEmployeePage() {
        textTitle.shouldBe(visible, Duration.ofSeconds(5));
    }

    @Step("Создание сотрудника c заполненными обязательными полями")
    public EmployeesPage createEmployee(String name, String surname, String Patronymic) {
        fieldsCollection.get(0).sendKeys(name);
        fieldsCollection.get(1).sendKeys(surname);
        fieldsCollection.get(2).sendKeys(Patronymic);
        btnSave.click();
        return new EmployeesPage();
    }
}
