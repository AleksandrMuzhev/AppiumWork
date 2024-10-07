package pages.mobile;

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

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

import helper.DataHelper;
import io.qameta.allure.Step;
import lombok.Getter;

/**
 * Страница авторизации
 */
public class AuthPage {

    /**
     * Стартовая страница авторизации после запуска приложения для Android (Все продукты)
     */
    private final String iconAuth = "android.widget.ImageView";
    private final SelenideAppiumElement btnLogin = elementByContentDesc("Войти");
    private final SelenideAppiumElement btnRegister = elementByContentDesc("Зарегистрироваться");
    @Getter
    private final SelenideAppiumElement btnDemo = elementByContentDesc("Демо-аккаунт");
    private final SelenideAppiumElement textMainAuthHelp = elementByXpathText("Авторизуйтесь для доступа к системе");

    /**
     * Форма авторизации (при вводе логина и пароля) для Android (Все продукты)
     */
    private final SelenideAppiumElement textTitleAuth = elementByXpathText("Авторизация");
    private final SelenideAppiumElement visualPassField = elementByResourceId("right-icon-adornment");
    private final SelenideAppiumElement forgotYourPassword = elementByXpathText("Забыли пароль?");
    private final SelenideAppiumElement textNotAccount = elementByXpathText("Нет аккаунта? ");
    private final SelenideAppiumElement registerUrlAuth = elementByXpathText("Зарегистрироваться");
    /**
     * Форма авторизации (при вводе логина и пароля) для Android Арника
     */
    private final SelenideAppiumCollection authFieldsA = collectionByResourceId("text-input-outlined");
    /**
     * Форма авторизации (при вводе логина и пароля) для Android SQNS
     */
    private final SelenideAppiumCollection authFieldsS = collectionByResourceId("com.medicalru.app.android:id/TextInput-input");

    /**
     * Форма регистрации для Android (Все продукты)
     */
    private final SelenideAppiumElement textTitleRegister = elementByXpathText("Регистрация");
    private final SelenideAppiumElement btnListSphereActivity = elementByResourceId("right-icon-adornment");
    private final SelenideAppiumElement btnCancel = elementByXpathText("Отмена");
    private final SelenideAppiumElement btnCreateAccount = elementByXpathText("Создать аккаунт");
    private final SelenideAppiumElement checkBoxAgreement = elementByClass("android.widget.CheckBox");
    private final SelenideAppiumElement btnLoginFromRegister = elementByContentDesc("Войти");
    private final SelenideAppiumElement titleFieldActive = elementByResourceId("text-input-outlined-label-active");
    private final SelenideAppiumElement textAgreementMail = elementByXpathText("Я даю согласие на получение рассылок");
    private final SelenideAppiumElement textIsAccount = elementByXpathText("Уже есть аккаунт? ");
    /**
     * Форма регистрации для Android Арника
     */
    private final SelenideAppiumElement listSphereActivityA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]");
    private final SelenideAppiumCollection registrationFieldsA = collectionByResourceId("text-input-outlined");
    private final SelenideAppiumElement textDescriptionCheckBoxAgreementA = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]");
    /**
     * Форма регистрации для Android SQNS
     */
    private final SelenideAppiumElement listSphereActivityS = elementByXpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup[1]");
    private final SelenideAppiumCollection registrationFieldsS = collectionByResourceId("com.medicalru.app.android:id/TextInput-input");
    private final SelenideAppiumElement textDescriptionCheckBoxAgreementS = elementByXpath("//android.widget.TextView[@resource-id=\"com.medicalru.app.android:id/Paragraph\"])[2]");

    /**
     * Готовые шаги(сценарии) для использования в теста
     */
    @Step("Авторизация пользователя с зарегистрированным данными Логин и Пароль")
    public RatePageWidget authRegisterDate() {
        var loginType = DataHelper.getAuthInfoMobile().getLogin();
        var passwordType = DataHelper.getAuthInfoMobile().getPassword();
        if (platformAndroid) {
            btnLogin.should(visible, Duration.ofSeconds(5));
            slowClick(btnLogin);
            if (arnica) {
                sendKeysAndFind(authFieldsA.first(), loginType);
                sendKeysAndFind(authFieldsA.last(), passwordType);
            } else if (sqns) {
                sendKeysAndFind(authFieldsS.first(), loginType);
                sendKeysAndFind(authFieldsS.last(), passwordType);
            }
            btnLogin.click();
        } else if (platformIOS) {
            // условия для IOS платформы
        }
        return new RatePageWidget();
    }
}
