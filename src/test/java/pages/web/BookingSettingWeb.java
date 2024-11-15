package pages.web;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

/**
 * Страница "Онлайн-запись и приложение" в браузере
 */
public class BookingSettingWeb {
    private final SelenideAppiumElement titlePage = $(By.cssSelector("div.content-title"));
    private final SelenideAppiumElement toggle = $(By.className("toggle"));

    public BookingSettingWeb() {
        titlePage.shouldBe(visible);
    }
}
