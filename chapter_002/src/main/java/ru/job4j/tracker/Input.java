package ru.job4j.tracker;

/**
 * Interface запроса.
 * @author karetskiy
 * @since 18.01.2017
 * @version 1
 */
public interface Input {

    /**
     * Ввод запроса.
     * @param question вопрос пользователю
     * @return введенную строку запроса.
     */
    String ask(String question);

}
