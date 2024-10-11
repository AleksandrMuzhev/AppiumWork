package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByClass;
import static driver.EmulatorHelper.collectionByContentDesc;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementById;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

import io.qameta.allure.Step;

/**
 * Форма создания услуги
 */
public class CreateServicePage {
    private final SelenideAppiumElement textTitle = elementByXpathText("Услуга");
    private final SelenideAppiumCollection fieldsCollection = collectionByClass("android.widget.EditText");
    private final SelenideAppiumElement countNameForSale = elementByXpathText("штука шт");
    private final SelenideAppiumElement btnSave = elementByContentDesc("Сохранить");
    private final SelenideAppiumElement mainServiceSwipe = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView");

    /**
     * Элементы Дата-пикера
     */
    private final SelenideAppiumElement hours = elementById("android:id/hours");
    private final SelenideAppiumElement minutes = elementById("android:id/minutes");
    private final SelenideAppiumElement btnOK = elementById("android:id/button1");
    private final SelenideAppiumElement btnCancel = elementById("android:id/button2");
    private final SelenideAppiumElement btnKeyboard = elementById("android:id/toggle_mode");

    /**
     * Элементы виджета "Выберите родительскую категорию"
     */
    private final SelenideAppiumElement textTitleCategory = elementByXpathText("//android.widget.TextView[@text=\"Выберите родительскую категорию\"]");
    private final SelenideAppiumCollection btnSelects = collectionByContentDesc("Выбрать");

    /**
     * Элементы ввода часов и минут с клавиатуры
     */
    private final SelenideAppiumCollection fieldsTimeCollection = collectionByClass("android.widget.EditText");
    private final SelenideAppiumElement btnDataPicker = elementById("android:id/toggle_mode");

    public CreateServicePage() {
        textTitle.shouldBe(visible, Duration.ofSeconds(5));
    }

    @Step("Создание услуги c заполненными обязательными полями")
    public ServicePage createService(String text) {
        fieldsCollection.get(0).sendKeys(text);
        fieldsCollection.get(2).click();
        btnSelects.get(0).should(visible, Duration.ofSeconds(5)).click();
        fieldsCollection.get(3).click();
        countNameForSale.should(visible, Duration.ofSeconds(5)).click();
        fieldsCollection.get(4).click();
        btnOK.click();
        fieldsCollection.get(5).sendKeys("1000");
        btnSave.click();
        return new ServicePage();
    }
}
