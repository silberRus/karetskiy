package ru.job4j.service;

import java.io.File;
import java.io.IOException;

/**
 * Class пользовательской работы с сервисами.
 * @author karetskiy
 * @since 05.03.2017
 * @version 1
 */
public class StartUI {

    /**
     * Сервисы IO.
     */
    private MyIOService service;

    /**
     * Иницилизация.
     * @param service сервисы.
     */
    public StartUI(MyIOService service) {

        this.service = service;
    }

    /**
     * Вход в программу.
     * @param args параметры консоля
     */
    public static void main(String[] args) throws IOException {

        StartUI startUI = new StartUI(new MyIOService());

        if (args.length == 0) {
            System.out.print("Нужно указать имя входного файла");
        } else {

            String path = args[0];
            File file = new File(path);
            if (!file.exists() || file.isDirectory()) {
                System.out.print("Не корректное имя файла");
            } else {

                long timeBegin, timeEnd;

                timeBegin = System.nanoTime();
                startUI.service.sort(file, new File(path.concat("OUT.txt")));
                timeEnd = System.nanoTime();

                System.out.print(String.format("Сервис отработал %s ", timeEnd - timeBegin));
            }
        }
    }
}