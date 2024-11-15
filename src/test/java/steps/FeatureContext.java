package steps;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumSelectors.withText;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static driver.EmulatorHelper.elementByXpathText;
import static driver.EmulatorHelper.slowClick;
import static helper.DateHelper.dateFormat;
import static helper.DateHelper.monthWithYear;
import static helper.DateHelper.rangeDateCurrentWeek;
import static helper.DeviceHelper.executeBash;
import static helper.RunHelper.runHelper;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import driver.EmulatorDriver;
import driver.EmulatorHelper;
import driver.WebDriverHelper;
import helper.DataHelper;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import listeners.VideoRecorder;
import pages.mobile.AddCommodity;
import pages.mobile.AuthPage;
import pages.mobile.BookingSettingPage;
import pages.mobile.ClientsPage;
import pages.mobile.CommodityPage;
import pages.mobile.CreateCommodityPage;
import pages.mobile.CreateEmployeePage;
import pages.mobile.CreateServicePage;
import pages.mobile.DateVisitPage;
import pages.mobile.EmployeesPage;
import pages.mobile.MainPage;
import pages.mobile.NewArrivalInvoicePage;
import pages.mobile.NewWriteOffPage;
import pages.mobile.OperationsCommodityPage;
import pages.mobile.ProfilePage;
import pages.mobile.ProvisionerPage;
import pages.mobile.RatePageWidget;
import pages.mobile.SchedulePage;
import pages.mobile.SelectCommodityPage;
import pages.mobile.SelectEmployeePage;
import pages.mobile.SelectStoragePage;
import pages.mobile.ServicePage;
import pages.mobile.StatisticPage;
import pages.mobile.StoragePage;
import pages.mobile.TimeStart;
import pages.mobile.VisitPage;
import pages.web.ArrivalInvoiceWeb;
import pages.web.BookingSettingWeb;
import pages.web.ClientInfoWeb;
import pages.web.CommodityPageWeb;
import pages.web.DocumentLogWeb;
import pages.web.LoginPageWeb;
import pages.web.RootPageWeb;
import pages.web.SchedulePageWeb;
import pages.web.ServicePageWeb;
import pages.web.StoragePageWeb;
import pages.web.WaybillWeb;
import pages.web.WriteOffWeb;

public class FeatureContext extends EmulatorDriver {
//    private VideoRecorder videoRecorder;
//    private boolean testFailed;
    private static boolean isSetupDone = false;
    Long numberCard = DataHelper.getUserInfo().getNumberCard();
    String name = DataHelper.getUserInfo().getName();
    String surname = DataHelper.getUserInfo().getSurname();
    String patronymic = DataHelper.getUserInfo().getPatronymic();
    String birthDay = DataHelper.getUserInfo().getBirthDay();
    String phone = DataHelper.getUserInfo().getPhone();
    String food = DataHelper.generateFood().getFood();

    private AuthPage authPage = new AuthPage();
    private ClientsPage clientsPage;
    private DateVisitPage dateVisitPage;
    private RatePageWidget ratePageWidget;
    private SchedulePage schedulePage;
    private SelectEmployeePage selectEmployeePage;
    private StatisticPage statisticPage;
    private TimeStart timeStart;
    private VisitPage visitPage;
    private ClientInfoWeb clientInfoWeb;
    private LoginPageWeb loginPageWeb;
    private RootPageWeb rootPageWeb;
    private SchedulePageWeb schedulePageWeb;
    private MainPage mainPage;
    private CommodityPage commodityPage;
    private CreateCommodityPage createCommodityPage;
    private ServicePage servicePage;
    private CreateServicePage createServicePage;
    private BookingSettingPage bookingSettingPage;
    private BookingSettingWeb bookingSettingWeb;
    private DocumentLogWeb documentLogWeb;
    private EmployeesPage employeesPage;
    private CreateEmployeePage createEmployeePage;
    private ServicePageWeb servicePageWeb;
    private CommodityPageWeb commodityPageWeb;
    private OperationsCommodityPage operationsCommodityPage;
    private StoragePage storagePage;
    private StoragePageWeb storagePageWeb;
    private AddCommodity addCommodity;
    private NewArrivalInvoicePage newArrivalInvoicePage;
    private ProvisionerPage provisionerPage;
    private SelectCommodityPage selectCommodityPage;
    private ArrivalInvoiceWeb arrivalInvoiceWeb;
    private WaybillWeb waybillWeb;
    private WriteOffWeb writeOffWeb;
    private SelectStoragePage selectStoragePage;
    private NewWriteOffPage newWriteOffPage;
    private ProfilePage profilePage;

