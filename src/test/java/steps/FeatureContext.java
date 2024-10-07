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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import driver.EmulatorDriver;
import driver.EmulatorHelper;
import driver.WebDriverHelper;
import helper.DataHelper;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import pages.mobile.AuthPage;
import pages.mobile.ClientsPage;
import pages.mobile.DateVisit;
import pages.mobile.RatePageWidget;
import pages.mobile.SchedulePage;
import pages.mobile.SelectEmployeePage;
import pages.mobile.StatisticPage;
import pages.mobile.TimeStart;
import pages.mobile.VisitPage;
import pages.web.ClientInfoWeb;
import pages.web.LoginPageWeb;
import pages.web.RootPageWeb;
import pages.web.SchedulePageWeb;

public class FeatureContext extends EmulatorDriver {
    private static boolean isSetupDone = false;
    Long numberCard = DataHelper.getUserInfo().getNumberCard();
    String name = DataHelper.getUserInfo().getName();
    String surname = DataHelper.getUserInfo().getSurname();
    String patronymic = DataHelper.getUserInfo().getPatronymic();
    String phone = DataHelper.getUserInfo().getPhone();

    private AuthPage authPage = new AuthPage();
    private ClientsPage clientsPage;
    private DateVisit dateVisit;
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

    /**
     * Отключение анимаций на эмуляторе чтобы не лагало
     */
    private static void disableAnimationOnEmulator() { //С помощью работы данного метода и указанных команд происходит ускорение работы эмулятора
        executeBash("adb -s shell settings put global transition_animation_scale 0.0"); //Отключаем анимацию
        executeBash("adb -s shell settings put global window_animation_scale 0.0"); //Отключаем анимацию при переключении в окнах
        executeBash("adb -s shell settings put global animator_duration_scale 0.0"); //Отключаем длительность этой анимации
    }

    @Before
    public static void setup() {
        if (!isSetupDone) {
//            Инициализация AndroidDriver, напрямую нигде не взаимодействуем. runHelper возвращает конструктор по-умолчанию и вызывает getDriverClass и получаем название device
            Configuration.browser = runHelper().getDriverClass().getName();
//        Configuration.startMaximized = false; //Эмулятор не будет стартовать на весь экран
            Configuration.browserSize = null; //Не указываем размер, так как зависеть будет от устройства
            Configuration.timeout = 10000; //Ограничение по времени для взаимодействия с элементом
            disableAnimationOnEmulator(); //Вызываем метод в связи с тем, что ПК при запуске эмулятора может подвиснуть. При отключении настроек анимации проблема решается
            isSetupDone = true;
        }
    }

    @Допустим("открываю приложение")
    public void setUp() {
        if (driver == null) {
            driver = (AppiumDriver) new EmulatorDriver().createDriver(null);
            WebDriverRunner.setWebDriver(driver);
        }
    }

    @Затем("закрываю приложение")
    @After
    public void tearDown() {
        driver.quit();
        driver = null;
        isSetupDone = false;
    }

    @Допустим("открываю браузер")
    public void switchBrowser() {
        loginPageWeb = WebDriverHelper.setWebDriver();
    }

    @Затем("закрываю браузер")
    public void closeBrowser() {
        WebDriverHelper.tearDownWeb();
    }

    @И("возвращаюсь назад")
    public void goBack() {
        EmulatorHelper.goBack();
    }

    @Пусть("^жду\\s+([0-9.]+)\\s+секунд$")
    public void ждуСекунд(double seconds) throws InterruptedException {
        Thread.sleep((long) (seconds * 1000));
    }

    @И("кликаю на {string} открывая страницу {string}")
    public void iClick(String text, String pageName) {
        slowClick(elementByXpathText(text));
        switch (pageName) {
            case "AuthPage":
                authPage = new AuthPage();
                break;
            case "ClientsPage":
                clientsPage = new ClientsPage();
                break;
            case "DateVisit":
                dateVisit = new DateVisit();
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
            // Добавьте другие страницы по мере необходимости
            default:
                throw new IllegalArgumentException("Неизвестная страница: " + pageName);
        }
    }

