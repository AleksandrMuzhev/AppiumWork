package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

/**
 * Класс помощник для выполнения bash команд
 */
public class DeviceHelper {
    /**
     * Выполняет bash скрипт с гарантированием возрата полной информации из консоли
     *
     * @param command bash скрипт
     * @return результат скрипта
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static String executeSh(String command) throws IOException, ExecutionException, InterruptedException {
        Process p = Runtime.getRuntime().exec(command); //Инициализируем новый процесс и получаем у него текущее окружение и через команду exec выполняем этот процесс
        FutureTask<String> future = new FutureTask<>(() -> { //() пустой метод, который вернет нам тип данных String & FutureTask класса для работы с новыми потоками для выполнения команды в будущем. Гарантирует то, что выполняется в команде консольной, завершит это действие и вернет все строчки
            return new BufferedReader(new InputStreamReader(p.getInputStream())).lines().map(Object::toString).collect(Collectors.joining("\n")); //Через BufferedReader обращаемся к процессу и Стримом извлекаем все строчки через lines(), и каждый объект превращаем в строчку через map(), разделяя новой строкой через collect & joining
        });
        new Thread(future).start();
        return future.get();
    }

    /**
     * 2-й вариант более сокращенный чем 3-й
     * Чтение стримом
     *
     * @param command
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static String[] executeBashStreamApi(String command) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(command); //Инициализируем новый процесс и получаем у него текущее окружение и через команду exec выполняем этот процесс
        String[] message = {""}; //Создаем массив с сообщениями
        new Thread(() -> {
            new BufferedReader(new InputStreamReader(p.getInputStream())).lines().forEach(x -> message[0] += x + "\n"); // через стримы (lines) перебираем каждую новую строчку и записываем в массив
        }).start(); //Создаем новый поток
        p.waitFor(); //Ждем завершения процесса
        return message; //Возвращаем массив сообщений
    }


    /**
     * Выполняет bash скрипт через терминал с обработкой exception
     * Не гарантирует полного получения результата выполнения команды, так как нет обратного Callback
     * Подходит для выполнения скрипта без возвращения результата
     *
     * @param command bash команда
     * @return результат скрипты
     */
    public static String executeBash(String command) { //передаем на вход команду в локальном терминале
        Process p;
        try {
            p = Runtime.getRuntime().exec(command); //Инициализируем новый процесс и получаем у него текущее окружение и через команду exec выполняем этот процесс
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        final String[] message = {""}; //Создаем массив с сообщениями

        new Thread(() -> { //Чтение сообщения происходит через новый поток (используем для случая, если приложение зависнет)
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream())); //Получаем все данные, которые приходят из процесса
            String line = null;
            while (true) { //Пока данные из процесса доступны, происходит чтение этих строк
                try {
                    if ((line = input.readLine()) == null) {
                        break;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                message[0] += line + "\n"; //записываем строки в первый элемент массива
            }
            System.out.println(message[0]); //выводим в консоль для дебагинга
        }).start(); //Запускаем поток
        try {
            p.waitFor(); //ждем завершения потока
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return message[0]; //Возвращаем сообщение
    }
}
