package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static config.ConfigReader.arnica;
import static config.ConfigReader.platformAndroid;
import static config.ConfigReader.platformIOS;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.sendKeysAndFind;
import static driver.EmulatorHelper.slowClick;
import static helper.Constants.getLOGIN;
import static helper.Constants.getPASSWORD;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

public class AuthPage {

    /**
     * Стартовая страница авторизации после запуска приложения для Android (Все продукты)
     */
    private static final SelenideElement iconAuth = $(MobileBy.className("android.widget.ImageView"));
    /**
     * Стартовая страница авторизации после запуска приложения для Android Арника
     */
    private static final SelenideElement btnLoginA = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Войти\"]"));
    private static final SelenideElement btnRegisterA = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Зарегистрироваться\"]"));
    private static final SelenideElement btnDemoA = $(MobileBy.xpath("//android.widget.Button[@content-desc=\"Демо-аккаунт\"]"));
    private static final SelenideElement textMainAuthHelpA = $(MobileBy.xpath("//android.widget.TextView[@text=\"Авторизуйтесь для доступа к системе\"]"));
    /**
     * Стартовая страница авторизации после запуска приложения для Android SQNS
     */
    private static final SelenideElement btnLoginS = $(MobileBy.id("com.medicalru.app.android:id/Войти"));
    private static final SelenideElement btnRegisterS = $(MobileBy.id("com.medicalru.app.android:id/Зарегистрироваться"));
    private static final SelenideElement btnDemoS = $(MobileBy.id("com.medicalru.app.android:id/Демо-аккаунт"));
    private static final SelenideElement textMainAuthHelpS = $(MobileBy.id("com.medicalru.app.android:id/Paragraph"));

    /**
     * Форма авторизации (при вводе логина и пароля) для Android (Все продукты)
     */
    private static final SelenideElement textTitleAuth = $(MobileBy.xpath("//android.widget.TextView[@text=\"Авторизация\"]"));
    private static final SelenideElement visualPassField = $(MobileBy.xpath("//android.widget.Button[@resource-id=\"right-icon-adornment\"]"));
    private static final SelenideElement forgotYourPassword = $(MobileBy.xpath("//android.widget.TextView[@text=\"Забыли пароль?\"]"));
    private static final SelenideElement textNotAccount = $(MobileBy.xpath("//android.widget.TextView[@text=\"Нет аккаунта? \"]"));
    private static final SelenideElement registerUrlAuth = $(MobileBy.xpath("//android.widget.TextView[@text=\"Зарегистрироваться\"]"));
    /**
     * Форма авторизации (при вводе логина и пароля) для Android Арника
     */
    private static final SelenideElement loginFieldA = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[1]"));
    private static final SelenideElement passFieldA = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[2]"));
    /**
     * Форма авторизации (при вводе логина и пароля) для Android SQNS
     */
    private static final SelenideElement loginFieldS = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"com.medicalru.app.android:id/TextInput-input\"])[1]"));
    private static final SelenideElement passFieldS = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"com.medicalru.app.android:id/TextInput-input\"])[2]"));

    /**
     * Форма регистрации для Android (Все продукты)
     */
    private static final SelenideElement textTitleRegister = $(MobileBy.xpath("//android.widget.TextView[@text=\"Регистрация\"]"));
    private static final SelenideElement btnListSphereActivity = $(MobileBy.xpath("//android.widget.Button[@resource-id=\"right-icon-adornment\"]"));
    private static final SelenideElement btnCancel = $(MobileBy.AccessibilityId("Отмена"));
    private static final SelenideElement btnCreateAccount = $(MobileBy.AccessibilityId("Создать аккаунт"));
    private static final SelenideElement checkBoxAgreement = $(MobileBy.xpath("//android.widget.CheckBox"));
    private static final SelenideElement btnLoginFromRegister = $(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Войти\"]"));
    /**
     * Форма регистрации для Android Арника
     */
    private static final SelenideElement titleFieldActiveA = $(MobileBy.xpath("//android.widget.TextView[@resource-id=\"text-input-outlined-label-active\"]")); //Заголовок активного поля для Арника
    private static final ElementsCollection listSphereActivityA = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]"));
    private static final SelenideElement emailFieldA = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[2]"));
    private static final SelenideElement phoneFieldA = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[3]"));
    private static final SelenideElement textAgreementMailA = $(MobileBy.xpath("//android.widget.TextView[@text=\"Я даю согласие на получение рассылок\"]"));
    private static final SelenideElement textDescriptionCheckBoxAgreementA = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]"));
    private static final SelenideElement textIsAccountA = $(MobileBy.xpath("//android.widget.TextView[@text=\"Уже есть аккаунт? \"]"));
    /**
     * Форма регистрации для Android SQNS
     */
    private static final SelenideElement titleFieldActiveS = $(MobileBy.id("com.medicalru.app.android:id/TextInput-input-label-active")); //Заголовок активного поля для SQNS
    private static final ElementsCollection listSphereActivityS = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup[1]"));
    private static final SelenideElement emailFieldS = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"com.medicalru.app.android:id/TextInput-input\"])[2]"));
    private static final SelenideElement phoneFieldS = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"com.medicalru.app.android:id/TextInput-input\"])[3]"));
    private static final SelenideElement textAgreementMailS = $(MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.medicalru.app.android:id/Paragraph\" and @text=\"Я даю согласие на получение рассылок\"]"));
    private static final SelenideElement textDescriptionCheckBoxAgreementS = $(MobileBy.xpath("(//android.widget.TextView[@resource-id=\"com.medicalru.app.android:id/Paragraph\"])[2]"));
    private static final SelenideElement textIsAccountS = $(MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.medicalru.app.android:id/Paragraph\" and @text=\"Уже есть аккаунт? \"]"));

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
                btnLoginA.should(visible).click();
                sendKeysAndFind(loginFieldA, getLOGIN());
                sendKeysAndFind(passFieldA, getPASSWORD());
                btnLoginA.should(visible).click();
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
