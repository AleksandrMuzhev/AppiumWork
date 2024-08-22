package pages;

import static com.codeborne.selenide.Selenide.$;
import static driver.EmulatorHelper.goBack;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

/**
 * Главное меню приложения (в нижней части TabBar и основной список разделов в боковом меню)
 */
public class MainMenuPage extends StartPage {

    //    /**
//     * Элементы TabBar (в нижней части) для Android (Все продукты)
//     */
//    private static final ElementsCollection namesBtnTabBar = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup"));
//    private static final ElementsCollection iconBtnTabBar = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]"));
//    private static final SelenideElement btnStatisticTabBar = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.Button[1]"));
//    private static final SelenideElement btnClientsTabBar = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.Button[3]"));
//    private static final SelenideElement btnScheduleTabBar = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.Button[2]"));
//    private static final SelenideElement btnNotificationsTabBar = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.Button[4]"));
//    private static final SelenideElement btnMainTabBar = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.Button[5]"));
//
//    /**
//     * Элементы всплыющего попапа для оценки качества для Android (Все продукты)
//     */
    private static final SelenideAppiumElement adPopUpRate = (SelenideAppiumElement) $(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"));

    //    private static final SelenideElement textTitlePopupRate = $(MobileBy.xpath("//android.widget.TextView[@text=\"Пожалуйста, оцените наше приложение\"]"));
//    private static final SelenideElement ErrorCritical = $(MobileBy.xpath("//android.widget.TextView[@text=\"Что-то пошло не так...\"]"));
//    private static final SelenideElement resetButton = $(MobileBy.AccessibilityId("Сбросить ошибку"));
//    private static final SelenideElement frameLayout = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout"));
//    /**
//     * Элементы всплыющего попапа для оценки качества для Android Арника
//     */
//    private static final SelenideElement btnCloseRateA = $(MobileBy.xpath("//android.widget.TextView[@text=\"Напомнить позже\"]"));
//    /**
//     * Элементы всплыющего попапа для оценки качества для Android SQNS
//     */
//    private static final SelenideElement btnCloseRateS = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Напомнить позже\"]"));
//
//    /**
//     * Элементы бокового главного меню приложения для Android (Все продукты)
//     */
//    private static final SelenideElement btnBackMain = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.Button"));
//    private static final SelenideElement titleSalonsAddressMain = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Розалия, Ленина, 5\"]"));
//    private static final SelenideElement btnSalonsMain = $(MobileBy.xpath("//android.widget.TextView[@text=\"\uDB81\uDCE1\"]"));
//    private static final SelenideElement titleListMain = $(MobileBy.xpath("//android.widget.TextView[@text=\"Меню\"]"));
//    private static final SelenideElement btnMenuProfileMain = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"НА\"]"));
//    private static final ElementsCollection listMainSections = $$(MobileBy.xpath("//android.widget.ScrollView/android.view.ViewGroup"));
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
//    /**
//     * Геттеры для обращения к полям класса из тестов
//     */
//    public static SelenideElement getBtnCloseRate() {
//        if (arnica) {
//            return btnCloseRateA;
//        } else if (sqns) {
//            return btnCloseRateS;
//        }
//        return null;
//    }
//
    @Step("Закрываем открывшееся всплывающее окно")
    public static void closePopUpMain() {
        if (adPopUpRate.exists()) {
            goBack();
        }
    }
//
//    @Step("Сбрасываем критическую ошибку Что-то пошло не так")
//    public MainMenuPage resetErrorCritical() {
//        if (ErrorCritical.exists()) {
//            resetButton.click();
//        }
//        return new MainMenuPage();
//    }
//
}
