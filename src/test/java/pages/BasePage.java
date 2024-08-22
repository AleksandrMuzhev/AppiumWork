package pages;

import static com.codeborne.selenide.appium.SelenideAppium.$;

import org.openqa.selenium.By;

import java.io.File;

/**
 * Базовый класс для скриншотов
 */
public class BasePage {

    /**
     * Делает скриншот экрана без статусбара
     *
     * @return файл скриншота
     */
    public File fullPageScreenshot() {
        return $(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.medicalru.app:id/action_bar_root\"]")).screenshot();
    }
}
