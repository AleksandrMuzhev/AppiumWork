package helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Вспомогательный класс для генерации даты в различном формате
 */

public class DateHelper {

    /**
     * Массив месяцев года для использования генерации дат в локаторах
     */
    public static String[] MONTH_NAMES = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    //Приватный конструктор, который предотвращает создание экземпляров.
    private DateHelper() {
    }

    /**
     * Универсальный метод для отображения текущей даты с указанием формата (Например, "EEE d MMMM uuuu" - требуется выбрать, что используем)
     */
    public static String dateFormat(LocalDate currentDate, String pattern) {
        return currentDate.format(DateTimeFormatter.ofPattern(pattern, new Locale("ru")));
    }

    /**
     * Методы для генерации сокращенных названий дней недели в формате EEE (Например, Пн)
     *
     * @param currentDate
     * @param locale
     * @return
     */
    //Сокращенное название текущего дня недели предыдущего месяца
    public static String dayOfWeekForPreviousMonth(LocalDate currentDate, Locale locale) {
        return currentDate.minusMonths(1).getDayOfWeek().getDisplayName(TextStyle.SHORT, locale).toUpperCase().substring(0, 1) + currentDate.minusMonths(1).getDayOfWeek().getDisplayName(TextStyle.SHORT, locale).toLowerCase().substring(1);
    }

    //Сокращенное название текущего дня недели следующего месяца
    public static String dayOfWeekForNextMonth(LocalDate currentDate, Locale locale) {
        return currentDate.plusMonths(1).getDayOfWeek().getDisplayName(TextStyle.SHORT, locale).toUpperCase().substring(0, 1) + currentDate.plusMonths(1).getDayOfWeek().getDisplayName(TextStyle.SHORT, locale).toLowerCase().substring(1);
    }

    // Метод для генерации сокращенного названия дня
    public static String dayOfWeek(LocalDate currentDate, Locale locale) {
        return currentDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, locale).toUpperCase().substring(0, 1) + currentDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, locale).toLowerCase().substring(1);
    }

    // Метод для генерации сокращенного названия дня недели предыдущего дня
    public static String dayOfWeekForPreviousDay(LocalDate currentDate, Locale locale) {
        return currentDate.minusDays(1).getDayOfWeek().getDisplayName(TextStyle.SHORT, locale).toUpperCase().substring(0, 1) + currentDate.minusDays(1).getDayOfWeek().getDisplayName(TextStyle.SHORT, locale).toLowerCase().substring(1);
    }

    // Метод для генерации сокращенного названия дня недели следующего дня
    public static String dayOfWeekForNextDay(LocalDate currentDate, Locale locale) {
        return currentDate.plusDays(1).getDayOfWeek().getDisplayName(TextStyle.SHORT, locale).toUpperCase().substring(0, 1) + currentDate.plusDays(1).getDayOfWeek().getDisplayName(TextStyle.SHORT, locale).toLowerCase().substring(1);
    }


    /**
     * Методы для генерации числа месяца в формате dd (Например, 15)
     *
     * @return
     */
    // Число текущего дня месяца
    public static int dayOfMonth() {
        return LocalDate.now().getDayOfMonth();
    }

    // Число предыдущего дня месяца
    public static int dayPrevOfMonth() {
        return LocalDate.now().minusDays(1).getDayOfMonth();
    }

    // Число следующего дня месяца
    public static int dayNextOfMonth() {
        return LocalDate.now().plusDays(1).getDayOfMonth();
    }


    /**
     * Методы для генерации дат в формате EEE dd MMMM yyyy (Например, Пн 1 января 2024)
     *
     * @return
     */
    //Текущий день месяца с сокращенным днем недели (Например, Вт 6 августа 2024)
    public static String dayOfMonthCurrent() {
        return dayOfWeek(LocalDate.now(), new Locale("ru")) + " " +
                LocalDate.now().getDayOfMonth() + " " +
                LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")) + " " +
                LocalDate.now().getYear();
    }

    //Текущий день предыдущего месяца с сокращенным днем недели (Например, Сб 6 июля 24)
    public static String dayOfMonthPrev() {
        return dayOfWeekForPreviousMonth(LocalDate.now(), new Locale("ru")) + " " +
                LocalDate.now().getDayOfMonth() + " " +
                LocalDate.now().minusMonths(1).getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")) + " " +
                String.valueOf(LocalDate.now().getYear()).substring(2);
    }

    //Текущий день следующего месяца с сокращенным днем недели (Например, Пт 6 сентября 24)
    public static String dayOfMonthNext() {
        return dayOfWeekForNextMonth(LocalDate.now(), new Locale("ru")) + " " +
                LocalDate.now().getDayOfMonth() + " " +
                LocalDate.now().plusMonths(1).getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")) + " " +
                String.valueOf(LocalDate.now().getYear()).substring(2);
    }

    //Дата предыдущего дня с сокращенным днем недели (Например, Пн 5 августа 24)
    public static String dateOfDayPrev() {
        return dayOfWeekForPreviousDay(LocalDate.now(), new Locale("ru")) + " " +
                LocalDate.now().minusDays(1).getDayOfMonth() + " " +
                LocalDate.now().minusDays(1).getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")) + " " +
                String.valueOf(LocalDate.now().getYear()).substring(2);
    }

    //Дата текущего дня с сокращенным днем недели (Например, Пн 6 августа 24)
    public static String dateCurrentFull() {
        return dayOfWeekForPreviousDay(LocalDate.now(), new Locale("ru")) + " " +
                LocalDate.now().getDayOfMonth() + " " +
                LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")) + " " +
                String.valueOf(LocalDate.now().getYear()).substring(2);
    }

    //Дата следующего дня с сокращенным днем недели (Например, Ср 7 августа 24)
    public static String dateOfDayNext() {
        return dayOfWeekForNextDay(LocalDate.now(), new Locale("ru")) + " " +
                LocalDate.now().plusDays(1).getDayOfMonth() + " " +
                LocalDate.now().plusDays(1).getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")) + " " +
                String.valueOf(LocalDate.now().getYear()).substring(2);
    }


    /**
     * Метод для генерации даты в формате MMMM yyyy (Например, Август 24)
     *
     * @return
     */
    public static String monthWithYear() {
        return MONTH_NAMES[LocalDate.now().getMonth().getValue() - 1] + " " +
                String.valueOf(LocalDate.now().getYear()).substring(2);
    }

    /**
     * Метод для генерации даты в формате yyyy-MM (Например, 2024-08)
     */
    public static String yearWithMonthValue() {
        return LocalDate.now().getYear() + "-" + LocalDate.now().getMonthValue();
    }


    /**
     * Метод для генерации диапазона текущей недели (Например, 29 - 04 августа 24)
     */
    public static String rangeDateCurrentWeek() {
        LocalDate currentDate = LocalDate.now();
        int dayOfWeek = currentDate.getDayOfWeek().getValue(); // 1 = понедельник, 2 = вторник,..., 7 = воскресенье

        LocalDate startOfWeek = currentDate.minusDays(dayOfWeek - 1); // понедельник
        LocalDate endOfWeek = currentDate.plusDays(7 - dayOfWeek); // воскресенье

        DateTimeFormatter formatterFrom = DateTimeFormatter.ofPattern("dd", new Locale("ru"));
        DateTimeFormatter formatterTo = DateTimeFormatter.ofPattern("dd MMMM uu", new Locale("ru"));

        String formattedStartOfWeek = startOfWeek.format(formatterFrom);
        String formattedEndOfWeek = endOfWeek.format(formatterTo);

        return String.format("%s - %s", formattedStartOfWeek, formattedEndOfWeek);
    }
}
