package helper;

import static helper.DeviceHelper.executeSh;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import config.ConfigReader;

/**
 * Класс помощник для извлечения информации из Apk файла через bash команды
 */
public class ApkInfoHelper {
    /**
     * AndroidManifest.xml файл в виде строки из apk файла
     */
    private String apkInfo;

    /**
     * Конструктор в котором происходит чтение apk файла из ресурсов и инициализируется переменная apkInfo
     */
    public ApkInfoHelper() {
        String app = ConfigReader.emulatorConfig.app(); //При инициализации текущего класса происходит чтение ссылки на файл
        if (app == null || app.isEmpty()) { //если файла нет или не указан - то кидаем исключение
            throw new RuntimeException("No value for key 'app' providing apk path in emulator.properties");
        }
        try {
            String pathToAapt = "C:\\Users\\user\\AppData\\Local\\Android\\Sdk\\build-tools\\34.0.0";
            apkInfo = executeSh(pathToAapt + "\\aapt dumb badging " + ConfigReader.emulatorConfig.app()); //Извлекаем скрипт через CMD в случае с Windows: указываем pathToAapt, далее aapt dumb badging читает AndroidManifest, берет нужные значения и записывает в переменную apkInfo
        } catch (IOException | InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Получаем AppPackage из apk с помощью регулярки
     *
     * @return
     */
    public String getAppPackageFromApk() {
        return findGroup1ValueFromString(apkInfo, "package: name='\\s*([^']+?)\\s*'"); //через регулярный метод достаем package
    }

    /**
     * Получаем MainActivity из apk с помощью регулярки
     *
     * @return
     */
    public String getAppMainActivity() {
        return findGroup1ValueFromString(apkInfo, "launchable-activity: name='\\s*([^']+?)\\s*'"); //через регулярный метод достаем activity
    }

    /**
     * Находит результат первой группы с помощью регулярок
     *
     * @param text  текст в котором нужно искать
     * @param regex регулярное выражение
     * @return результат 1 группы
     */
    private static String findGroup1ValueFromString(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}

