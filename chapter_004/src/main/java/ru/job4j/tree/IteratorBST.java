package ru.job4j.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class итератора бинарного дерева.
 * @author karetskiy
 * @since 25.06.2018
 * @version 1
 * @param <T> тип значений дерева.
 */
public class IteratorBST<T extends Comparable<T>> implements Iterator<T> {

    /**
     * Текущая нода.
     */
    private Deque<NodeBST<T>> queue;

    /**
     * Конструктор, при создании организуем очередь.
     * @param first нода от которой будем считать очередь.
     */
    public IteratorBST(NodeBST<T> first) {

        queue = new ArrayDeque<>();
        queue.addLast(first);
    }

    /**
     * Проверяет есть следующий элемент или нет.
     * @return true если есть следующий элемент.
     */
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /**
     * Возвращает следующее значение.
     * @return T следующее значение.
     */
    @Override
    public T next() throws NoSuchElementException {

        NodeBST<T> node = queue.removeFirst();
        for (NodeBST<T> child: node.child()) {
            if (child != null) {
                queue.addLast(child);
            }
        }
        return node.getValue();
    }
}
