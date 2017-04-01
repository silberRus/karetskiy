package ru.job4j.chat;

/**
 * Interface ввода вывода.
 * @author karetskiy
 * @since 02.04.2017
 * @version 1
 */
public interface Api {

    /**
     * Ввод запроса.
     * @return ответ бота.
     */
    String input();

    /**
     * Возврат ответа.
     * @return ответ бота.
     */
    void out(String answer);
}
