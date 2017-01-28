package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class ввода информации из консоли.
 * @author karetskiy
 * @since 28.01.2017
 * @version 2
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

    /**
     * Спрашиваем у пользователя вопрос и возвращаем в интерфейс ответ,
     * заодно проверяем возможные ответы .
     * @param question - вопрос пользователю.
     * @param listAsks - массив возможных запросов пользователя.
     * @return ответ пользователя.
     */
    public String ask(String question, String[] listAsks) throws MenuOutExeption {

        boolean exist = false;
        String key = this.ask(question);

        for (String ask: listAsks) {
            if (key.equals(ask)) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutExeption("Out of range menu ask");
        }
    }
}