    @И("кликаю на часть текста {string} открывая страницу {string}")
    public void iClickNotAllText(String text, String pageName) {
        $(withText(text)).click();
        switch (pageName) {
            case "AuthPage":
                authPage = new AuthPage();
                break;
            case "ClientsPage":
                clientsPage = new ClientsPage();
                break;
            case "DateVisit":
                dateVisit = new DateVisit();
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
            // Добавьте другие страницы по мере необходимости
            default:
                throw new IllegalArgumentException("Неизвестная страница: " + pageName);
        }
    }

    @И("кликаю на {string} оставаясь на текущей странице")
    public void iClickAndStayOnCurrentPage(String text) {
        slowClick(elementByXpathText(text));
        // Ничего не делаем, остаемся на текущей странице
    }

    @И("кликаю на часть текста {string} оставаясь на текущей странице")
    public void iClickNotAllTextAndStayOnCurrentPage(String text) {
        $(withText(text)).click();
        // Ничего не делаем, остаемся на текущей странице
    }

    @И("пользователь авторизуется с зарегистрированным данными")
    public void userAuthWithRegisterData() {
        ratePageWidget = authPage.authRegisterDate();
    }

//    @И("перехожу в справочник клиентов в браузере")
//    public void goToInfoClients() {
//        var urlWeb = DataHelper.getUrlInfo();
//        var authInfoWeb = DataHelper.getUserInfoWeb();
//        open(urlWeb.getUrl());
//        $(By.id("RootLoginForm_login")).sendKeys(LOGIN_WEB);
//        $(By.id("RootLoginForm_password")).sendKeys(PASSWORD_WEB);
//        $(By.cssSelector("input[type=submit]")).click();
//        $(By.cssSelector("input[title=\"Что-нибудь - название, имя, емэйл\"]")).sendKeys(authInfoWeb.getUser());
//        $(By.cssSelector("div.field.search-submit-button > button")).click();
//        $(By.linkText(authInfoWeb.getUser())).click();
//        $(By.linkText("Продажи")).click();
//        if (arnica) {
//            $(By.linkText("Клиенты")).click();
//        } else if (sqns) {
//            $(By.linkText("Пациенты")).click();
//        }
//    }

    @И("создаю клиента {string} {string} {string} {string} c номером телефона {string}")
    public void clientNewWithPhone(String numberCard, String name, String surname, String
            patronimyc, String phone) {
        clientsPage.createClientWithPhone(numberCard, name, surname, patronimyc, phone);
    }

    @И("создаю клиента с случайными данными")
    public void clientNewRandomData() {
        clientNewWithPhone("" + numberCard, name, surname, patronymic, phone);
    }

    @Тогда("вижу клиента {string} с номером телефона {string} в результате фильтра")
    public void checkResultFilterClient(String name, String phone) {
        clientsPage.checkResultClientSearch(name, phone);
    }

    @Тогда("вижу добавленного клиента с случайными данными в результате фильтра")
    public void checkClientRandomInInfo() {
        String formattedPhone = DataHelper.generateFormattedPhone(phone);
        String fullname = surname + " " + name + " " + patronymic + " ";
        clientsPage.checkResultClientSearch(fullname, formattedPhone);
    }

    @Тогда("вижу добавленного клиента {string} с номером телефона {string} в справочнике браузера")
    public void checkClientInInfo(String name, String phone) {
        clientInfoWeb.checkClientVisible(name, phone);
    }

    @Тогда("вижу добавленного клиента с случайными данными в справочнике браузера")
    public void checkClientAddRandomInfo() {
        String formattedPhone = DataHelper.generateFormattedPhone(phone);
        String fullname = surname + " " + name + " " + patronymic;
        clientInfoWeb.checkClientVisible(fullname, formattedPhone);
    }

