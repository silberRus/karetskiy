package ru.job4j.tree;

import java.util.Iterator;
import java.util.Optional;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Class простого дерева.
 * @author karetskiy
 * @since 16.06.2018
 * @version 2
 * @param <E> тип значений дерева.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * Текущая ветка.
     */
    private Node<E> node;

    /**
     * Конструктор.
     * @param e - значение корневого элемента.
     */
    public Tree(E e) {
        node = new Node<>(e);
    }

    /**
     * Добавляет значение в ветку.
     * @param parent - значение ветки родителя в которую добавляют.
     * @param child - значение ветки которую добавляют.
     * @return true если значение было добавлено.
     */
    @Override
    public boolean add(E parent, E child) {

        Optional<Node<E>> rel = findBy(parent);
        boolean isPresent = rel.isPresent();
        if (isPresent && !findBy(child).isPresent()) {
            rel.get().add(new Node(child));
        }
        return isPresent;
    }

    /**
     * Ищет ветку по значению.
     * @param value - значение ветки котрую нужно найти.
     * @return ветку которую искали по значению.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {

        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.node);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Проверяет дерево бинарное или нет.
     * @return true если дерево бинарное.
     */
    public boolean isBinary() {

        IteratorTree<E> iterator = (IteratorTree<E>) iterator();
        boolean isBinary = true;

        while (iterator.hasNext()) {
            Node<E> de = iterator.nextNode();
            if (de.leaves().size() > 2) {
                isBinary = false;
                break;
            }
        }
        return isBinary;
    }

    /**
     * Итератор дерева.
     * @return итератор.
     */
    @Override
    public Iterator<E> iterator() {

        return new IteratorTree<>(node);
    }

    /**
     * Возвращает представление дерева.
     * @return представление дерева.
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        forEach(nd->sb.append(nd.toString()));
        return sb.toString();
    }
}