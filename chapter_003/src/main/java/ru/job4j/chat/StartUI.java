package ru.job4j.chat;

import java.io.File;
import java.io.IOException;

/**
 * Клас для входа через консоль.
 * @author karetskiy
 * @since 02.04.2017
 * @version 1
 */
public class StartUI {

    /**
     * Вход в программу.
     * @param args параметры консоля (ождается имя файла ответов).
     */
    public static void main(String[] args) throws IOException {

        StartUI startUI = new StartUI();

        if (args.length == 0) {
            System.out.print("Нужно указать имя файла ответов");
        } else {

            String path = args[0];
            File file = new File(path);
            if (!file.exists() || file.isDirectory()) {
                System.out.print("Не корректное имя файла");
            } else {

                RoboKot roboKot = new RoboKot(path);
                roboKot.play(new ConsoleApi());
           }
        }
    }
}