package ru.job4j.generalization;

/**
 * Class пользователь.
 * @author karetskiy
 * @since 24.11.2017
 * @version 1
 */
public class User
{

    /**
     * id пользователя
     */
    private int id;

    /**
     * id имя и город пользователя.
     */
    private String name, city;

    /**
     * Конструктор.
     * @param name - имя пользователя.
     * @param city - город пользователя.
     */
    public User(String name, String city)
    {
        this.name = name;
        this.city = city;
    }

    /**
     * Устанавливает id пользователю.
     * @param id - устанавливаемый идентификатор..
     */
    void setId(int id)
    {
        this.id = id;
    }

    /**
     * Представление пользователя.
     * @return Представление.
     *
     */
    @Override
    public String toString() {
        return String.format("#%s %s (%s)", id, name, city);
    }
}