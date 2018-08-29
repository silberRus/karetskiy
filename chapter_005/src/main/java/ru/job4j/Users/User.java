package ru.job4j.Users;

/**
 * Class хранилище даных пользователя.
 *
 * @author karetskiy
 * @version 1
 * @since 29.08.2018
 */
public class User {

    /**
     * Идентификатор пользователя.
     */
    private int id;

    /**
     * Сумма денег пользователя.
     */
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
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Изменяет сумму денег пользователя.
     * @param dif сумма на которую нужно изинить счет пользователя.
     */
    public void changeAmount(int dif) {
        this.amount += dif;
    }

    /**
     * Вычисление хеша пользователя.
     * @return
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Представление пользователя.
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}