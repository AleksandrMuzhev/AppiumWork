package driver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static config.ConfigReader.platformAndroid;
import static config.ConfigReader.platformIOS;

import com.codeborne.selenide.WebDriverProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Nonnull;

import config.ConfigReader;
import helper.ApkInfoHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

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
     * @param desiredCapabilities настройки для создания сесcии
     * @return сессия AndroidDriver || IOSDriver
     */
    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        if (platformAndroid) {
            initPackageAndActivity();
            desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
            desiredCapabilities.setCapability("deviceName", DEVICE_NAME);
            desiredCapabilities.setCapability("platformName", PLATFORM_NAME);
            desiredCapabilities.setCapability("appPackage", APP_PACKAGE);
            desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);
            desiredCapabilities.setCapability("app", getAbsolutePath(APP));
            desiredCapabilities.setCapability("automationName", AUTOMATION_NAME);
            driver = new AndroidDriver<>(getUrl(), desiredCapabilities);
        } else if (platformIOS) {
            // Аналогично настройки для IOS
        }

        return driver;
    }
}
