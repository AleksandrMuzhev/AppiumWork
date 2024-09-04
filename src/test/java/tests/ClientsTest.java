package tests;

import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByXpathText;
import static driver.EmulatorHelper.slowClick;
import static helper.Constants.generateFirstName;
import static helper.Constants.generateLastName;
import static helper.Constants.generatePatronymic;
import static helper.Constants.generatePhone;
import static pages.AuthPage.authRegisterDate;
import static pages.ClientsPage.checkResultClientSearch;
import static pages.ClientsPage.createClientWithPhone;
import static pages.ClientsPage.filterClientInfo;
import static pages.ClientsPage.getTextTitleResultImport;
import static pages.ClientsPage.importContact;
import static pages.MainMenuPage.closePopUpMain;

import com.codeborne.selenide.Condition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;

public class ClientsTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        authRegisterDate();
        closePopUpMain();
        if (arnica) {
            slowClick(elementByXpathText("Клиенты"));
        } else if (sqns) {
            slowClick(elementByXpathText("Пациенты"));
        }
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

        createClientWithPhone(firstName, lastName, patronymic, phone);
        filterClientInfo(lastName + " " + firstName);
        checkResultClientSearch(lastName + " " + firstName + " " + patronymic + " ", formattedPhone);
    }

    @Description("Импорт контактов работает")
    @Test
    public void testImportContacts() {
        importContact();

        String expected = "Результаты";

        getTextTitleResultImport().should(Condition.visible).shouldHave(Condition.exactText(expected));
    }

}
