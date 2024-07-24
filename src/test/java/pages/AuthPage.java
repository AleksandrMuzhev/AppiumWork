package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;
import static helper.Constants.getLOGIN;
import static helper.Constants.getPASSWORD;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

public class AuthPage {

    /**
     * Стартовая страница авторизации после запуска приложения (Общее) для Android
     */
    private static final SelenideElement iconAuth = $(MobileBy.className("android.widget.ImageView"));
    private static final SelenideElement titleMainAuth = $(MobileBy.xpath("//android.widget.TextView[@text=\"Клиника Онлайн МИС\"]"));
    private static final SelenideElement helpTextMainAuth = $(MobileBy.xpath("//android.widget.TextView[@text=\"Авторизуйтесь для доступа к системе\"]"));

    /**
     * Стартовая страница авторизации после запуска приложения для Android Арника
     */
    private static final SelenideElement btnLoginA = $(MobileBy.AccessibilityId("Войти"));
    private static final SelenideElement btnRegisterA = $(MobileBy.AccessibilityId("Зарегистрироваться"));
    private static final SelenideElement btnDemoA = $(MobileBy.AccessibilityId("Демо-аккаунт"));

    /**
     * Стартовая страница авторизации после запуска приложения (sqns)
     */
    private static final SelenideElement btnLoginS = $(MobileBy.id("com.medicalru.app.android:id/Войти"));
    //    private static final SelenideElement btnLoginS = $(MobileBy.AccessibilityId("Войти"));
    private static final SelenideElement btnRegisterS = $(MobileBy.id("com.medicalru.app.android:id/Зарегистрироваться"));
    private static final SelenideElement btnDemoS = $(MobileBy.id("com.medicalru.app.android:id/Демо-аккаунт"));

    /**
     * Форма авторизации (Общее) для Android
     */
    private static final SelenideElement titleAuth = $(MobileBy.xpath("//android.widget.TextView[@text=\"Авторизация\"]"));
    private static final SelenideElement loginField = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[1]"));
    private static final SelenideElement passField = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[2]"));
    private static final SelenideElement visualPassField = $(MobileBy.xpath("//android.widget.TextView[@text=\"\uDB81\uDED0\"]"));
    private static final SelenideElement forgotYourPassword = $(MobileBy.xpath("//android.widget.TextView[@text=\"Забыли пароль?\"]"));
    private static final SelenideElement textNotAccount = $(MobileBy.xpath("//android.widget.TextView[@text=\"Нет аккаунта? \"]"));
    private static final SelenideElement registerUrlAuth = $(MobileBy.xpath("//android.widget.TextView[@text=\"Зарегистрироваться\"]"));

    /**
     * Форма регистрации (Общее) для Android
     */
    private static final SelenideElement titleRegister = $(MobileBy.xpath("//android.widget.TextView[@text=\"Регистрация\"]"));
    private static final SelenideElement titleFieldActive = $(MobileBy.xpath("//android.widget.TextView[@resource-id=\"text-input-outlined-label-active\"]")); //Заголовок активного поля
    private static final SelenideElement btnListSphereActivity = $(MobileBy.xpath("//android.widget.TextView[@text=\"\uDB80\uDD40\"]"));
    private static final ElementsCollection listSphereActivity = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]"));
    private static final SelenideElement btnCancel = $(MobileBy.AccessibilityId("Отмена"));
    private static final SelenideElement emailField = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[2]"));
    private static final SelenideElement phoneField = $(MobileBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[3]"));
    private static final SelenideElement btnCreateAccount = $(MobileBy.AccessibilityId("Создать аккаунт"));
    private static final SelenideElement checkBoxAgreement = $(MobileBy.xpath("//android.widget.TextView[@text=\"\uDB80\uDD32\"]"));
    private static final SelenideElement textAgreementMail = $(MobileBy.xpath("//android.widget.TextView[@text=\"Я даю согласие на получение рассылок\"]"));
    private static final SelenideElement textDescriptionCheckBoxAgreement = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]"));
    private static final SelenideElement textIsAccount = $(MobileBy.xpath("//android.widget.TextView[@text=\"Уже есть аккаунт? \"]"));
    private static final SelenideElement btnLoginFromRegister = $(MobileBy.xpath("//android.widget.TextView[@text=\"Войти\"]"));


    /**
     * Готовые шаги(сценарии) для использования в теста
     */
    @Step("Авторизация пользователя с зарегистрированным данными Логин и Пароль")
    public static void authRegisterDate() {
        if (arnica) {
            btnLoginA.should(Condition.visible).click();
            loginField.should(Condition.visible).sendKeys(getLOGIN());
            passField.should(Condition.visible).sendKeys(getPASSWORD());
            btnLoginA.should(Condition.visible).click();
        } else if (sqns) {
            btnLoginS.should(Condition.visible).click();
            loginField.should(Condition.visible).sendKeys(getLOGIN());
            passField.should(Condition.visible).sendKeys(getPASSWORD());
            btnLoginS.should(Condition.visible).click();
        }
    }


}
