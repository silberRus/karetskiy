package ru.job4j.info;

/**
 * Class статистики изменений списка.
 *
 * @author karetskiy
 * @version 1
 * @since 18.07.2018
 */
public class Info {

    /**
     * Сколько изменилось.
     */
    private int changed;

    /**
     * Сколько добавлено.
     */
    private int added;

    /**
     * Сколько удалено.
     */
    private int deleted;

    /**
     * Увеличивает статистику по добавленным.
     */
    public void add() {
        added++;
    }

    /**
     * Увеличивает статистику по удаленным.
     */
    public void delete() {
        deleted++;
    }

    /**
     * Увеличивает статистику по имененным.
     */
    public void change() {
        changed++;
    }

    /**
     * Представление статистики.
     * @return представление статистики.
     */
    @Override
    public String toString() {
        return "Info{" +
                "changed=" + changed +
                ", added=" + added +
                ", deleted=" + deleted +
                '}';
    }
}