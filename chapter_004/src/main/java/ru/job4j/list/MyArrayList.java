package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Class реализация листа коллекции на основе массивов.
 * @author karetskiy
 * @since 13.04.2018
 * @version 1
 */
public class MyArrayList<E> implements Iterable{

    /**
     * массив для хранения элементов коллекции.
     */
    private Object[] objects = new Object[0];

    /**
     * Размер коллекции.
     */
    private int size = 0;

    /**
     * Текущее состояние коллекции.
     */
    private int modCount = 0;

    /**
     * Увеличивает массив объектов в 2 раза.
     */
    private void ensureCapacity() {
        objects = Arrays.copyOf(objects, (size + 1)  * 2);
    }

    /**
     * Добавляет элемент в коллекцию.
     * @param value - добовляемый элемент.
     *
     */
    public void add(E value)
    {
        if (size == objects.length) ensureCapacity();
        objects[size++] = value;
        modCount++;
    }

    /**
     * Получает элемент по индексу.
     * @param index - индекс элемента который нужно получить.
     * @return элемент коллекции.
     */
    public E get(int index) {
        return (E) objects[index];
    }

    /**
     * Возвращает представление коллеции в виде строки.
     * @return представление коллеции.
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for(Object object: this) {
            sb.append(object);
            sb.append(";");
        }
        return sb.toString();
    }

    /**
     * Возвращает последний индекс.
     * @return последний индекс коллекции.
     */
    public int getLastIndex() {
        return size - 1;
    }

    /**
     * Получает текущее состояние коллекции.
     * @return текущее состояние коллекции.
     */
    public int getModCount() {
        return modCount;
    }

    /**
     * Возвращает итератор коллекции.
     * @return итератор коллекции.
     */
    @Override
    public Iterator iterator() {
        return new MyArrayIterator(this, modCount);
    }
}
