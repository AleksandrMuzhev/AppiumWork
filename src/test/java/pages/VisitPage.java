package pages;

import static com.codeborne.selenide.Condition.visible;
import static config.ConfigReader.arnica;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.collectionByXpath;
import static driver.EmulatorHelper.elementByClass;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByResourceId;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.elementByXpathText;
import static driver.EmulatorHelper.slowClick;
import static driver.EmulatorHelper.swipe;
import static helper.DateHelper.dayOfMonth;
import static helper.DateHelper.yearWithMonthValue;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import io.qameta.allure.Step;
import lombok.Getter;


public class VisitPage {
    SchedulePage schedulePage;

    /**
     * Элементы календаря перед созданием Визита для Android Арника
     */
    private final SelenideAppiumElement btnBackDateVisit = elementByContentDesc("назад");
    @Getter
    private final SelenideAppiumElement textTitleCalendarVisit = elementByXpathText("Дата посещения");
    private final SelenideAppiumElement textSelectDateVisit = elementByXpathText("Выберите дату\"]");
    private final SelenideAppiumElement btnToDayDateVisit = elementByContentDesc("сегодня");
    private final SelenideAppiumCollection dayNamesSchedule = collectionByXpath("//android.view.ViewGroup[@resource-id=\"undefined.item_\"" + yearWithMonthValue() + "\".header.dayNames\"]");
    private final SelenideAppiumElement numberDayCalendar = elementByXpath("(//android.widget.TextView[@text=\"" + dayOfMonth() + "\"])[1]");

    /**
     * Элементы Время начала перед созданием Визита для Android Арника
     */
    private final SelenideAppiumElement textTitleTimeStartVisit = elementByXpathText("Время начала");
    private final SelenideAppiumElement textSelectTimeStartVisit = elementByXpathText("Выберите или укажите");
    private final SelenideAppiumElement btnNowVisit = elementByContentDesc("сейчас");
    private final SelenideAppiumElement textNameEmployee = elementByXpathText("Стефанив Ольга Валерьевна");
    private final SelenideAppiumElement textPositionEmployee = elementByXpathText("Мастер маникюра / педикюра / подолог\"]");
    private final SelenideAppiumElement textDescriptionTimeFromTo = elementByXpathText("Время с 09:00 по 19:00");
    private final SelenideAppiumCollection mainTimeStartVisitCollection = collectionByXpath("//android.widget.ScrollView/android.view.ViewGroup");
    private final SelenideAppiumElement btnSetTimeManual = elementByContentDesc("Задать вручную");

    /**
     * Основная страница раздела Визит для Android (Все продукты)
     * Новый визит
     */
    @Getter
    private final SelenideAppiumElement textTitleNewVisitText = elementByXpathText("Новый визит");
    private final SelenideAppiumElement textDateAndTime = elementByXpathText("Дата и время\"]");
    private final SelenideAppiumElement dateField = elementByResourceId("text-input-outlined");
    private final SelenideAppiumElement btnWidgetCalendar = elementByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button");
    private final SelenideAppiumElement btnWidgetTime = elementByXpathText("\uDB82\uDD54\"]");
    private final SelenideAppiumElement textTitleVisitor = elementByXpathText("Посетитель");
    private final SelenideAppiumElement btnAddVisitor = elementByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.Button");
    private final SelenideAppiumElement textTitleServices = elementByXpathText("Услуги");
    private final SelenideAppiumElement btnAddServices = elementByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button");
    private final SelenideAppiumElement visitContentForSwipe = elementByClass("android.widget.ScrollView");