    /**
     * Отключение анимаций на эмуляторе чтобы не лагало
     */
    private static void disableAnimationOnEmulator() { //С помощью работы данного метода и указанных команд происходит ускорение работы эмулятора
        executeBash("adb -s shell settings put global transition_animation_scale 0.0"); //Отключаем анимацию
        executeBash("adb -s shell settings put global window_animation_scale 0.0"); //Отключаем анимацию при переключении в окнах
        executeBash("adb -s shell settings put global animator_duration_scale 0.0"); //Отключаем длительность этой анимации
    }

    @Допустим("открываю приложение")
    @Step("открываю приложение")
    public void setUp() {
        if (!isSetupDone) {
            Configuration.browser = runHelper().getDriverClass().getName();
            Configuration.browserSize = null;
            Configuration.timeout = 10000; //Ограничение по времени для взаимодействия с элементом
            disableAnimationOnEmulator(); //Вызываем метод в связи с тем, что ПК при запуске эмулятора может подвиснуть. При отключении настроек анимации проблема решается
            isSetupDone = true;
        }
        if (driver == null) {
            driver = (AppiumDriver) new EmulatorDriver().createDriver(null);
            WebDriverRunner.setWebDriver(driver);
        }
    }

    @Затем("закрываю приложение")
    @After
    @Step("закрываю приложение")
    public void tearDown() {
        driver.quit();
        driver = null;
        isSetupDone = false;

//        videoRecorder.stopRecording();
//        if (testFailed) {
//            attachVideo(); // Присоединение видео к отчету только при падении теста
//        }
    }

//    @Attachment(value = "Test video", type = "video/mp4")
//    public byte[] attachVideo() {
//        Path path = Paths.get("output/video.mp4");
//        try {
//            return Files.readAllBytes(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new byte[0];
//        }
//    }

    @Допустим("открываю браузер")
    @Step("открываю браузер")
    public void switchBrowser() {
        loginPageWeb = WebDriverHelper.setWebDriver();
    }

    @Затем("закрываю браузер")
    @Step("закрываю браузер")
    public void closeBrowser() {
        WebDriverHelper.tearDownWeb();
    }

    @И("возвращаюсь назад")
    @Step("возвращаюсь назад")
    public void goBack() {
        EmulatorHelper.goBack();
    }

    @Пусть("^жду\\s+([0-9.]+)\\s+секунд$")
    @Step("^жду\\s+([0-9.]+)\\s+секунд$")
    public void ждуСекунд(double seconds) throws InterruptedException {
        Thread.sleep((long) (seconds * 1000));
    }

