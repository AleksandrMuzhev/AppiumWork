package pages.web;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

public class SchedulePageWeb {
    private final SelenideAppiumCollection linkTitleMenu = $$(By.cssSelector("div.layout-general-wrapper.ng-isolate-scope a > span:nth-child(2)"));
    private final SelenideAppiumElement salesLink = $(By.linkText("Продажи"));
    private final SelenideAppiumElement clientsArnica = $(By.linkText("Клиенты"));
    private final SelenideAppiumElement clientsSqns = $(By.linkText("Пациенты"));


    public SchedulePageWeb() {
        linkTitleMenu.get(0).shouldBe(visible);
    }

    public ClientInfoWeb goToClientInfo() {
        salesLink.click();
        if(arnica) {
            clientsArnica.click();
        } else if (sqns) {
            clientsSqns.click();
        }
        return new ClientInfoWeb();
    }
}
