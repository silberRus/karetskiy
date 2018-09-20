package ru.job4j.Users;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class хранилище даных пользователя.
 *
 * @author karetskiy
 * @version 1
 * @since 29.08.2018
 */
@ThreadSafe
public class User {

    /**
     * Идентификатор пользователя.
     */
    private final int id;

    /**
     * Сумма денег пользователя.
     */
    @GuardedBy("this")
    private int amount;

    /**
     * Конструктор, задаем идентификатор и сумму денег.
     * @param id идентификатор пользователя.
     * @param amount сумма денег пользователя.
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Получает идентификатор пользователя.
     * @return идентификатор пользователя.
     */
    public int getId() {
        return id;
    }

    /**
     * Изменяет сумму денег пользователя.
     * @param dif сумма на которую нужно изинить счет пользователя.
     */
    public synchronized void changeAmount(int dif) {
        this.amount += dif;
    }

    /**
     * Вычисление хеша пользователя.
     * @return вычисленный хеш пользователя.
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Представление пользователя.
     * @return представление пользователя.
     */
    @Override
    public synchronized String toString() {
        return "User{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}