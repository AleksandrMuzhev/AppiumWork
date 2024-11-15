package pages.mobile;

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
import static driver.EmulatorHelper.swipe;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import helper.DataHelper;
import io.qameta.allure.Step;
import lombok.Getter;

/**
 * Страница
 */
public class ClientsPage {

    /**
     * Основная страница раздела Клиент для Android Арника
     */
    private final SelenideAppiumElement textTitlePageA = elementByXpathText("Клиенты");
    private final SelenideAppiumElement btnSearchClient = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button");
    private final SelenideAppiumElement searchClientField = elementByXpathText("ФИО посетителя");
    private final SelenideAppiumElement btnCategoryClient = elementByContentDesc("Категория клиентов");
    private final SelenideAppiumElement mainContentClientsForSwipe = elementByClass("//android.widget.ScrollView");
    /**
     * Основная страница раздела Пациент для Android SQNS
     */
    private final SelenideAppiumElement textTitlePageS = elementByXpathText("Пациенты");

    /**
     * Bottomsheet "Выберите категорию" для Android Арника
     */
    private final SelenideAppiumElement textTitleSelectCategory = elementByXpathText("Выберите категории\"]");
    private final SelenideAppiumElement btnCloseSelectCategory = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button");
    private final SelenideAppiumElement btnPlusCategory = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button");
    private final SelenideAppiumElement btnEnter = elementByContentDesc("Применить");

    /**
     * Элементы кнопки "+" в "Выберите клиента" для Android Арника
     */
    private final SelenideAppiumElement btnPlus = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.Button");
    private final SelenideAppiumElement btnImportClients = elementByContentDesc("Импортировать из контактов");
    private final SelenideAppiumElement btnAddNewClientA = elementByContentDesc("Добавить нового клиента");
    /**
     * Элементы кнопки "+" в "Выберите пациента" для Android SQNS
     */
    private final SelenideAppiumElement btnAddNewClientS = elementByContentDesc("Добавить нового пациента");

    /**
     * Форма создания нового клиента для Android Арника
     */
    private final SelenideAppiumElement mainNewClientForSwipe = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView");
    private final SelenideAppiumElement textTitleClient = elementByXpathText("Клиент");
    private final SelenideAppiumElement textDescriptionClient = elementByXpathText("Новый клиент");
    private final SelenideAppiumCollection formCreateClientFieldsA = collectionByResourceId("text-input-outlined");
    private final SelenideAppiumElement smsCheckBox = elementByContentDesc("Согласен на получение SMS");
    private final SelenideAppiumElement btnAddCategory = elementByContentDesc("Добавить категорию");
    private final SelenideAppiumElement genderNotSelect = elementByContentDesc("Не выбрано");
    private final SelenideAppiumElement genderWomen = elementByContentDesc("Женщина");
    private final SelenideAppiumElement genderMan = elementByContentDesc("Мужчина");
    private final SelenideAppiumElement descriptionField = elementByXpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[4]");
    private final SelenideAppiumElement btnCreateClient = elementByContentDesc("Создать");
    /**
     * Форма создания нового клиента для Android SQNS
     */
    private final SelenideAppiumCollection formCreateClientFieldsS = collectionByResourceId("com.medicalru.app.android:id/TextInput-input");


    /**
     * Bottomsheet подтверждения разрешения доступа к контактов при переходе в Импортировать контакты для Android Арника
     */
    private final SelenideAppiumElement popupImportContact = elementByXpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout");
    private final SelenideAppiumElement btnEnableImport = elementByXpath("com.android.permissioncontroller:id/permission_allow_button");
    private final SelenideAppiumElement btnBlockImport = elementByXpath("com.android.permissioncontroller:id/permission_deny_button");

    /**
     * Форма "Импорт контактов" для Android Арника
     */
    private final SelenideAppiumElement mainImportContactForSwipe = elementByClass("//android.widget.ScrollView");
    private final SelenideAppiumElement textTitleImportContact = elementByXpathText("Импорт контактов\"]");
    private final SelenideAppiumElement searchImportField = elementByXpathText("Поиск...");
    private final SelenideAppiumElement btnImport = elementByContentDesc("Импортировать");