    private final SelenideAppiumElement btnListSales = elementByXpath("//android.view.ViewGroup[@content-desc=\"Продажа\"]/android.widget.Button");
    private final SelenideAppiumElement textListSales = elementByXpathText("Продажа");
    private final SelenideAppiumCollection collectionBtnSaleInVisit = collectionByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]");
    private final SelenideAppiumElement btnAddCommodity = elementByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.Button");
    private final SelenideAppiumElement btnAddCertificate = elementByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button");
    private final SelenideAppiumElement btnAddSubscription = elementByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.Button");

    private final SelenideAppiumElement textTitleCommentAndAttachments = elementByXpathText("Комментарии и вложения");
    private final SelenideAppiumElement btnListCommentAndAttachments = elementByXpath("//android.view.ViewGroup[@content-desc=\"Комментарии и вложения\"]/android.widget.Button");
    private final SelenideAppiumElement btnAddAttachments = elementByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.Button");
    private final SelenideAppiumElement commentField = elementByResourceId("text-input-flat");

    private final SelenideAppiumElement textPaymentNotAvailabel = elementByXpathText("Оплаты недоступны");
    private final SelenideAppiumElement btnClientCame = elementByContentDesc("Клиент пришел");

    private final SelenideAppiumElement btnStatusVisit = elementByContentDesc("Визит не подтвержден");
    private final SelenideAppiumElement btnSaveVisit = elementByContentDesc("Сохранить визит");

    /**
     * Bottomsheet (всплывающее меню) Выберите клиента в визите для Android Арника
     */
    private final SelenideAppiumElement bottomsheetSelectClient = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]");
    @Getter
    private final SelenideAppiumElement btnBack = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[1]");
    private final SelenideAppiumElement textTitleSelectClient = elementByXpathText("Выберите клиента");
    private final SelenideAppiumElement btnSearchClient = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[2]");
    private final SelenideAppiumElement btnPlus = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.Button");
    private final SelenideAppiumElement searchClientField = elementByXpathText("ФИО посетителя");
    private final SelenideAppiumElement btnAddNewClient = elementByContentDesc("Добавить нового клиента");
    private final SelenideAppiumElement btnImportContacts = elementByContentDesc("Импортировать из контактов");

    /**
     * Bottomsheet (всплывающее меню) Выберите клиента в визите для Android Арника
     */
    private final SelenideAppiumCollection collectionServiceCatalog = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");

    /**
     * Попап "Статус визита"
     */
    public final SelenideAppiumElement textTitleStatusVisit = elementByXpathText("Cтатус визита");
    public final SelenideAppiumElement btnSelectStatus = elementByContentDesc("Выбрать");
    public final SelenideAppiumElement btnCancelStatus = elementByContentDesc("Отмена");

    /**
     * Плашка "Добавить оплату" и далее форма "Оплата визита" для Android Арника
     */
    public final SelenideAppiumElement btnAddPayment = elementByContentDesc("Добавить оплату");
    public final SelenideAppiumElement textTitlePaymentVisit = elementByXpathText("Оплата визита");
    public final SelenideAppiumCollection paymentFields = collectionByResourceId("text-input-outlined");
    public final SelenideAppiumElement btnMainCashBox = elementByContentDesc("Основная касса");
    public final SelenideAppiumElement btnMainCurrentAccount = elementByContentDesc("Основной расчетный счет]");
    public final SelenideAppiumElement btnViewMoreVariable = elementByContentDesc("Показать больше вариантов\"]");
    public final SelenideAppiumElement btnPay = elementByContentDesc("Оплатить");

    /**
     * Конструктор для инициализации страницы
     */
    public VisitPage() {
        if (arnica) {
            btnBack.click();
        }
    }

    /**
     * Геттеры с условиями по разнице продуктов
     */
    public final SelenideAppiumElement getCheckBoxDirectoryService(String nameService) {
        return elementByXpath("//android.view.ViewGroup[@content-desc=\"" + nameService + "\"]/android.view.ViewGroup/android.widget.Button");
    }

    public final SelenideAppiumElement getCatalogService(String nameService) {
        return elementByXpath("//android.view.ViewGroup[@content-desc=\"" + nameService + "\"]");
    }

    public SelenideAppiumElement getTimeStartVisit() {
        SelenideAppiumElement targetElement = mainTimeStartVisitCollection.stream()
                .filter(element -> "09:00".equals(element.getAttribute("content-desc")))
                .findFirst()
                .orElse(null);
        return targetElement;
    }

    /**
     * Готовые шаги для применения в тестах
     */

    @Step("Если список Продажа скрыт, то кликаем для раскрытия")
    public void openBtnListSales() {
        while (!textListSales.exists()) {
            swipe(visitContentForSwipe, "up", 50);
            if (textListSales.exists()) {
                break;
            }
        }
        if (!btnAddCommodity.exists()) {
            slowClick(btnListSales);
        }
    }

