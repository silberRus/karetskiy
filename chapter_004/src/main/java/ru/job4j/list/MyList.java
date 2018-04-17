package ru.job4j.list;

import java.util.Iterator;

/**
 * Абстрактный Class коллекции для других реализаций списков.
 * @author karetskiy
 * @since 18.04.2018
 * @version 1
 */
public abstract class MyList<E> implements Iterable<E>{

    /**
     * Размер коллекции.
     */
    int size = 0;

    /**
     * Текущее состояние коллекции.
     */
    int modCount = 0;

    /**
     * Добавляет элемент в коллекцию.
     * @param value - добовляемый элемент.
     *
     */
    public void add(E value)
    {
        size++;
        modCount++;
    }

    /**
     * Получает элемент по индексу.
     * @param index - индекс элемента который нужно получить.
     * @return элемент коллекции.
     */
    abstract E get(int index);

    /**
     * Возвращает представление коллеции в виде строки.
     * @return представление коллеции.
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for(E item: this) {
            sb.append(item.toString());
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
     * Возвращает итератор коллеции.
     * @return итератор коллекции.
     */
    @Override
    public Iterator<E> iterator() {
        return new MyIterator(this, modCount);
    }
}
