package tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.slowClick;
import static helper.DateHelper.dateFormat;
import static helper.DateHelper.monthWithYear;
import static helper.DateHelper.rangeDateCurrentWeek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import io.qameta.allure.Description;
import pages.AuthPage;
import pages.StatisticPage;

public class StatisticTest extends BaseTest {
    StatisticPage statisticPage;

    @BeforeEach
    void setUp() {
        var authPage = new AuthPage();
        var ratePageWidget = authPage.authRegisterDate();
        var statisticPage = ratePageWidget.closePopUpRateWidget();
    }

    @Description("Работа кнопки обновления данных")
    @Test
    public void testWorkBtnUpdateDateStatistic() {
        statisticPage.clickOnBtnUpdateInStatistic();
        statisticPage.getMainStatisticForSwipe().exists();
    }

    @Description("Переключаем на странице статистике дату на предыдущий день и на следующий день")
    @Test
    public void testSwitchDateStatisticPrevAndNextDay() {
        statisticPage.prevSwitchDayStatistic();
        statisticPage.getMainStatisticForSwipe().exists();

        slowClick(statisticPage.getBtnSwitchCurrentDayStatistic());
        statisticPage.nextSwitchDayStatistic();
        statisticPage.getMainStatisticForSwipe().exists();
    }

    @Description("Переключаем статистику за день/неделю/месяц")
    @Test
    public void testSwitchDateStatisticDayOrWeekOrMonth() {
        String expectedCurrentDateBtnOfDay = dateFormat(LocalDate.now(), "EEE d MMMM uuuu");
        String expectedCurrentDateBtnOfWeek = rangeDateCurrentWeek();
        String expectedCurrentDateBtnOfMonth = monthWithYear();

        statisticPage.getTextBtnSelectCurrentDay().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfDay));
        statisticPage.getMainStatisticForSwipe().exists();

        statisticPage.switchStaticOnWeek();
        statisticPage.getTextBtnSelectCurrentWeek().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfWeek));
        statisticPage.getMainStatisticForSwipe().exists();

        statisticPage.switchStaticOnMonth();
        statisticPage.getTextBtnSelectCurrentMonth().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfMonth));
        statisticPage.getMainStatisticForSwipe().exists();
    }

    @Description("Проверяем, что статистика за текущий день отображается верно")
    @Test
    public void testCheckStatisticCurrentDayViewSuccess() {
        String expectedCurrentDateBtnOfDay = dateFormat(LocalDate.now(), "EEE d MMMM uuuu");

        statisticPage.getTextBtnSelectCurrentDay().should(visible).shouldHave(exactText(expectedCurrentDateBtnOfDay));
        statisticPage.checkTitlePageStatisticViewSuccess();
    }

}

