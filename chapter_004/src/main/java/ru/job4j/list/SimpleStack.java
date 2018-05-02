package ru.job4j.list;

/**
 * Class стека.
 * @author karetskiy
 * @since 18.04.2018
 * @version 1
 */
public class SimpleStack<T> {

    /**
     * Коллекция для стека.
     */
    private ArrayList<T> store = new ArrayList<>();

    /**
     * Возвращает следующий элемент из стека и удаляет его в коллекции.
     * @return следующий элемент из стека.
     */
    public T poll() {

        T value = store.getLast();
        store.deleteLast();
        return value;
    }

    /**
     * Помещает элемент в стек.
     * @param value - помещаемое значение.
     */
    public void push(T value){
        store.add(value);
    }

    /**
     * представление стека.
     * @return представление очереди.
     */
    @Override
    public String toString() {
        return store.toString();
    }
}