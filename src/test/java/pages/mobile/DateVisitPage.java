package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByXpath;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.elementByXpathText;
import static helper.DateHelper.dayOfMonth;
import static helper.DateHelper.yearWithMonthValue;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

import io.qameta.allure.Step;
import lombok.Getter;

public class DateVisitPage {

    /**
     * Элементы календаря перед созданием Визита для Android Арника
     */
    private SelenideAppiumElement btnBackDateVisit = elementByContentDesc("назад");
    @Getter
    private SelenideAppiumElement textTitleCalendarVisit = elementByXpathText("Дата посещения");
    private SelenideAppiumElement textSelectDateVisit = elementByXpathText("Выберите дату");
    private SelenideAppiumElement btnToDayDateVisit = elementByContentDesc("сегодня");
    private SelenideAppiumCollection dayNamesSchedule = collectionByXpath("//android.view.ViewGroup[@resource-id=\"undefined.item_\"" + yearWithMonthValue() + "\".header.dayNames\"]");
    private SelenideAppiumElement numberDayCalendar = elementByXpath("(//android.widget.TextView[@text=\"" + dayOfMonth() + "\"])[1]");

    public DateVisitPage() {
        textTitleCalendarVisit.shouldBe(visible, Duration.ofSeconds(5));
    }

    @Step("Выбираем 'Сегодня' и переходим к выбору времени визита")
    public TimeStart goToTimeStart() {
        btnToDayDateVisit.click();
        return new TimeStart();
    }
}
