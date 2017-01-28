package ru.job4j.tracker;

/**
 * Class ошибок в меню.
 * @author karetskiy
 * @since 27.01.2017
 * @version 1
 */
public class MenuOutExeption extends Exception{

    /**
     * Конструктор. передает в родительский метод сообщение об ошибке для обработчика.
     * @param msg - сообщение ошибки в меню.
     */
    public MenuOutExeption(String msg) {
        super(msg);
    }
}
