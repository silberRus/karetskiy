package ru.job4j.set;

import ru.job4j.list.LinkedList;

/**
 * Class сета на основе асоциативного списка.
 * @author karetskiy
 * @since 21.04.2018
 * @version 1
 * @param <T> тип сета.
 */
public class LinkedSet<T> extends LinkedList<T> {

    /**
     * Добавляет элемент в сет.
     * При добавлении проверяет чтобы элемент был уникальным.
     */
    @Override
    public boolean add(T item) {

        boolean find = false;

        for (T elemen: this) {
            if (elemen.equals(item)) {
                find = true;
                break;
            }
        }
        if (!find) {
            super.add(item);
        }
        return !find;
    }
}