    @И("фильтрую клиента {string}")
    public void filterClient(String name) {
        clientsPage.filterClientInfo(name);
    }

    @И("импортирую контакт из справочника клиентов")
    public void checkResultFilterClientInfo() {
        clientsPage = clientsPage.importContact();
    }

    @Тогда("вижу страницу результатов импорта")
    public void checkResultImportPage() {
        clientsPage.getTextTitleResultImport().shouldHave(exactText("Результаты"));
    }

    @И("закрываю всплывающее окно")
    public void closePopup() {
        statisticPage = ratePageWidget.closePopUpRateWidget();
    }

    @И("переключаю календарь расписания на месяц назад")
    public void switchCalendarScheduleOnMonthBack() {
        schedulePage = schedulePage.prevSwitchCalendar();
    }

    @И("переключаю календарь расписания на месяц вперед")
    public void switchCalendarScheduleOnMonthNext() {
        schedulePage = schedulePage.nextSwitchCalendar();
    }

    @И("переключаю расписание на текущий день")
    public void switchCalendarScheduleCurrentDay() {
        schedulePage.getBtnSwitchCurrentDaySchedule().click();
    }

    @Тогда("вижу дату в расписании на месяц прошлого месяца")
    public void checkDatePrevMonth() {
        String expectedPrev = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("EEE d MMMM uuuu", new Locale("ru")));
        schedulePage.getBtnSelectDayPrevMonth().should(visible).shouldHave(exactText(expectedPrev));
    }

    @Тогда("вижу дату в расписании на месяц следующего месяца")
    public void checkDateNextMonth() {
        String expectedNext = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("EEE d MMMM uuuu", new Locale("ru")));
        schedulePage.getBtnSelectDayNextMonth().should(visible).shouldHave(exactText(expectedNext));
    }

    @И("переключаю расписание на недели")
    public void switchScheduleOnWeek() {
        schedulePage = schedulePage.viewScheduleByWeek();
    }

    @Тогда("проверяю страницу расписания по неделям")
    public void checkPageScheduleOnWeeK() {
        schedulePage.getMondayText().should(visible).shouldHave(exactText("Понедельник"));
    }

    @И("кликаю на создание визита через кнопку плюс в расписании")
    public void clickOnCreateVisitWithBtnPlusInSchedule() {
        dateVisit = schedulePage.clickOnNewVisitInBtnPlus();
    }

    @Тогда("вижу календарь посещения перед созданием визита")
    public void checkCalendarVisitBeforeCreateVisit() {
        dateVisit.getTextTitleCalendarVisit().shouldHave(exactText("Дата посещения"));
    }

    @И("перехожу на страницу расписание")
    public void switchOnPageSchedule() {
        schedulePage = statisticPage.goToSchedule();
    }

    @И("перехожу в новый визит через свободное время {string} в расписании")
    public void clickOnTimeInSchedule(String string) {
        visitPage = schedulePage.createVisitClickOnFreedomTime(string);
    }

    @Тогда("вижу новый визит")
    public void checkNewVisit() {
        visitPage.getTextTitleNewVisitText().shouldHave(exactText("Новый визит"));
    }

    @Тогда("вижу {string}")
    public void checkText(String text) {
        elementByXpathText(text).shouldHave(exactText(text));
    }

    @И("перехожу в форму добавления сотрудника через расписание")
    public void goToAddEmployeeWithSchedule() {
        selectEmployeePage = schedulePage.clickOnAddEmployeeInBtnPlus();
    }

    @И("обновляю страницу расписания")
    public void updateSchedule() {
        schedulePage.updateScheduleSwipe();
    }

    @Тогда("вижу страницу расписания")
    public void checkSchedule() {
        schedulePage.getTextTitleSchedule().shouldBe(visible);
        schedulePage.getBtnPlus().shouldBe(visible);
    }

    @И("обновляю страницу статистики")
    public void updateStatistic() {
        statisticPage.clickOnBtnUpdateInStatistic();
    }

    @Тогда("страница статистики отображается без ошибок")
    public void checkStatistic() {
        statisticPage.getTitleStatistic().shouldBe(visible);
        statisticPage.getTitleVisitsStatistic().shouldBe(visible);
    }

    @И("переключаю страницу статистики на предыдущий день")
    public void switchStatisticPrevDay() {
        statisticPage.prevSwitchDayStatistic();
    }

    @И("переключаю страницу статистики на следующий день")
    public void switchStatisticNextDay() {
        statisticPage.nextSwitchDayStatistic();
    }

    @И("переключаю страницу статистики на текущий день")
    public void switchStatisticCurrentDay() {
        statisticPage.getBtnSwitchCurrentDayStatistic().click();
    }

    @И("переключаю страницу статистики по неделям")
    public void switchStatisticOnWeek() {
        String expectedCurrentDateBtnOfWeek = rangeDateCurrentWeek();

        statisticPage.switchStaticOnWeek();
        statisticPage.getTextBtnSelectCurrentWeek().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfWeek));
        statisticPage.getMainStatisticForSwipe().exists();
    }

    @И("переключаю страницу статистики по месяцам")
    public void switchStatisticOnMonth() {
        String expectedCurrentDateBtnOfMonth = monthWithYear();

        statisticPage.switchStaticOnMonth();
        statisticPage.getTextBtnSelectCurrentMonth().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfMonth));
        statisticPage.getMainStatisticForSwipe().exists();
    }

    @И("статистика за текущий день отображается верно")
    public void checkStatisticOnCurrentDaySuccess() {
        String expectedCurrentDateBtnOfDay = dateFormat(LocalDate.now(), "EEE d MMMM uuuu");

        statisticPage.getTextBtnSelectCurrentDay().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfDay));
        statisticPage.checkTitlePageStatisticViewSuccess();
    }

    @И("создаю клиента с заполненными валидными полями")
    public void createClientWithInputValidField() {
        clientsPage.createValidClient();
    }

    @И("заполняю поле {string}: {string}")
    public void sendKeysField(String field, String text) {
        EmulatorHelper.elementByXpathText(field).sendKeys(text);
    }

    @И("заполняю поле {string} случайным ФИО")
    public void sendKeysRandomField(String text) {
        sendKeysField(text, surname + " " + name);
    }

    @Допустим("логинюсь в браузере")
    public void loginInBrowser() {
        rootPageWeb = loginPageWeb.validLogin();
    }

    @И("ищу пользователя в админке по email {string} и перехожу в акаунт {string}")
    public void searchEmployeeInRoot(String email, String nameEmployee) {
        schedulePageWeb = rootPageWeb.goToEmployee(email, nameEmployee);
    }

    @И("перехожу в справочник клиентов браузера")
    public void goToClients() {
        clientInfoWeb = schedulePageWeb.goToClientInfo();
    }


//    @Дано("^заполняю \"([^\"]*)\": \"([^\"]*)\" в строке \"([^\"]*)\"$")
//    @Дано("^заполняю '([^']*)': \"([^\"]*)\" в строке \"([^\"]*)\"$")
//    @Дано("^заполняю \"([^\"]*)\": '([^']*)' в строке '([^']*)'$")
//    @Дано("^заполняю '([^']*)': '([^']*)' в строке '([^']*)'$")
//    public void fillInRow(String label, String text, String name) {
//        // Предварительная обработка текста, если необходимо
//        text = text.trim();
//        name = name.trim();
//
//        // Поиск элемента строки по тексту
//        SelenideAppiumElement row = (SelenideAppiumElement) $(byText(name)).closest("tr");
//
//        // Поиск элемента по метке внутри строки
//        SelenideAppiumElement element = (SelenideAppiumElement) row.$(byText(label)).sibling(0);
//
//        // Заполнение элемента значением
//        sendKeysAndFind(element, text);
//    }

}
