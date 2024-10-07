package pages.web;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

public class ClientInfoWeb {
    private final SelenideAppiumElement titlePage = $(By.cssSelector("div.content-title"));
    private final SelenideAppiumElement submitFilter = $(By.cssSelector(".ibutton_svg-filter"));
    private final SelenideAppiumElement nameType = $(By.cssSelector("input[title='ФИО']"));
    private final SelenideAppiumElement btnEnter = $(By.cssSelector("button.ibutton_outline"));
    private final SelenideAppiumElement clientName = $(By.cssSelector("tr:nth-child(1) > td:nth-child(3) span > span"));
    private final SelenideAppiumElement clientPhone = $(By.cssSelector("tr:nth-child(1) > td:nth-child(6) > label > label"));

    public ClientInfoWeb() {
        titlePage.shouldBe(visible);
    }

    public ClientInfoWeb checkClientVisible(String name, String phone) {
        submitFilter.click();
        nameType.sendKeys(name);
        btnEnter.click();
        clientName.shouldHave(text(name));
        clientPhone.shouldHave(text(phone));
        return this;
    }


}
