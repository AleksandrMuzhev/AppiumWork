package helper;

import config.ConfigReader;
import driver.EmulatorDriver;

/**
 * Класс помощник для создания универсального инстанса AndroidDriver
 */
public class RunHelper {
    private RunHelper() {
    }

    /**
     * Статичный конструктор для вызова методов из класса без создания экземпляра
     *
     * @return
     */
    public static RunHelper runHelper() {
        return new RunHelper();
    }

    /**
     * Реализуем AndroidDriver через кастомные классы для каждого варианта девайса
     *
     * @return
     */
    public static Class<?> getDriverClass() {
        String deviceHost = ConfigReader.testConfig.deviceHost(); //Считываем deviceHost из test.properties

        switch (deviceHost) { //через switch определяем.
            case "browserstack": //если browserstack - то возвращаем особый класс с доп. логикой. В классе должна быть имплементация интерфейса
                //return.BrowserstackMobileDriver.class;
            case "selenoid": //если selenoid - то возвращаем особый класс с доп. логикой. В классе должна быть имплементация интерфейса
                //return.SelenoidMobileDriver.class;
            case "emulator": //если emulator - то возвращаем EmulatorDriver, тот класс, где есть настройки и чтение package + инициализация драйвера
                return EmulatorDriver.class;
            case "real": //если real - то возвращаем особый класс с доп. логикой. В классе должна быть имплементация интерфейса
                //return RealMobileDriver.class;
            default:
                throw new RuntimeException("В файле конфигурации нет параметра deviceHost: " +
                        "browserstack/selenoid/emulator/real");
        }
    }
}
