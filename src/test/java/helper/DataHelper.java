package helper;

import static config.ConfigReader.arnica;
import static config.ConfigReader.sqns;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

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
     * Данные для логина, пароля в мобильном приложении
     */
    public static String LOGIN_ARNICA = "filter-495@arnica.pro";
    public static String PASSWORD_ARNICA = "12345qwert";
    public static String LOGIN_SQNS = "filter-4717@arnica.pro";
    public static String PASSWORD_SQNS = "qwe123";

    /**
     * Данные для логина, пароля, стендов, целевых пользователей для WEB
     */
    public static String LOGIN_WEB = "admin1";
    public static String PASSWORD_WEB = "zuF124dkPa";
    public static String USER_ARNICA_WEB = "Остах Ирина Николаевна";
    public static String USER_SQNS_WEB = "Успенский Владимир Валерьевич";
    public static String URL_STAND_ARNICA = "https://stand11.arnica.pro/root/login";
    public static String URL_STAND_SQNS = "https://stand3k.arnica.pro/root/login";

    //Приватный конструктор, который предотвращает создание экземпляров.
    private DataHelper() {
    }

    // Специальный метод для заполнения локального класса (объекта) AuthInfoMobile данными для логина, пароля в МПС в зависимости от продукта и стенда
    public static AuthInfoMobile getAuthInfoMobile() {
        if (arnica) {
            return new AuthInfoMobile(LOGIN_ARNICA, PASSWORD_ARNICA);
        } else if (sqns) {
            return new AuthInfoMobile(LOGIN_SQNS, PASSWORD_SQNS);
        }
        return null;
    }

    // Специальный метод для заполнения локального класса (объекта) AuthInfoWeb данными для логина, пароля, ФИО пользователя в веб-браузере в зависимости от продукта и стенда
    public static AuthInfoWeb getUserInfoWeb() {
        if (arnica) {
            return new AuthInfoWeb(LOGIN_WEB, PASSWORD_WEB, USER_ARNICA_WEB);
        } else if (sqns) {
            return new AuthInfoWeb(LOGIN_WEB, PASSWORD_WEB, USER_SQNS_WEB);
        }
        return null;
    }

    // Специальный метод для заполнения локального класса (объекта) UrlInfo данными для URL в веб-браузере в зависимости от продукта и стенда
    public static UrlInfo getUrlInfo() {
        if (arnica) {
            return new UrlInfo(URL_STAND_ARNICA);
        } else if (sqns) {
            return new UrlInfo(URL_STAND_SQNS);
        }
        return null;
    }

    /**
     * Генерация случайных данных
     */
    // Генерация случайных чисел (например, для номера медицинской карты)
    public static long generateNumberCard() {
        return faker.number().randomNumber();
    }

    // Генерация случайного имени
    public static String generateFirstName() {
        return faker.name().firstName();
    }

    // Генерация случайной фамилии в зависимости от пола
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

    // Генерация случайного отчества в зависимости от пола
    public static String generatePatronymic() {
        String gender = faker.demographic().sex();
        if (gender.equals("Male")) {
            return faker.name().lastName() + "ович";  // Отчество для мужчин
        } else {
            return faker.name().lastName() + "овна";  // Отчество для женщин
        }
    }

    // Генерация случайной даты рождения в рамках 100 лет назад
    public static String generateBirthDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        // Получаем текущую дату
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        //Генерируем случайный год от (currentYear - 100) до currentYear - 1
        int year = ThreadLocalRandom.current().nextInt(currentYear - 100, currentYear);

        //Генерируем случайный месяц и день
        int month = ThreadLocalRandom.current().nextInt(0, 12);
        int day = ThreadLocalRandom.current().nextInt(1, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        //Устанавливаем сгенерированную дату
        calendar.set(year, month, day);
        Date birthDate = calendar.getTime();

        //Форматируем дату в нужный формат и возвращаем как результат метода
        return dateFormat.format(birthDate);
    }

    // Генерация случайного номера телефона
    public static String generatePhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    // Метод для форматирования номера телефона, например, +7(832)034-65-23
    public static String formattedPhoneWeb(String phone) {
        return "+7(" + phone.substring(0, 3) + ")" + phone.substring(3, 6) + "-" + phone.substring(6, 8) + "-" + phone.substring(8, 10);
    }

    // Метод для форматирования номера телефона, например, +78323465234
    public static String formattedPhoneMob(String phone) {
        return "+7" + phone.substring(0, 3) + phone.substring(3, 6) + phone.substring(6, 8) + phone.substring(8, 10);
    }

    // Генерация случайных названий кабинетов
    public static String generateRoom() {
        String[] roomTypes = {"Кардиология", "Дерматология", "Педиатрия", "Ортопедия", "Онкология", "Неврология", "Гинекология"};
        String roomType = faker.options().option(roomTypes);
        return roomType;
    }

    // Генерация случайных названий складов
    public static String generateStorage() {
        String[] storageNames = {"Склад1", "Склад2", "Склад3", "Склад4", "Склад5", "Склад6", "Склад7", "Склад8", "Склад9", "Склад10", "Склад11", "Склад12", "Склад13", "Склад14", "Склад15"};
        String storageName = faker.options().option(storageNames);
        return storageName;
    }

    // Генерация случайных названий фруктов
    public static FoodInfo generateFood() {
        return new FoodInfo(faker.food().fruit());
    }

    // Специальный метод для заполнения локального класса (объекта) UserInfo данными
    public static UserInfo getUserInfo() {
        return new UserInfo(generateNumberCard(), generateFirstName(), generateLastName(), generatePatronymic(), generateBirthDate(), generatePhone());
    }

    /**
     * Локальные классы (объекты), хранящие данные, заполняемые статическими методами текущего класса
     */
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
        String birthDay;
        String phone;
    }

    @Value
    public static class FoodInfo {
        String food;
    }
}
