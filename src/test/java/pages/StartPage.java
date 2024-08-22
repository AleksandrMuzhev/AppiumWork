package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

/**
 * Стартовая страница авторизованного пользователя
 */
public class StartPage extends BasePage {

    private SelenideAppiumElement btnMainTabBar = (SelenideAppiumElement) $(By.id("menu_catalog"));

    @Step("Проверяем, что кнопка меню выделена оранжевым/синим цветом")
    public void isMainMenuIconSelected() {
        btnMainTabBar.should(Condition.selected);
    }

}
