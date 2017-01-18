package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class ввода информации из консоли.
 * @author karetskiy
 * @since 18.01.2017
 * @version 1
 */
public class ConsoleInput implements Input {

    /**
     * Для получения информации от системы.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Спрашиваем у пользователя вопрос и возвращаем в интерфейс ответ.
     * @param question - вопрос пользователю.
     * @return ответ пользователя.
     */
    public String ask(String question) {
        System.out.println(question);
        return  this.scanner.nextLine();
    }
}
