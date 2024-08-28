package pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.collectionByClass;
import static driver.EmulatorHelper.collectionByXpath;
import static driver.EmulatorHelper.elementByClass;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.elementByXpathText;
import static driver.EmulatorHelper.swipeToRefresh;
import static helper.DateHelper.dayOfMonthCurrent;
import static helper.DateHelper.monthWithYear;
import static helper.DateHelper.rangeDateCurrentWeek;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

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

    //    private static final SelenideElement btnSelectPrevDay = $(MobileBy.AccessibilityId(dateOfDayPrev()));
//    private static final SelenideElement btnSelectNextDay = $(MobileBy.AccessibilityId(dateOfDayNext()));
    private static final SelenideAppiumElement mainStatisticForSwipe = elementByClass("android.widget.ScrollView");
    /**
     * Основная страница раздела Статистика для Android Арника
     */
//    private static final SelenideElement btnSwitchCurrentDayStatisticA = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button"));
    private static final SelenideAppiumElement btnUpdateStatisticA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[1]");
    /**
     * Основная страница раздела Статистика для Android SQNS
     */
    private static final SelenideAppiumElement btnUpdateStatisticS = elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[1]");

//    private static final SelenideElement btnSwitchCurrentDayStatisticS = $(MobileBy.xpath("(//android.widget.Button[@resource-id=\"icon-button\"])[3]"));
//
//    /**
//     * Bottosheet (всплывающее меню) Параметры (Все продукты)
//     */
//    private static final SelenideElement popUpConfigStatistic = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup"));
//    private static final SelenideElement btnClosePopupSchedule = $(MobileBy.xpath("(//android.widget.Button[@resource-id=\"icon-button\"])[1]"));
//    private static final SelenideElement titleStatisticPopup = $(MobileBy.xpath("//android.widget.TextView[@text=\"Параметры статистики\"]"));
//    private static final SelenideElement btnOptionStatisticOnDays = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"По дням\"]"));
//    private static final SelenideElement btnOptionStatisticOnWeek = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"По неделям\"]"));
//    private static final SelenideElement btnOptionStatisticOnMonths = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"По месяцам\"]"));
//    /**
//     * Bottosheet (всплывающее меню) Параметры Арника
//     */
//    private static final SelenideElement btnConfigStaticA = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Параметры\"]"));
//    /**
//     * Bottosheet (всплывающее меню) Параметры SQNS
//     */
//    private static final SelenideElement btnConfigStaticS = $(MobileBy.id("com.medicalru.app.android:id/Параметры"));


    /**
     * Геттеры для обращения к полям класса из тестов
     */
//    public static SelenideElement getTitleStatistic() {
//        return titleStatistic;
//    }
    public static SelenideAppiumElement getTextBtnSelectCurrentDay() {
        return textBtnSelectCurrentDay;
    }

    //    public static SelenideElement getTextBtnSelectCurrentWeek() {
//        return textBtnSelectCurrentWeek;
//    }
//
//    public static SelenideElement getTextBtnSelectCurrentMonth() {
//        return textBtnSelectCurrentMonth;
//    }
//
//    public static SelenideElement getBtnSelectDayPrevDay() {
//        return btnSelectPrevDay;
//    }
//
//    public static SelenideElement getBtnSelectDayNextDay() {
//        return btnSelectNextDay;
//    }
//
//    public static SelenideElement getBtnSwitchCurrentDayStatistic() {
//        if (arnica) {
//            return btnSwitchCurrentDayStatisticA.should(visible);
//        } else if (sqns) {
//            return btnSwitchCurrentDayStatisticS.should(visible);
//        }
//        return null;
//    }
    public static SelenideAppiumElement getMainStatisticForSwipe() {
        return mainStatisticForSwipe;
    }

//    public static SelenideElement getBtnConfigStatic() {
//        if (arnica) {
//            return btnConfigStaticA;
//        } else if (sqns) {
//            return btnConfigStaticS;
//        }
//        return null;
//    }
//

    /**
     * Готовые шаги для применения в тестах
     */
    @Step("Нажимаем на кнопку обновления в статистике")
    public static void clickOnBtnUpdateInStatistic() {
        if (arnica) {
            btnUpdateStatisticA.should(visible).click();
        } else if (sqns) {
            btnUpdateStatisticS.should(visible).click();
        }
    }
//    @Step("Переключаем статистику на предыдущий день")
//    public static void prevSwitchDayStatistic() {
////        String firstDayMonth = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("ru")).toUpperCase().substring(0, 1) +
////                LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("ru")).toLowerCase().substring(1) + " " +
////                "1" + " " +
////                LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")) + " " +
////                LocalDate.now().getYear();
////        System.out.println("textBtnSelectCurrentDay = " + textBtnSelectCurrentDay);
////        System.out.println("firstDayMonth = " + firstDayMonth);
////        if (!textBtnSelectCurrentDay.equals(firstDayMonth)) {
//        swipeToRefresh(collectionBtnDaysStatisticForSwipe, "right", 60);
//        btnSelectPrevDay.should(visible).click();
////        } else {
////            btnSelectPrevDay.should(Condition.visible).click();
////        }
//
//    }
//
//    @Step("Переключаем статистику на следующий день")
//    public static void nextSwitchDayStatistic() {
//        btnSelectNextDay.should(visible).click();
//    }
//
//    @Step("Переключаем статистику по неделям")
//    public static void switchStaticOnWeek() {
//        getBtnConfigStatic().should(visible).click();
//        btnOptionStatisticOnWeek.should(visible).click();
//    }
//
//    @Step("Переключаем статистику по месяцам")
//    public static void switchStaticOnMonth() {
//        getBtnConfigStatic().should(visible).click();
//        btnOptionStatisticOnMonths.should(visible).click();
//    }

    @Step("Проверяем заголовки страницы Статистика (страница отображается верно)")
    public static void checkTitlePageStatisticViewSuccess() {
        String finances = "Финансы";
        String visits = "Визиты";
        String cashBox = "Кассы";
        String salaryEmployee = "Зарплата сотрудников";
        String mySalary = "Моя зарплата";

        titleFinancesStatistic.should(visible).shouldHave(exactText(finances));
        titleVisitsStatistc.should(visible).shouldHave(exactText(visits));
        swipeToRefresh(mainStatisticForSwipe, "up", 50);
        titleCashboxStatistic.should(visible).shouldHave(exactText(cashBox));
        titleSalaryEmployees.shouldHave(visible).shouldHave(exactText(salaryEmployee));
        swipeToRefresh(mainStatisticForSwipe, "up", 50);
        titleMySalary.should(visible).shouldHave(exactText(mySalary));
    }
}