    @И("кликаю на {string} открывая страницу {string}")
    @Step("кликаю на {string} открывая страницу {string}")
    public void iClick(String text, String pageName) {
        slowClick(elementByXpathText(text));
        switch (pageName) {
            case "AuthPage":
                authPage = new AuthPage();
                break;
            case "ClientsPage":
                clientsPage = new ClientsPage();
                break;
            case "DateVisitPage":
                dateVisitPage = new DateVisitPage();
                break;
            case "RatePageWidget":
                ratePageWidget = new RatePageWidget();
                break;
            case "SchedulePage":
                schedulePage = new SchedulePage();
                break;
            case "SelectEmployeePage":
                selectEmployeePage = new SelectEmployeePage();
                break;
            case "StatisticPage":
                statisticPage = new StatisticPage();
                break;
            case "TimeStart":
                timeStart = new TimeStart();
                break;
            case "VisitPage":
                visitPage = new VisitPage();
                break;
            case "ClientInfoWeb":
                clientInfoWeb = new ClientInfoWeb();
                break;
            case "LoginPageWeb":
                loginPageWeb = new LoginPageWeb();
                break;
            case "RootPageWeb":
                rootPageWeb = new RootPageWeb();
                break;
            case "SchedulePageWeb":
                schedulePageWeb = new SchedulePageWeb();
                break;
            case "MainPage":
                mainPage = new MainPage();
                break;
            case "CommodityPage":
                commodityPage = new CommodityPage();
                break;
            case "CreateCommodityPage":
                createCommodityPage = new CreateCommodityPage();
                break;
            case "ServicePage":
                servicePage = new ServicePage();
                break;
            case "CreateServicePage":
                createServicePage = new CreateServicePage();
                break;
            case "BookingSettingPage":
                bookingSettingPage = new BookingSettingPage();
                break;
            case "BookingSettingWeb":
                bookingSettingWeb = new BookingSettingWeb();
                break;
            case "DocumentLogWeb":
                documentLogWeb = new DocumentLogWeb();
                break;
            case "EmployeesPage":
                employeesPage = new EmployeesPage();
                break;
            case "CreateEmployeePage":
                createEmployeePage = new CreateEmployeePage();
                break;
            case "ServicePageWeb":
                servicePageWeb = new ServicePageWeb();
                break;
            case "CommodityPageWeb":
                commodityPageWeb = new CommodityPageWeb();
                break;
            case "OperationsCommodityPage":
                operationsCommodityPage = new OperationsCommodityPage();
                break;
            case "StoragePage":
                storagePage = new StoragePage();
                break;
            case "StoragePageWeb":
                storagePageWeb = new StoragePageWeb();
                break;
            case "AddCommodity":
                addCommodity = new AddCommodity();
                break;
            case "NewArrivalInvoicePage":
                newArrivalInvoicePage = new NewArrivalInvoicePage();
                break;
            case "ProvisionerPage":
                provisionerPage = new ProvisionerPage();
                break;
            case "SelectCommodityPage":
                selectCommodityPage = new SelectCommodityPage();
                break;
            case "ArrivalInvoiceWeb":
                arrivalInvoiceWeb = new ArrivalInvoiceWeb();
                break;
            case "WaybillWeb":
                waybillWeb = new WaybillWeb();
                break;
            case "WriteOffWeb":
                writeOffWeb = new WriteOffWeb();
                break;
            case "SelectStoragePage":
                selectStoragePage = new SelectStoragePage();
                break;
            case "NewWriteOffPage":
                newWriteOffPage = new NewWriteOffPage();
                break;
            case "ProfilePage":
                profilePage = new ProfilePage();
                break;
            // Добавьте другие страницы по мере необходимости
            default:
                throw new IllegalArgumentException("Неизвестная страница: " + pageName);
        }
    }

