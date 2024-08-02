package tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.androidScrollToAnElementByText;
import static pages.AuthPage.authRegisterDate;
import static pages.MainMenuPage.closePopUpMain;
import static pages.SchedulePage.clickOnAddEmployeeInBtnPlus;
import static pages.SchedulePage.clickOnNewVisitInBtnPlus;
import static pages.SchedulePage.createVisitClickOnFreedomTime;
import static pages.SchedulePage.getBtnSelectDayNextMonth;
import static pages.SchedulePage.getBtnSelectDayPrevMonth;
import static pages.SchedulePage.getBtnSwitchCurrentDaySchedule;
import static pages.SchedulePage.getMainContentForSwipe;
import static pages.SchedulePage.getMondayText;
import static pages.SchedulePage.getTextCabinet;
import static pages.SchedulePage.getTitleSelectEmployeeSchedule;
import static pages.SchedulePage.goToConfigFilterScheduleSelectCabinets;
import static pages.SchedulePage.nextSwitchCalendar;
import static pages.SchedulePage.prevSwitchCalendar;
import static pages.SchedulePage.updateScheduleSwipe;
import static pages.SchedulePage.viewScheduleByWeek;
import static pages.VisitPage.getTitleCalendarVisit;
import static pages.VisitPage.getTitleNewVisitText;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import io.qameta.allure.Description;

public class ScheduleTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        authRegisterDate();
        closePopUpMain();
        androidScrollToAnElementByText("Расписание");
    }

    @Description("Переключаем на странице расписания дату на месяц назад и на месяц вперед")
    @Test
    public void testSwitchScheduleDatePrevAndNextMonth() {
        String expectedPrev = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("EEE d MMMM uuuu", new Locale("ru")));
        String expectedNext = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("EEE d MMMM uuuu", new Locale("ru")));

        prevSwitchCalendar();
        getBtnSelectDayPrevMonth().should(visible).shouldHave(exactText(expectedPrev));

        getBtnSwitchCurrentDaySchedule().click();
        nextSwitchCalendar();
        getBtnSelectDayNextMonth().should(visible).shouldHave(exactText(expectedNext));
    }

    @Description("Проверяем отображение расписания на неделю и сверяем любой текст дня недели (в данном случае Понедельник)")
    @Test
    public void testViewScheduleByWeek() {
        viewScheduleByWeek();

        getMondayText().should(visible).shouldHave(exactText("Понедельник"));
    }

    @Description("Проверяем работу кнопки создания визита в расписании")
    @Test
    public void testWorkButtonCreateVisit() {
        clickOnNewVisitInBtnPlus();

        getTitleCalendarVisit().should(visible).shouldHave(exactText("Дата посещения"));
    }

    @Description("Проверяем открытие формы создания визита через нажатие на свободное время")
    @Test
    public void testCreateVisitFormWithClickOnFreedomTime() {
        createVisitClickOnFreedomTime();

        getTitleNewVisitText().should(visible).shouldHave(exactText("Новый визит"));
    }

    @Description("Проверяем открытие bottomsheet добавления сотрудника через нажатие на свободное время")
    @Test
    public void testAddEmployeeFormWithClickOnFreedomTime() {
        clickOnAddEmployeeInBtnPlus();

        getTitleSelectEmployeeSchedule().should(visible).shouldHave(exactText("Выберите сотрудника"));
    }

    @Description("Проверяем, что расписание по кабинетам присутстует")
    @Test
    public void testScheduleOnCabinetsIsDisplayed() {
        goToConfigFilterScheduleSelectCabinets();

        getTextCabinet().should(visible).shouldHave(exactText("Кабинет"));
    }

    @Description("Проверяем обновление расписание свайпом")
    @Test
    public void testUpdateScheduleSwipe() {
        updateScheduleSwipe();

        getMainContentForSwipe().shouldBe(visible);
    }

}
