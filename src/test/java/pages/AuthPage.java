package pages;

import static com.codeborne.selenide.Condition.visible;
import static config.ConfigReader.arnica;
import static config.ConfigReader.platformAndroid;
import static config.ConfigReader.platformIOS;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByClass;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByResourceId;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.elementByXpathText;
import static driver.EmulatorHelper.sendKeysAndFind;
import static driver.EmulatorHelper.slowClick;
import static helper.Constants.getLOGIN;
import static helper.Constants.getPASSWORD;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import io.qameta.allure.Step;

public class AuthPage {

    /**
     * Стартовая страница авторизации после запуска приложения для Android (Все продукты)
     */
    private static final String iconAuth = "android.widget.ImageView";
    private static final SelenideAppiumElement btnLogin = elementByContentDesc("Войти");
    private static final SelenideAppiumElement btnRegister = elementByContentDesc("Зарегистрироваться");
    private static final SelenideAppiumElement btnDemo = elementByContentDesc("Демо-аккаунт");
    private static final SelenideAppiumElement textMainAuthHelp = elementByXpathText("Авторизуйтесь для доступа к системе");

    /**
     * Форма авторизации (при вводе логина и пароля) для Android (Все продукты)
     */
    private static final SelenideAppiumElement textTitleAuth = elementByXpathText("Авторизация");
    private static final SelenideAppiumElement visualPassField = elementByResourceId("right-icon-adornment");
    private static final SelenideAppiumElement forgotYourPassword = elementByXpathText("Забыли пароль?");
    private static final SelenideAppiumElement textNotAccount = elementByXpathText("Нет аккаунта? ");
    private static final SelenideAppiumElement registerUrlAuth = elementByXpathText("Зарегистрироваться");
    /**
     * Форма авторизации (при вводе логина и пароля) для Android Арника
     */
    private static final SelenideAppiumCollection authFieldsA = collectionByResourceId("text-input-outlined");
    /**
     * Форма авторизации (при вводе логина и пароля) для Android SQNS
     */
    private static final SelenideAppiumCollection authFieldsS = collectionByResourceId("com.medicalru.app.android:id/TextInput-input");

    /**
     * Форма регистрации для Android (Все продукты)
     */
    private static final SelenideAppiumElement textTitleRegister = elementByXpathText("Регистрация");
    private static final SelenideAppiumElement btnListSphereActivity = elementByResourceId("right-icon-adornment");
    private static final SelenideAppiumElement btnCancel = elementByXpathText("Отмена");
    private static final SelenideAppiumElement btnCreateAccount = elementByXpathText("Создать аккаунт");
    private static final SelenideAppiumElement checkBoxAgreement = elementByClass("android.widget.CheckBox");
    private static final SelenideAppiumElement btnLoginFromRegister = elementByContentDesc("Войти");
    private static final SelenideAppiumElement titleFieldActive = elementByResourceId("text-input-outlined-label-active");
    private static final SelenideAppiumElement textAgreementMail = elementByXpathText("Я даю согласие на получение рассылок");
    private static final SelenideAppiumElement textIsAccount = elementByXpathText("Уже есть аккаунт? ");
    /**
     * Форма регистрации для Android Арника
     */
    private static final SelenideAppiumElement listSphereActivityA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]");
    private static final SelenideAppiumCollection registrationFieldsA = collectionByResourceId("text-input-outlined");
    private static final SelenideAppiumElement textDescriptionCheckBoxAgreementA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]");
    /**
     * Форма регистрации для Android SQNS
     */
    private static final SelenideAppiumElement listSphereActivityS = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup[1]");
    private static final SelenideAppiumCollection registrationFieldsS = collectionByResourceId("com.medicalru.app.android:id/TextInput-input");
    private static final SelenideAppiumElement textDescriptionCheckBoxAgreementS = elementByXpath("//android.widget.TextView[@resource-id=\"com.medicalru.app.android:id/Paragraph\"])[2]");

    /**
     * Геттеры для обращения к полям класса из тестов
     */
    public static SelenideAppiumElement getBtnDemo() {
        return btnDemo;
    }

    /**
     * Готовые шаги(сценарии) для использования в теста
     */
    @Step("Авторизация пользователя с зарегистрированным данными Логин и Пароль")
    public static void authRegisterDate() {
        if (platformAndroid) {
            if (arnica) {
                btnLogin.should(visible).click();
                sendKeysAndFind(authFieldsA.first(), getLOGIN());
                sendKeysAndFind(authFieldsA.last(), getPASSWORD());
                btnLogin.click();
            } else if (sqns) {
                btnLogin.should(visible);
                slowClick(btnLogin);
                sendKeysAndFind(authFieldsS.first(), getLOGIN());
                sendKeysAndFind(authFieldsS.last(), getPASSWORD());
                btnLogin.click();
            }
        } else if (platformIOS) {
            // условия для IOS платформы
        }
    }
}