    @И("кликаю на часть текста {string} открывая страницу {string}")
    @Step("кликаю на часть текста {string} открывая страницу {string}")
    public void iClickNotAllText(String text, String pageName) {
        $(withText(text)).click();
        switch (pageName) {
            case "AuthPage":
                authPage = new AuthPage();
                break;
            case "ClientsPage":
                clientsPage = new ClientsPage();
                break;
            case "DateVisitPage":
                dateVisitPage = new DateVisitPage();
                break;
            case "RatePageWidget":
                ratePageWidget = new RatePageWidget();
                break;
            case "SchedulePage":
                schedulePage = new SchedulePage();
                break;
            case "SelectEmployeePage":
                selectEmployeePage = new SelectEmployeePage();
                break;
            case "StatisticPage":
                statisticPage = new StatisticPage();
                break;
            case "TimeStart":
                timeStart = new TimeStart();
                break;
            case "VisitPage":
                visitPage = new VisitPage();
                break;
            case "ClientInfoWeb":
                clientInfoWeb = new ClientInfoWeb();
                break;
            case "LoginPageWeb":
                loginPageWeb = new LoginPageWeb();
                break;
            case "RootPageWeb":
                rootPageWeb = new RootPageWeb();
                break;
            case "SchedulePageWeb":
                schedulePageWeb = new SchedulePageWeb();
                break;
            case "MainPage":
                mainPage = new MainPage();
                break;
            case "CommodityPage":
                commodityPage = new CommodityPage();
                break;
            case "CreateCommodityPage":
                createCommodityPage = new CreateCommodityPage();
                break;
            case "ServicePage":
                servicePage = new ServicePage();
                break;
            case "CreateServicePage":
                createServicePage = new CreateServicePage();
                break;
            case "BookingSettingPage":
                bookingSettingPage = new BookingSettingPage();
                break;
            case "BookingSettingWeb":
                bookingSettingWeb = new BookingSettingWeb();
                break;
            case "DocumentLogWeb":
                documentLogWeb = new DocumentLogWeb();
                break;
            case "EmployeesPage":
                employeesPage = new EmployeesPage();
                break;
            case "CreateEmployeePage":
                createEmployeePage = new CreateEmployeePage();
                break;
            case "ServicePageWeb":
                servicePageWeb = new ServicePageWeb();
                break;
            case "CommodityPageWeb":
                commodityPageWeb = new CommodityPageWeb();
                break;
            case "OperationsCommodityPage":
                operationsCommodityPage = new OperationsCommodityPage();
                break;
            case "StoragePage":
                storagePage = new StoragePage();
                break;
            case "StoragePageWeb":
                storagePageWeb = new StoragePageWeb();
                break;
            case "AddCommodity":
                addCommodity = new AddCommodity();
                break;
            case "NewArrivalInvoicePage":
                newArrivalInvoicePage = new NewArrivalInvoicePage();
                break;
            case "ProvisionerPage":
                provisionerPage = new ProvisionerPage();
                break;
            case "SelectCommodityPage":
                selectCommodityPage = new SelectCommodityPage();
                break;
            case "ArrivalInvoiceWeb":
                arrivalInvoiceWeb = new ArrivalInvoiceWeb();
                break;
            case "WaybillWeb":
                waybillWeb = new WaybillWeb();
                break;
            case "WriteOffWeb":
                writeOffWeb = new WriteOffWeb();
                break;
            case "SelectStoragePage":
                selectStoragePage = new SelectStoragePage();
                break;
            case "NewWriteOffPage":
                newWriteOffPage = new NewWriteOffPage();
                break;
            case "ProfilePage":
                profilePage = new ProfilePage();
                break;
            // Добавьте другие страницы по мере необходимости
            default:
                throw new IllegalArgumentException("Неизвестная страница: " + pageName);
        }
    }

    @И("кликаю на {string} оставаясь на текущей странице")
    @Step("кликаю на {string} оставаясь на текущей странице")
    public void iClickAndStayOnCurrentPage(String text) {
        slowClick(elementByXpathText(text));
        // Ничего не делаем, остаемся на текущей странице
    }

    @И("кликаю на часть текста {string} оставаясь на текущей странице")
    @Step("кликаю на часть текста {string} оставаясь на текущей странице")
    public void iClickNotAllTextAndStayOnCurrentPage(String text) {
        $(withText(text)).click();
        // Ничего не делаем, остаемся на текущей странице
    }

    @И("пользователь авторизуется с зарегистрированным данными")
    @Step("пользователь авторизуется с зарегистрированным данными")
    public void userAuthWithRegisterData() {
        ratePageWidget = authPage.authRegisterDate();
    }

    @И("создаю клиента {string} {string} {string} {string} c номером телефона {string}")
    @Step("создаю клиента {string} {string} {string} {string} c номером телефона {string}")
    public void clientNewWithPhone(String numberCard, String name, String surname, String patronimyc, String birthDay, String phone) {
        clientsPage.createClientRandom(numberCard, name, surname, patronimyc, birthDay, phone);
    }

