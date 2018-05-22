package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Class итератор двумерных массивов.
 * @author karetskiy
 * @since 24.01.2018
 * @version 2
 */
public class MatrixIterator implements Iterator<Integer> {

    /**
     * Массив значений.
     */
    private final int[][] values;

    /**
     * Крусоры в массивах, первый элемент на масиве, второй внутри массива.
     */
    private int[] cursor = {0, -1};

    /**
     * Конструктор.
     * @param values - массив значений.
     */
    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    /**
     * Получаем следующий индекс массива.
     * @return следующий индекс.
     */
    private int[] nextInd() {

        int[] ind = {cursor[0], cursor[1]};
        ind[1]++;

        if (ind[1] == values[ind[0]].length) {
            ind[0]++;
            ind[1] = 0;
        }
        return ind[0] == values.length ? null : ind;
    }

    /**
     * Проверяем возможность сдвигать корретку.
     * @return true если можно.
     */
    @Override
    public boolean hasNext() {
        return nextInd() != null;
    }

    /**
     * Сдвигаем курсор и возвращаем значение.
     * @return значение на котором стоит курсор.
     */
    @Override
    public Integer next() {

        cursor = nextInd();
        if (cursor == null) {
            throw new java.util.NoSuchElementException();
        }
        return values[cursor[0]][cursor[1]];
    }
}