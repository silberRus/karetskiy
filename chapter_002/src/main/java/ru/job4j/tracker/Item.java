package ru.job4j.tracker;


/**
 * Class Базовый класс заявки.
 * @author karetskiy
 * @since 16.01.2017
 * @version 1
 */
public class Item {

    /**
     * Имя и описание заявки.
     */
    protected String name, description;

    /**
     * Уникальный идентификатор заявки.
     */
    String id = "";

    /**
     * При создании указываем имя и описание.
     * @param name - имя заявки.
     * @param description - описание заявки.
     */
    public Item(String name, String description) {

        this.name = name;
        this.description = description;
    }

    /**
     * Устанавливает id.
     * @param id - уникальный идентификатор заявки.
     */
    public void setID(String id) {
        this.id =  id;
    }
}
