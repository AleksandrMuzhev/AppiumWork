import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Необязательный вспомогательный класс для проверки работы кода (при необходимости можно удалить)
 */
public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("ru"));


        //Вывод в терминал (подставить вместо "Hello world" данные на вывод)
        System.out.println("Hello world");
    }
}
