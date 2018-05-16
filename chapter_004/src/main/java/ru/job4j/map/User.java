package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

public final class User {

    public String name;
    public int children;
    public Calendar birthday;

    public User(String name, int children, Calendar birthday) {

        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, children, birthday);
    }
}
