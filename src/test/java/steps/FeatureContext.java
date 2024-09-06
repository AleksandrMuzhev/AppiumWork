package steps;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.AppiumSelectors.withText;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.elementByXpathText;
import static driver.EmulatorHelper.sendKeysAndFind;
import static driver.EmulatorHelper.slowClick;
import static driver.WebDriverHelper.setWebDriver;
import static helper.Constants.LOGIN_WEB;
import static helper.Constants.PASSWORD_WEB;
import static helper.Constants.getUSER;
import static helper.Constants.getUrlWeb;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import driver.EmulatorDriver;
import driver.EmulatorHelper;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import pages.AuthPage;
import pages.ClientsPage;
import pages.RatePageWidget;
import pages.SchedulePage;
import pages.SelectEmployeePage;
import pages.StatisticPage;
import pages.VisitPage;
import tests.BaseTest;

public class FeatureContext extends BaseTest {
    private static AuthPage authPage = new AuthPage();
    private static RatePageWidget ratePageWidget;
    private static StatisticPage statisticPage;
    private static ClientsPage clientsPage;
    private static SchedulePage schedulePage;
    private static VisitPage visitPage;
    private static SelectEmployeePage selectEmployeePage;

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
    }

    @Допустим("открываю браузер")
    public void switchBrowser() {
        setWebDriver();
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
            case "RatePageWidget":
                ratePageWidget = new RatePageWidget();
                break;
            case "SchedulePage":
                schedulePage = new SchedulePage();
                break;
            case "StatisticPage":
                statisticPage = new StatisticPage();
                break;
            case "ClientsPage":
                clientsPage = new ClientsPage();
                break;
            case "AuthPage":
                authPage = new AuthPage();
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
            case "RatePageWidget":
                ratePageWidget = new RatePageWidget();
                break;
            case "SchedulePage":
                schedulePage = new SchedulePage();
                break;
            case "StatisticPage":
                statisticPage = new StatisticPage();
                break;
            case "ClientsPage":
                clientsPage = new ClientsPage();
                break;
            case "AuthPage":
                authPage = new AuthPage();
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
    public void sendKeysToElement() {
        ratePageWidget = authPage.authRegisterDate();
    }

    @И("перехожу в справочник клиентов")
    public void goToInfoClients() {
        open(getUrlWeb());
        $(By.id("RootLoginForm_login")).sendKeys(LOGIN_WEB);
        $(By.id("RootLoginForm_password")).sendKeys(PASSWORD_WEB);
        $(By.cssSelector("input[type=submit]")).click();
        $(By.cssSelector("input[title=\"Что-нибудь - название, имя, емэйл\"]")).sendKeys(getUSER());
        $(By.cssSelector("div.field.search-submit-button > button")).click();
        $(By.linkText(getUSER())).click();
        $(By.linkText("Продажи")).click();
        if (arnica) {
            $(By.linkText("Клиенты")).click();
        } else if (sqns) {
            $(By.linkText("Пациенты")).click();
        }
    }

    @И("создаю клиента {string} {string} {string} c номером телефона {string}")
    public void clientWithPhone(String name, String surname, String patronimyc, String phone) {
        clientsPage = clientsPage.createClientWithPhone(name, surname, patronimyc, phone);
    }

    @И("фильтрую клиента {string}")
    public void filterClient(String name) {
        clientsPage = clientsPage.filterClientInfo(name);
    }

    @И("импортирую контакт из справочника клиентов")
    public void checkResultFilterClientInfo() {
        clientsPage = clientsPage.importContact();
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
        schedulePage = schedulePage.clickOnNewVisitInBtnPlus();
    }

    @Тогда("вижу календарь посещения перед созданием визита")
    public void checkCalendarVisitBeforeCreateVisit() {
        visitPage.getTextTitleCalendarVisit().should(visible).shouldHave(exactText("Дата посещения"));
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
