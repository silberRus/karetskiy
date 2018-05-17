package ru.job4j.map;

import static java.lang.Math.abs;

/**
 * Class карты на основе хеш таблицы.
 * @author karetskiy
 * @since 18.05.2018
 * @version 1
 */
public class HashMap<K,V> {

    /**
     * Класс ячейки для хранения ключ-значение.
     */
    static final class Node<K, V>{
        K key;
        V value;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Размер карты.
     */
    private int size = 0;

    /**
     * Хранилище ячеек карты.
     */
    private Node<K, V>[] values = new Node[3];

    /**
     * Увеличиввет размер ячеек карты.
     */
    private void ensureCapacity() {

        Node<K, V>[] newValues = new Node[2 * values.length];
        for (Node<K, V> nod : values) {
            if (nod != null) {
                newValues[hashCode(nod.key, newValues.length)] = nod;
            }
        }
        values = newValues;
    }

    /**
     * Вычисляет хеш код карты.
     * @param key значение хеш код которого нужно вычислить.
     * @param max число хеша которое не должен превысеть хеш.
     * @return число, хеш код из значения.
     */
    private int hashCode(K key, int max) {

        int code = abs(key.hashCode()) * 31;
        do {
            code = code / max;
        } while (code > max - 1);

        return code;
    }

    /**
     * Вычисляет хеш код карты.
     * @param key значение хеш код которого нужно вычислить.
     * @return число, хеш код из значения.
     */
    private int hashCode(K key) {
        return hashCode(key, values.length);
    }

    public int size() {
        return size;
    }

    /**
     * Вставляет значение в карту.
     * @param key ключ эелемента карты.
     * @param value значение элемента карты.
     * @return true если место было свободно и false если было занято.
     */
    public boolean insert(K key, V value) {

        if (size >= values.length / 2) {
            ensureCapacity();
        }

        int hex = hashCode(key);
        boolean present = values[hex] != null;

        if (!present) {
            values[hex] = new Node(key, value);
            size++;
        }
        return !present;
    }

    /**
     * Получает значение из карты.
     * @param key ключ эелемента карты.
     * @return значение элекмента карты.
     */
    public V get(K key) {

        return values[hashCode(key)].value;
    }

    /**
     * Удаляет значение по ключу.
     * @param key ключ эелемента карты.
     * @return true если значение было удалено или false если значение не было найдено.
     */
    public boolean delete(K key) {

        int hex = hashCode(key);
        boolean present = values[hex] != null;

        if (present) {
            values[hex] = null;
            size--;
        }
        return present;
    }

    /**
     * Представление карты.
     * @return Представление карты.
     */
    @Override
    public String toString() {

        final String LS = System.lineSeparator();

        StringBuilder sb = new StringBuilder();
        for (Node<K, V> node : values) {
            if (node != null) {
                sb.append(String.format("%s:%s%s", node.key.toString(), node.value.toString(), LS));
            }
        }
        return sb.toString();
    }
}
