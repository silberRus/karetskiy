package ru.job4j.set;

import ru.job4j.list.ArrayList;

/**
 * Class сета на основе массива.
 * @author karetskiy
 * @since 16.05.2018
 * @version 3
 */
public class ArraySet<T> extends ArrayList<T> {

    /**
     * Добавляет элемент в сет.
     * При добавлении проверяет чтобы элемент был уникальным.
     * @return true если элемент был добавлен и false если элемент уже был.
     */
    @Override
    public boolean add(T t) {

        boolean notFind = index(t) < 0;
        if (notFind) super.add(t);
        return notFind;
    }

    /**
     * Удаляет элемент из коллекции.
     * @param t элемент который нужно удалить.
     * @return true если элемент был удален и false если элемент не нашли.
     */
    public boolean remove(T t) {

        int ind = index(t);
        if (ind >= 0) remove(ind);
        return ind >= 0;
    }

    /**
     * Получает индекс элемента в коллекции.
     * @param t элемент индекс которого нужно получить.
     * @return индекс элемент или -1 если элемент не был найден.
     */
    public int index(T t) {

        for(int ind = 0; ind <= getLastIndex(); ind++) {
            if (get(ind).equals(t)) {
                return ind;
            }
        }
        return -1;
    }
}