package ru.job4j.set;

import static java.lang.Math.abs;

/**
 * Class сета на основе хештаблицы.
 * @author karetskiy
 * @since 16.05.2018
 * @version 1
 */
public class HashTableSet<T> {

    /**
     * Размер сета.
     */
    private int size = 0;

    /**
     * Сеты ячеек сета.
     */
    private ArraySet<T>[] hashTable = new ArraySet[0];

    /**
     * Вычисляет хеш функцию значения.
     * @param t значение хеш код которого нужно вычислить.
     * @return число, хеш код из значения.
     */
    private int hashCode(T t) {

        int code = abs(t.hashCode());
        do {
            code = code / hashTable.length;
        } while (code > hashTable.length);

        return code;
    }

    /**
     * Добавляет значение в сет.
     * @param t значение которое нужно добавить.
     * @return true если значение было добавленоа, false если значение уже было.
     */
    public boolean add(T t) {

        boolean added = !contains(t);

        if (added) {
            size++;
            if (size > hashTable.length) {
                ensureCapacity();
            }
            added = hashTable[hashCode(t)].add(t);
        }
        return added;
    }

    /**
     * Проверяет есть ли такое значение в сете или нет.
     * @param t значение которое нужно проверить.
     * @return true если значение если, false если хначения нет.
     */
    public boolean contains(T t) {
        return hashTable.length != 0 && hashTable[hashCode(t)].index(t) >= 0;
    }

    /**
     * Удаляет значение из сета.
     * @param t значение которое нужно удалить.
     * @return true если значение было удалено, false если значения небыло.
     */
    public boolean remove(T t) {
        return hashTable[hashCode(t)].remove(t);
    }

    /**
     * Увеличивает емкость сета.
     */
    private void ensureCapacity() {

        ArraySet<T>[] newHashTable = new ArraySet[size * 2 + size];
        for (int ind = 0; ind < newHashTable.length; ind++) {
            newHashTable[ind] = new ArraySet<>();
        }
        for(ArraySet<T> hashLine: hashTable) {
            hashLine.forEach(t->newHashTable[hashCode(t)].add(t));
        }
        hashTable = newHashTable;
    }

    /**
     * Возвращает представление сета.
     * @return представление сета.
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for(ArraySet<T> arraySet: hashTable) {
            if (arraySet.getLastIndex() >= 0) {
                sb.append(arraySet.toString());
            }
        }
        return sb.toString();
    }
}