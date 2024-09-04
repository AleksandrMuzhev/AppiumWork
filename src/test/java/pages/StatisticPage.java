package pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.collectionByClass;
import static driver.EmulatorHelper.collectionByXpath;
import static driver.EmulatorHelper.elementByClass;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.elementByXpathText;
import static driver.EmulatorHelper.swipeToRefresh;
import static helper.DateHelper.dateOfDayNext;
import static helper.DateHelper.dateOfDayPrev;
import static helper.DateHelper.dayOfMonthCurrent;
import static helper.DateHelper.monthWithYear;
import static helper.DateHelper.rangeDateCurrentWeek;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import io.qameta.allure.Step;

public class StatisticPage {

    /**
     * Основная страница раздела Статистика для Android (Все продукты)
     */
    private static final SelenideAppiumCollection appBarStatistic = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
    private static final SelenideAppiumElement titleStatistic = elementByXpathText("Статистика");
    private static final SelenideAppiumElement btnSalonsStatistic = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[2]");
    private static final SelenideAppiumCollection collectionBtnDaysStatisticForSwipe = collectionByClass("android.widget.HorizontalScrollView"); //Кнопки с датами в коллекции определяются через метод .first()
    private static final SelenideAppiumElement titleFinancesStatistic = elementByXpathText("Финансы");
    private static final SelenideAppiumElement titleVisitsStatistc = elementByXpathText("Визиты");
    private static final SelenideAppiumElement titleCashboxStatistic = elementByXpathText("Кассы");
    private static final SelenideAppiumElement titleSalaryEmployees = elementByXpathText("Зарплата сотрудников");
    private static final SelenideAppiumElement titleMySalary = elementByXpathText("Моя зарплата");
    //Текст на кнопке текущего дня
    private static final SelenideAppiumElement textBtnSelectCurrentDay = elementByXpathText(dayOfMonthCurrent());
    //Текст на кнопке текущей недели
    private static final SelenideAppiumElement textBtnSelectCurrentWeek = elementByXpathText(rangeDateCurrentWeek());
    //Текст на кнопке текущего месяца с годом
    private static final SelenideAppiumElement textBtnSelectCurrentMonth = elementByXpathText(monthWithYear());

    private static final SelenideAppiumElement btnSelectPrevDay = elementByXpathText(dateOfDayPrev());
    private static final SelenideAppiumElement btnSelectNextDay = elementByXpathText(dateOfDayNext());
    private static final SelenideAppiumElement mainStatisticForSwipe = elementByClass("android.widget.ScrollView");
    /**
     * Основная страница раздела Статистика для Android Арника
     */
    private static final SelenideAppiumElement btnSwitchCurrentDayStatisticA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button");
    private static final SelenideAppiumElement btnUpdateStatisticA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[1]");
    /**
     * Основная страница раздела Статистика для Android SQNS
     */
    private static final SelenideAppiumElement btnUpdateStatisticS = elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[1]");
    private static final SelenideAppiumElement btnSwitchCurrentDayStatisticS = elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[4]");

    /**
     * Bottosheet (всплывающее меню) Параметры (Все продукты)
     */
    private static final SelenideAppiumElement btnConfigStatic = elementByContentDesc("Параметры");
    private static final SelenideAppiumElement popUpConfigStatistic = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup");
    private static final SelenideAppiumElement btnClosePopupSchedule = elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[1]");
    private static final SelenideAppiumElement titleStatisticPopup = elementByXpathText("Параметры статистики");
    private static final SelenideAppiumElement btnOptionStatisticOnDays = elementByContentDesc("По дням");
    private static final SelenideAppiumElement btnOptionStatisticOnWeek = elementByContentDesc("По неделям");
    private static final SelenideAppiumElement btnOptionStatisticOnMonths = elementByContentDesc("По месяцам");

    /**
     * Геттеры для обращения к полям класса из тестов
     */
    public static SelenideAppiumElement getTitleStatistic() {
        return titleStatistic;
    }

    public static SelenideAppiumElement getTextBtnSelectCurrentDay() {
        return textBtnSelectCurrentDay;
    }

    public static SelenideAppiumElement getTextBtnSelectCurrentWeek() {
        return textBtnSelectCurrentWeek;
    }

    public static SelenideAppiumElement getTextBtnSelectCurrentMonth() {
        return textBtnSelectCurrentMonth;
    }

    public static SelenideAppiumElement getBtnSelectDayPrevDay() {
        return btnSelectPrevDay;
    }

    public static SelenideAppiumElement getBtnSelectDayNextDay() {
        return btnSelectNextDay;
    }

    public static SelenideAppiumElement getBtnSwitchCurrentDayStatistic() {
        if (arnica) {
            return (SelenideAppiumElement) btnSwitchCurrentDayStatisticA.should(visible);
        } else if (sqns) {
            return (SelenideAppiumElement) btnSwitchCurrentDayStatisticS.should(visible);
        }
        return null;
    }

    public static SelenideAppiumElement getMainStatisticForSwipe() {
        return mainStatisticForSwipe;
    }

    /**
     * Готовые шаги для применения в тестах
     */
    @Step("Нажимаем на кнопку обновления в статистике")
    public static StatisticPage clickOnBtnUpdateInStatistic() {
        if (arnica) {
            btnUpdateStatisticA.click();
        } else if (sqns) {
            btnUpdateStatisticS.click();
        }
        return new StatisticPage();
    }

    @Step("Переключаем статистику на предыдущий день")
    public static void prevSwitchDayStatistic() {
        String firstDayMonth = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("ru")).toUpperCase().substring(0, 1) +
                LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("ru")).toLowerCase().substring(1) + " " +
                "1" + " " +
                LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")) + " " +
                LocalDate.now().getYear();
        if (!textBtnSelectCurrentDay.equals(firstDayMonth)) {
            swipeToRefresh((SelenideAppiumElement) collectionBtnDaysStatisticForSwipe.first(), "right", 60);
            btnSelectPrevDay.should(visible).click();
        } else {
            btnSelectPrevDay.should(visible).click();
        }

    }

    @Step("Переключаем статистику на следующий день")
    public static void nextSwitchDayStatistic() {
        btnSelectNextDay.should(visible).click();
    }

    @Step("Переключаем статистику по неделям")
    public static void switchStaticOnWeek() {
        btnConfigStatic.should(visible).click();
        btnOptionStatisticOnWeek.should(visible).click();
    }

    @Step("Переключаем статистику по месяцам")
    public static void switchStaticOnMonth() {
        btnConfigStatic.should(visible).click();
        btnOptionStatisticOnMonths.should(visible).click();
    }

    @Step("Проверяем заголовки страницы Статистика (страница отображается верно)")
    public static void checkTitlePageStatisticViewSuccess() {
        String finances = "Финансы";
        String visits = "Визиты";
        String cashBox = "Кассы";
        String salaryEmployee = "Зарплата сотрудников";
        String mySalary = "Моя зарплата";

        titleFinancesStatistic.should(visible).shouldHave(exactText(finances));
        titleVisitsStatistc.shouldHave(exactText(visits));
        swipeToRefresh(mainStatisticForSwipe, "up", 50);
        titleCashboxStatistic.should(visible).shouldHave(exactText(cashBox));
        swipeToRefresh(mainStatisticForSwipe, "up", 50);
        titleSalaryEmployees.shouldHave(exactText(salaryEmployee));
        swipeToRefresh(mainStatisticForSwipe, "up", 50);
        titleMySalary.should(visible).shouldHave(exactText(mySalary));
    }
}


