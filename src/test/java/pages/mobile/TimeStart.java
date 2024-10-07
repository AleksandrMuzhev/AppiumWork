package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByXpath;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

public class TimeStart {

    /**
     * Элементы Время начала перед созданием Визита для Android Арника
     */
    private final SelenideAppiumElement textTitleTimeStartVisit = elementByXpathText("Время начала");
    private final SelenideAppiumElement textSelectTimeStartVisit = elementByXpathText("Выберите или укажите");
    private final SelenideAppiumElement btnNowVisit = elementByContentDesc("сейчас");
    private final SelenideAppiumElement textNameEmployee = elementByXpathText("Стефанив Ольга Валерьевна");
    private final SelenideAppiumElement textPositionEmployee = elementByXpathText("Мастер маникюра / педикюра / подолог\"]");
    private final SelenideAppiumElement textDescriptionTimeFromTo = elementByXpathText("Время с 09:00 по 19:00");
    private final SelenideAppiumCollection mainTimeStartVisitCollection = collectionByXpath("//android.widget.ScrollView/android.view.ViewGroup");
    private final SelenideAppiumElement btnSetTimeManual = elementByContentDesc("Задать вручную");

    public TimeStart() {
        textTitleTimeStartVisit.shouldBe(visible, Duration.ofSeconds(5));
    }

    public VisitPage goToVisitCurrent() {
        textTitleTimeStartVisit.click();
        return new VisitPage();
    }

}
