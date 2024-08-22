//package pages;
//
//import static com.codeborne.selenide.Condition.exactText;
//import static com.codeborne.selenide.Condition.visible;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.$$;
//import static config.ConfigReader.arnica;
//import static config.ConfigReader.sqns;
//import static driver.EmulatorHelper.swipeToRefresh;
//import static helper.DateHelper.dateOfDayNext;
//import static helper.DateHelper.dateOfDayPrev;
//import static helper.DateHelper.dayOfMonthCurrent;
//import static helper.DateHelper.monthWithYear;
//import static helper.DateHelper.rangeDateCurrentWeek;
//
//import com.codeborne.selenide.ElementsCollection;
//import com.codeborne.selenide.SelenideElement;
//
//import io.appium.java_client.MobileBy;
//import io.qameta.allure.Step;
//
//public class StatisticPage {
//
//    /**
//     * Основная страница раздела Статистика для Android (Все продукты)
//     */
//    private static final ElementsCollection appBarStatistic = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"));
//    private static final SelenideElement titleStatistic = $(MobileBy.xpath("(//android.widget.TextView[@text=\"Статистика\"])[1]"));
//    private static final SelenideElement btnUpdateStatistic = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[1]"));
//    private static final SelenideElement btnSalonsStatistic = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[2]"));
//    private static final SelenideElement collectionBtnDaysStatisticForSwipe = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView"));
//    private static final SelenideElement titleFinancesStatistic = $(MobileBy.xpath("//android.widget.TextView[@text=\"Финансы\"]"));
//    private static final SelenideElement titleVisitsStatistc = $(MobileBy.xpath("//android.widget.TextView[@text=\"Визиты\"]"));
//    private static final SelenideElement titleCashboxStatistic = $(MobileBy.xpath("//android.widget.TextView[@text=\"Кассы\"]"));
//    private static final SelenideElement titleSalaryEmployees = $(MobileBy.xpath("(//android.widget.TextView[@text=\"Зарплата сотрудников\"])[1]"));
//    private static final SelenideElement titleMySalary = $(MobileBy.xpath("//android.widget.TextView[@text=\"Моя зарплата\"]"));
//    //Текст на кнопке текущего дня
//    private static final SelenideElement textBtnSelectCurrentDay = $(MobileBy.xpath("//android.widget.TextView[@text=\"" + dayOfMonthCurrent() + "\"]"));
//    //Текст на кнопке текущей недели
//    private static final SelenideElement textBtnSelectCurrentWeek = $(MobileBy.xpath("//android.widget.TextView[@text=\"" + rangeDateCurrentWeek() + "\"]"));
//    //Текст на кнопке текущего месяца с годом
//    private static final SelenideElement textBtnSelectCurrentMonth = $(MobileBy.xpath("//android.widget.TextView[@text=\"" + monthWithYear() + "\"]"));
//
//    private static final SelenideElement btnSelectPrevDay = $(MobileBy.AccessibilityId(dateOfDayPrev()));
//    private static final SelenideElement btnSelectNextDay = $(MobileBy.AccessibilityId(dateOfDayNext()));
//    private static final SelenideElement mainStatisticForSwipe = $(MobileBy.xpath("//android.widget.ScrollView"));
//    /**
//     * Основная страница раздела Статистика для Android Арника
//     */
//    private static final SelenideElement btnSwitchCurrentDayStatisticA = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button"));
//    /**
//     * Основная страница раздела Статистика для Android SQNS
//     */
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
//
//
//    /**
//     * Геттеры для обращения к полям класса из тестов
//     */
//    public static SelenideElement getTitleStatistic() {
//        return titleStatistic;
//    }
//
//    public static SelenideElement getTextBtnSelectCurrentDay() {
//        return textBtnSelectCurrentDay;
//    }
//
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
//
//    public static SelenideElement getMainStatisticForSwipe() {
//        return mainStatisticForSwipe;
//    }
//
//    public static SelenideElement getBtnConfigStatic() {
//        if (arnica) {
//            return btnConfigStaticA;
//        } else if (sqns) {
//            return btnConfigStaticS;
//        }
//        return null;
//    }
//
//    /**
//     * Готовые шаги для применения в тестах
//     */
//    @Step("Нажимаем на кнопку обновления в статистике")
//    public static void clickOnBtnUpdateInStatistic() {
//        btnUpdateStatistic.should(visible).click();
//    }
//
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
//
//    @Step("Проверяем заголовки страницы Статистика (страница отображается верно)")
//    public static void checkTitlePageStatisticViewSuccess() {
//        String finances = "Финансы";
//        String visits = "Визиты";
//        String cashBox = "Кассы";
//        String salaryEmployee = "Зарплата сотрудников";
//        String mySalary = "Моя зарплата";
//
//        titleFinancesStatistic.should(visible).shouldHave(exactText(finances));
//        titleVisitsStatistc.should(visible).shouldHave(exactText(visits));
//        swipeToRefresh(mainStatisticForSwipe, "up", 50);
//        titleCashboxStatistic.should(visible).shouldHave(exactText(cashBox));
//        titleSalaryEmployees.shouldHave(visible).shouldHave(exactText(salaryEmployee));
//        swipeToRefresh(mainStatisticForSwipe, "up", 50);
//        titleMySalary.should(visible).shouldHave(exactText(mySalary));
//    }
//}
