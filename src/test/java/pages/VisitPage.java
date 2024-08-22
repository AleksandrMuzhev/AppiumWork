package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.androidScrollToAnElementBySecondTextWithClick;
import static driver.EmulatorHelper.androidScrollToAnElementByText;
import static driver.EmulatorHelper.androidScrollToAnElementByTextWithClick;
import static driver.EmulatorHelper.slowClick;
import static helper.DateHelper.dayOfMonth;
import static helper.DateHelper.yearWithMonthValue;
import static pages.SchedulePage.clickOnNewVisitInBtnPlus;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;


public class VisitPage {

    /**
     * Элементы календаря перед созданием Визита для Android Арника
     */
    private static final SelenideElement btnBackDateVisit = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"назад\"]"));
    private static final SelenideElement textTitleCalendarVisit = $(MobileBy.xpath("//android.widget.TextView[@text=\"Дата посещения\"]"));
    private static final SelenideElement textSelectDateVisit = $(MobileBy.xpath("//android.widget.TextView[@text=\"Выберите дату\"]"));
    private static final SelenideElement btnToDayDateVisit = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"сегодня\"]"));
    private static final ElementsCollection dayNamesSchedule = $$(MobileBy.xpath("//android.view.ViewGroup[@resource-id=\"undefined.item_\"" + yearWithMonthValue() + "\".header.dayNames\"]"));
    private static final SelenideElement numberDayCalendar = $(MobileBy.xpath("(//android.widget.TextView[@text=\"" + dayOfMonth() + "\"])[1]"));

    /**
     * Элементы Время начала перед созданием Визита для Android Арника
     */
    private static final SelenideElement textTitleTimeStartVisit = $(MobileBy.xpath("//android.widget.TextView[@text=\"Время начала\"]"));
    private static final SelenideElement textSelectTimeStartVisit = $(MobileBy.xpath("//android.widget.TextView[@text=\"Выберите или укажите\"]"));
    private static final SelenideElement btnNowVisit = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"сейчас\"]"));
    private static final SelenideElement textNameEmployee = $(MobileBy.xpath("//android.widget.TextView[@text=\"Стефанив Ольга Валерьевна \"]"));
    private static final SelenideElement textPositionEmployee = $(MobileBy.xpath("//android.widget.TextView[@text=\"Мастер маникюра / педикюра / подолог\"]"));
    private static final SelenideElement textDescriptionTimeFromTo = $(MobileBy.xpath("//android.widget.TextView[@text=\"Время с 09:00 по 19:00\"]"));
    private static final ElementsCollection mainTimeStartVisitCollection = $$(MobileBy.xpath("//android.widget.ScrollView/android.view.ViewGroup"));
    private static final SelenideElement btnSetTimeManual = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Задать вручную\"]"));

    /**
     * Основная страница раздела Визит для Android (Все продукты)
     * Новый визит
     */
    private static final SelenideElement textTitleNewVisitText = $(MobileBy.xpath("//android.widget.TextView[@text=\"Новый визит\"]"));
    private static final SelenideElement textDateAndTime = $(MobileBy.xpath("//android.widget.TextView[@text=\"Дата и время\"]"));
    private static final SelenideElement dateField = $(MobileBy.xpath("//android.widget.EditText[@resource-id=\"text-input-outlined\"]"));
    //    private static final SelenideElement timeField = $(MobileBy.xpath());
    private static final SelenideElement btnWidgetCalendar = $(MobileBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button"));
    private static final SelenideElement getBtnWidgetTime = $(MobileBy.xpath("//android.widget.TextView[@text=\"\uDB82\uDD54\"]"));
    private static final SelenideElement textTitleVisitor = $(MobileBy.xpath("//android.widget.TextView[@text=\"Посетитель\"]"));
    private static final SelenideElement btnAddVisitor = $(MobileBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.Button"));
    private static final SelenideElement textTitleServices = $(MobileBy.xpath("//android.widget.TextView[@text=\"Услуги\"]"));
    private static final SelenideElement btnAddServices = $(MobileBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button"));
    private static final SelenideElement visitContentForSwipe = $(MobileBy.xpath("//android.widget.ScrollView"));

    private static final SelenideElement btnListSales = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Продажа\"]/android.widget.Button"));
    private static final SelenideElement textListSales = $(MobileBy.xpath("//android.widget.TextView[@text=\"Продажа\"]"));
    private static final ElementsCollection collectionBtnSaleInVisit = $$(MobileBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]"));
    private static final SelenideElement btnAddCommodity = $(MobileBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.Button"));
    private static final SelenideElement btnAddCertificate = $(MobileBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button"));
    private static final SelenideElement btnAddSubscription = $(MobileBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.Button"));

    private static final SelenideElement textTitleCommentAndAttachments = $(MobileBy.xpath("//android.widget.TextView[@text=\"Комментарии и вложения\"]"));
    private static final SelenideElement btnListCommentAndAttachments = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Комментарии и вложения\"]/android.widget.Button"));
    private static final SelenideElement btnAddAttachments = $(MobileBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.Button"));
    private static final SelenideElement commentField = $(MobileBy.xpath("//android.widget.EditText[@resource-id=\"text-input-flat\"]"));

    private static final SelenideElement textPaymentNotAvailabel = $(MobileBy.xpath("//android.widget.TextView[@text=\"Оплаты недоступны\"]"));
    private static final SelenideElement btnClientCame = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Клиент пришел\"]"));

    private static final SelenideElement btnStatusVisit = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Визит не подтвержден\"]"));
    private static final SelenideElement btnSaveVisit = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Сохранить визит\"]"));

    /**
     * Bottomsheet (всплывающее меню) Выберите клиента в визите для Android Арника
     */
    private static final SelenideElement bottomsheetSelectClient = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]"));
    private static final SelenideElement btnBack = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[1]"));
    private static final SelenideElement textTitleSelectClient = $(MobileBy.xpath("//android.widget.TextView[@text=\"Выберите клиента\"]"));
    private static final SelenideElement btnSearchClient = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[2]"));
    private static final SelenideElement btnPlus = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.Button"));
    private static final SelenideElement searchClientField = $(MobileBy.xpath("//android.widget.EditText[@text=\"ФИО посетителя\"]"));
    private static final SelenideElement btnAddNewClient = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Добавить нового клиента\"]"));
    private static final SelenideElement btnImportContacts = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Импортировать из контактов\"]"));

    /**
     * Bottomsheet (всплывающее меню) Выберите клиента в визите для Android Арника
     */
    private static final ElementsCollection collectionServiceCatalog = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"));

    /**
     * Попап "Статус визита"
     */
    public static final SelenideElement textTitleStatusVisit = $(MobileBy.xpath("//android.widget.TextView[@text=\"Cтатус визита\"]"));
    public static final SelenideElement btnSelectStatus = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Выбрать\"]"));
    public static final SelenideElement btnCancelStatus = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Отмена\"]"));

    /**
     * Плашка "Добавить оплату" и далее форма "Оплата визита" для Android Арника
     */
    public static final SelenideElement btnAddPayment = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Добавить оплату\"]"));
    public static final SelenideElement textTitlePaymentVisit = $(MobileBy.xpath("//android.widget.TextView[@text=\"Оплата визита\"]"));
    public static final SelenideElement sumPaymentField = $(MobileBy.xpath("//android.widget.EditText[@resource-id=\"text-input-outlined\" and @text=\"1000\"]"));
    public static final SelenideElement btnMainCashBox = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Основная касса\"]"));
    public static final SelenideElement btnMainCurrentAccount = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Основной расчетный счет\"]"));
    public static final SelenideElement btnViewMoreVariable = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Показать больше вариантов\"]"));
    public static final SelenideElement numberCardField = $(MobileBy.xpath("//android.widget.EditText[@resource-id=\"text-input-outlined\" and @text=\" \"]"));
    public static final SelenideElement btnPay = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Оплатить\"]"));

    /**
     * Геттеры для обращения к полям класса из тестов
     */
    public static final SelenideElement getBtnBack() {
        return btnBack;
    }

    public static final SelenideElement getTextTitleNewVisitText() {
        return textTitleNewVisitText;
    }

    public static final SelenideElement getTextTitleCalendarVisit() {
        return textTitleCalendarVisit;
    }

    public static final SelenideElement getCheckBoxDirectoryService(String nameService) {
        return $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"" + nameService + "\"]/android.view.ViewGroup/android.widget.Button"));
    }

    public static final SelenideElement getCatalogService(String nameService) {
        return $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"" + nameService + "\"]"));
    }

    public static SelenideElement getTimeStartVisit() {
        SelenideElement targetElement = mainTimeStartVisitCollection.stream()
                .filter(element -> "09:00".equals(element.getAttribute("content-desc")))
                .findFirst()
                .orElse(null);
        return targetElement;
    }

    /**
     * Готовые шаги для применения в тестах
     */

    @Step("Если список Продажа скрыт, то кликаем для раскрытия")
    public static void openBtnListSales() {
        while (!textListSales.exists()) {
            androidScrollToAnElementByText("Продажа");
            if (textListSales.exists()) {
                break;
            }
        }
        if (!btnAddCommodity.exists()) {
            slowClick(btnListSales);
        }
    }

    @Step("Переходим в новый визит через кнопку Плюс расписания")
    public static void goToNewVisitWithBtnPlus() {
        clickOnNewVisitInBtnPlus();
        btnToDayDateVisit.should(Condition.visible).click();
        btnNowVisit.should(Condition.visible).click();
    }

    @Step("Добавление клиента в визит")
    public static void addClientInVisit(String name) {
        if (!bottomsheetSelectClient.exists()) {
            btnAddVisitor.should(Condition.visible).click();
        }
        btnSearchClient.should(Condition.visible).click();
        searchClientField.should(Condition.visible).sendKeys(name);
        androidScrollToAnElementBySecondTextWithClick(name);
    }

    @Step("Создание клиента через визит")
    public static void createClientInVisit() {
        if (!bottomsheetSelectClient.exists()) {
            btnAddVisitor.should(Condition.visible).click();
        }
        btnPlus.should(Condition.visible).click();
        if(arnica){
            androidScrollToAnElementByTextWithClick("Добавить нового клиента");
        } else if (sqns) {
            androidScrollToAnElementByTextWithClick("Добавить нового пациента");
        }

//        btnSearchClient.should(Condition.visible).click();
//        searchClientField.should(Condition.visible).sendKeys("Валерий");
//        androidScrollToAnElementByTextWithClick("Лотович Валерий");
    }

    @Step("Добавляем в визит услугу")
    public static void addToVisitService() {
        androidScrollToAnElementByTextWithClick("Добавьте услуги");
        androidScrollToAnElementByTextWithClick("Парикмахерские услуги");
        androidScrollToAnElementByTextWithClick("Стрижки");
        androidScrollToAnElementByTextWithClick("Стрижки челки");
    }

    @Step("Добавляем в визит товар")
    public static void addToVisitCommodity() {
        openBtnListSales();
        collectionBtnSaleInVisit.get(0).should(Condition.visible).click();
        androidScrollToAnElementByTextWithClick("Магазин");
        androidScrollToAnElementByTextWithClick("Кинетикс");
        androidScrollToAnElementByTextWithClick("Кинетикс пробник");
    }

    @Step("Добавляем в визит сертификат")
    public static void addToVisitCertificate() {
        openBtnListSales();
        collectionBtnSaleInVisit.get(1).should(Condition.visible).click();
        androidScrollToAnElementByTextWithClick("Подарочный сертификат 1000 руб");
    }

    @Step("Добавляем в визит абонемент")
    public static void addToVisitSubscription() {
        openBtnListSales();
        collectionBtnSaleInVisit.get(2).should(Condition.visible).click();
        androidScrollToAnElementByTextWithClick("Антицеллюлитный массаж (бедра,ягодицы)");
    }

    @Step("Меняем статус визита")
    public static void changeStatusVisit(String status) {
        btnStatusVisit.should(Condition.visible).click();
        androidScrollToAnElementByTextWithClick(status);
        btnSelectStatus.should(Condition.visible).click();
    }

    @Step("Оплачиваем визит и сохраняем")
    public static void payVisit() {
        btnAddPayment.should(Condition.visible).click();
        btnMainCashBox.should(Condition.visible).click();
        btnSaveVisit.should(Condition.visible).click();
    }
}
