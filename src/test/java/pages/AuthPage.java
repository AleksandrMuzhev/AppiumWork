package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;
import static com.codeborne.selenide.appium.SelenideAppium.$x;
import static org.openqa.selenium.By.xpath;
import static config.ConfigReader.arnica;
import static config.ConfigReader.platformAndroid;
import static config.ConfigReader.platformIOS;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.sendKeysAndFind;
import static driver.EmulatorHelper.slowClick;
import static helper.Constants.getLOGIN;
import static helper.Constants.getPASSWORD;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

public class AuthPage {

    /**
     * Стартовая страница авторизации после запуска приложения для Android (Все продукты)
     */
    private static final SelenideAppiumElement iconAuth = (SelenideAppiumElement) $(By.className("android.widget.ImageView"));
    /**
     * Стартовая страница авторизации после запуска приложения для Android Арника
     */
    public static String btnLoginA = "//android.widget.Button[@content-desc=\"Войти\"]";
    public static SelenideAppiumElement elementByXpath(String xpath) {
        return $x(xpath);
    }
    private static final SelenideAppiumElement btnRegisterA = (SelenideAppiumElement) $(xpath("//android.widget.Button[@content-desc=\"Зарегистрироваться\"]"));
    private static final SelenideAppiumElement btnDemoA = (SelenideAppiumElement) $(xpath("//android.widget.Button[@content-desc=\"Демо-аккаунт\"]"));
    private static final SelenideAppiumElement textMainAuthHelpA = (SelenideAppiumElement) $(xpath("//android.widget.TextView[@text=\"Авторизуйтесь для доступа к системе\"]"));
    /**
     * Стартовая страница авторизации после запуска приложения для Android SQNS
     */
    private static final SelenideAppiumElement btnLoginS = (SelenideAppiumElement) $(By.id("com.medicalru.app.android:id/Войти"));
    private static final SelenideAppiumElement btnRegisterS = (SelenideAppiumElement) $(By.id("com.medicalru.app.android:id/Зарегистрироваться"));
    private static final SelenideAppiumElement btnDemoS = (SelenideAppiumElement) $(By.id("com.medicalru.app.android:id/Демо-аккаунт"));
    private static final SelenideAppiumElement textMainAuthHelpS = (SelenideAppiumElement) $(By.id("com.medicalru.app.android:id/Paragraph"));

