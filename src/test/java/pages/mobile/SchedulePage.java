package pages.mobile;

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
import static driver.EmulatorHelper.swipe;
import static helper.DateHelper.dayOfMonth;
import static helper.DateHelper.dayOfMonthCurrent;
import static helper.DateHelper.dayOfMonthNext;
import static helper.DateHelper.dayOfMonthPrev;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

import io.qameta.allure.Step;
import lombok.Getter;

/**
 * Страница расписания
 */
public class SchedulePage {

    /**
     * Основная страница раздела Расписание для Android (Все продукты)
     */
    @Getter
    private final SelenideAppiumElement textTitleSchedule = elementByXpathText("Расписание");
    private final SelenideAppiumElement enterFilter = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[1]");
    private final SelenideAppiumElement configTable = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[2]");
    private final SelenideAppiumElement configFilter = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[3]");

    private final SelenideAppiumCollection employeesSchedule = collectionByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    @Getter
    private final SelenideAppiumElement textCabinet = elementByXpathText("Кабинет");
    private final SelenideAppiumElement spinnerForUpdate = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.ImageView");
    @Getter
    private final SelenideAppiumElement mainContentForSwipe = elementByClass("android.widget.ScrollView");

    private final SelenideAppiumCollection btnCollectionDaysSchedule = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup");
    @Getter
    private final SelenideAppiumElement btnSelectDayPrevMonth = elementByXpathText(dayOfMonthPrev());
    @Getter
    private final SelenideAppiumElement btnSelectDayNextMonth = elementByXpathText(dayOfMonthNext());
    private final SelenideAppiumElement btnSelectCurrentDay = elementByXpathText(dayOfMonthCurrent());
    private final SelenideAppiumElement btnAddEmployeePage = elementByContentDesc("Добавить сотрудника");
    /**
     * Основная страница раздела Расписание для Android Арника
     */
    private final SelenideAppiumElement calendarBtnA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button");
    private final SelenideAppiumElement btnSwitchCurrentDayScheduleA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button");
    /**
     * Основная страница раздела Расписание для Android SQNS
     */
    private final SelenideAppiumElement calendarBtnS = elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[4]");
    private final SelenideAppiumElement btnSwitchCurrentDayScheduleS = elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[5]");

    /**
     * Элементы настройки фильтра в Расписании для Android Арника
     */
    private final SelenideAppiumElement titleFilterConfigSchedule = elementByXpathText("Фильтр");
    private final SelenideAppiumElement btnCloseConfigFilter = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button");
    private final SelenideAppiumElement textViewInSchedule = elementByXpathText("Показывать в расписании\"]");
    private final SelenideAppiumCollection btnCollectionViewInSchedule = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
    private final SelenideAppiumElement textViewPosition = elementByXpathText("Отображаемые должности");
    private final SelenideAppiumCollection btnCollectionViewPosition = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup");
    private final SelenideAppiumElement btnApplyFilter = elementByXpathText("Применить фильтр");
    private final SelenideAppiumElement btnResetFilter = elementByXpathText("Сбросить");

    /**
     * Элементы календаря в Расписании для Android Арника
     */
    private final SelenideAppiumElement titleCalendarSchedule = elementByXpathText("Выберите дату\"]");
    private final SelenideAppiumElement btnCloseCalendar = elementByXpathText("uDB80\uDD56");
    private final SelenideAppiumElement titleDate = elementByResourceId("undefined.header.title");
    private final SelenideAppiumElement leftArrow = elementByXpath("//android.view.ViewGroup[@resource-id=\"undefined.header.leftArrow\"]/android.widget.ImageView");
    private final SelenideAppiumElement rightArrow = elementByXpath("//android.view.ViewGroup[@resource-id=\"undefined.header.rightArrow\"]/android.widget.ImageView");
    private final SelenideAppiumCollection dayNamesSchedule = collectionByResourceId("undefined.header.dayNames");
    private final SelenideAppiumCollection daysSchedule = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
    private final SelenideAppiumElement numberDayCalendar = elementByXpath("//android.widget.TextView[@text=\"" + dayOfMonth() + "\"]");

    /**
     * Bottosheet (всплывающее меню) сотрудника в расписании
     */
    private final SelenideAppiumElement popUpEmployeeSchedule = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup");
    private final SelenideAppiumElement btnClosePopupSchedule = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button");
    private final SelenideAppiumElement infoSchedulePopupEmployee = elementByXpath("(//android.view.ViewGroup[@content-desc=\"НА, Никонова Анастасия , Директор\"])[1]");
    private final SelenideAppiumElement firstActionTextSchedule = elementByXpathText("Быстрые действия\"]");
    private final SelenideAppiumElement btnChangeEmployeeSchedule = elementByXpathText("Изменить сотрудника");
    private final SelenideAppiumElement btnCallEmployeeSchedule = elementByXpathText("Позвонить");
    private final SelenideAppiumElement timetableScheduleText = elementByXpathText("График");
    private final SelenideAppiumElement btnPauses = elementByXpathText("Перерывы");
    private final SelenideAppiumElement btnCancelWordDay = elementByXpathText("Отменить смену");
    private final SelenideAppiumElement btnScheduleOnWeek = elementByXpathText("Расписание на неделю");

