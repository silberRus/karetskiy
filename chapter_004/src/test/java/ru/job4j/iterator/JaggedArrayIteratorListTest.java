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
public class JaggedArrayIteratorListTest {

    /**
     * Итератор.
     */
    private Iterator<Integer> it;

    /**
     * Проверяем итератор.
     */
    @Before
    public void setUp() {

        it = new MatrixIterator(new int[][]{{1}, {3, 4}});
    }

    /**
     * Проверяем итератор.
     */
    @Test(expected = NoSuchElementException.class)
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {

        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        it.next();
    }

    /**
     * Проверяем итератор.
     */
    @Test(expected = NoSuchElementException.class)
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {

        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        it.next();
    }

    /**
     * Проверяем итератор.
     */
    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
