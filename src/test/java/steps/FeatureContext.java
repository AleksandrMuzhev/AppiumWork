//package steps;
//
//import static com.codeborne.selenide.Selenide.$;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.openqa.selenium.By;
//
//import io.cucumber.java.ParameterType;
//import io.cucumber.java.ru.Допустим;
//import io.cucumber.java.ru.Затем;
//import io.cucumber.java.ru.Пусть;
//import tests.BaseTest;
//
//public class FeatureContext extends BaseTest {
//
//    @Допустим("открываю приложение")
//    @BeforeEach
//    public void setUp() {
//        startDriver();
//    }
//
//    @Затем("закрываю приложение")
//    @AfterEach
//    public void tearDown() {
//        afterEach();
//    }
//
//    @Пусть("кликаю на {string}")
//    public void iClickOnButton(String string) {
//        $(By.partialLinkText(string)).click();
//    }
//
//}
