package ru.job4j.generic;

import java.util.Arrays;

/**
 * Class коллекции объектов.
 * @author karetskiy
 * @since 04.04.2018
 * @version 2
 * @param <T> тип списка.
 */
public class SimpleArray<T> {

    /**
     * Массив для хранения объектов коллекции.
     */
    private Object[] objects = new Object[0];
    /**
     * Указывает индекс самого поледнего элемента в массиве.
     */
    private int lastIndex = -1;

    /**
     * Возвращает последний индекс коллекции.
     * @return последний индекс коллекции.
     *
     */
    public int getLastIndex() {
        return lastIndex;
    }

    /**
     * Увеличивает массив объектов в 1.5 раза.
     */
    private void ensureCapacity() {

        this.objects = Arrays.copyOf(this.objects, (lastIndex + 2) * 2);
    }

    /**
     * Добавление элемента в коллекцию.
     * @param model - добавляемый объект в коллекцию.
     */
    public void add(T model) {

        if (lastIndex == this.objects.length - 1) {
            ensureCapacity();
        }
        lastIndex++;
        this.objects[lastIndex] = model;
    }

    /**
     * Удаление элемента из коллекции.
     * @param index - индекс удаляемого элемента в коллекции.
     */
    public void delete(int index) {

        if (index <= lastIndex) {
            for (int ind = index; ind < lastIndex; ind++) {
                this.objects[ind] = this.objects[ind + 1];
            }
            this.objects[lastIndex] = null;
            lastIndex--;
        }
    }

    /**
     * Устанавливает элемент в коллекцию по указанному индексу.
     * @param index - индекс вставляемого элемента в коллекции.
     * @param model - вставляемый объект.
     */
    public void set(int index, T model) {

        if (index <= lastIndex) {
            this.objects[index] = model;
        }
    }

    /**
     * Возвращает элемент по указангому индексу в коллекции.
     * @param ind - индекс возвращаемого элемента в коллекции.
     * @return объект из коллекции.
     */
    public T get(int ind) {
        return (T) objects[ind];
    }

    /**
     * Строковое представление коллекции.
     * @return строковое представление.
     */
    @Override
    public String toString() {

        final String LS = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        for (int ind = 0; ind <= lastIndex; ind++) {
            sb.append(String.format("%s%s", objects[ind], LS));
        }
        return String.format("%s%s%s", "SimpleArray:", LS, sb.toString());
    }
}