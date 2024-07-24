package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.MobileBy;

public class VisitPage {

    /**
     * Новый визит для Android Арника
     */
    private static final SelenideElement titleNewVisitText = $(MobileBy.xpath("//android.widget.TextView[@text=\"Новый визит\"]"));

    /**
     * Элементы календаря перед созданием Визита для Android Арника
     */
    private static final SelenideElement titleCalendarVisit = $(MobileBy.xpath("//android.widget.TextView[@text=\"Дата посещения\"]"));
    private static final SelenideElement selectDateTextVisit = $(MobileBy.xpath("//android.widget.TextView[@text=\"Выберите дату\"]"));
//    private static final SelenideElement btnCloseCalendar = $(MobileBy.xpath("//android.widget.TextView[@text=\"\uDB80\uDD56\"]"));
//    private static final SelenideElement titleDate = $(MobileBy.xpath("//android.widget.TextView[@resource-id=\"undefined.header.title\"]"));
//    private static final SelenideElement leftArrow = $(MobileBy.xpath("//android.view.ViewGroup[@resource-id=\"undefined.header.leftArrow\"]/android.widget.ImageView"));
//    private static final SelenideElement rightArrow = $(MobileBy.xpath("//android.view.ViewGroup[@resource-id=\"undefined.header.rightArrow\"]/android.widget.ImageView"));
//    private static final ElementsCollection dayNames = $$(MobileBy.xpath("//android.view.ViewGroup[@resource-id=\"undefined.header.dayNames\"]"));
//    private static final ElementsCollection days = $$(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));
//    private static final SelenideElement numberDayCalendar = $(MobileBy.xpath("//android.widget.TextView[@text=\"" + LocalDate.now().getDayOfMonth() + "\"]"));


    /**
     * Bottomsheet (всплывающее меню) выбора клиентов в визите для Android Арника
     */
    private static final SelenideElement btnBackSelectClient = $(MobileBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button[1]"));


    /**
     * Геттеры для обращения к полям класса из тестов
     */
    public static final SelenideElement getBtnBackSelectClient() {
        return btnBackSelectClient;
    }

    public static final SelenideElement getTitleNewVisitText() {
        return titleNewVisitText;
    }

    public static final SelenideElement getTitleCalendarVisit() {
        return titleCalendarVisit;
    }


}
