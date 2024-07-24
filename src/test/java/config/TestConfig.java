package config;
//Интерфейс для чтения настроек из файла test.properties

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ //Указываем, что читаем properties и то, что находится в файле test.properties
        "system:properties", //означает, что на вход подаются настройки, если мы запускаем внешние аргументы
        "file:src/test/resources/configs/test.properties"
})
public interface TestConfig extends Config {
    @Key("updateScreenshots")
    @DefaultValue("false")
        //устанавливаем значение по-умолчанию, если в файле настроек ничего не задано
    boolean isScreenshotsNeedToUpdate();//метод для обозначения по ключу

    @Key("deviceHost")
    String deviceHost(); //метод для обозначения по ключу
}
