package tests;

import static com.codeborne.selenide.Selenide.$;
import static driver.EmulatorHelper.androidScrollToAnElementByTextWithClick;
import static pages.AuthPage.authRegisterDate;
import static pages.ClientsPage.createValidClient;
import static pages.MainMenuPage.closePopUpMain;
import static pages.VisitPage.addClientInVisit;
import static pages.VisitPage.addToVisitCertificate;
import static pages.VisitPage.addToVisitService;
import static pages.VisitPage.addToVisitSubscription;
import static pages.VisitPage.changeStatusVisit;
import static pages.VisitPage.createClientInVisit;
import static pages.VisitPage.goToNewVisitWithBtnPlus;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Description;
import pages.VisitPage;

public class VisitTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        authRegisterDate();
        closePopUpMain();
        androidScrollToAnElementByTextWithClick("Расписание");
    }

    @Description("Создание сложного визита")
    @Test
    public void testCreateHardVisit() {
        goToNewVisitWithBtnPlus();
        addClientInVisit("Лотович Валерий");
        addToVisitService();
        addToVisitCertificate();
        addToVisitSubscription();
        changeStatusVisit("Клиент пришел");
        VisitPage.payVisit();
    }

    @Description("Можно создать и добавить в визит клиента (создание клиента через визит)")
    @Test
    public void testCreateClientInVisit() {
        String expected = "Петров Дмитрий Иванович";
        SelenideElement actual = $(MobileBy.xpath("//android.widget.TextView[@text=\"" + expected + "\"]"));

        goToNewVisitWithBtnPlus();
        createClientInVisit();
        createValidClient();

        actual.should(Condition.visible).shouldHave(Condition.exactText(expected));
    }

}
