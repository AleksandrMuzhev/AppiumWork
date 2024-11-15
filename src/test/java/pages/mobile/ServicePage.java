package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByResourceId;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import io.qameta.allure.Step;

/**
 * Раздел Товары
 */
public class ServicePage {
    /**
     * Основная страница раздела Товары для Android SQNS
     */
    private final SelenideAppiumElement titleListServices = elementByXpathText("Услуги");
    private final SelenideAppiumElement btnSearch = elementByResourceId("magnify-button");
    private final SelenideAppiumElement btnPlus = elementByResourceId("plus-button");
    private final SelenideAppiumCollection btnIcons = collectionByResourceId("icon-button");
    private final SelenideAppiumElement fieldSearch = elementByResourceId("search-bar");

    /**
     * Элементы виджета в кнопке "+"
     */
    private final SelenideAppiumElement btnNewCommodity = elementByContentDesc("Новая услуга");
    private final SelenideAppiumElement btnNewCategory = elementByContentDesc("Новая категория");

    public ServicePage() {
        titleListServices.shouldBe(visible, Duration.ofSeconds(5));
    }

    @Step("Переход в форму создания услуги")
    public CreateServicePage goToCreateService() {
        btnPlus.click();
        btnNewCommodity.should(visible, Duration.ofSeconds(5)).click();
        return new CreateServicePage();
    }

    @Step("Переход в форму создания категории услуг")
    public CreateServicePage goToCreateCategory() {
        btnPlus.click();
        btnNewCategory.should(visible, Duration.ofSeconds(5)).click();
        return new CreateServicePage();
    }

    @Step("Фильтрация справочника Услуги по названию услуги или категории услуг")
    public CommodityPage filterServiceName(String text) {
        btnSearch.click();
        fieldSearch.sendKeys(text);
        return new CommodityPage();
    }

    @Step("Проверяем 1-й найденный результат на сооветствие поиска в фильтре")
    public ServicePage checkResultClientSearch(String text) {
        SelenideAppiumElement element = elementByXpathText(text);

        String actual = element.shouldHave(visible, Duration.ofSeconds(5)).getText();
        Assertions.assertEquals(text, actual);
        return this;
    }
}
