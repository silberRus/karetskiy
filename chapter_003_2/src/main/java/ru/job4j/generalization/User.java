package ru.job4j.generalization;

import java.util.Random;

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
     * Генератор случайных чисел.
     */
    private static final Random RN = new Random();

    /**
     * Конструктор.
     * @param name - имя пользователя.
     * @param city - город пользователя.
     */
    public User(String name, String city)
    {
        this.name = name;
        this.city = city;
        this.id = (int) (System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Получает id пользователя.
     * @return id идентификатор пользователя.
     */
    public Integer getId()
    {
        return this.id;
    }

    /**
     * Представление пользователя.
     * @return Представление.
     *
     */
    @Override
    public String toString() {
        return String.format("%s (%s)", name, city);
    }
}