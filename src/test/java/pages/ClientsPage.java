package pages;

import static com.codeborne.selenide.Selenide.$;
import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.androidScrollToAnElementBySecondTextWithClick;
import static driver.EmulatorHelper.androidScrollToAnElementByTextWithClick;
import static driver.EmulatorHelper.slowClick;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import org.junit.jupiter.api.Assertions;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

public class ClientsPage {

    /**
     * Основная страница раздела Клиент для Android Арника
     */
    private static final SelenideElement textTitleClients = $(MobileBy.xpath("(//android.widget.TextView[@text=\"Клиенты\"])[1]"));
    private static final SelenideElement btnSearchClient = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button"));
    private static final SelenideElement searchClientField = $(MobileBy.xpath("//android.widget.EditText[@text=\"ФИО посетителя\"]"));
    private static final SelenideElement btnCategoryClient = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Категория клиентов\"]"));
    private static final SelenideElement mainContentClientsForSwipe = $(MobileBy.xpath("//android.widget.ScrollView"));

    /**
     * Bottomsheet "Выберите категорию" для Android Арника
     */
    private static final SelenideElement textTitleSelectCategory = $(MobileBy.xpath("//android.widget.TextView[@text=\"Выберите категории\"]"));
    private static final SelenideElement btnCloseSelectCategory = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button"));
    private static final SelenideElement btnPlusCategory = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button"));
    private static final SelenideElement btnEnter = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Применить\"]"));

    /**
     * Элементы кнопки "+" в "Выберите клиента" для Android Арника
     */
    private static final SelenideElement btnPlus = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.Button"));
    private static final SelenideElement btnImportClients = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Импортировать из контактов\"]"));
    private static final SelenideElement btnAddNewClient = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Добавить нового клиента\"]"));

    /**
     * Форма создания нового клиента для Android Арника
     */
    private static final SelenideElement mainNewClientForSwipe = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView"));
    private static final SelenideElement textTitleClient = $(MobileBy.xpath("//android.widget.TextView[@text=\"Клиент\"]"));
    private static final SelenideElement textDescriptionClient = $(MobileBy.xpath("//android.widget.TextView[@text=\"Новый клиент\"]"));
    private static final SelenideElement nameField = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[1]"));
    private static final SelenideElement surnameField = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[2]"));
    private static final SelenideElement patronymicField = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[3]"));
    private static final SelenideElement phoneField = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[4]"));
    private static final SelenideElement smsCheckBox = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Согласен на получение SMS\"]"));
    private static final SelenideElement emailField = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[5]"));
    private static final SelenideElement btnAddCategory = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Добавить категорию\"]"));
    private static final SelenideElement birthdayField = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[6]"));
    private static final SelenideElement genderNotSelect = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Не выбрано\"]"));
    private static final SelenideElement genderWomen = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Женщина\"]"));
    private static final SelenideElement genderMan = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Мужчина\"]"));
    private static final SelenideElement descriptionField = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[4]"));
    private static final SelenideElement btnCreateClient = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Создать\"]"));

    /**
     * Bottomsheet подтверждения разрешения доступа к контактов при переходе в Импортировать контакты для Android Арника
     */
    private static final SelenideElement popupImportContact = $(MobileBy.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout"));
    private static final SelenideElement btnEnableImport = $(MobileBy.xpath("com.android.permissioncontroller:id/permission_allow_button"));
    private static final SelenideElement btnBlockImport = $(MobileBy.xpath("com.android.permissioncontroller:id/permission_deny_button"));

    /**
     * Форма "Импорт контактов" для Android Арника
     */
    private static final SelenideElement mainImportContactForSwipe = $(MobileBy.xpath("//android.widget.ScrollView"));
    private static final SelenideElement textTitleImportContact = $(MobileBy.xpath("//android.widget.TextView[@text=\"Импорт контактов\"]"));
    private static final SelenideElement searchImportField = $(MobileBy.xpath("//android.widget.EditText[@text=\"Поиск...\"]"));
    private static final SelenideElement btnImport = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Импортировать\"]"));

    /**
     * Страница результатов импорта контактов для Android Арника
     */
    private static final SelenideElement textTitleResultImport = $(MobileBy.xpath("//android.widget.TextView[@text=\"Результаты\"]"));

    /**
     * Геттеры для использования данных в шагах и в тестах
     */
    public static SelenideElement getTextTitleResultImport() {
        return textTitleResultImport;
    }
    /**
     * Готовые шаги для применения в тестах
     */
    @Step("Создание клиента с заполненными валидными полями")
    public static void createValidClient() {
        nameField.should(Condition.visible).sendKeys("Дмитрий");
        surnameField.sendKeys("Петров");
        patronymicField.sendKeys("Иванович");
        phoneField.sendKeys("9124567895");
        slowClick(smsCheckBox);
        emailField.sendKeys("test37@mail.ru");
        birthdayField.should(Condition.visible).sendKeys("10.10.1980");
        androidScrollToAnElementByTextWithClick("Мужчина");
        descriptionField.sendKeys("Здоровая личность");
        btnCreateClient.should(Condition.visible).click();
    }

    @Step("Создание клиента c номером телефона")
    public static void createClientWithPhone(String name, String surname, String patronymic, String phone) {
        btnPlus.should(Condition.visible).click();
        if (arnica) {
            androidScrollToAnElementByTextWithClick("Добавить нового клиента");
        } else if (sqns) {
            androidScrollToAnElementByTextWithClick("Добавить нового пациента");
        }
        nameField.sendKeys(name);
        surnameField.sendKeys(surname);
        patronymicField.sendKeys(patronymic);
        phoneField.sendKeys(phone);
        btnCreateClient.click();
    }

    @Step("Фильтрация клиента в справочнике через поиск")
    public static void filterClientInfo(String name) {
        btnSearchClient.should(Condition.visible).click();
        searchClientField.should(Condition.visible).sendKeys(name);
    }

    @Step("Проверяем 1-й найденный результат на сооветствие поиска в фильтре")
    public static void checkResultClientSearch(String name, String phone) {
        SelenideElement actualName = $(MobileBy.xpath("(//android.widget.TextView[@text=\"" + name + "\"])[2]"));
        SelenideElement actualPhone = $(MobileBy.xpath("(//android.widget.TextView[@text=\"" + phone + "\"])[2]"));

        System.out.println(actualName);
        System.out.println(actualPhone);
        Assertions.assertEquals(name, actualName.should(Condition.visible).getText());
        Assertions.assertEquals(phone, actualPhone.should(Condition.visible).getText());
    }

    @Step("Импорт контактов из справочника клиентов")
    public static void importContact(String name) {
        btnPlus.should(Condition.visible).click();
        btnImportClients.should(Condition.visible).click();
        if(popupImportContact.exists()) {
            btnEnableImport.click();
        }
        searchImportField.sendKeys(name);
        androidScrollToAnElementBySecondTextWithClick(name);
        btnImport.should(Condition.visible).click();
    }

}
