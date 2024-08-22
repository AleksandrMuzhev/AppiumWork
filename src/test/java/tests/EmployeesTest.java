package tests;

import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;

public class EmployeesTest extends BaseTest {

//    @BeforeEach
//    public void setUp() {
//        authRegisterDate();
//        closePopUpMain();
//        androidScrollToAnElementByTextWithClick("Меню");
//    }

    @Description("Создание сотрудника и отображение его на десктопе")
    @Test
    public void testCreateEmployee() throws InterruptedException {
        open("https://stand11.arnica.pro/root/login");
        Thread.sleep(5000);

    }
}