    @И("создаю клиента с случайными данными")
    @Step("создаю клиента с случайными данными")
    public void clientNewRandomData() {
        clientNewWithPhone("" + numberCard, name, surname, patronymic, birthDay, phone);
    }

    @Тогда("вижу клиента {string} с номером телефона {string} в результате фильтра")
    @Step("вижу клиента {string} с номером телефона {string} в результате фильтра")
    public void checkResultFilterClient(String name, String phone) {
        clientsPage.checkResultClientSearch(name, phone);
    }

    @Тогда("вижу добавленного клиента с случайными данными в результате фильтра")
    @Step("вижу добавленного клиента с случайными данными в результате фильтра")
    public void checkClientRandomInInfo() {
        String formattedPhone = DataHelper.formattedPhoneMob(phone);
        String fullname = surname + " " + name + " " + patronymic + " ";
        clientsPage.checkResultClientSearch(fullname, formattedPhone);
    }

    @Тогда("вижу добавленного клиента {string} с номером телефона {string} в справочнике браузера")
    @Step("вижу добавленного клиента {string} с номером телефона {string} в справочнике браузера")
    public void checkClientInInfo(String name, String phone) {
        clientInfoWeb.checkClientVisible(name, phone);
    }

    @Тогда("вижу добавленного клиента с случайными данными в справочнике браузера")
    @Step("вижу добавленного клиента с случайными данными в справочнике браузера")
    public void checkClientAddRandomInfo() {
        String formattedPhone = DataHelper.formattedPhoneWeb(phone);
        String fullname = surname + " " + name + " " + patronymic;
        clientInfoWeb.checkClientVisible(fullname, formattedPhone);
    }

    @И("фильтрую клиента {string}")
    @Step("фильтрую клиента {string}")
    public void filterClient(String name) {
        clientsPage.filterClientInfo(name);
    }

    @И("импортирую контакт из справочника клиентов")
    @Step("импортирую контакт из справочника клиентов")
    public void checkResultFilterClientInfo() {
        clientsPage = clientsPage.importContact();
    }

    @Тогда("вижу страницу результатов импорта")
    @Step("вижу страницу результатов импорта")
    public void checkResultImportPage() {
        clientsPage.getTextTitleResultImport().shouldHave(exactText("Результаты"));
    }

    @И("закрываю всплывающее окно")
    @Step("закрываю всплывающее окно")
    public void closePopup() {
        statisticPage = ratePageWidget.closePopUpRateWidget();
    }

    @И("переключаю календарь расписания на месяц назад")
    @Step("переключаю календарь расписания на месяц назад")
    public void switchCalendarScheduleOnMonthBack() {
        schedulePage = schedulePage.prevSwitchCalendar();
    }

    @И("переключаю календарь расписания на месяц вперед")
    @Step("переключаю календарь расписания на месяц вперед")
    public void switchCalendarScheduleOnMonthNext() {
        schedulePage = schedulePage.nextSwitchCalendar();
    }

    @И("переключаю расписание на текущий день")
    @Step("переключаю расписание на текущий день")
    public void switchCalendarScheduleCurrentDay() {
        schedulePage.getBtnSwitchCurrentDaySchedule().click();
    }

