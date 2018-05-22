package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class теста.
 * @author karetskiy
 * @since 22.05.2018
 * @version 2
 */
public class EvenIteratorListTest {

    /**
     * Итератор.
     */
    private Iterator<Integer> it;

    /**
     * Получаем заполненный итератор.
     *
     */
    @Before
    public void setUp() {

        it = new EvenNumbersIterator(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    /**
     * Проверяем итератор.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Проверяем итератор.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {

        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }

    /**
     * Проверяем итератор.
     */
    @Test
    public void  shouldReturnFalseIfNoAnyEvenNumbers() {

        it = new EvenNumbersIterator(new int[]{1});
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Проверяем итератор.
     */
    @Test
    public void allNumbersAreEven() {

        it = new EvenNumbersIterator(new int[] {2, 4, 6, 8});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
    }
}