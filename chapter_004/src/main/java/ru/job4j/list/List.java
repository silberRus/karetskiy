package ru.job4j.list;

/**
 * Абстрактный Class коллекции для других реализаций списков.
 * @author karetskiy
 * @since 18.04.2018
 * @version 1
 * @param <E> тип списка.
 */
public abstract class List<E> implements Iterable<E> {

    /**
     * Размер коллекции.
     */
    private int size = 0;

    /**
     * Текущее состояние коллекции.
     */
    private int modCount = 0;

    /**
     * Получает размер коллекции.
     * @return Размер коллекции.
     *
     */
    public int getSize() {

        return size;
    }

    /**
     * Уменьшает размер на 1.
     */
    public void subOneSize() {

        size--;
    }

    /**
     * Добавляет элемент в коллекцию.
     * @param value - добовляемый элемент.
     * @return true если элемент был добавлен в список.
     *
     */
    public boolean add(E value) {

        size++;
        modCount++;
        return true;
    }

    /**
     * Получает элемент по индексу.
     * @param index - индекс элемента который нужно получить.
     * @return элемент коллекции.
     */
    public abstract E get(int index);

    /**
     * Возвращает представление коллеции в виде строки.
     * @return представление коллеции.
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (E item: this) {
            if (item != null) {
                sb.append(item.toString());
                sb.append(";");
            }
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
    public java.util.Iterator iterator() {
        return new IteratorList(this, modCount);
    }
}
