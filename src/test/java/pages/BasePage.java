package pages;

import static com.codeborne.selenide.Selenide.$;

import java.io.File;

import io.appium.java_client.MobileBy;

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
        return $(MobileBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.medicalru.app:id/action_bar_root\"]")).screenshot();
    }
}