    @Тогда("вижу дату в расписании на месяц прошлого месяца")
    @Step("вижу дату в расписании на месяц прошлого месяца")
    public void checkDatePrevMonth() {
        String expectedPrev = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("EEE d MMMM uu", new Locale("ru")));
        schedulePage.getBtnSelectDayPrevMonth().should(visible).shouldHave(exactText(expectedPrev));
    }

    @Тогда("вижу дату в расписании на месяц следующего месяца")
    @Step("вижу дату в расписании на месяц следующего месяца")
    public void checkDateNextMonth() {
        String expectedNext = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("EEE d MMMM uuuu", new Locale("ru")));
        schedulePage.getBtnSelectDayNextMonth().should(visible).shouldHave(exactText(expectedNext));
    }

    @И("переключаю расписание на недели")
    @Step("переключаю расписание на недели")
    public void switchScheduleOnWeek() {
        schedulePage = schedulePage.viewScheduleByWeek();
    }

    @Тогда("проверяю страницу расписания по неделям")
    @Step("проверяю страницу расписания по неделям")
    public void checkPageScheduleOnWeeK() {
        schedulePage.getMondayText().should(visible).shouldHave(exactText("Понедельник"));
    }

    @И("кликаю на создание визита через кнопку плюс в расписании")
    @Step("кликаю на создание визита через кнопку плюс в расписании")
    public void clickOnCreateVisitWithBtnPlusInSchedule() {
        dateVisitPage = schedulePage.clickOnNewVisitInBtnPlus();
    }

    @Тогда("вижу календарь посещения перед созданием визита")
    @Step("вижу календарь посещения перед созданием визита")
    public void checkCalendarVisitBeforeCreateVisit() {
        dateVisitPage.getTextTitleCalendarVisit().shouldHave(exactText("Дата посещения"));
    }

    @И("перехожу на страницу расписание")
    @Step
    public void switchOnPageSchedule() {
        schedulePage = statisticPage.goToSchedule();
    }

    @И("перехожу в новый визит через свободное время {string} в расписании")
    @Step("перехожу в новый визит через свободное время {string} в расписании")
    public void clickOnTimeInSchedule(String string) {
        visitPage = schedulePage.createVisitClickOnFreedomTime(string);
    }

    @Тогда("вижу новый визит")
    @Step("вижу новый визит")
    public void checkNewVisit() {
        visitPage.getTextTitleNewVisitText().shouldHave(exactText("Новый визит"));
    }

    @Тогда("вижу {string}")
    @Step("вижу {string}")
    public void checkText(String text) {
        elementByXpathText(text).shouldHave(exactText(text));
    }

    @И("перехожу в форму добавления сотрудника через расписание")
    @Step("перехожу в форму добавления сотрудника через расписание")
    public void goToAddEmployeeWithSchedule() {
        selectEmployeePage = schedulePage.clickOnAddEmployeeInBtnPlus();
    }

    @И("обновляю страницу расписания")
    @Step("обновляю страницу расписания")
    public void updateSchedule() {
        schedulePage.updateScheduleSwipe();
    }

    @Тогда("вижу страницу расписания")
    @Step("вижу страницу расписания")
    public void checkSchedule() {
        schedulePage.getTextTitleSchedule().shouldBe(visible);
        schedulePage.getBtnPlus().shouldBe(visible);
    }

    @И("обновляю страницу статистики")
    @Step("обновляю страницу статистики")
    public void updateStatistic() {
        statisticPage.clickOnBtnUpdateInStatistic();
    }

    @Тогда("страница статистики отображается без ошибок")
    @Step("страница статистики отображается без ошибок")
    public void checkStatistic() {
        statisticPage.getTitleStatistic().shouldBe(visible);
        statisticPage.getTitleVisitsStatistic().shouldBe(visible);
    }

    @И("переключаю страницу статистики на предыдущий день")
    @Step("переключаю страницу статистики на предыдущий день")
    public void switchStatisticPrevDay() {
        statisticPage.prevSwitchDayStatistic();
    }

    @И("переключаю страницу статистики на следующий день")
    @Step("переключаю страницу статистики на следующий день")
    public void switchStatisticNextDay() {
        statisticPage.nextSwitchDayStatistic();
    }

    @И("переключаю страницу статистики на текущий день")
    @Step("переключаю страницу статистики на текущий день")
    public void switchStatisticCurrentDay() {
        statisticPage.getBtnSwitchCurrentDayStatistic().click();
    }

    @И("переключаю страницу статистики по неделям")
    @Step("переключаю страницу статистики по неделям")
    public void switchStatisticOnWeek() {
        String expectedCurrentDateBtnOfWeek = rangeDateCurrentWeek();

        statisticPage.switchStaticOnWeek();
        statisticPage.getTextBtnSelectCurrentWeek().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfWeek));
        statisticPage.getMainStatisticForSwipe().exists();
    }

    @И("переключаю страницу статистики по месяцам")
    @Step("переключаю страницу статистики по месяцам")
    public void switchStatisticOnMonth() {
        String expectedCurrentDateBtnOfMonth = monthWithYear();

        statisticPage.switchStaticOnMonth();
        statisticPage.getTextBtnSelectCurrentMonth().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfMonth));
        statisticPage.getMainStatisticForSwipe().exists();
    }

    @И("статистика за текущий день отображается верно")
    @Step("статистика за текущий день отображается верно")
    public void checkStatisticOnCurrentDaySuccess() {
        String expectedCurrentDateBtnOfDay = dateFormat(LocalDate.now(), "EEE d MMMM uuuu");

        statisticPage.getTextBtnSelectCurrentDay().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfDay));
        statisticPage.checkTitlePageStatisticViewSuccess();
    }

    @И("создаю клиента с заполненными валидными полями")
    @Step("создаю клиента с заполненными валидными полями")
    public void createClientWithInputValidField() {
        clientsPage.createValidClient();
    }

    @И("заполняю поле {string}: {string}")
    @Step("заполняю поле {string}: {string}")
    public void sendKeysField(String field, String text) {
        EmulatorHelper.elementByXpathText(field).sendKeys(text);
    }

    @И("заполняю поле {string} случайным ФИО")
    @Step("заполняю поле {string} случайным ФИО")
    public void sendKeysRandomField(String text) {
        sendKeysField(text, surname + " " + name);
    }

    @Допустим("логинюсь в браузере")
    @Step("логинюсь в браузере")
    public void loginInBrowser() {
        rootPageWeb = loginPageWeb.validLogin();
    }

    @И("ищу организацию {string} в админке и перехожу в акаунт {string}")
    @Step("ищу организацию {string} в админке и перехожу в акаунт {string}")
    public void searchEmployeeInRoot(String searchText, String nameEmployee) {
        schedulePageWeb = rootPageWeb.goToEmployee(searchText, nameEmployee);
    }

    @И("перехожу в справочник клиентов браузера")
    @Step("перехожу в справочник клиентов браузера")
    public void goToClients() {
        clientInfoWeb = schedulePageWeb.goToClientInfo();
    }

    @И("создаю товар с случайными данными")
    @Step("создаю товар с случайными данными")
    public void commodityNewRandom() {
        createCommodityPage = commodityPage.goToCreateCommodity();
        commodityPage = createCommodityPage.createRandomCommodity(food);
    }

    @И("фильтрую справочник товаров по случайному названию")
    @Step("фильтрую справочник товаров по случайному названию")
    public void filterCommodity() {
        commodityPage.filterFoodName(food);
    }

    @Тогда("вижу добавленный товар с случайными данными в результате фильтра")
    @Step("вижу добавленный товар с случайными данными в результате фильтра")
    public void checkCommodityRandomInInfo() {
        commodityPage.checkResultClientSearch(food);
    }

    @И("создаю услугу с случайными данными")
    @Step("создаю услугу с случайными данными")
    public void serviceNewRandom() {
        createServicePage = servicePage.goToCreateService();
        servicePage = createServicePage.createService(food);
    }

    @И("фильтрую справочник услуг по случайному названию")
    @Step("фильтрую справочник услуг по случайному названию")
    public void filterService() {
        servicePage.filterServiceName(food);
    }

    @Тогда("вижу добавленную услугу с случайными данными в результате фильтра")
    @Step("вижу добавленную услугу с случайными данными в результате фильтра")
    public void checkServiceRandomInInfo() {
        commodityPage.checkResultClientSearch(food);
    }
}
