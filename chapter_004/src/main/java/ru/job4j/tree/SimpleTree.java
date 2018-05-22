package ru.job4j.tree;

import java.util.Optional;

/**
 * Интерфейс дерева.
 * @author karetskiy
 * @since 22.05.2018
 * @version 2
 * @param <E> тип значений дерева.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {

    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return true если значение было добвалено.
     */
    boolean add(E parent, E child);

    /**
     * проверяет вхождение значения в дереве.
     * @param value проверяемое значение.
     * @return ветку дерева в которую входит значение.
     */
    Optional<Node<E>> findBy(E value);
}