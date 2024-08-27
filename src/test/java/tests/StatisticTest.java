package tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.fail;
import static driver.EmulatorHelper.slowClick;
import static helper.DateHelper.dateFormat;
import static helper.DateHelper.monthWithYear;
import static helper.DateHelper.rangeDateCurrentWeekNotNameMonthStartWeek;
import static helper.DateHelper.rangeDateCurrentWeekWithNameMonthStartWeek;
import static pages.AuthPage.authRegisterDate;
import static pages.MainMenuPage.closePopUpMain;
import static pages.StatisticPage.checkTitlePageStatisticViewSuccess;
import static pages.StatisticPage.clickOnBtnUpdateInStatistic;
import static pages.StatisticPage.getBtnSwitchCurrentDayStatistic;
import static pages.StatisticPage.getMainStatisticForSwipe;
import static pages.StatisticPage.getTextBtnSelectCurrentDay;
import static pages.StatisticPage.getTextBtnSelectCurrentMonth;
import static pages.StatisticPage.getTextBtnSelectCurrentWeek;
import static pages.StatisticPage.nextSwitchDayStatistic;
import static pages.StatisticPage.prevSwitchDayStatistic;
import static pages.StatisticPage.switchStaticOnMonth;
import static pages.StatisticPage.switchStaticOnWeek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import io.qameta.allure.Description;

public class StatisticTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        authRegisterDate();
        closePopUpMain();
    }

    @Description("Работа кнопки обновления данных")
    @Test
    public void testWorkBtnUpdateDateStatistic() {
        clickOnBtnUpdateInStatistic();
        getMainStatisticForSwipe().exists();
    }

    @Description("Переключаем на странице статистике дату на предыдущий день и на следующий день")
    @Test
    public void testSwitchDateStatisticPrevAndNextDay() {
        prevSwitchDayStatistic();
        getMainStatisticForSwipe().exists();

        slowClick(getBtnSwitchCurrentDayStatistic());
        nextSwitchDayStatistic();
        getMainStatisticForSwipe().exists();
    }

    @Description("Переключаем статистику за день/неделю/месяц")
    @Test
    public void testSwitchDateStatisticDayOrWeekOrMonth() {
        String expectedCurrentDateBtnOfDay = dateFormat(LocalDate.now(), "EEE d MMMM uuuu");
        String expectedCurrentDateBtnOfWeekShort = rangeDateCurrentWeekNotNameMonthStartWeek();
        String expectedCurrentDateBtnOfWeekLong = rangeDateCurrentWeekWithNameMonthStartWeek();
        String expectedCurrentDateBtnOfMonth = monthWithYear();

        getTextBtnSelectCurrentDay().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfDay));
        getMainStatisticForSwipe().exists();

        switchStaticOnWeek();
        try {
            getTextBtnSelectCurrentWeek().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfWeekShort));
        } catch (AssertionError e) {
            try {
                getTextBtnSelectCurrentWeek().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfWeekLong));
            } catch (AssertionError ex) {
                fail("Элемент для текущей недели не соответствует ожидаемым значениям: "
                        + expectedCurrentDateBtnOfWeekShort + " или "
                        + expectedCurrentDateBtnOfWeekLong);
            }
        }
        getMainStatisticForSwipe().exists();

        switchStaticOnMonth();
        getTextBtnSelectCurrentMonth().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfMonth));
        getMainStatisticForSwipe().exists();
    }

    @Description("Проверяем, что статистика за текущий день отображается верно")
    @Test
    public void testCheckStatisticCurrentDayViewSuccess() {
        String expectedCurrentDateBtnOfDay = dateFormat(LocalDate.now(), "EEE d MMMM uuuu");

        getTextBtnSelectCurrentDay().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfDay));
        checkTitlePageStatisticViewSuccess();
    }

}

