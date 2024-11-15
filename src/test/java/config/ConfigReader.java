package config;

import org.aeonbits.owner.ConfigFactory;

/**
 * Класс для чтения файлов .properties через интерфейс EmulatorConfig
 */
public class ConfigReader {
    /**
     * Читалка для emulator.properties
     */
    public static final EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class, System.getProperties()); // Означает, с помощью фабрики конфигов создается инициализация интерфейсов и properties для Emulator
    /**
     * Читалка для test.properties
     */
    public static final TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties()); // Означает, с помощью фабрики конфигов создается инициализация интерфейсов и properties для Test

    /**
     * Публичные статичные переменные для извлечения определенного контекста названия из .apk файла в emulator.properties (в зависимости от продукта)
     */
    public static final boolean arnica = ConfigReader.emulatorConfig.app().contains("arnica");
    public static final boolean sqns = ConfigReader.emulatorConfig.app().contains("sqns");

    /**
     * Публичные статичные переменные для извлечения определенного контекста названия из platformName в emulator.properties (в зависимости от платформы)
     */
    public static final boolean platformAndroid = ConfigReader.emulatorConfig.platformName().contains("android");
    public static final boolean platformIOS = ConfigReader.emulatorConfig.platformName().contains("ios");
}
