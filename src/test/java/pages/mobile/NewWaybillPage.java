package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByClass;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementById;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;
import java.time.LocalDate;

/**
 * Страница создания Перемещения товаров
 */
public class NewWaybillPage {
    private final SelenideAppiumElement titleWayBill = elementByXpathText("Перемещение товаров");
    private final SelenideAppiumCollection btnIcons = collectionByResourceId("icon-button");
    private final SelenideAppiumCollection fieldsEditText = collectionByClass("android.widget.EditText");
    private final SelenideAppiumElement numCurrentCal = elementByXpathText("\"" + LocalDate.now().getDayOfMonth() + "\"");

    private final SelenideAppiumElement btnSelectStorage = elementByContentDesc("Изменить");
    private final SelenideAppiumElement btnSaveDoc = elementByContentDesc("Сохранить документ");

    /**
     * Элементы Дата-пикера
     */
    private final SelenideAppiumElement hours = elementById("android:id/hours");
    private final SelenideAppiumElement minutes = elementById("android:id/minutes");
    private final SelenideAppiumElement btnOK = elementById("android:id/button1");
    private final SelenideAppiumElement btnCancel = elementById("android:id/button2");
    private final SelenideAppiumElement btnKeyboard = elementById("android:id/toggle_mode");
    /**
     * Элементы ввода часов и минут с клавиатуры
     */
    private final SelenideAppiumCollection fieldsTimeCollection = collectionByClass("android.widget.EditText");
    private final SelenideAppiumElement btnDataPicker = elementById("android:id/toggle_mode");

    public NewWaybillPage() {
        titleWayBill.shouldBe(visible, Duration.ofSeconds(5));
    }
}
