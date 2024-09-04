package pages;

import static com.codeborne.selenide.Condition.visible;
import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.collectionByXpath;
import static driver.EmulatorHelper.collectionByXpathText;
import static driver.EmulatorHelper.elementByClass;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByResourceId;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.elementByXpathText;
import static driver.EmulatorHelper.swipeToRefresh;
import static helper.DateHelper.dayOfMonth;
import static helper.DateHelper.dayOfMonthCurrent;
import static helper.DateHelper.dayOfMonthNext;
import static helper.DateHelper.dayOfMonthPrev;
import static pages.VisitPage.getBtnBack;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

import io.qameta.allure.Step;

public class SchedulePage {

    /**
     * Основная страница раздела Расписание для Android (Все продукты)
     */
    private static final SelenideAppiumElement textTitleSchedule = elementByXpathText("Расписание");
    private static final SelenideAppiumElement enterFilter = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[1]");
    private static final SelenideAppiumElement configTable = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[2]");
    private static final SelenideAppiumElement configFilter = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[3]");

    private static final SelenideAppiumCollection employeesSchedule = collectionByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    private static final SelenideAppiumElement textCabinet = elementByXpathText("Кабинет");
    private static final SelenideAppiumElement spinnerForUpdate = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.ImageView");
    private static final SelenideAppiumElement mainContentForSwipe = elementByClass("android.widget.ScrollView");

    private static final SelenideAppiumCollection btnCollectionDaysSchedule = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup");
    private static final SelenideAppiumElement btnSelectDayPrevMonth = elementByXpathText(dayOfMonthPrev());
    private static final SelenideAppiumElement btnSelectDayNextMonth = elementByXpathText(dayOfMonthNext());
    private static final SelenideAppiumElement btnSelectCurrentDay = elementByXpathText(dayOfMonthCurrent());
    /**
     * Основная страница раздела Расписание для Android Арника
     */
    private static final SelenideAppiumElement calendarBtnA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button");
    private static final SelenideAppiumElement btnSwitchCurrentDayScheduleA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button");
    /**
     * Основная страница раздела Расписание для Android SQNS
     */
    private static final SelenideAppiumElement calendarBtnS = elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[4]");
    private static final SelenideAppiumElement btnSwitchCurrentDayScheduleS = elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[5]");

    /**
     * Элементы настройки фильтра в Расписании для Android Арника
     */
    private static final SelenideAppiumElement titleFilterConfigSchedule = elementByXpathText("Фильтр");
    private static final SelenideAppiumElement btnCloseConfigFilter = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button");
    private static final SelenideAppiumElement textViewInSchedule = elementByXpathText("Показывать в расписании\"]");
    private static final SelenideAppiumCollection btnCollectionViewInSchedule = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
    private static final SelenideAppiumElement textViewPosition = elementByXpathText("Отображаемые должности");
    private static final SelenideAppiumCollection btnCollectionViewPosition = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup");
    private static final SelenideAppiumElement btnApplyFilter = elementByXpathText("Применить фильтр");
    private static final SelenideAppiumElement btnResetFilter = elementByXpathText("Сбросить");

    /**
     * Элементы календаря в Расписании для Android Арника
     */
    private static final SelenideAppiumElement titleCalendarSchedule = elementByXpathText("Выберите дату\"]");
    private static final SelenideAppiumElement btnCloseCalendar = elementByXpathText("uDB80\uDD56");
    private static final SelenideAppiumElement titleDate = elementByResourceId("undefined.header.title");
    private static final SelenideAppiumElement leftArrow = elementByXpath("//android.view.ViewGroup[@resource-id=\"undefined.header.leftArrow\"]/android.widget.ImageView");
    private static final SelenideAppiumElement rightArrow = elementByXpath("//android.view.ViewGroup[@resource-id=\"undefined.header.rightArrow\"]/android.widget.ImageView");
    private static final SelenideAppiumCollection dayNamesSchedule = collectionByResourceId("undefined.header.dayNames");
    private static final SelenideAppiumCollection daysSchedule = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
    private static final SelenideAppiumElement numberDayCalendar = elementByXpath("//android.widget.TextView[@text=\"" + dayOfMonth() + "\"]");

    /**
     * Bottosheet (всплывающее меню) сотрудника в расписании
     */
    private static final SelenideAppiumElement popUpEmployeeSchedule = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup");
    private static final SelenideAppiumElement btnClosePopupSchedule = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button");
    private static final SelenideAppiumElement infoSchedulePopupEmployee = elementByXpath("(//android.view.ViewGroup[@content-desc=\"НА, Никонова Анастасия , Директор\"])[1]");
    private static final SelenideAppiumElement firstActionTextSchedule = elementByXpathText("Быстрые действия\"]");
    private static final SelenideAppiumElement btnChangeEmployeeSchedule = elementByXpathText("Изменить сотрудника");
    private static final SelenideAppiumElement btnCallEmployeeSchedule = elementByXpathText("Позвонить");
    private static final SelenideAppiumElement timetableScheduleText = elementByXpathText("График");
    private static final SelenideAppiumElement btnPauses = elementByXpathText("Перерывы");
    private static final SelenideAppiumElement btnCancelWordDay = elementByXpathText("Отменить смену");
    private static final SelenideAppiumElement btnScheduleOnWeek = elementByXpathText("Расписание на неделю");