    /**
     * Форма авторизации (при вводе логина и пароля) для Android (Все продукты)
     */
    private static final SelenideAppiumElement textTitleAuth = (SelenideAppiumElement) $(xpath("//android.widget.TextView[@text=\"Авторизация\"]"));
    private static final SelenideAppiumElement visualPassField = (SelenideAppiumElement) $(xpath("//android.widget.Button[@resource-id=\"right-icon-adornment\"]"));
    private static final SelenideAppiumElement forgotYourPassword = (SelenideAppiumElement) $(xpath("//android.widget.TextView[@text=\"Забыли пароль?\"]"));
    private static final SelenideAppiumElement textNotAccount = (SelenideAppiumElement) $(xpath("//android.widget.TextView[@text=\"Нет аккаунта? \"]"));
    private static final SelenideAppiumElement registerUrlAuth = (SelenideAppiumElement) $(xpath("//android.widget.TextView[@text=\"Зарегистрироваться\"]"));
    /**
     * Форма авторизации (при вводе логина и пароля) для Android Арника
     */
    private static final SelenideAppiumElement loginFieldA = (SelenideAppiumElement) $(xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[1]"));
    private static final SelenideAppiumElement passFieldA = (SelenideAppiumElement) $(xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[2]"));
    /**
     * Форма авторизации (при вводе логина и пароля) для Android SQNS
     */
    private static final SelenideAppiumElement loginFieldS = (SelenideAppiumElement) $(xpath("(//android.widget.EditText[@resource-id=\"com.medicalru.app.android:id/TextInput-input\"])[1]"));
    private static final SelenideAppiumElement passFieldS = (SelenideAppiumElement) $(xpath("(//android.widget.EditText[@resource-id=\"com.medicalru.app.android:id/TextInput-input\"])[2]"));

    /**
     * Форма регистрации для Android (Все продукты)
     */
    private static final SelenideAppiumElement textTitleRegister = (SelenideAppiumElement) $(xpath("//android.widget.TextView[@text=\"Регистрация\"]"));
    private static final SelenideAppiumElement btnListSphereActivity = (SelenideAppiumElement) $(xpath("//android.widget.Button[@resource-id=\"right-icon-adornment\"]"));
    //    private static final SelenideAppiumElement btnCancel = $(By.AccessibilityId("Отмена"));
//    private static final SelenideAppiumElement btnCreateAccount = $(By.AccessibilityId("Создать аккаунт"));
    private static final SelenideAppiumElement checkBoxAgreement = (SelenideAppiumElement) $(xpath("//android.widget.CheckBox"));
    private static final SelenideAppiumElement btnLoginFromRegister = (SelenideAppiumElement) $(xpath("//android.view.ViewGroup[@content-desc=\"Войти\"]"));
    /**
     * Форма регистрации для Android Арника
     */
    private static final SelenideAppiumElement titleFieldActiveA = (SelenideAppiumElement) $(xpath("//android.widget.TextView[@resource-id=\"text-input-outlined-label-active\"]")); //Заголовок активного поля для Арника
    private static final SelenideAppiumCollection listSphereActivityA = $$(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]"));
    private static final SelenideAppiumElement emailFieldA = (SelenideAppiumElement) $(xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[2]"));
    private static final SelenideAppiumElement phoneFieldA = (SelenideAppiumElement) $(xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[3]"));
    private static final SelenideAppiumElement textAgreementMailA = (SelenideAppiumElement) $(xpath("//android.widget.TextView[@text=\"Я даю согласие на получение рассылок\"]"));
    private static final SelenideAppiumElement textDescriptionCheckBoxAgreementA = (SelenideAppiumElement) $(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]"));
    private static final SelenideAppiumElement textIsAccountA = (SelenideAppiumElement) $(xpath("//android.widget.TextView[@text=\"Уже есть аккаунт? \"]"));
    /**
     * Форма регистрации для Android SQNS
     */
    private static final SelenideAppiumElement titleFieldActiveS = (SelenideAppiumElement) $(By.id("com.medicalru.app.android:id/TextInput-input-label-active")); //Заголовок активного поля для SQNS
    private static final SelenideAppiumCollection listSphereActivityS = $$(xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup[1]"));
    private static final SelenideAppiumElement emailFieldS = (SelenideAppiumElement) $(xpath("(//android.widget.EditText[@resource-id=\"com.medicalru.app.android:id/TextInput-input\"])[2]"));
    private static final SelenideAppiumElement phoneFieldS = (SelenideAppiumElement) $(xpath("(//android.widget.EditText[@resource-id=\"com.medicalru.app.android:id/TextInput-input\"])[3]"));
    private static final SelenideAppiumElement textAgreementMailS = (SelenideAppiumElement) $(xpath("//android.widget.TextView[@resource-id=\"com.medicalru.app.android:id/Paragraph\" and @text=\"Я даю согласие на получение рассылок\"]"));
    private static final SelenideAppiumElement textDescriptionCheckBoxAgreementS = (SelenideAppiumElement) $(xpath("(//android.widget.TextView[@resource-id=\"com.medicalru.app.android:id/Paragraph\"])[2]"));
    private static final SelenideAppiumElement textIsAccountS = (SelenideAppiumElement) $(xpath("//android.widget.TextView[@resource-id=\"com.medicalru.app.android:id/Paragraph\" and @text=\"Уже есть аккаунт? \"]"));

    /**
     * Геттеры для обращения к полям класса из тестов
     */
    public static SelenideElement getBtnDemoA() {
        return btnDemoA;
    }

    /**
     * Готовые шаги(сценарии) для использования в теста
     */
    @Step("Авторизация пользователя с зарегистрированным данными Логин и Пароль")
    public static void authRegisterDate() {
        if (platformAndroid) {
            if (arnica) {
                elementByXpath(btnLoginA).should(visible);
//                btnLoginA.should(visible);
                slowClick(elementByXpath(btnLoginA));
                sendKeysAndFind(loginFieldA, getLOGIN());
                sendKeysAndFind(passFieldA, getPASSWORD());
//                btnLoginA.should(visible).click();
            } else if (sqns) {
                btnLoginS.should(visible);
                slowClick(btnLoginS);
                sendKeysAndFind(loginFieldS, getLOGIN());
                sendKeysAndFind(passFieldS, getPASSWORD());
                btnLoginS.should(visible).click();
            }
        } else if (platformIOS) {
            // условия для IOS платформы
        }
    }


}
