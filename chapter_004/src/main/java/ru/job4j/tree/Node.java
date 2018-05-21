package ru.job4j.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Node<E extends Comparable<E>> {

        private final List<Node<E>> children = new ArrayList<>();
        private final E value;

        public Node(final E value) {
            this.value = value;
        }

        public void add(Node<E> child) {
            this.children.add(child);
        }

        public List<Node<E>> leaves() {
            return this.children;
        }

        public boolean eqValue(E that) {
            return this.value.compareTo(that) == 0;

        }

        public Iterator iterator() {
            return children.iterator();
        }
}
