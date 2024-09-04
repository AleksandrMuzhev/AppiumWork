package pages;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByClass;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByResourceId;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.elementByXpathText;
import static driver.EmulatorHelper.slowClick;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import io.qameta.allure.Step;

public class ClientsPage {

    /**
     * Основная страница раздела Клиент для Android Арника
     */
    private static final SelenideAppiumElement textTitleClients = elementByXpathText("Клиенты");
    private static final SelenideAppiumElement btnSearchClient = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button");
    private static final SelenideAppiumElement searchClientField = elementByXpathText("ФИО посетителя");
    private static final SelenideAppiumElement btnCategoryClient = elementByContentDesc("Категория клиентов");
    private static final SelenideAppiumElement mainContentClientsForSwipe = elementByClass("//android.widget.ScrollView");

    /**
     * Bottomsheet "Выберите категорию" для Android Арника
     */
    private static final SelenideAppiumElement textTitleSelectCategory = elementByXpathText("Выберите категории\"]");
    private static final SelenideAppiumElement btnCloseSelectCategory = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button");
    private static final SelenideAppiumElement btnPlusCategory = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button");
    private static final SelenideAppiumElement btnEnter = elementByContentDesc("Применить");

    /**
     * Элементы кнопки "+" в "Выберите клиента" для Android Арника
     */
    private static final SelenideAppiumElement btnPlus = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.Button");
    private static final SelenideAppiumElement btnImportClients = elementByContentDesc("Импортировать из контактов");
    private static final SelenideAppiumElement btnAddNewClient = elementByContentDesc("Добавить нового клиента");

    /**
     * Форма создания нового клиента для Android Арника
     */
    private static final SelenideAppiumElement mainNewClientForSwipe = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView");
    private static final SelenideAppiumElement textTitleClient = elementByXpathText("Клиент");
    private static final SelenideAppiumElement textDescriptionClient = elementByXpathText("Новый клиент");
    private static final SelenideAppiumCollection formCreateClientFields = collectionByResourceId("text-input-outlined");
    private static final SelenideAppiumElement smsCheckBox = elementByContentDesc("Согласен на получение SMS");
    private static final SelenideAppiumElement btnAddCategory = elementByContentDesc("Добавить категорию");
    private static final SelenideAppiumElement genderNotSelect = elementByContentDesc("Не выбрано");
    private static final SelenideAppiumElement genderWomen = elementByContentDesc("Женщина");
    private static final SelenideAppiumElement genderMan = elementByContentDesc("Мужчина");
    private static final SelenideAppiumElement descriptionField = elementByXpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[4]");
    private static final SelenideAppiumElement btnCreateClient = elementByContentDesc("Создать");

    /**
     * Bottomsheet подтверждения разрешения доступа к контактов при переходе в Импортировать контакты для Android Арника
     */
    private static final SelenideAppiumElement popupImportContact = elementByXpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout");
    private static final SelenideAppiumElement btnEnableImport = elementByXpath("com.android.permissioncontroller:id/permission_allow_button");
    private static final SelenideAppiumElement btnBlockImport = elementByXpath("com.android.permissioncontroller:id/permission_deny_button");

    /**
     * Форма "Импорт контактов" для Android Арника
     */
    private static final SelenideAppiumElement mainImportContactForSwipe = elementByClass("//android.widget.ScrollView");
    private static final SelenideAppiumElement textTitleImportContact = elementByXpathText("Импорт контактов\"]");
    private static final SelenideAppiumElement searchImportField = elementByXpathText("Поиск...");
    private static final SelenideAppiumElement btnImport = elementByContentDesc("Импортировать");

    /**
     * Страница результатов импорта контактов для Android Арника
     */
    private static final SelenideAppiumElement textTitleResultImport = elementByXpathText("Результаты");

    /**
     * Геттеры для использования данных в шагах и в тестах
     */
    public static SelenideAppiumElement getTextTitleResultImport() {
        return textTitleResultImport;
    }

    public static SelenideAppiumElement getBtnPlus() {
        if (arnica) {
            return btnPlus;
        } else if (sqns) {
            return elementByResourceId("fab");
        }
        return null;
    }

    public static SelenideAppiumElement getBtnAddNewClient() {
        if (arnica) {
            return btnAddNewClient;
        } else if (sqns) {
            return elementByContentDesc("Добавить нового пациента");
        }
        return null;
    }

    /**
     * Готовые шаги для применения в тестах
     */
    @Step("Создание клиента с заполненными валидными полями")
    public static void createValidClient() {
        formCreateClientFields.first().should(visible).sendKeys("Дмитрий");
        formCreateClientFields.get(1).sendKeys("Петров");
        formCreateClientFields.get(2).sendKeys("Иванович");
        formCreateClientFields.get(4).sendKeys("9124567895");
        slowClick(smsCheckBox);
        formCreateClientFields.get(5).sendKeys("test37@mail.ru");
        formCreateClientFields.get(6).should(visible).sendKeys("10.10.1980");
        elementByXpathText("Мужчина");
        descriptionField.sendKeys("Здоровая личность");
        btnCreateClient.should(visible).click();
    }

    @Step("Создание клиента c номером телефона")
    public static void createClientWithPhone(String name, String surname, String patronymic, String phone) {
        getBtnPlus().should(visible, Duration.ofSeconds(5)).click();
        getBtnAddNewClient().should(visible).click();
        formCreateClientFields.first().sendKeys(name);
        formCreateClientFields.get(1).sendKeys(surname);
        formCreateClientFields.get(2).sendKeys(patronymic);
        formCreateClientFields.get(3).sendKeys(phone);
        btnCreateClient.click();
    }

    @Step("Фильтрация клиента в справочнике через поиск")
    public static void filterClientInfo(String name) {
        btnSearchClient.should(visible).click();
        searchClientField.should(visible).sendKeys(name);
    }

    @Step("Проверяем 1-й найденный результат на сооветствие поиска в фильтре")
    public static void checkResultClientSearch(String name, String phone) {
        SelenideElement actualName = elementByXpath("(//android.widget.TextView[@text=\"" + name + "\"])[2]");
        SelenideElement actualPhone = elementByXpath("(//android.widget.TextView[@text=\"" + phone + "\"])[2]");

        System.out.println(actualName);
        System.out.println(actualPhone);
        Assertions.assertEquals(name, actualName.should(visible).getText());
        Assertions.assertEquals(phone, actualPhone.should(visible).getText());
    }

    @Step("Импорт контактов из справочника клиентов")
    public static void importContact() {
        SelenideAppiumElement name = collectionByResourceId("com.medicalru.app.android:id/Paragraph").get(2);

        getBtnPlus().should(visible).click();
        btnImportClients.should(visible).click();
        if (popupImportContact.exists()) {
            btnEnableImport.click();
        }
        elementByXpathText("В вашем телефоне нет контактов").shouldBe(not(visible), Duration.ofSeconds(5));
        searchImportField.sendKeys(name.getText());
        name.click();
        btnImport.should(visible).click();
    }

}
