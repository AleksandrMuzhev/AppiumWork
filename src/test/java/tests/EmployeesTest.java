//package tests;
//
//import static com.codeborne.selenide.Selenide.open;
//import static com.codeborne.selenide.appium.SelenideAppium.$;
//import static driver.WebDriverHelper.setWebDriver;
//import static helper.Constants.getLOGIN;
//import static helper.Constants.getPASSWORD;
//import static helper.Constants.getUSER;
//import static helper.Constants.getUrlWeb;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//
//import io.qameta.allure.Description;
//
//public class EmployeesTest {
//
//    @BeforeEach
//    public void setUp() {
//        authRegisterDate();
//        closePopUpMain();
//        elementByXpathText("Расписание").click();
//    }
//
//    @Description("Создание сотрудника и отображение его на десктопе")
//    @Test
//    public void testCreateEmployee() throws InterruptedException {
//        setWebDriver();
//        open(getUrlWeb());
//        $(By.id("RootLoginForm_login")).sendKeys(getLOGIN());
//        $(By.id("RootLoginForm_password")).sendKeys(getPASSWORD());
//        $(By.cssSelector("input[type=submit]")).click();
//        $(By.cssSelector("input[title=\"Что-нибудь - название, имя, емэйл\"]")).sendKeys(getUSER());
//        $(By.cssSelector("div.field.search-submit-button > button")).click();
//        $(By.linkText(getUSER())).click();
//        $(By.linkText("Продажи")).click();
//        $(By.linkText("Клиенты")).click();
//        Thread.sleep(3000);
//    }
//}
