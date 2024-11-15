package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByClass;
import static driver.EmulatorHelper.collectionByContentDesc;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementById;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;
import java.time.LocalDate;

import io.qameta.allure.Step;

/**
 * Страница создания Поступления товаров
 */
public class NewArrivalInvoicePage {
    /**
     * Основная страница раздела Товары для Android SQNS
     */
    private final SelenideAppiumElement titleListCommodity = elementByXpathText("Поступление товаров");
    private final SelenideAppiumCollection btnIcons = collectionByResourceId("icon-button");
    private final SelenideAppiumCollection fieldsEditText = collectionByClass("android.widget.EditText");
    private final SelenideAppiumElement numCurrentCal = elementByXpathText("\"" + LocalDate.now().getDayOfMonth() + "\"");

    private final SelenideAppiumElement btnNew = elementByContentDesc("Новый");
    private final SelenideAppiumCollection btnChanges = collectionByContentDesc("Изменить");
    private final SelenideAppiumElement btnAdd = elementByXpathText("добавить");
    private final SelenideAppiumElement btnSaveDoc = elementByContentDesc("Сохранить документ");


    /**
     * Элементы Дата-пикера
     */
    private final SelenideAppiumElement hours = elementById("android:id/hours");
    private final SelenideAppiumElement minutes = elementById("android:id/minutes");
    private final SelenideAppiumElement btnOK = elementById("android:id/button1");
    private final SelenideAppiumElement btnCancel = elementById("android:id/button2");
    private final SelenideAppiumElement btnKeyboard = elementById("android:id/toggle_mode");
    /**
     * Элементы ввода часов и минут с клавиатуры
     */
    private final SelenideAppiumCollection fieldsTimeCollection = collectionByClass("android.widget.EditText");
    private final SelenideAppiumElement btnDataPicker = elementById("android:id/toggle_mode");

    public NewArrivalInvoicePage() {
        titleListCommodity.shouldBe(visible, Duration.ofSeconds(5));
    }

    @Step("Переход на страницу Поставщик")
    public ProvisionerPage goToProvisioner() {
        btnNew.click();
        return new ProvisionerPage();
    }

    @Step("Переход на страницу Выбор товара")
    public SelectCommodityPage goToSelectCommodity() {
        btnAdd.click();
        return new SelectCommodityPage();
    }

    @Step("Сохранение нового поступления товара и переход на страницу Операции с товарами")
    public OperationsCommodityPage saveNewArrival() {
        btnSaveDoc.click();
        return new OperationsCommodityPage();
    }


}
