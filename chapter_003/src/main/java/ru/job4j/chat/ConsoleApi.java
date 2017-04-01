package ru.job4j.chat;

import java.util.Scanner;

/**
 * Class ввода вывда информации из консоли.
 * @author karetskiy
 * @since 02.04.2017
 * @version 1
 */
public class ConsoleApi implements Api {

    /**
     * Для получения информации от системы.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Спрашиваем у пользователя вопрос и возвращаем в интерфейс ответ.
     * @return ответ пользователя.
     */
    @Override
    public String input() {
        return this.scanner.nextLine();
    }

    /**
     * Выводим в консоль ответ.
     * @param answer ответ пользователю.
     */
    @Override
    public void out(String answer) {
        System.out.println(answer);
    }
}
