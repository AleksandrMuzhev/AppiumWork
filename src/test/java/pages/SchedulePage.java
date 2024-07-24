package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static driver.EmulatorHelper.androidScrollToAnElementByText;
import static pages.VisitPage.getBtnBackSelectClient;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

public class SchedulePage {

    /**
     * Основная страница раздела Расписание для Android Арника
     */
    private static final SelenideElement titleSchedule = $(MobileBy.xpath("//android.widget.TextView[@text=\"Расписание\"]"));
    private static final SelenideElement calendarBtn = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button"));
    private static final SelenideElement enterFilter = $(MobileBy.xpath("//android.widget.TextView[@text=\"\uDB85\uDC8A\"]"));
    private static final SelenideElement configTable = $(MobileBy.xpath("//android.widget.TextView[@text=\"\uDB84\uDFC2\"]"));
    private static final SelenideElement configFilter = $(MobileBy.xpath("//android.widget.TextView[@text=\"\uDB80\uDE33\"]"));
    private static final SelenideElement btnSwitchCurrentDay = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button"));
    private static final SelenideElement time10_00 = $(MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"10:00\"])[1]"));
    private static final SelenideElement textCabinet = $(MobileBy.xpath("//android.widget.TextView[@text=\"Кабинет\"]"));

    private static final ElementsCollection btnCollectionDaysSchedule = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup"));
    private static final SelenideElement btnSelectDayPrevMonth = $(MobileBy.xpath("//android.widget.TextView[@text=\"" + generateDayOfWeekForPreviousMonth(LocalDate.now(), new Locale("ru")) + " " +
            LocalDate.now().getDayOfMonth() + " " +
            LocalDate.now().minusMonths(1).getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")) + " " +
            LocalDate.now().getYear() + "\"]"));
    private static final SelenideElement btnSelectDayNextMonth = $(MobileBy.xpath("//android.widget.TextView[@text=\"" + generateDayOfWeekForNextMonth(LocalDate.now(), new Locale("ru")) + " " +
            LocalDate.now().getDayOfMonth() + " " +
            LocalDate.now().plusMonths(1).getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")) + " " +
            LocalDate.now().getYear() + "\"]"));
    private static final SelenideElement btnSelectCurrentDay = $(MobileBy.xpath("//android.widget.TextView[@text=\"" + generateDayOfWeek(LocalDate.now(), new Locale("ru")) + " " +
            LocalDate.now().getDayOfMonth() + " " +
            LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")) + " " +
            LocalDate.now().getYear() + "\"]"));

    /**
     * Элементы настройки фильтра в Расписании для Android Арника
     */
    private static final SelenideElement titleFilterConfigSchedule = $(MobileBy.xpath("//android.widget.TextView[@text=\"Фильтр\"]"));
    private static final SelenideElement btnCloseConfigFilter = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button"));
    private static final SelenideElement textViewInSchedule = $(MobileBy.xpath("//android.widget.TextView[@text=\"Показывать в расписании\"]"));
    private static final ElementsCollection btnCollectionViewInSchedule = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"));
    private static final SelenideElement textViewPosition = $(MobileBy.xpath("//android.widget.TextView[@text=\"Отображаемые должности\"]"));
    private static final ElementsCollection btnCollectionViewPosition = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup"));
    private static final SelenideElement btnApplyFilter = $(MobileBy.AccessibilityId("Применить фильтр"));
    private static final SelenideElement btnResetFilter = $(MobileBy.AccessibilityId("Сбросить"));

    /**
     * Элементы календаря в Расписании для Android Арника
     */
    private static final SelenideElement titleCalendarSchedule = $(MobileBy.xpath("//android.widget.TextView[@text=\"Выберите дату\"]"));
    private static final SelenideElement btnCloseCalendar = $(MobileBy.xpath("//android.widget.TextView[@text=\"\uDB80\uDD56\"]"));
    private static final SelenideElement titleDate = $(MobileBy.xpath("//android.widget.TextView[@resource-id=\"undefined.header.title\"]"));
    private static final SelenideElement leftArrow = $(MobileBy.xpath("//android.view.ViewGroup[@resource-id=\"undefined.header.leftArrow\"]/android.widget.ImageView"));
    private static final SelenideElement rightArrow = $(MobileBy.xpath("//android.view.ViewGroup[@resource-id=\"undefined.header.rightArrow\"]/android.widget.ImageView"));
    private static final ElementsCollection dayNames = $$(MobileBy.xpath("//android.view.ViewGroup[@resource-id=\"undefined.header.dayNames\"]"));
    private static final ElementsCollection days = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));
    private static final SelenideElement numberDayCalendar = $(MobileBy.xpath("//android.widget.TextView[@text=\"" + LocalDate.now().getDayOfMonth() + "\"]"));

    /**
     * Bottosheet (всплывающее меню) сотрудника в расписании
     */
    private static final SelenideElement popUpEmployeeSchedule = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup"));
    private static final SelenideElement btnClosePopupSchedule = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button"));
    private static final SelenideElement infoSchedulePopupEmployee = $(MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"НА, Никонова Анастасия , Директор\"])[1]"));
    private static final SelenideElement firstActionTextSchedule = $(MobileBy.xpath("//android.widget.TextView[@text=\"Быстрые действия\"]"));
    private static final SelenideElement btnChangeEmployeeSchedule = $(MobileBy.AccessibilityId("Изменить сотрудника"));
    private static final SelenideElement btnCallEmployeeSchedule = $(MobileBy.AccessibilityId("Позвонить"));
    private static final SelenideElement timetableScheduleText = $(MobileBy.xpath("//android.widget.TextView[@text=\"График\"]"));
    private static final SelenideElement btnPauses = $(MobileBy.AccessibilityId("Перерывы"));
    private static final SelenideElement btnCancelWordDay = $(MobileBy.AccessibilityId("Отменить смену"));
    private static final SelenideElement btnScheduleOnWeek = $(MobileBy.AccessibilityId("Расписание на неделю"));

    /**
     * Элементы расписания на неделю
     */
    private static final SelenideElement mondayText = $(MobileBy.xpath("//android.widget.TextView[@text=\"Понедельник\"]"));

    /**
     * Bottosheet (всплывающее меню) после нажатия на время в расписании
     */
    private static final SelenideElement titleBorrowTime = $(MobileBy.xpath("//android.widget.TextView[@text=\"Занять время\"]"));
    private static final SelenideElement btnSelect = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Выбрать\"]"));

    /**
     * Элементы кнопки "+" в Расписании для Android Арника
     */
    private static final SelenideElement btnPlus = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.Button/android.view.ViewGroup"));
    private static final ElementsCollection bottomSheetOverPlus = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]"));
    private static final SelenideElement btnAddEmployee = $(MobileBy.AccessibilityId("Добавить сотрудника"));
    private static final SelenideElement btnNewVisit = $(MobileBy.AccessibilityId("Новый визит"));
    private static final ElementsCollection timesSchedule = $$(MobileBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]"));
    private static final ElementsCollection employeesSchedule = $$(MobileBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[1]"));
    private static final SelenideElement titleSelectEmployeeSchedule = $(MobileBy.xpath("//android.widget.TextView[@text=\"Выберите сотрудника\"]"));

    /**
     * Методы для генерации дат в различных форматах
     */
    // Метод для генерации даты в нужном формате (plusDays прибавляет указанное количество дней)
    public static String generateDateOfDays(long addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    // Метод для генерации текущего месяца
    public static String generateMonth(String pattern) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    // Метод для генерации текущего года
    public static String generateYear(String pattern) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    // Метод для генерации названия дня недели
    public static String generateDayOfWeek(LocalDate currentDate, Locale locale) {
        return currentDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, locale);
    }

    // Метод для генерации сокращенного названия дня недели предыдущего месяца
    public static String generateDayOfWeekForPreviousMonth(LocalDate currentDate, Locale locale) {
        return currentDate.minusMonths(1).getDayOfWeek().getDisplayName(TextStyle.SHORT, locale);
    }

    // Метод для генерации сокращенного названия дня недели следующего месяца
    public static String generateDayOfWeekForNextMonth(LocalDate currentDate, Locale locale) {
        return currentDate.plusMonths(1).getDayOfWeek().getDisplayName(TextStyle.SHORT, locale);
    }


    /**
     * Геттеры для обращения к полям класса из тестов
     */

    public static SelenideElement getBtnSelectDayPrevMonth() {
        return btnSelectDayPrevMonth;
    }

    public static SelenideElement getBtnSelectDayNextMonth() {
        return btnSelectDayNextMonth;
    }

    public static SelenideElement getBtnSelectDayCurrentMonth() {
        return btnSelectCurrentDay;
    }

    public static SelenideElement getBtnSwitchCurrentDay() {
        return btnSwitchCurrentDay.should(Condition.visible);
    }

    public static SelenideElement getMondayText() {
        return mondayText;
    }

    public static SelenideElement getTitleSelectEmployeeSchedule() {
        return titleSelectEmployeeSchedule;
    }

    public static SelenideElement getTextCabinet() {
        return textCabinet;
    }


    /**
     * Готовые шаги для применения в тестах
     */
    @Step("Переключаем календарь на месяц назад")
    public static void prevSwitchCalendar() {
        calendarBtn.should(Condition.visible).click();
        leftArrow.should(Condition.visible).click();
        numberDayCalendar.should(Condition.visible).click();
    }

    @Step("Переключаем календарь на месяц вперед")
    public static void nextSwitchCalendar() {
        calendarBtn.should(Condition.visible).click();
        rightArrow.should(Condition.visible).click();
        numberDayCalendar.should(Condition.visible).click();
    }

    @Step("Просмотр раписания сотрудника по неделям")
    public static void viewScheduleByWeek() {
        employeesSchedule.get(0).click();
        androidScrollToAnElementByText("Расписание на неделю");
    }

    @Step("Нажимаем на Новый визит в кнопке Плюс из Расписания")
    public static void clickOnNewVisitInBtnPlus() {
        btnPlus.should(Condition.visible).click();
        androidScrollToAnElementByText("Новый визит");
    }

    @Step("Нажимаем на Добавление сотрудника в кнопке Плюс из Расписания")
    public static void clickOnAddEmployeeInBtnPlus() {
        btnPlus.should(Condition.visible).click();
        androidScrollToAnElementByText("Добавить сотрудника");
    }

    @Step("Открываем форму создания визита через нажатие на свободное время")
    public static void createVisitClickOnFreedomTime() {
        time10_00.should(visible).click();
        androidScrollToAnElementByText("Выбрать");
        getBtnBackSelectClient().click();
    }

    @Step("Переходим в настройки фильтра Расписания и выбираем Кабинеты")
    public static void goToConfigFilterScheduleSelectCabinets() {
        configFilter.should(visible).click();
        androidScrollToAnElementByText("Кабинеты");
        btnApplyFilter.should(visible).click();
    }


}
