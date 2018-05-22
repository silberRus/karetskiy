package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Class итератор четных чисел в массиве.
 * @author karetskiy
 * @since 24.01.2018
 * @version 2
 */
public class EvenNumbersIterator implements Iterator<Integer> {

    /**
     * Массив значений.
     */
    private final int[] values;

    /**
     * Крусор.
     */
    private int index = -1;

    /**
     * Конструктор.
     * @param values - массив значений.
     */
    public EvenNumbersIterator(final int[] values) {
        this.values = values;
    }

    /**
     * Ищем следующее четное число и возвращаем индекс его положения.
     * -1 если не нашли.
     * @return индекс в массиве со следующим четным числом.
     */
    private int nextEvenIndex() {

        if (index != values.length) {
            for (int ind = index + 1; ind < values.length; ind++) {
                if (this.values[ind] % 2 == 0) {
                    return ind;
                }
            }
        }
        return -1;
    }

    /**
     * Проверяем возможность сдвигать корретку.
     * @return true если можно.
     */
    @Override
    public boolean hasNext() {
        return nextEvenIndex() != -1;
    }

    /**
     * Сдвигаем курсор по четным числам и возвращаем значение.
     * @return значение на котором стоит курсор.
     */
    @Override
    public Integer next() {

        index = nextEvenIndex();
        if (index == -1) {
            throw new java.util.NoSuchElementException();
        }
        return values[index];
    }
}