    /**
     * Элементы расписания на неделю
     */
    private static final SelenideAppiumElement mondayText = elementByXpathText("Понедельник");

    /**
     * Bottosheet (всплывающее меню) после нажатия на время в расписании
     */
    private static final SelenideAppiumElement titleBorrowTime = elementByXpathText("Занять время");
    private static final SelenideAppiumElement btnSelect = elementByContentDesc("Выбрать");

    /**
     * Элементы кнопки "+" в Расписании для Android Арника
     */
    private static final SelenideAppiumElement btnPlus = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.Button");
    private static final SelenideAppiumCollection bottomSheetOverPlus = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]");
    private static final SelenideAppiumElement btnAddEmployee = elementByXpathText("Добавить сотрудника");
    private static final SelenideAppiumElement btnNewVisit = elementByXpathText("Новый визит");
    private static final SelenideAppiumElement titleSelectEmployeeSchedule = elementByXpathText("Выберите сотрудника");

    /**
     * Геттеры для обращения к полям класса из тестов
     */

    public static SelenideAppiumElement getMondayText() {
        return mondayText;
    }

    public static SelenideAppiumElement getBtnPlus() {
        if (arnica) {
            return btnPlus;
        } else if (sqns) {
            return elementByResourceId("fab");
        }
        return null;
    }

    public static SelenideAppiumElement getConfigFilter() {
        if (arnica) {
            return configFilter;
        } else if (sqns) {
            return elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[3]");
        }
        return null;
    }

    public static SelenideAppiumElement getBtnSelectDayPrevMonth() {
        return btnSelectDayPrevMonth;
    }

    public static SelenideAppiumElement getBtnSelectDayNextMonth() {
        return btnSelectDayNextMonth;
    }

    public static SelenideAppiumElement getBtnSwitchCurrentDaySchedule() {
        if (arnica) {
            return (SelenideAppiumElement) btnSwitchCurrentDayScheduleA.should(visible);
        } else if (sqns) {
            return (SelenideAppiumElement) btnSwitchCurrentDayScheduleS.should(visible);
        }
        return null;
    }

    public static SelenideAppiumElement getTitleSelectEmployeeSchedule() {
        return titleSelectEmployeeSchedule;
    }

    public static SelenideAppiumElement getTextCabinet() {
        return textCabinet;
    }

    public static SelenideAppiumElement getMainContentForSwipe() {
        return mainContentForSwipe;
    }

    public static SelenideAppiumElement getCalendarBtn() {
        if (arnica) {
            return calendarBtnA;
        } else if (sqns) {
            return calendarBtnS;
        }
        return null;
    }

    /**
     * Готовые шаги для применения в тестах
     */
    @Step("Переключаем календарь на месяц назад")
    public static void prevSwitchCalendar() {
        getCalendarBtn().should(visible).click();
        leftArrow.should(visible).click();
        numberDayCalendar.should(visible).click();
    }

    @Step("Переключаем календарь на месяц вперед")
    public static void nextSwitchCalendar() {
        getCalendarBtn().should(visible).click();
        rightArrow.should(visible).click();
        numberDayCalendar.should(visible).click();
    }

    @Step("Просмотр расписания сотрудника по неделям")
    public static void viewScheduleByWeek() {
        employeesSchedule.get(0).click();
        elementByXpathText("Расписание на неделю").click();
    }

    @Step("Нажимаем на Новый визит в кнопке Плюс из Расписания")
    public static void clickOnNewVisitInBtnPlus() {
        getBtnPlus().should(visible, Duration.ofSeconds(5)).click();
        btnNewVisit.should(visible).click();
    }

    @Step("Нажимаем на Добавление сотрудника в кнопке Плюс из Расписания")
    public static void clickOnAddEmployeeInBtnPlus() {
        getBtnPlus().should(visible).click();
        btnAddEmployee.should(visible).click();
    }

    @Step("Открываем форму создания визита через нажатие на свободное время")
    public static void createVisitClickOnFreedomTime() {
        collectionByXpathText("10:00").first().should(visible).click();
        btnSelect.should(visible).click();
        if (arnica) {
            getBtnBack().click();
        }
    }


    @Step("Переходим в настройки фильтра Расписания и выбираем Кабинеты")
    public static void goToConfigFilterScheduleSelectCabinets() {
        getConfigFilter().should(visible).click();
        elementByXpathText("Кабинеты").click();
        btnApplyFilter.should(visible).click();
    }

    @Step("Тянем страницу Расписания для обновления")
    public static void updateScheduleSwipe() {
        swipeToRefresh(mainContentForSwipe, "down", 50);
    }
}
