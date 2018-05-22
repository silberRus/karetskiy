package ru.job4j.list;

/**
 * Class коллекции на основе связанных объектов.
 * @author karetskiy
 * @since 18.04.2018
 * @version 2
 * @param <E> Тип списка.
 */
public class LinkedList<E> extends List<E> {

    /**
     * первый элемент ноды.
     */
    private Node<E> first;

    /**
     * последний элемент ноды.
     */
    private Node<E> last;

    /**
     * Class внутренней ноды для связанных объектов.
     * @param <E> типс списка нода.
     * */
    private static class Node<E> {

        /**
         * Хранимый объект коллекции.
         */
        private E element;

        /**
         * Следующий элемент коллекции.
         */
        private Node<E> next;

        /**
         * Предыдущий элемент коллекции.
         */
        private Node<E> prev;

        /**
         * Конструктуор ноды.
         * @param prev - предыдущий элеиент коллекции.
         * @param next - следующий элеиент коллекции.
         * @param element - значение элемента коллекции.
         *
         */
        Node(Node<E> prev, E element, Node<E> next) {

            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        /**
         * Привязывает следующий элемент коллекции.
         * @param next - привязываем сыледующий элемент коллекции.
         *
         */
        void setNext(Node<E> next) {
            this.next = next;
        }

        /**
         * возвращает следующий элемент коллекции.
         * @return следующий элемент коллекции.
         *
         */
        Node<E> getNext() {
            return next;
        }

        /**
         * возвращает значение элемента коллекции.
         * @return элемент коллекции.
         *
         */
        E getElement() {
            return element;
        }
    }

    /**
     * Добавляет элемент в коллекцию.
     * @param item - добавляемый элемент коллекции.
     * @return true если элемент был добавлен в список.
     *
     */
    public boolean add(E item) {

        Node<E> newElem = new Node<E>(last, item, null);

        if (getSize() == 0) {
            first = newElem;
        } else {
            last.setNext(newElem);
        }
        last = newElem;

        return super.add(item);
    }

    /**
     * Возвращает элемент коллекции по индексу.
     * @param index - индекс требуемого элемента коллекции.
     * @return элеиент коллекции.
     *
     */
    public E get(int index) {

        Node<E> current = first;
        for (int ind = 0; ind < index; ind++) {
            current = current.getNext();
        }
        return current.getElement();
    }

    /**
     * Удаляет первый элемент в коллекии.
     */
    public void deleteFirst() {

        first.prev = null;
        first = first.next;
    }
}
