package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class итератор для листа коллекции.
 * @author karetskiy
 * @since 18.04.2018
 * @version 2
 */
public class MyIterator<T> implements Iterator<T>{

    /**
     * Текущая коллекция.
     */
    private MyList<T> myList;
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
     * @param myList - коллекция итератора.
     * @param expectedModCount - состояние коллекции на момент создания.
     *
     */
    public MyIterator(MyList<T> myList, int expectedModCount) {

        this.myList = myList;
        this.expectedModCount = expectedModCount;
    }

    /**
     * Проверяет изменилась коллекция или неn.
     * вызывает исключение, если коллекция изменилась.
     *
     */
    private void verifyModCount() {
        if (myList.getModCount() != expectedModCount) throw new ConcurrentModificationException();
    }

    /**
     * Проверяет доступность следущего элемента в коллеции.
     * @return true если доступно следущее значение в итераторе.
     *
     */
    @Override
    public boolean hasNext() throws ConcurrentModificationException{

        verifyModCount();
        return cursor <= myList.getLastIndex();
    }

    /**
     * Возвращает следущее значение в коллеции и сдвиает крусор.
     * @return следущее значение в итераторе.
     *
     */
    @Override
    public T next() throws ConcurrentModificationException, NoSuchElementException {

        verifyModCount();
        if (!hasNext()) throw new NoSuchElementException();

        return myList.get(cursor++);
    }
}