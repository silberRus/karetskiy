package ru.job4j.generic;

import java.util.Iterator;

/**
 * Class итератора коллекции объектов.
 *
 * @author karetskiy
 * @version 1
 * @since 10.03.2018
 * @param <T> тип итератора.
 */
class IteratotorArray<T> implements Iterator {

    /**
     * Текущая коллекция.
     */
    private SimpleArray<T> simpleArray;
    /**
     * Текущий курсор коллекции.
     */
    private int cursor = 0;

    /**
     * Конструктор итератора.
     *
     * @param simpleArray - коллекция итератора.
     */
    IteratotorArray(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    /**
     * Проверяет доступность следущего элемента в коллеции.
     *
     * @return true если доступно следущее значение в итераторе.
     */
    @Override
    public boolean hasNext() {
        return cursor <= simpleArray.getLastIndex();
    }

    /**
     * Возвращает следущее значение в коллеции и сдвиает крусор.
     *
     * @return следущее значение в итераторе.
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return simpleArray.get(cursor++);
    }
}