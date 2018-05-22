package ru.job4j.list;

import java.util.Arrays;

/**
 * Class реализация листа коллекции на основе массивов.
 * @author karetskiy
 * @since 16.05.2018
 * @version 4
 * @param <E> тип списка.
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
        objects = Arrays.copyOf(objects, (getSize() + 1)  * 2);
    }

    /**
     * Добавляет элемент в коллекцию.
     * @param value - добовляемый элемент.
     * @return true если значение было добавлено в список.
     */
    public boolean add(E value) {

        if (getSize() == objects.length) {
            ensureCapacity();
        }
        objects[getSize()] = value;
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
        return get(getSize() - 1);
    }

    /**
     * Удаляет последний элемент в коллекии.
     */
    public void deleteLast() {
        objects[getSize() - 1] = null;
        subOneSize();
    }
}
