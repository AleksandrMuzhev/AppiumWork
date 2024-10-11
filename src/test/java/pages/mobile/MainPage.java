package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

/**
 * Главное меню приложения
 */
public class MainPage {

    /**
     * Элементы бокового главного меню приложения для Android (Все продукты)
     */
    private static final SelenideAppiumElement btnBackMain = elementByXpath("android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.Button");
    private static final SelenideAppiumElement btnSalonsMain = elementByXpathText("\uDB81\uDCE1");
    private static final SelenideAppiumElement titleListMain = elementByXpathText("Меню");
//    private static final SelenideElement sectionStatisticMain = $(MobileBy.AccessibilityId("Статистика"));
//    private static final SelenideElement sectionScheduleMain = $(MobileBy.AccessibilityId("Расписание"));
//    private static final SelenideElement sectionOnlineRecordMain = $(MobileBy.AccessibilityId("Онлайн-запись"));
//    private static final SelenideElement sectionClientsMain = $(MobileBy.AccessibilityId("Клиенты"));
//    private static final SelenideElement sectionMain = $(MobileBy.AccessibilityId("Товары"));
//    private static final SelenideElement sectionOperationsCommodityMain = $(MobileBy.AccessibilityId("Операции с товарами"));
//    private static final SelenideElement sectionStoragesMain = $(MobileBy.AccessibilityId("Склады"));
//    private static final SelenideElement sectionInventoryMain = $(MobileBy.AccessibilityId("Инвентаризация"));
//    private static final SelenideElement sectionTimetableWorkMain = $(MobileBy.AccessibilityId("График работы"));
//    private static final SelenideElement sectionNotificatonsMain = $(MobileBy.AccessibilityId("Уведомления"));
//    private static final SelenideElement sectionConfigMain = $(MobileBy.AccessibilityId("Настройки"));
//    private static final SelenideElement sectionUpdatesMain = $(MobileBy.AccessibilityId("Обновления"));
//    private static final SelenideElement sectionSupportMain = $(MobileBy.AccessibilityId("Техподдержка"));
//    private static final SelenideElement sectionAboutMain = $(MobileBy.AccessibilityId("О приложении"));
//

    public MainPage() {
        titleListMain.shouldBe(visible, Duration.ofSeconds(5));
    }

    /**
     * Геттеры для обращения к полям класса из тестов
     */


}
