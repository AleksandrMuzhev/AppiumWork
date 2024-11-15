package pages.web;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

/**
 * Страница Журнал действий в браузере
 */
public class DocumentLogWeb {
    private final SelenideAppiumElement titlePage = $(By.cssSelector("div.content-title"));
    private final SelenideAppiumElement selectAction = $(By.id("DocumentLogSearch_action"));
    private final SelenideAppiumCollection listSelectAction = $$(By.cssSelector("#DocumentLogSearch_action option"));
    private final SelenideAppiumElement fieldDayWith = $(By.cssSelector("[title='с']"));
    private final SelenideAppiumElement fieldDayBy = $(By.cssSelector("[title='по']"));
    private final SelenideAppiumElement fieldDateDocumentWith = $(By.cssSelector("[title='Дата с']"));
    private final SelenideAppiumElement fieldDateDocumentBy = $(By.cssSelector("[title='Дата по']"));
    private final SelenideAppiumCollection stringTable = $$(By.cssSelector("tr.checkable"));

    public DocumentLogWeb() {
        titlePage.shouldBe(visible);
    }


}
