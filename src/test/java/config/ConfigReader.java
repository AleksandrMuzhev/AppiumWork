package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {
    public static final EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class, System.getProperties()); // Означает, с помощью фабрики конфигов создается инициализация интерфейсов и properties для Emulator
    public static final TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties()); // Означает, с помощью фабрики конфигов создается инициализация интерфейсов и properties для Test

    /**
     * Публичные статичные переменные для извлечения определенного контекста названия из .apk файла в emulator.properties (в зависимости от продукта)
     */
    public static boolean arnica = ConfigReader.isArnicaApp();
    public static boolean sqns = ConfigReader.isSqnsApp();

    /**
     * Публичные статичные переменные для извлечения определенного контекста названия из platformName в emulator.properties (в зависимости от платформы)
     */
    public static boolean platformAndroid = ConfigReader.isPlatformAndroid();
    public static boolean platformIOS = ConfigReader.isPlatformIOS();


    /**
     * Методы для извлечения контекста в названии .apk файла
     */
    private static boolean isArnicaApp() {
        String appPath = ConfigReader.emulatorConfig.app();
        return appPath.contains("arnicaStand11.apk");
    }

    private static boolean isSqnsApp() {
        String appPath = ConfigReader.emulatorConfig.app();
        return appPath.contains("sqnsEditVisit20240718.apk");
    }

    /**
     * Методы для извлечения контекста в названии platformName
     */
    private static boolean isPlatformAndroid() {
        String platform = ConfigReader.emulatorConfig.platformName();
        return platform.contains("android");
    }

    private static boolean isPlatformIOS() {
        String platform = ConfigReader.emulatorConfig.platformName();
        return platform.contains("ios");
    }

}
