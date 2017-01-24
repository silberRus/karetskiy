package ru.job4j.tracker;


/**
 * Class Базовый класс заявки.
 * @author karetskiy
 * @since 25.01.2017
 * @version 3
 */
public class Item {

    /**
     * Уникальный идентификатор, имя и описание заявки.
     */
    private String id, name, description;

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
     * Возвращает строковое представление заявки.
     * @return представление заявки.
     */
    public String toString() {

        return String.format("[%s] имя: %s; описание: %s", this.id, this.name, this.description);
    }

    /**
     * Устанавливает id.
     * @param id - уникальный идентификатор заявки.
     */
    public void setID(String id) {

        this.id =  id;
    }
    /**
     * Получаем id.
     * @return уникальный идентификатор заявки.
     */
    public String getID() {

        return this.id;
    }

    /**
     * Получем имя.
     * @return имя заявки.
     */
    public String getName() {

        return this.name;
    }
    /**
     * Устанавливаем имя.
     * @param name имя заявки которое устанавливаем.
     */
    public void setName(String name) {

        this.name = name;
    }
}
