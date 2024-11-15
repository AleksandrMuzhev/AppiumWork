package steps;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;

public class CucumberHooks {

    @Before
    public void setUp(Scenario scenario) {
        // Добавляем слушателя Allure для Selenide
        setUpAll();

        // Логируем начало теста
        Allure.step("Запуск теста: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        // Логируем результат теста
        if (scenario.isFailed()) {
            Allure.step("Тест провален: " + scenario.getName());
            // Логика для захвата скриншотов или других данных
        } else {
            Allure.step("Тест завершен успешно: " + scenario.getName());
        }

        // Удаляем слушателя Allure для Selenide
        tearDownAll();
    }

    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    public static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
}