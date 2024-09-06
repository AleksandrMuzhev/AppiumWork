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
import static driver.EmulatorHelper.slowClick;
import static driver.EmulatorHelper.swipe;
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
import lombok.Getter;

public class StatisticPage {

    /**
     * Основная страница раздела Статистика для Android (Все продукты)
     */
    private final SelenideAppiumCollection appBarStatistic = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
    @Getter
    private final SelenideAppiumElement titleStatistic = elementByXpathText("Статистика");
    private final SelenideAppiumElement btnSalonsStatistic = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[2]");
    private final SelenideAppiumCollection collectionBtnDaysStatisticForSwipe = collectionByClass("android.widget.HorizontalScrollView"); //Кнопки с датами в коллекции определяются через метод .first()
    private final SelenideAppiumElement titleFinancesStatistic = elementByXpathText("Финансы");
    private final SelenideAppiumElement titleVisitsStatistc = elementByXpathText("Визиты");
    private final SelenideAppiumElement titleCashboxStatistic = elementByXpathText("Кассы");
    private final SelenideAppiumElement titleSalaryEmployees = elementByXpathText("Зарплата сотрудников");
    private final SelenideAppiumElement titleMySalary = elementByXpathText("Моя зарплата");
    //Текст на кнопке текущего дня
    @Getter
    private final SelenideAppiumElement textBtnSelectCurrentDay = elementByXpathText(dayOfMonthCurrent());
    //Текст на кнопке текущей недели
    @Getter
    private final SelenideAppiumElement textBtnSelectCurrentWeek = elementByXpathText(rangeDateCurrentWeek());
    //Текст на кнопке текущего месяца с годом
    @Getter
    private final SelenideAppiumElement textBtnSelectCurrentMonth = elementByXpathText(monthWithYear());
    @Getter
    private final SelenideAppiumElement btnSelectPrevDay = elementByXpathText(dateOfDayPrev());
    @Getter
    private final SelenideAppiumElement btnSelectNextDay = elementByXpathText(dateOfDayNext());
    @Getter
    private final SelenideAppiumElement mainStatisticForSwipe = elementByClass("android.widget.ScrollView");
    /**
     * Основная страница раздела Статистика для Android Арника
     */
    private final SelenideAppiumElement btnSwitchCurrentDayStatisticA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button");
    private final SelenideAppiumElement btnUpdateStatisticA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[1]");
    /**
     * Основная страница раздела Статистика для Android SQNS
     */
    private final SelenideAppiumElement btnUpdateStatisticS = elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[1]");
    private final SelenideAppiumElement btnSwitchCurrentDayStatisticS = elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[4]");

    /**
     * Bottosheet (всплывающее меню) Параметры (Все продукты)
     */
    private final SelenideAppiumElement btnConfigStatic = elementByContentDesc("Параметры");
    private final SelenideAppiumElement popUpConfigStatistic = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup");
    private final SelenideAppiumElement btnClosePopupSchedule = elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[1]");
    private final SelenideAppiumElement titleStatisticPopup = elementByXpathText("Параметры статистики");
    private final SelenideAppiumElement btnOptionStatisticOnDays = elementByContentDesc("По дням");
    private final SelenideAppiumElement btnOptionStatisticOnWeek = elementByContentDesc("По неделям");
    private final SelenideAppiumElement btnOptionStatisticOnMonths = elementByContentDesc("По месяцам");

    /**
     * Конструктор на проверку видимости загрузки страницы
     */
    public StatisticPage() {
        titleStatistic.shouldBe(visible);
    }

    /**
     * Геттеры с условиями по разнице продуктов
     */
    public SelenideAppiumElement getBtnSwitchCurrentDayStatistic() {
        if (arnica) {
            return (SelenideAppiumElement) btnSwitchCurrentDayStatisticA.should(visible);
        } else if (sqns) {
            return (SelenideAppiumElement) btnSwitchCurrentDayStatisticS.should(visible);
        }
        return null;
    }

    /**
     * Готовые шаги для применения в тестах
     */
    @Step("Переход на страницу клиентов/пациентов")
    public ClientsPage goToClients() {
        if (arnica) {
            slowClick(elementByXpathText("Клиенты"));
        } else if (sqns) {
            slowClick(elementByXpathText("Пациенты"));
        }
        return new ClientsPage();
    }

    @Step("Переход на страницу клиентов/пациентов")
    public SchedulePage goToSchedule() {
        slowClick(elementByXpathText("Расписание"));
        return new SchedulePage();
    }


    @Step("Нажимаем на кнопку обновления в статистике")
    public StatisticPage clickOnBtnUpdateInStatistic() {
        if (arnica) {
            btnUpdateStatisticA.click();
        } else if (sqns) {
            btnUpdateStatisticS.click();
        }
        return new StatisticPage();
    }

    @Step("Переключаем статистику на предыдущий день")
    public StatisticPage prevSwitchDayStatistic() {
        String firstDayMonth = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("ru")).toUpperCase().substring(0, 1) +
                LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("ru")).toLowerCase().substring(1) + " " +
                "1" + " " +
                LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")) + " " +
                LocalDate.now().getYear();
        if (!textBtnSelectCurrentDay.equals(firstDayMonth)) {
            swipe((SelenideAppiumElement) collectionBtnDaysStatisticForSwipe.first(), "right", 60);
            btnSelectPrevDay.should(visible).click();
        } else {
            btnSelectPrevDay.should(visible).click();
        }
        return new StatisticPage();
    }

    @Step("Переключаем статистику на следующий день")
    public StatisticPage nextSwitchDayStatistic() {
        btnSelectNextDay.should(visible).click();
        return new StatisticPage();
    }

    @Step("Переключаем статистику по неделям")
    public StatisticPage switchStaticOnWeek() {
        btnConfigStatic.should(visible).click();
        btnOptionStatisticOnWeek.should(visible).click();
        return new StatisticPage();
    }

    @Step("Переключаем статистику по месяцам")
    public StatisticPage switchStaticOnMonth() {
        btnConfigStatic.should(visible).click();
        btnOptionStatisticOnMonths.should(visible).click();
        return new StatisticPage();
    }

    @Step("Проверяем заголовки страницы Статистика (страница отображается верно)")
    public StatisticPage checkTitlePageStatisticViewSuccess() {
        String finances = "Финансы";
        String visits = "Визиты";
        String cashBox = "Кассы";
        String salaryEmployee = "Зарплата сотрудников";
        String mySalary = "Моя зарплата";

        titleFinancesStatistic.should(visible).shouldHave(exactText(finances));
        titleVisitsStatistc.shouldHave(exactText(visits));
        swipe(mainStatisticForSwipe, "up", 50);
        titleCashboxStatistic.should(visible).shouldHave(exactText(cashBox));
        swipe(mainStatisticForSwipe, "up", 50);
        titleSalaryEmployees.shouldHave(exactText(salaryEmployee));
        swipe(mainStatisticForSwipe, "up", 50);
        titleMySalary.should(visible).shouldHave(exactText(mySalary));
        return new StatisticPage();
    }
}


