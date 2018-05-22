package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Class итератор простых чисел в массиве.
 * @author karetskiy
 * @since 21.01.2018
 * @version 1
 */
public class PrimeIterator implements Iterator<Integer> {

    /**
     * Массив значений.
     */
    private final int[] values;

    /**
     * Крусор.
     */
    private int index = 0;


    /**
     * Конструктор.
     * @param values - массив значений.
     *
     */
    public PrimeIterator(final int[] values) {
        this.values = values;
    }

    /**
     * Проверяет число простое или нет.
     * @param value проверяемое число.
     * @return true если число простое.
     *
     */
    private boolean isPrime(int value) {

        boolean isPrime = value > 1;

        for (int num = 2; num < value - 1; num++) {
            if (value % num == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    /**
     * Ищем следующее простое число.
     * @return индекс в массиве со следующим простым числом.
     *
     */
    private int nextPrimeIndex() {

        if (index + 1 < values.length) {
            for (int ind = index + 1; ind < values.length; ind++) {
                if (isPrime(values[ind])) {
                    return ind;
                }
            }
        }
        return -1;
    }

    /**
     * Проверяем возможность сдвигать корретку.
     * @return true если можно.
     *
     */
    @Override
    public boolean hasNext() {

        return nextPrimeIndex() >= 0;
    }

    /**
     * Сдвигаем курсор по простым числам и возвращаем значение.
     * @return значение на котором стоит курсор.
     *
     */
    @Override
    public Integer next() {

        index = nextPrimeIndex();
        if (index == -1) {
            throw new java.util.NoSuchElementException();
        }
        return values[index];
    }
}