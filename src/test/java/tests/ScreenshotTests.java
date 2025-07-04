//package tests;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInfo;
//
//import java.io.File;
//
//import pages.MainMenuPage;
//
//public class ScreenshotTests extends BaseTest { //Наследуем от базового тестового класса
//
//    /**
//     * Информация о тестовом методе
//     */
//    private TestInfo testInfo;
//
//    /**
//     * Перед каждым тестом инициализация тестовой информации
//     *
//     * @param testInfo информация из junit5
//     */
//    @BeforeEach
//    public void init(TestInfo testInfo) { //Конструктор с параметрами для переопределения поля testInfo
//        this.testInfo = testInfo;
//    }
//
//    /**
//     * Запускать первым, чтобы сделать эталон скриншота
//     * Проверка верстки страницы Каталог
//     * Надо чтобы в test.properties было значение true у updateScreenshots
//     */
////    @Test
////    public void testMainCatalogScreenshot() {
////        File mainScreenScreenshot = new MainMenuPage().closePopUp()
////                .openCatalog()
////                .fullPageScreenshot();
////        assertScreenshot(mainScreenScreenshot, testInfo.getDisplayName());
////    }
//
//    /**
//     * Падающий тест для проверки что в аллюр сохраняется картинка с отличиями
//     * Надо чтобы в test.properties было значение false у updateScreenshots
//     * Запускать вторым, чтобы увидеть различия
//     */
//    @Test
//    public void testMainScreenScreenshotFail() {
//        File mainScreenScreenshot = new MainMenuPage()
//                .fullPageScreenshot();
//        assertScreenshot(mainScreenScreenshot, "testMainCatalogScreenshot()");
//    }
//}
