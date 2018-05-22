package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

/**
 * Class пользователя.
 * @author karetskiy
 * @since 22.05.2018
 * @version 2
 */
public final class User {

    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Количество детей.
     */
    private int children;

    /**
     * день рождегние пользователя.
     */
    private Calendar birthday;

    /**
     * Конструктор пользователя.
     * @param name имя пользовтеля.
     * @param children количество детей пользовтеля.
     * @param birthday день рождение пользовтеля.
     */
    public User(String name, int children, Calendar birthday) {

        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Вычисляем хеш пользователя.
     * @return хеш пользователя.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    /**
     * Сравниваем пользователей.
     * @param o пользователь с которым сравниваем.
     * @return true если пользователи равны.
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }
}
