package ru.job4j.list;

import java.util.Arrays;

/**
 * Class реализация листа коллекции на основе массивов.
 * @author karetskiy
 * @since 18.04.2018
 * @version 2
 */
public class MyArrayList<E> extends MyList<E>{

    /**
     * массив для хранения элементов коллекции.
     */
    private Object[] objects = new Object[0];

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
        objects[size] = value;
        super.add(value);
    }

    /**
     * Получает элемент по индексу.
     * @param index - индекс элемента который нужно получить.
     * @return элемент коллекции.
     */
    public E get(int index) {
        return (E) objects[index];
    }

}
