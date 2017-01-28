package ru.job4j.tracker;

/**
 * Interface запроса.
 * @author karetskiy
 * @since 28.01.2017
 * @version 2
 */
public interface Input {

    /**
     * Ввод запроса.
     * @param question вопрос пользователю
     * @return введенную строку запроса.
     */
    String ask(String question);

    /**
     * Ввод запроса, с перечислением возможных ответов.
     * @param question вопрос пользователю.
     * @param listAsks список возможных пунктов меню.
     * @return введенную строку запроса.
     */
    String ask(String question, String[] listAsks) throws MenuOutExeption;

}
