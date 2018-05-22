package ru.job4j.generic;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class теста.
 * @author karetskiy
 * @since 22.05.2018
 * @version 2
 */
public class SimpleArrayTest {

    /**
     * Сепаратор для перевода строк.
     */
    private final String ls = System.lineSeparator();

    /**
     * Получаем список.
     * @return список.
     */
    private SimpleArray<Integer> newSimpleArray() {

        SimpleArray<Integer> sa = new SimpleArray<>();

        sa.add(1);
        sa.add(3);
        sa.add(2);

        return sa;
    }

    /**
     * Проверяем метод add.
     */
    @Test
    public void add132() {

        assertThat(newSimpleArray().toString(), is(String.format("%s%s%s%s%s%s%s%s",
                            "SimpleArray:", ls,
                                        "1", ls,
                                        "3", ls,
                                        "2", ls)));
    }

    /**
     * Проверяем метод delete.
     */
    @Test
    public void deleteind1result12() {

        SimpleArray<Integer> sa = newSimpleArray();
        sa.delete(1);

        assertThat(sa.toString(), is(String.format("%s%s%s%s%s%s",
                "SimpleArray:", ls,
                "1", ls,
                "2", ls)));
    }

   /**
     * Проверяем метод set.
     */
    @Test
    public void setind1val4result142() {

        SimpleArray<Integer> sa = newSimpleArray();
        sa.set(1, 4);

        assertThat(sa.toString(), is(String.format("%s%s%s%s%s%s%s%s",
                "SimpleArray:", ls,
                "1", ls,
                "4", ls,
                "2", ls)));
    }

    /**
     * Проверяем метод get.
     */
    @Test
    public void getind2result2() {
        assertThat(newSimpleArray().get(2), is(2));
    }

    /**
     * Проверяем исключение когда список закончился.
     */
    @Test(expected = NoSuchElementException.class)
    public void saOfNextMethodShouldThrowNoSuchElementException() {

        IteratotorArray<Integer> it = new IteratotorArray<>(newSimpleArray());

        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        it.next();
    }
}
