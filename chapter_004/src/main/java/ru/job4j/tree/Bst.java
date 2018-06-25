package ru.job4j.tree;

/**
 * Class бинарного дерева.
 * @author karetskiy
 * @since 25.06.2018
 * @version 1
 * @param <E> тип значений дерева.
 */
public class Bst<E extends Comparable<E>> {

    /**
     * Корневая ветка.
     */
    private NodeBST<E> node = new NodeBST<>();

    /**
     * Добавляет значение в дерево.
     * @param e добавляемое значение.
     */
    public void add(E e) {
        node.add(e);
    }

    /**
     * Возвращает итератор дерева.
     * @return итератор.
     */
    public IteratorBST iterator() {
        return (IteratorBST<E>) node.iterator();
    }

    /**
     * Возвращает Представление дерева.
     * @return представление дерева.
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        IteratorBST<E> iteratorBST = iterator();
        while (iteratorBST.hasNext()) {
            sb.append(iteratorBST.next().toString());
        }
        return sb.toString();
    }
}