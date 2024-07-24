package config;
// Интерфейс для чтения настроек из файла emulator.properties
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ //Указываем, что читаем properties и то, что находится в файле emulator.properties
        "system:properties", //означает, что на вход подаются настройки, если мы запускаем внешние аргументы
        "file:src/test/resources/configs/emulator.properties"
})

public interface EmulatorConfig extends Config{
    @Key("deviceName")
    String deviceName();//метод для обозначения по ключу

    @Key("platformName")
    String platformName();//метод для обозначения по ключу

    @Key("appPackage")
    String appPackage();//метод для обозначения по ключу

    @Key("appActivity")
    String appActivity();//метод для обозначения по ключу

    @Key("app")
    String app();//метод для обозначения по ключу

    @Key("remoteURL")
    String remoteURL();//метод для обозначения по ключу

    @Key("automationName")
    String automationName();
}
