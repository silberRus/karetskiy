package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class итератор для листа коллекции.
 * @author karetskiy
 * @since 13.04.2018
 * @version 1
 */
public class MyArrayIterator<T> implements Iterator<T>{

    /**
     * Текущая коллекция.
     */
    private MyArrayList<T> myArrayList;
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
     * @param myArrayList - коллекция итератора.
     * @param expectedModCount - состояние коллекции на момент создания.
     *
     */
    public MyArrayIterator(MyArrayList<T> myArrayList, int expectedModCount) {

        this.myArrayList = myArrayList;
        this.expectedModCount = expectedModCount;
    }

    /**
     * Проверяет доступность следущего элемента в коллеции.
     * @return true если доступно следущее значение в итераторе.
     *
     */
    @Override
    public boolean hasNext() throws ConcurrentModificationException{

        if (myArrayList.getModCount() != expectedModCount) throw new ConcurrentModificationException();
        return cursor < myArrayList.getLastIndex();
    }

    /**
     * Возвращает следущее значение в коллеции и сдвиает крусор.
     * @return следущее значение в итераторе.
     *
     */
    @Override
    public T next() throws ConcurrentModificationException, NoSuchElementException {

        if (myArrayList.getModCount() != expectedModCount) throw new ConcurrentModificationException();
        if (!hasNext()) throw new NoSuchElementException();

        return myArrayList.get(cursor++);
    }
}