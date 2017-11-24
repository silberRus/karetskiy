package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Class Трекера.
 * @author karetskiy
 * @since 24.11.2017
 * @version 4
 */
public class Tracker {

    /**
     * Хранилище заявок.
     */
    private ArrayList<Item> items = new ArrayList<>();

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
        items.add(item);
        return item;
    }

    /**
     * Обновляем заявку в хранилище трекера, по id.
     * @param item - заявка которую обновляем.
     */
    public void update(Item item)
    {
        items.set(getIndItem(item), item);
    }

    /**
     * Удаляем заявку из трекера.
     * @param item - заявка которую удаляем.
     */
    public void delete(Item item) {

        items.remove(getIndItem(item));
    }

    /**
     * Находим все заявки.
     * @return все заявки трекера:
     */
    public ArrayList<Item> findAll()
    {
        ArrayList<Item> findItems = new ArrayList<>();
        items.forEach(item -> findItems.add(item));

        return findItems;
    }

    /**
     * Находим все заявки с одинаковым именем.
     * @param name - имя по которому ищем заявки.
     * @return заявки с указанным именем:
     */
    public ArrayList findByName(String name) {

        ArrayList<Item> findItems = new ArrayList<>();
        items.forEach(item -> {
            if(item.getName().equals(name))
                findItems.add(item);
        });

        return findItems;
    }

    /**
     * ищем заявку по id.
     * @param id - ID заявки.
     * @return заявки с указанным id:
     */
    public Item findById(String id) {

        for (Item item: items)
        {
            if(item.getID().equals(id)) return item;
        }
        return null;
    }

    /**
     * Находим индекс заявки в хранилище.
     * @param item - заявка индекс которой ищем.
     * @return индекс в массиве:
     */
    public int getIndItem(Item item) {

        String id = item.getID();
        int ind = 0;
        Iterator<Item> iterator = items.iterator();

        while (iterator.hasNext())
        {
            if (iterator.next().getID() == id) return ind;
            ind++;
        }
        return -1;
    }

    /**
     * Возвращает заявку по индексу.
     * @param index - индекс заявки в массиве.
     * @return заявку из массива:
     */
    public Item getByIndex(int index)
    {
        return items.get(index);
    }
}