package ru.job4j.list;

/**
 * Class ноды.
 * @author karetskiy
 * @since 19.04.2018
 * @version 1
 */
public class Node<T> {


    /**
     * Значение ноды.
     */
    T value;

    /**
     * Следующая нода.
     */
    Node<T> next;

    /**
     * Конструктор ноды.
     * @param value - значение ноды.
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Проверяет зациклена коллекция или нет.
     * @param first - элемент коллекции.
     * @return true если коллекция зациклена.
     */
    static public boolean hasCycle(Node first) {

        Node x = first;
        Node x2 = x.next;

        while (x2 != null && x2.next != null) {
            if (x == x2) return true;
            x = x.next;
            x2 = x2.next.next;
        }
        return false;
    }
}
