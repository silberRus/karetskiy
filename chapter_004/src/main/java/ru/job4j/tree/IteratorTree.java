package ru.job4j.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Class итератора дерева.
 * @author karetskiy
 * @since 16.06.2018
 * @version 3
 * @param <T> тип значений дерева.
 */
public class IteratorTree<T extends Comparable<T>> implements Iterator<T> {

    /**
     * Текущая нода
     */
    private Deque<Node<T>> queue;

    /**
     * Конструктор, при создании организуем очередь.
     * @param first нода от которой будем считать очередь.
     */
    public IteratorTree(Node<T> first) {

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
     * Возвращает следующую ноду.
     * @return следующую ноду.
     */
    public Node<T> nextNode() {

        Node<T> node = queue.removeFirst();
        for (Node<T> child: node.leaves()) {
            queue.addLast(child);
        }
        return node;
    }

    /**
     * Возвращает следующее значение.
     * @return T следующее значение.
     */
    @Override
    public T next() {

        return nextNode().getValue();
    }
}