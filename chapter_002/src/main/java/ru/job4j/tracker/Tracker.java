package ru.job4j.tracker;

import java.util.Random;

/**
 * Class Трекера.
 * @author karetskiy
 * @since 17.01.2017
 * @version 2
 */
public class Tracker {

    /**
     * Хранилище заявок.
     */
    private Item[] items = new Item[10];

    /**
     * Верхний индекс заявки (незанятый).
     */
    private int newIndex = 0;

    /**
     * Генератор случайных чисел.
     */
    private static final Random RN = new Random();

    /**
     * Добавляем заявку в трекер.
     * @param item - заявка которую добавляем.
     * @return добавленную заявку:
     */
    public Item add(Item item) {

        item.setID(String.valueOf(System.currentTimeMillis() + RN.nextInt()));
        this.items[newIndex++] = item;
        return item;
    }

    /**
     * Обновляем заявку в хранилище трекера, по id.
     * @param item - заявка которую обновляем.
     */
    public void update(Item item) {

        this.items[getIndItem(item)] = item;
    }

    /**
     * Удаляем зачку из трекера.
     * @param item - заявка которую удаляем.
     */
    public void delete(Item item) {

        newIndex--;
        for (int ind = getIndItem(item); ind != this.newIndex; ind++) {
            this.items[ind] = this.items[ind + 1];
        }
    }

    /**
     * Находим все заявки.
     * @return все зачвки трекера:
     */
    public Item[] findAll() {

        Item[] findItems = new Item[this.newIndex];
        for (int ind = 0; ind != this.newIndex; ind++) {
            findItems[ind] = this.items[ind];
        }
        return findItems;
    }

    /**
     * Находим все заявки с одинаковым именем.
     * @param name - имя по которому ищем заявки.
     * @return заявки с указанным именем:
     */
    public Item[] findByName(String name) {

        int numFind = 0;

        for (int ind = 0; ind != this.newIndex; ind++) {
            if (items[ind].getName().equals(name)) {
                numFind++;
            }
        }
        Item[] newItems = new Item[numFind];

        for (int ind = 0; ind != numFind; ind++) {
            if (items[ind].getName().equals(name)) {
                newItems[ind] = this.items[ind];
            }
        }
        return newItems;
    }

    /**
     * ищем заявку по id.
     * @param id - ID заявки.
     * @return заявки с указанным id:
     */
    public Item findById(String id) {

        for (int ind = 0; ind != newIndex; ind++) {
            if (this.items[ind].getID().equals(id)) {
                return this.items[ind];
            }
        }
        return null;
    }

    /**
     * Находим индекс заявки в хранилище.
     * @param item - заявка индекс которой ищем.
     * @return индекс в массиве:
     */
    private int getIndItem(Item item) {

        for (int ind = 0; ind != newIndex; ind++) {
            if (items[ind].getID().equals(item.getID())) {
                return ind;
            }
        }
        return -1;
    }

    /**
     * Возвращает заявку по индексу.
     * @param index - индекс заявки в массиве.
     * @return заявку из массива:
     */
    public Item getByIndex(int index) {
        return this.items[index];
    }
}