    /**
     * Элементы расписания на неделю
     */
    @Getter
    private final SelenideAppiumElement mondayText = elementByXpathText("Понедельник");

    /**
     * Bottosheet (всплывающее меню) после нажатия на время в расписании
     */
    private final SelenideAppiumElement titleBorrowTime = elementByXpathText("Занять время");
    private final SelenideAppiumElement btnSelect = elementByContentDesc("Выбрать");

    /**
     * Элементы кнопки "+" в Расписании для Android Арника
     */
    private final SelenideAppiumElement btnPlusA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.Button");
    private final SelenideAppiumCollection bottomSheetOverPlus = collectionByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]");
    private final SelenideAppiumElement btnAddEmployee = elementByXpathText("Добавить сотрудника");
    private final SelenideAppiumElement btnNewVisit = elementByXpathText("Новый визит");
    @Getter
    private final SelenideAppiumElement titleSelectEmployeeSchedule = elementByXpathText("Выберите сотрудника");

    /**
     * Элементы кнопки "+" в Расписании для Android Арника
     */
    private final SelenideAppiumElement btnPlusS = elementByResourceId("fab");


    /**
     * Конструктор на проверку видимости загрузки страницы
     */
    public SchedulePage() {
        textTitleSchedule.shouldBe(visible);
    }

    /**
     * Геттеры с условиями по разнице продуктов
     */

    public SelenideAppiumElement getBtnPlus() {
        if (arnica) {
            return btnPlusA;
        } else if (sqns) {
            return btnPlusS;
        }
        return null;
    }

    public SelenideAppiumElement getConfigFilter() {
        if (arnica) {
            return configFilter;
        } else if (sqns) {
            return elementByXpath("(//android.widget.Button[@resource-id=\"icon-button\"])[3]");
        }
        return null;
    }

    public SelenideAppiumElement getBtnSwitchCurrentDaySchedule() {
        if (arnica) {
            return (SelenideAppiumElement) btnSwitchCurrentDayScheduleA.should(visible);
        } else if (sqns) {
            return (SelenideAppiumElement) btnSwitchCurrentDayScheduleS.should(visible);
        }
        return null;
    }

    public SelenideAppiumElement getCalendarBtn() {
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
    public SchedulePage prevSwitchCalendar() {
        getCalendarBtn().should(visible).click();
        leftArrow.should(visible).click();
        numberDayCalendar.should(visible).click();
        return new SchedulePage();
    }

    @Step("Переключаем календарь на месяц вперед")
    public SchedulePage nextSwitchCalendar() {
        getCalendarBtn().should(visible).click();
        rightArrow.should(visible).click();
        numberDayCalendar.should(visible).click();
        return new SchedulePage();
    }

    @Step("Просмотр расписания сотрудника по неделям")
    public SchedulePage viewScheduleByWeek() {
        if (!employeesSchedule.get(0).exists()) {
            btnAddEmployeePage.click();
        }
        employeesSchedule.get(0).click();
        elementByXpathText("Расписание на неделю").click();
        return new SchedulePage();
    }

    @Step("Нажимаем на Новый визит в кнопке Плюс из Расписания")
    public DateVisit clickOnNewVisitInBtnPlus() {
        getBtnPlus().should(visible, Duration.ofSeconds(5)).click();
        btnNewVisit.should(visible).click();
        return new DateVisit();
    }

    @Step("Нажимаем на Добавление сотрудника в кнопке Плюс из Расписания")
    public SelectEmployeePage clickOnAddEmployeeInBtnPlus() {
        getBtnPlus().should(visible).click();
        btnAddEmployee.should(visible).click();
        return new SelectEmployeePage();
    }

    @Step("Открываем форму создания визита через нажатие на свободное время")
    public VisitPage createVisitClickOnFreedomTime(String time) {
        collectionByXpathText(time).first().should(visible).click();
        btnSelect.should(visible).click();
        return new VisitPage();
    }


    @Step("Переходим в настройки фильтра Расписания и выбираем Кабинеты/Пациенты")
    public SchedulePage goToConfigFilterScheduleSelectCabinets() {
        getConfigFilter().should(visible).click();
        if (arnica) {
            elementByXpathText("Кабинеты").click();
        } else if (sqns) {
            elementByXpathText("Пациенты").click();
        }
        btnApplyFilter.should(visible).click();
        return new SchedulePage();
    }

    @Step("Тянем страницу Расписания для обновления")
    public SchedulePage updateScheduleSwipe() {
        swipe(mainContentForSwipe, "down", 50);
        return this;
    }


}