//    @Step("Переходим в новый визит через кнопку Плюс расписания")
//    public void goToNewVisitWithBtnPlus() {
//        var  clickOnNewVisitInBtnPlus();
//        btnToDayDateVisit.should(visible).click();
//        btnNowVisit.should(visible).click();
//    }
//
//    @Step("Добавление клиента в визит")
//    public static void addClientInVisit(String name) {
//        if (!bottomsheetSelectClient.exists()) {
//            btnAddVisitor.should(visible).click();
//        }
//        btnSearchClient.should(visible).click();
//        searchClientField.should(visible).sendKeys(name);
//        androidScrollToAnElementBySecondTextWithClick(name);
//    }
//
//    @Step("Создание клиента через визит")
//    public static void createClientInVisit() {
//        if (!bottomsheetSelectClient.exists()) {
//            btnAddVisitor.should(visible).click();
//        }
//        btnPlus.should(visible).click();
//        if (arnica) {
//            androidScrollToAnElementByTextWithClick("Добавить нового клиента");
//        } else if (sqns) {
//            androidScrollToAnElementByTextWithClick("Добавить нового пациента");
//        }
//
////        btnSearchClient.should(Condition.visible).click();
////        searchClientField.should(Condition.visible).sendKeys("Валерий");
////        androidScrollToAnElementByTextWithClick("Лотович Валерий");
//    }
//
//    @Step("Добавляем в визит услугу")
//    public static void addToVisitService() {
//        androidScrollToAnElementByTextWithClick("Добавьте услуги");
//        androidScrollToAnElementByTextWithClick("Парикмахерские услуги");
//        androidScrollToAnElementByTextWithClick("Стрижки");
//        androidScrollToAnElementByTextWithClick("Стрижки челки");
//    }
//
//    @Step("Добавляем в визит товар")
//    public static void addToVisitCommodity() {
//        openBtnListSales();
//        collectionBtnSaleInVisit.get(0).should(visible).click();
//        androidScrollToAnElementByTextWithClick("Магазин");
//        androidScrollToAnElementByTextWithClick("Кинетикс");
//        androidScrollToAnElementByTextWithClick("Кинетикс пробник");
//    }
//
//    @Step("Добавляем в визит сертификат")
//    public static void addToVisitCertificate() {
//        openBtnListSales();
//        collectionBtnSaleInVisit.get(1).should(visible).click();
//        androidScrollToAnElementByTextWithClick("Подарочный сертификат 1000 руб");
//    }
//
//    @Step("Добавляем в визит абонемент")
//    public static void addToVisitSubscription() {
//        openBtnListSales();
//        collectionBtnSaleInVisit.get(2).should(visible).click();
//        androidScrollToAnElementByTextWithClick("Антицеллюлитный массаж (бедра,ягодицы)");
//    }
//
//    @Step("Меняем статус визита")
//    public static void changeStatusVisit(String status) {
//        btnStatusVisit.should(visible).click();
//        androidScrollToAnElementByTextWithClick(status);
//        btnSelectStatus.should(visible).click();
//    }
//
//    @Step("Оплачиваем визит и сохраняем")
//    public static void payVisit() {
//        btnAddPayment.should(visible).click();
//        btnMainCashBox.should(visible).click();
//        btnSaveVisit.should(visible).click();
//    }
}
