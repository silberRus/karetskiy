package ru.job4j.list;

/**
 * Class очередь.
 * @author karetskiy
 * @since 18.04.2018
 * @version 1
 * @param <T> тип очереди.
 */
public class SimpleQueue<T> {

    /**
     * Коллекция для хранения очереди.
     */
    private LinkedList<T> store = new LinkedList<>();

    /**
     * Возвращает следующий элемент из очереди и удаляет его в очереди.
     * @return крайний элемент в очереди.
     */
    public T poll() {
        T value = store.get(0);
        store.deleteFirst();
        return value;
    }

    /**
     * Помещает элемент в очередь.
     * @param value - помещаемое значение.
     */
    public void push(T value) {
        store.add(value);
    }

    /**
     * представление очереди.
     * @return представление очереди.
     */
    @Override
    public String toString() {
        return store.toString();
    }
}