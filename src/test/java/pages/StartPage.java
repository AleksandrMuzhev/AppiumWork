package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

/**
 * Стартовая страница авторизованного пользователя
 */
public class StartPage extends BasePage {

    private SelenideElement btnMainTabBar = $(MobileBy.id("menu_catalog"));

    @Step("Проверяем, что кнопка меню выделена оранжевым/синим цветом")
    public void isMainMenuIconSelected() {
        btnMainTabBar.should(Condition.selected);
    }

}
