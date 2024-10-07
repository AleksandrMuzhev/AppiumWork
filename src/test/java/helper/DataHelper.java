package helper;

import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;

import com.github.javafaker.Faker;

import java.util.Locale;

import lombok.Value;

/**
 * Утилитный класс с данными
 */
public class DataHelper {

    private static final Faker faker = new Faker(new Locale("ru"));

    /**
     * Путь куда сохраняются скриншоты селенида
     */
    public static String SCREENSHOT_TO_SAVE_FOLDER = "screenshots/actual/";

    /**
     * Данные для логина, пароля, стендов для WEB
     */
    public static String LOGIN_ARNICA = "filter-495@arnica.pro";
    public static String PASSWORD_ARNICA = "12345qwert";
    public static String LOGIN_SQNS = "muzhevTest@arnica.pro";
    public static String PASSWORD_SQNS = "qwe123";

    public static String LOGIN_WEB = "admin1";
    public static String PASSWORD_WEB = "zuF124dkPa";
    public static String USER_ARNICA_WEB = "Остах Ирина Николаевна";
    public static String USER_SQNS_WEB = "Чернойван Василий";
    public static String URL_STAND_ARNICA = "https://stand11.arnica.pro/root/login";
    public static String URL_STAND_SQNS = "https://stand15k.arnica.pro/root/login";

    //Приватный конструктор, который предотвращает создание экземпляров.
    private DataHelper() {
    }

    public static AuthInfoMobile getAuthInfoMobile() {
        if (arnica) {
            return new AuthInfoMobile(LOGIN_ARNICA, PASSWORD_ARNICA);
        } else if (sqns) {
            return new AuthInfoMobile(LOGIN_SQNS, PASSWORD_SQNS);
        }
        return null;
    }

    public static AuthInfoWeb getUserInfoWeb() {
        if (arnica) {
            return new AuthInfoWeb(LOGIN_WEB, PASSWORD_WEB, USER_ARNICA_WEB);
        } else if (sqns) {
            return new AuthInfoWeb(LOGIN_WEB, PASSWORD_WEB, USER_SQNS_WEB);
        }
        return null;
    }

    public static UrlInfo getUrlInfo() {
        if (arnica) {
            return new UrlInfo(URL_STAND_ARNICA);
        } else if (sqns) {
            return new UrlInfo(URL_STAND_SQNS);
        }
        return null;
    }

    @Value
    public static class AuthInfoMobile {
        String login;
        String password;
    }

    @Value
    public static class AuthInfoWeb {
        String login;
        String password;
        String user;
    }

    @Value
    public static class UrlInfo {
        String url;
    }

    @Value
    public static class UserInfo {
        Long numberCard;
        String name;
        String surname;
        String patronymic;
        String phone;
    }

    /**
     * Генерация случайных данных
     */
    public static long generateNumberCard() {
        return faker.number().randomNumber();
    }
    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        String gender = faker.demographic().sex();
        String lastName = faker.name().lastName();
        if (gender.equals("Female")) {
            // Применение женских суффиксов
            if (lastName.endsWith("ов") || lastName.endsWith("ев") || lastName.endsWith("ин")) {
                lastName = lastName + "а";
            } else if (lastName.endsWith("ский") || lastName.endsWith("цкий")) {
                lastName = lastName.substring(0, lastName.length() - 2) + "ая";
            } else if (lastName.endsWith("ой")) {
                lastName = lastName.substring(0, lastName.length() - 2) + "ая";
            }
        }
        // Если мужчина, фамилия остается без изменений
        return lastName;
    }

    public static String generatePatronymic() {
        String gender = faker.demographic().sex();
        if (gender.equals("Male")) {
            return faker.name().lastName() + "ович";  // Отчество для мужчин
        } else {
            return faker.name().lastName() + "овна";  // Отчество для женщин
        }
    }

    public static String generatePhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String generateFormattedPhone(String phone) {
        String formattedPhone = "+7(" + phone.substring(0, 3) + ")"
                + phone.substring(3, 6) + "-"
                + phone.substring(6, 8) + "-"
                + phone.substring(8, 10);
        return formattedPhone;
    }

    // Генерация случайных названий кабинетов
    public static String generateRoom() {
        String[] roomTypes = {"Кардиология", "Дерматология", "Педиатрия", "Ортопедия", "Онкология", "Неврология", "Гинекология"};
        String roomType = faker.options().option(roomTypes);
        return roomType;
    }

    public static UserInfo getUserInfo() {
        return new UserInfo(generateNumberCard(), generateFirstName(), generateLastName(), generatePatronymic(), generatePhone());
    }

}
