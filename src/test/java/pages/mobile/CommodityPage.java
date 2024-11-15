package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByResourceId;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

import io.qameta.allure.Step;

/**
 * Раздел Товары
 */
public class CommodityPage {
    /**
     * Основная страница раздела Товары для Android SQNS
     */
    private final SelenideAppiumElement titleListCommodity = elementByXpathText("Товары");
    private final SelenideAppiumElement btnSearch = elementByResourceId("magnify-button");
    private final SelenideAppiumElement btnPlus = elementByResourceId("plus-button");
    private final SelenideAppiumCollection btnIcons = collectionByResourceId("icon-button");
    private final SelenideAppiumElement fieldSearch = elementByResourceId("search-bar");

    /**
     * Элементы виджета в кнопке "+"
     */
    private final SelenideAppiumElement btnNewCommodity = elementByContentDesc("Новый товар");
    private final SelenideAppiumElement btnNewCategory = elementByContentDesc("Новая категория");


    public CommodityPage() {
        titleListCommodity.shouldBe(visible, Duration.ofSeconds(5));
    }

    @Step("Переход в форму создания товара")
    public CreateCommodityPage goToCreateCommodity() {
        btnPlus.click();
        btnNewCommodity.should(visible, Duration.ofSeconds(5)).click();
        return new CreateCommodityPage();
    }

    @Step("Переход в форму создания категории товара")
    public CreateCommodityPage goToCreateCategory() {
        btnPlus.click();
        btnNewCategory.should(visible, Duration.ofSeconds(5)).click();
        return new CreateCommodityPage();
    }

    @Step("Фильтрация справочника Товары по названию товара или категории услуг")
    public CommodityPage filterFoodName(String text) {
        btnSearch.click();
        fieldSearch.sendKeys(text);
        return new CommodityPage();
    }

    @Step("Проверяем 1-й найденный результат на сооветствие поиска в фильтре")
    public CommodityPage checkResultClientSearch(String text) {
        SelenideAppiumElement actual = elementByXpathText(text);

        actual.shouldHave(visible, Duration.ofSeconds(5)).getText();
        return this;
    }
}
