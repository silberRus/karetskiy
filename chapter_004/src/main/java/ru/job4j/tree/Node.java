package ru.job4j.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 * @param <E> тип.
 */
public class Node<E extends Comparable<E>> {

    /**
     * Ветка.
     */
    private final List<Node<E>> children = new ArrayList<>();

    /**
     * Значение начала ветки.
     */
    private final E value;

    /**
     * Конструктор ветки.
     * @param value значение начала ветки.
     */
    public Node(final E value) {
            this.value = value;
        }

    /**
     * Добавляет ветку в ветку.
     * @param child добавляемая ветка.
     */
    public void add(Node<E> child) {
            this.children.add(child);
        }

    /**
     * Возвращает подчиненную ветку.
     * @return подчиненная ветка.
     */
    public List<Node<E>> leaves() {
            return this.children;
        }

    /**
     * Проверяет содержится значение в ветке или нет.
     * @param that проверяемое значение.
     * @return true если значение содержится.
     */
    public boolean eqValue(E that) {

        return this.value.compareTo(that) == 0;
    }

    /**
     * Возвращает итератор ветки.
     * @return итератор ветки.
     */
    public Iterator iterator() {
            return children.iterator();
        }
}
