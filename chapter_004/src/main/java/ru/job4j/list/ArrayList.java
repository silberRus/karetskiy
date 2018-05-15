package ru.job4j.list;

import java.util.Arrays;

/**
 * Class реализация листа коллекции на основе массивов.
 * @author karetskiy
 * @since 16.05.2018
 * @version 4
 */
public class ArrayList<E> extends List<E> {

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
    public boolean add(E value)
    {
        if (size == objects.length) ensureCapacity();
        objects[size] = value;
        return super.add(value);
    }

    /**
     * Удаляет элемент по индексу из коллекции.
     * @param index - индекс элемента который нужно удалить.
     */
    public void remove(int index) {

        if (index != getLastIndex()) {
            for (int ind = index; ind < getLastIndex(); ind++) {
                this.objects[ind] = this.objects[ind + 1];
            }
        }
        deleteLast();
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
     * Возвращает последний элемент коллекии.
     * @return последний элемент коллекции.
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * Удаляет последний элемент в коллекии.
     */
    public void deleteLast() {
        objects[size - 1] = null;
        size--;
    }
}
