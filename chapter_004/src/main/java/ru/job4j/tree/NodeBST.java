package ru.job4j.tree;

import java.util.Iterator;

/**
 * Class ноды двоичного дерева.
 * @author karetskiy
 * @since 16.06.2018
 * @version 1
 * @param <E> тип значений дерева.
 */
public class NodeBST<E extends Comparable<E>> {

    /**
     * Левая нода, которая меньше значения.
     */
    private NodeBST<E> left;

    /**
     * Правая нода, которая больше значения.
     */
    private NodeBST<E> right;

    /**
     * Значение ноды.
     */
    private E value;

    /**
     * Добавляет значение в ноду.
     * @param e добавляемое значение.
     */
    public void add(E e) {

        if (value == null) {

            left = new NodeBST<>();
            right = new NodeBST<>();
            value = e;
        } else {

            if (!e.equals(value)) {
                (e.hashCode() < value.hashCode() ? left : right).add(e);
            }
        }
    }

    /**
     * Возвращает текущее значние ноды.
     * @return значение ноды.
     */
    public E getValue() {
        return value;
    }

    /**
     * Добавляет значение ноды в массив если значение у ноды не null.
     * @param val нода.
     * @param array массив куда добавляем.
     * @param ind индекс в массиве куда добавлять.
     */
    private void addToArray(NodeBST<E> val, NodeBST<E>[] array, int ind) {

        if (val.getValue() != null) {
            array[ind] = val;
        }
    }

    /**
     * Возвращает массив подчиенных нод.
     * @return массив подчиненных нод.
     */
    public NodeBST<E>[] child() {

        int size = (left == null ? 0 : 1) + (right == null ? 0 : 1);

        NodeBST<E>[] child = new NodeBST[size];

        if (size > 0) {
            addToArray(left, child, 0);
            addToArray(right, child, size - 1);
        }
        return child;
    }

    /**
     * Возвращает итератор ветки.
     * @return итератор ветки.
     */
    public Iterator iterator() {
        return new IteratorBST(this);
    }
}