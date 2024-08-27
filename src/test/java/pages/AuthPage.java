package pages;

import static com.codeborne.selenide.Condition.visible;
import static config.ConfigReader.arnica;
import static config.ConfigReader.platformAndroid;
import static config.ConfigReader.platformIOS;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementById;
import static driver.EmulatorHelper.elementByXpath;
import static driver.EmulatorHelper.sendKeysAndFind;
import static driver.EmulatorHelper.slowClick;
import static helper.Constants.getLOGIN;
import static helper.Constants.getPASSWORD;

import io.qameta.allure.Step;

public class AuthPage {

    /**
     * Стартовая страница авторизации после запуска приложения для Android (Все продукты)
     */
    private static final String iconAuth = "android.widget.ImageView";

    /**
     * Стартовая страница авторизации после запуска приложения для Android Арника
     */
    private static final String btnLoginA = "//android.widget.Button[@content-desc=\"Войти\"]";
    private static final String btnRegisterA = "//android.widget.Button[@content-desc=\"Зарегистрироваться\"]";
    private static final String btnDemoA = "//android.widget.Button[@content-desc=\"Демо-аккаунт\"]";
    private static final String textMainAuthHelpA = "//android.widget.TextView[@text=\"Авторизуйтесь для доступа к системе\"]";
    /**
     * Стартовая страница авторизации после запуска приложения для Android SQNS
     */
    private static final String btnLoginS = "com.medicalru.app.android:id/Войти";
    private static final String btnRegisterS = "com.medicalru.app.android:id/Зарегистрироваться";
    private static final String btnDemoS = "com.medicalru.app.android:id/Демо-аккаунт";
    private static final String textMainAuthHelpS = "com.medicalru.app.android:id/Paragraph";

    /**
     * Форма авторизации (при вводе логина и пароля) для Android (Все продукты)
     */
    private static final String textTitleAuth = "//android.widget.TextView[@text=\"Авторизация\"]";
    private static final String visualPassField = "//android.widget.Button[@resource-id=\"right-icon-adornment\"]";
    private static final String forgotYourPassword = "//android.widget.TextView[@text=\"Забыли пароль?\"]";
    private static final String textNotAccount = "//android.widget.TextView[@text=\"Нет аккаунта? \"]";
    private static final String registerUrlAuth = "//android.widget.TextView[@text=\"Зарегистрироваться\"]";
    /**
     * Форма авторизации (при вводе логина и пароля) для Android Арника
     */
    private static String loginFieldA = "(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[1]";
    private static String passFieldA = "(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[2]";
    /**
     * Форма авторизации (при вводе логина и пароля) для Android SQNS
     */
    private static final String loginFieldS = "(//android.widget.EditText[@resource-id=\"com.medicalru.app.android:id/TextInput-input\"])[1]";
    private static final String passFieldS = "(//android.widget.EditText[@resource-id=\"com.medicalru.app.android:id/TextInput-input\"])[2]";

    /**
     * Форма регистрации для Android (Все продукты)
     */
    private static final String textTitleRegister = "//android.widget.TextView[@text=\"Регистрация\"]";
    private static final String btnListSphereActivity = "//android.widget.Button[@resource-id=\"right-icon-adornment\"]";
    private static final String btnCancel = "Отмена";
    private static final String btnCreateAccount = "Создать аккаунт";
    private static final String checkBoxAgreement = "//android.widget.CheckBox";
    private static final String btnLoginFromRegister = "//android.view.ViewGroup[@content-desc=\"Войти\"]";
    /**
     * Форма регистрации для Android Арника
     */
    private static final String titleFieldActiveA = "//android.widget.TextView[@resource-id=\"text-input-outlined-label-active\"]"; //Заголовок активного поля для Арника
    private static final String listSphereActivityA = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]";
    private static final String emailFieldA = "(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[2]";
    private static final String phoneFieldA = "(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[3]";
    private static final String textAgreementMailA = "//android.widget.TextView[@text=\"Я даю согласие на получение рассылок\"]";
    private static final String textDescriptionCheckBoxAgreementA = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]";
    private static final String textIsAccountA = "//android.widget.TextView[@text=\"Уже есть аккаунт? \"]";
    /**
     * Форма регистрации для Android SQNS
     */
    private static final String titleFieldActiveS = "com.medicalru.app.android:id/TextInput-input-label-active"; //Заголовок активного поля для SQNS
    private static final String listSphereActivityS = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup[1]";
    private static final String emailFieldS = "(//android.widget.EditText[@resource-id=\"com.medicalru.app.android:id/TextInput-input\"])[2]";
    private static final String phoneFieldS = "(//android.widget.EditText[@resource-id=\"com.medicalru.app.android:id/TextInput-input\"])[3]";
    private static final String textAgreementMailS = "//android.widget.TextView[@resource-id=\"com.medicalru.app.android:id/Paragraph\" and @text=\"Я даю согласие на получение рассылок\"]";
    private static final String textDescriptionCheckBoxAgreementS = "(//android.widget.TextView[@resource-id=\"com.medicalru.app.android:id/Paragraph\"])[2]";
    private static final String textIsAccountS = "//android.widget.TextView[@resource-id=\"com.medicalru.app.android:id/Paragraph\" and @text=\"Уже есть аккаунт? \"]";

    /**
     * Геттеры для обращения к полям класса из тестов
     */
//    public static SelenideElement getBtnDemoA() {
//        return btnDemoA;
//    }

    /**
     * Готовые шаги(сценарии) для использования в теста
     */
    @Step("Авторизация пользователя с зарегистрированным данными Логин и Пароль")
    public static void authRegisterDate() throws InterruptedException {
        if (platformAndroid) {
            if (arnica) {
                elementByXpath(btnLoginA).should(visible).click();
//                sendKeysAndFind(loginFieldA, getLOGIN());
//                sendKeysAndFind(passFieldA, getPASSWORD());
//                btnLoginA.should(visible).click();
            } else if (sqns) {
                elementByContentDesc("Войти").should(visible);
                slowClick(elementByContentDesc("Войти"));
                sendKeysAndFind(collectionByResourceId("com.medicalru.app.android:id/TextInput-input").first(), getLOGIN());
                sendKeysAndFind(collectionByResourceId("com.medicalru.app.android:id/TextInput-input").last(), getPASSWORD());
                elementById(btnLoginS).should(visible).click();
            }
        } else if (platformIOS) {
            // условия для IOS платформы
        }
    }


}
