package ru.job4j.sorting;

/**
 * Class пользователь.
 * @author karetskiy
 * @since 26.11.2017
 * @version 1
 */
class User implements Comparable<User>{

    /**
     * id имя и город пользователя.
     */
    private String name;

    /**
     * Возраст пользователя.
     */
    private int age;

    /**
     * Конструктор.
     * @param name - имя пользователя.
     * @param age - возраст пользователя.
     */
    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    /**
     * Сортировка пользователя.
     * Сортируем по возрасту + имя
     * @return компоратор сортировки.
     *
     */
    @Override
    public int compareTo(User o) {
        return this.age == o.age ? this.name.compareTo(o.name) : Integer.compare(this.age, o.age);
    }

    /**
     * Представление пользователя.
     * @return Представление.
     *
     */
    @Override
    public String toString() {
        return String.format("%s age:%s", name, age);
    }
}