    /**
     * Страница результатов импорта контактов для Android Арника
     */
    @Getter
    private final SelenideAppiumElement textTitleResultImport = elementByXpathText("Результаты");

    /**
     * Конструктор на проверку видимости загрузки страницы
     */
    public ClientsPage() {
        if (arnica) {
            textTitlePageA.shouldBe(visible, Duration.ofSeconds(10));
        } else if (sqns) {
            textTitlePageS.shouldBe(visible, Duration.ofSeconds(10));
        }
    }

    /**
     * Геттеры с условиями по разнице продуктов
     */
    public SelenideAppiumElement getBtnPlus() {
        if (arnica) {
            return btnPlus;
        } else if (sqns) {
            return elementByResourceId("fab");
        }
        return null;
    }

    public SelenideAppiumElement getBtnAddNewClient() {
        if (arnica) {
            return btnAddNewClientA;
        } else if (sqns) {
            return btnAddNewClientS;
        }
        return null;
    }

    public SelenideAppiumCollection getFormCreateClientFields() {
        if (arnica) {
            return formCreateClientFieldsA;
        } else if (sqns) {
            return formCreateClientFieldsS;
        }
        return null;
    }

    /**
     * Готовые шаги для применения в тестах
     */
    @Step("Создание клиента с заполненными валидными полями")
    public ClientsPage createValidClient() {
        getFormCreateClientFields().first().should(visible).sendKeys("Дмитрий");
        getFormCreateClientFields().get(1).sendKeys("Петров");
        getFormCreateClientFields().get(2).sendKeys("Иванович");
        getFormCreateClientFields().get(4).sendKeys("9124567895");
        slowClick(smsCheckBox);
        getFormCreateClientFields().get(5).sendKeys("test37@mail.ru");
        getFormCreateClientFields().get(6).should(visible).sendKeys("10.10.1980");
        elementByXpathText("Мужчина");
        descriptionField.sendKeys("Здоровая личность");
        btnCreateClient.should(visible).click();
        return this;
    }

    @Step("Создание клиента c заполненными номер карты, имя, фамилия, отчество, дата рождения, телефон")
    public ClientsPage createClientRandom(String numberCard, String name, String surname, String patronymic, String birthDay, String phone) {
        getBtnPlus().should(visible, Duration.ofSeconds(5)).click();
        getBtnAddNewClient().should(visible).click();
        getFormCreateClientFields().first().sendKeys(numberCard);
        getFormCreateClientFields().get(1).sendKeys(name);
        getFormCreateClientFields().get(2).sendKeys(surname);
        getFormCreateClientFields().get(3).sendKeys(patronymic);
        getFormCreateClientFields().get(4).sendKeys(birthDay);
        getFormCreateClientFields().get(5).sendKeys(phone);
        btnCreateClient.click();
        return this;
    }

    @Step("Фильтрация клиента в справочнике через поиск")
    public ClientsPage filterClientInfo(String name) {
        btnSearchClient.should(visible).click();
        searchClientField.should(visible).sendKeys(name);
        return this;
    }

    @Step("Проверяем 1-й найденный результат на сооветствие поиска в фильтре")
    public ClientsPage checkResultClientSearch(String name, String phone) {
        SelenideElement actualName = elementByXpath("(//android.widget.TextView[@text=\"" + name + "\"])[2]");
        SelenideElement actualPhone = elementByXpath("(//android.widget.TextView[@text=\"" + phone + "\"])[2]");

        Assertions.assertEquals(name, actualName.should(visible, Duration.ofSeconds(5)).getText());
        Assertions.assertEquals(phone, actualPhone.should(visible, Duration.ofSeconds(5)).getText());
        return this;
    }

    @Step("Импорт контактов из справочника клиентов")
    public ClientsPage importContact() {
        SelenideAppiumElement name = collectionByResourceId("com.medicalru.app.android:id/Paragraph").get(2);

        getBtnPlus().should(visible).click();
        btnImportClients.should(visible).click();
        if (popupImportContact.exists()) {
            btnEnableImport.click();
        }
        elementByXpathText("В вашем телефоне нет контактов").shouldBe(not(visible), Duration.ofSeconds(5));
        searchImportField.sendKeys(name.getText());
        name.click();
        btnImport.should(visible, Duration.ofSeconds(5)).click();
        return this;
    }
}
