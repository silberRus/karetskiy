package ru.job4j.set;

import ru.job4j.list.MyLinkedList;

/**
 * Class сета на основе асоциативного списка.
 * @author karetskiy
 * @since 21.04.2018
 * @version 1
 */
public class MyLinkedSet<T> extends MyLinkedList<T> {

    /**
     * Добавляет элемент в сет.
     * При добавлении проверяет чтобы элемент был уникальным.
     */
    @Override
    public void add(T item) {

        boolean find = false;

        for (T elemen: this) {
            if (elemen.equals(item)) {
                find = true;
                break;
            }
        }
        if (!find) super.add(item);
    }
}
