package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.elementByResourceId;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.goBack;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

import io.qameta.allure.Step;

/**
 * Виджет оценки приложения после успешной авторизации (появляется раз в 120 дней)
 */
public class RatePageWidget {

    private final SelenideAppiumElement adPopUpRate = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");
    private final SelenideAppiumElement btnRemember = elementByResourceId("com.medicalru.app.android:id/Напомнить позже-container");

    public RatePageWidget() {
    }

    @Step("Закрываем открывшееся всплывающее окно")
    public StatisticPage closePopUpRateWidget() {
        if (arnica) {
            if (adPopUpRate.exists()) {
                goBack();
            }
        } else if (sqns) {
//            if (btnRemember.exists()){
                btnRemember.should(visible, Duration.ofSeconds(20)).click();
//            }
        }
        return new StatisticPage();
    }
}
