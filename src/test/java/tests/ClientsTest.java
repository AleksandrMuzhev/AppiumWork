package tests;

import static helper.Constants.generateFirstName;
import static helper.Constants.generateLastName;
import static helper.Constants.generatePatronymic;
import static helper.Constants.generatePhone;

import com.codeborne.selenide.Condition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import pages.AuthPage;
import pages.ClientsPage;

public class ClientsTest extends BaseTest {
    ClientsPage clientsPage;

    @BeforeEach
    public void setUp() {
        var authPage = new AuthPage();
        var ratePageWidget = authPage.authRegisterDate();
        var statisticPage = ratePageWidget.closePopUpRateWidget();
        var clientsPage = statisticPage.goToClients();
    }

    @Description("Создание клиента с номером телефона")
    @Test
    public void testCreateClientWithPhone() {
        String firstName = generateFirstName();
        String lastName = generateLastName();
        String patronymic = generatePatronymic();
        String phone = generatePhone();

        // Добавляем форматирование номера телефона
        String formattedPhone = "+7(" + phone.substring(0, 3) + ")"
                + phone.substring(3, 6) + "-"
                + phone.substring(6, 8) + "-"
                + phone.substring(8, 10);

        clientsPage.createClientWithPhone(firstName, lastName, patronymic, phone);
        clientsPage.filterClientInfo(lastName + " " + firstName);
        clientsPage.checkResultClientSearch(lastName + " " + firstName + " " + patronymic + " ", formattedPhone);
    }

    @Description("Импорт контактов работает")
    @Test
    public void testImportContacts() {
        clientsPage.importContact();

        String expected = "Результаты";

        clientsPage.getTextTitleResultImport().should(Condition.visible).shouldHave(Condition.exactText(expected));
    }

}
