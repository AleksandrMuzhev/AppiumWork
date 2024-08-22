//package pages;
//
//import static com.codeborne.selenide.Selenide.$;
//
//import com.codeborne.selenide.SelenideElement;
//
//import io.appium.java_client.MobileBy;
//
///**
// * Страница "Мой профиль"
// */
//public class ProfilePage {
//
//    /**
//     * Элементы AppBar для Android Арника
//     */
//    private static final SelenideElement btnBack = $(MobileBy.AccessibilityId("назад"));
//    private static final SelenideElement titleMyProfile = $(MobileBy.xpath("//android.widget.TextView[@text=\"Мой профиль\"]"));
//    private static final SelenideElement btnAppBarExit = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button"));
//
//
//    /**
//     * Основное содержимое страницы профиля для Android Арника
//     */
//    private static final SelenideElement idEmployee = $(MobileBy.xpath("//android.widget.TextView[@text=\"ID сотрудника: 1\"]"));
//    private static final SelenideElement infoProfileEmployee = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"НА, Никонова Анастасия , +7(790)287-77-23\"]"));
//    private static final SelenideElement editProfile = $(MobileBy.AccessibilityId("Редактировать профиль"));
//    private static final SelenideElement keyAccess = $(MobileBy.AccessibilityId("Код-пароль доступа"));
//    private static final SelenideElement changePassword = $(MobileBy.AccessibilityId("Сменить пароль"));
//    private static final SelenideElement btnExit = $(MobileBy.AccessibilityId("Выйти"));
//    private static final SelenideElement btnDeleteAccount = $(MobileBy.AccessibilityId("Удалить учетную запись"));
//
//    /**
//     * Элементы названия продукта для Android Арника
//     */
//    private static final SelenideElement titleProduct = $(MobileBy.xpath("//android.widget.TextView[@text=\"Arnica CRM\"]"));
//    private static final SelenideElement descriptionProduct = $(MobileBy.xpath("//android.widget.TextView[@text=\"Управление салоном красоты\"]"));
//
//}
