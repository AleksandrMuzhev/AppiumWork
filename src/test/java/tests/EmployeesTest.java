package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;
import static driver.WebDriverHelper.setWebDriver;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import io.qameta.allure.Description;

public class EmployeesTest extends BaseTest {

//    @BeforeEach
//    public void setUp() throws InterruptedException {
//        authRegisterDate();
//        closePopUpMain();
////        androidScrollToAnElementByTextWithClick("Меню");
//    }

    @Description("Создание сотрудника и отображение его на десктопе")
    @Test
    public void testCreateEmployee() throws InterruptedException {
        setWebDriver();
        open("https://stand11.arnica.pro/root/login");
        $(By.id("RootLoginForm_login")).sendKeys("admin1");
        $(By.id("RootLoginForm_password")).sendKeys("zuF124dkPa");
        $(By.cssSelector("input[type=submit]")).click();
        $(By.cssSelector("input[title=\"Что-нибудь - название, имя, емэйл\"]")).sendKeys("Остах Ирина Николаевна");
        $(By.cssSelector("div.field.search-submit-button > button")).click();
        $$(By.cssSelector(".search-result-list td:nth-child(3)")).findBy(text("Остах Ирина Николаевна")).click();
        Thread.sleep(3000);
    }
}
