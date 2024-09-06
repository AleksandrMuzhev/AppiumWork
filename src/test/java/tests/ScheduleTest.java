package tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import io.qameta.allure.Description;
import pages.AuthPage;
import pages.SchedulePage;
import pages.VisitPage;

public class ScheduleTest extends BaseTest {
    SchedulePage schedulePage;
    VisitPage visitPage;

    @BeforeEach
    public void setUp() {
        var authPage = new AuthPage();
        var ratePageWidget = authPage.authRegisterDate();
        var statisticPage = ratePageWidget.closePopUpRateWidget();
        var schedulePage = statisticPage.goToSchedule();
    }

    @Description("Переключаем на странице расписания дату на месяц назад и на месяц вперед")
    @Test
    public void testSwitchScheduleDatePrevAndNextMonth() {
        String expectedPrev = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("EEE d MMMM uuuu", new Locale("ru")));
        String expectedNext = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("EEE d MMMM uuuu", new Locale("ru")));

        schedulePage.prevSwitchCalendar();
        schedulePage.getBtnSelectDayPrevMonth().should(visible).shouldHave(exactText(expectedPrev));

        schedulePage.getBtnSwitchCurrentDaySchedule().click();
        schedulePage.nextSwitchCalendar();
        schedulePage.getBtnSelectDayNextMonth().should(visible).shouldHave(exactText(expectedNext));
    }

    @Description("Проверяем отображение расписания на неделю и сверяем любой текст дня недели (в данном случае Понедельник)")
    @Test
    public void testViewScheduleByWeek() {
        schedulePage.viewScheduleByWeek();

        schedulePage.getMondayText().should(visible).shouldHave(exactText("Понедельник"));
    }

    @Description("Проверяем работу кнопки создания визита в расписании")
    @Test
    public void testWorkButtonCreateVisit() {
        schedulePage.clickOnNewVisitInBtnPlus();

        visitPage.getTextTitleCalendarVisit().should(visible).shouldHave(exactText("Дата посещения"));
    }

    @Description("Проверяем открытие формы создания визита через нажатие на свободное время")
    @Test
    public void testCreateVisitFormWithClickOnFreedomTime() {
        String time = "10:00";
        schedulePage.createVisitClickOnFreedomTime(time);

        visitPage.getTextTitleNewVisitText().should(visible).shouldHave(exactText("Новый визит"));
    }

    @Description("Проверяем открытие bottomsheet добавления сотрудника через нажатие на свободное время")
    @Test
    public void testAddEmployeeFormWithClickOnFreedomTime() {
        schedulePage.clickOnAddEmployeeInBtnPlus();

        schedulePage.getTitleSelectEmployeeSchedule().should(visible).shouldHave(exactText("Выберите сотрудника"));
    }

//    @Description("Проверяем, что расписание по кабинетам присутстует")
//    @Test
//    public void testScheduleOnCabinetsIsDisplayed() {
//        String room = generateRoom();
//
//        setWebDriver();
//        open(getUrlWeb());
//        $(By.id("RootLoginForm_login")).sendKeys(LOGIN_WEB);
//        $(By.id("RootLoginForm_password")).sendKeys(PASSWORD_WEB);
//        $(By.cssSelector("input[type=submit]")).click();
//        $(By.linkText(getUSER())).click();
//        $(By.linkText("Сотрудники")).click();
//        $(By.linkText("Кабинеты")).click();
//        $(By.linkText("Новый кабинет")).click();
//        $(By.cssSelector("input[title='Наименование']")).sendKeys(room);
//        $(By.cssSelector("input[value='Сохранить и закрыть']")).click();
//
//        goToConfigFilterScheduleSelectCabinets();
//        getTextCabinet().should(visible).shouldHave(exactText("Кабинет"));
//    }

    @Description("Проверяем обновление расписание свайпом")
    @Test
    public void testUpdateScheduleSwipe() {
        schedulePage.updateScheduleSwipe();

        schedulePage.getMainContentForSwipe().shouldBe(visible);
    }

}
