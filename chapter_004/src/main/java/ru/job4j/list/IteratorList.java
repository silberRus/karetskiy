package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Class итератор для листа коллекции.
 * @author karetskiy
 * @since 18.04.2018
 * @version 2
 * @param <T> тип списка итератора.
 */
public class IteratorList<T> implements java.util.Iterator<T> {

    /**
     * Текущая коллекция.
     */
    private List<T> list;
    /**
     * Текущий курсор коллекции.
     */
    private int cursor = 0;

    /**
     * Запоминаем состояние колекции на момент создания итератора.
     */
    private int expectedModCount = 0;

    /**
     * Конструктуор класса.
     * @param list - коллекция итератора.
     * @param expectedModCount - состояние коллекции на момент создания.
     */
    public IteratorList(List<T> list, int expectedModCount) {

        this.list = list;
        this.expectedModCount = expectedModCount;
    }

    /**
     * Проверяет изменилась коллекция или неn.
     * вызывает исключение, если коллекция изменилась.
     *
     */
    private void verifyModCount() {

        if (list.getModCount() != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    /**
     * Проверяет доступность следущего элемента в коллеции.
     * @return true если доступно следущее значение в итераторе.
     *
     */
    @Override
    public boolean hasNext() throws ConcurrentModificationException {

        verifyModCount();
        return cursor <= list.getLastIndex();
    }

    /**
     * Возвращает следущее значение в коллеции и сдвиает крусор.
     * @return следущее значение в итераторе.
     *
     */
    @Override
    public T next() throws ConcurrentModificationException, NoSuchElementException {

        verifyModCount();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return list.get(cursor++);
    }
}