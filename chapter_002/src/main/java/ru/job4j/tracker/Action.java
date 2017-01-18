package ru.job4j.tracker;


/**
 * Class действия пользователя.
 * @author karetskiy
 * @since 18.01.2017
 * @version 1
 */
public class Action {

    /**
     * Описание запроса и запрос пользователя в интрфейсе.
     */
    private String show, ask;

    /**
     * При иницилизации задаем переменные.
     * @param show описание запроса
     * @param ask запрос пользователя
     */
    public Action(String show, String ask) {

        this.ask = ask;
        this.show = show;
    }

    /**
     * Возвращаем запрос.
     * @return запрос пользователя.
     */
    public String getAsk() {
        return this.ask;
    }

    /**
     * Как звучит вопрос от пользователя.
     * @return описание запроса.
     */
    public String getShow() {
        return this.show;
    }
}
