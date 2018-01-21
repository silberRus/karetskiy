package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Class итератор двумерных массивов.
 * @author karetskiy
 * @since 21.01.2018
 * @version 1
 */
public class MatrixIterator implements Iterator<Integer> {

    /**
     * Массив значений.
     */
    private final int[][] values;

    /**
     * Крусор в массивах.
     */
    private int index = 0;

    /**
     * Размер массвов.
     */
    private final int size;

    /**
     * Конструктор.
     * @param values - массив значений.
     *
     */
    public MatrixIterator(final int[][] values) {

        this.values = values;
        this.size = size();
    }

    /**
     * Вычисляем размер массивов.
     * @return размер массивов.
     *
     */
    private final int size() {

        int size = 0;
        for (int[] value : this.values) {
            size += value.length;
        }
        return size;
    }

    /**
     * Проверяем возможность сдвигать корретку.
     * @return true если можно.
     *
     */
    @Override
    public boolean hasNext() {

        return this.size > this.index;
    }

    /**
     * Сдвигаем курсор и возвращаем значение.
     * @return значение на котором стоит курсор.
     *
     */
    @Override
    public Integer next() {

        int ind = 0;

        for (int[] value : this.values) {

            if (ind + value.length > this.index) {
                this.index++;
                return value[this.index - ind - 1];
            }
            ind += value.length;
        }
        return null;
    }
}