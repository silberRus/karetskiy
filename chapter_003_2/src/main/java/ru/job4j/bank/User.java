package ru.job4j.bank;

import java.util.Objects;

public class User {

    /**
     * Имя и паспортные данные пользователя.
     */
    private String name, passport;

    /**
     * Конструктор.
     * @param name - имя пользователя.
     * @param passport - паспортные данные пользователя.
     */
    public User(String name, String passport) {

        this.name = name;
        this.passport = passport;
    }

    /**
     * Представление пользователя.
     * @return Представление пользователя.
     */
    @Override
    public String toString() {
        return String.format("%s #%s", name, passport);
    }

    /**
     * Хеш пользователя из паспртных данных и имени.
     * @return Хеш пользователя.
     */
    @Override
    public int hashCode() {

        return Objects.hash(name, passport);
    }
}
