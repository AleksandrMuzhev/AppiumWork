package driver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static config.ConfigReader.platformAndroid;
import static config.ConfigReader.platformIOS;

import com.codeborne.selenide.WebDriverProvider;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Nonnull;

import config.ConfigReader;
import helper.ApkInfoHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

/**
 * Класс для инициализации AndroidDriver || IOSDriver
 */
public class EmulatorDriver implements WebDriverProvider { //Имплементация интерфейса WebDriverProvider, который дает возможность реализовать метод createDriver универсальным путем (переопределяет метод createDriver для генерации нужной сессии)
    protected static AppiumDriver driver;

    //чтение пропертей
    private static final String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static final String PLATFORM_NAME = ConfigReader.emulatorConfig.platformName();

    private static String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static String APP_ACTIVITY = ConfigReader.emulatorConfig.appActivity();
    private static final String APP = ConfigReader.emulatorConfig.app();
    private static final String URL = ConfigReader.emulatorConfig.remoteURL();
    private static final String AUTOMATION_NAME = ConfigReader.emulatorConfig.automationName();

    /**
     * Валидация URL ссылки из пропертей
     *
     * @return
     */
    public static URL getUrl() { //Метод для проверки корректно указанной ссылки для подключения к Appium
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Получаем абсолютный путь от рутового путя
     *
     * @param filePath путь к файлу из корня прокта
     * @return
     */
    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found"); //проверяем что файл существует

        return file.getAbsolutePath();
    }

    /**
     * Получаем AppPackage и AppActivity из чтения apk файла (для Android)
     */
    private void initPackageAndActivity() {
        ApkInfoHelper helper = new ApkInfoHelper();
        APP_PACKAGE = APP_PACKAGE.isEmpty() ? helper.getAppPackageFromApk() : APP_PACKAGE;
        APP_ACTIVITY = APP_ACTIVITY.isEmpty() ? helper.getAppMainActivity() : APP_ACTIVITY;
    }

    /**
     * Создает appium сессию AndroidDriver || IOSDriver
     *
     * @param capabilities настройки для создания сесcии
     * @return сессия AndroidDriver || IOSDriver
     */
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        if (platformAndroid) {
            initPackageAndActivity();

            UiAutomator2Options options = new UiAutomator2Options();
            options.setAutoGrantPermissions(true);
            options.setDeviceName(DEVICE_NAME);
            options.setPlatformName(PLATFORM_NAME);
            options.setAppPackage(APP_PACKAGE);
            options.setAppActivity(APP_ACTIVITY);
            options.setApp(getAbsolutePath(APP));
            options.setAutomationName(AUTOMATION_NAME);

            driver = new AndroidDriver(getUrl(), options);
        } else if (platformIOS) {
            // Конфигурация для iOS
            XCUITestOptions options = new XCUITestOptions();
            options.setDeviceName(DEVICE_NAME);
            options.setPlatformName(PLATFORM_NAME);
            options.setApp(getAbsolutePath(APP));
            options.setAutomationName(AUTOMATION_NAME);
//            options.setUdid(UDID);
//            options.setXcodeSigningId(XCODE_SIGNING_ID);
//            options.setBundleId(BUNDLE_ID);

            driver = new IOSDriver(getUrl(), options);
        }
        return driver;
    }
}
