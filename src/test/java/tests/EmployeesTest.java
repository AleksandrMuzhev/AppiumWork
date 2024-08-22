package tests;

import static com.codeborne.selenide.Selenide.open;

import static driver.WebDriverHelper.setWebDriver;
import static pages.AuthPage.authRegisterDate;
import static pages.MainMenuPage.closePopUpMain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;

public class EmployeesTest extends BaseTest {

    @BeforeEach
    public void setUp() throws InterruptedException {
        authRegisterDate();
        closePopUpMain();
//        androidScrollToAnElementByTextWithClick("Меню");
    }

    @Description("Создание сотрудника и отображение его на десктопе")
    @Test
    public void testCreateEmployee() throws InterruptedException {
        setWebDriver();
        open("https://stand11.arnica.pro/root/login");
        Thread.sleep(5000);

    }
}
