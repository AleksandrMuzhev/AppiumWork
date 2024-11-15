package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

/**
 * Страница "Мой профиль"
 */
public class ProfilePage {

    /**
     * Элементы AppBar для Android Арника
     */
    private static final SelenideAppiumElement btnBack = elementByXpathText("назад");
    private static final SelenideAppiumElement titleMyProfile = elementByXpathText("Мой профиль");
    private static final SelenideAppiumElement btnAppBarExit = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button");


    /**
     * Основное содержимое страницы профиля для Android Арника
     */
    private static final SelenideAppiumElement idEmployee = elementByXpathText("ID сотрудника: 1");
    private static final SelenideAppiumElement infoProfileEmployee = elementByXpathText("НА, Никонова Анастасия , +7(790)287-77-23");
    private static final SelenideAppiumElement editProfile = elementByXpathText("Редактировать профиль");
    private static final SelenideAppiumElement keyAccess = elementByXpathText("Код-пароль доступа");
    private static final SelenideAppiumElement changePassword = elementByXpathText("Сменить пароль");
    private static final SelenideAppiumElement btnExit = elementByXpathText("Выйти");
    private static final SelenideAppiumElement btnDeleteAccount = elementByXpathText("Удалить учетную запись");

    /**
     * Элементы названия продукта для Android Арника
     */
    private static final SelenideAppiumElement titleProduct = elementByXpathText("Arnica CRM");
    private static final SelenideAppiumElement descriptionProduct = elementByXpathText("Управление салоном красоты");

    public ProfilePage() {
        titleMyProfile.shouldBe(visible, Duration.ofSeconds(5));
    }

}
