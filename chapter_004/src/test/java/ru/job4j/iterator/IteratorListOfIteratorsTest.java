package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Arrays;
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
public class IteratorListOfIteratorsTest {

    /**
     * Итератор.
     */
    private Iterator<Integer> it;

    /**
     * Проверяем итератор.
     */
    @Before
    public void setUp() {

        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
    }

    /**
     * Проверяем итератор.
     */
    @Test
    public void hasNextNextSequentialInvocation() {

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Проверяем итератор.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {

        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
    }

    /**
     * Проверяем итератор.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {

        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
    }

    /**
     * Проверяем итератор.
     */
    @Test
    public void hasNextShouldReturnFalseInCaseOfEmptyIterators() {

        Iterator<Integer> it1 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it2 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it3 = (new ArrayList<Integer>()).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Проверяем итератор.
     */
    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {

        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        it.next();
    }

    /**
     * Проверяем итератор.
     */
    @Test
    public void  itHasNextShouldBeTrue() {

        Iterator<Integer> it1 = Arrays.asList(1, 2).iterator();
        Iterator<Iterator<Integer>> input = Arrays.asList(it1).iterator();

        assertThat(input.hasNext(), is(true));
    }

    /**
     * Проверяем итератор.
     */
    @Test
    public void shouldReturnFalseInCaseOfEmptyIterator() {

        Iterator<Iterator<Integer>> its = new ArrayList<Iterator<Integer>>().iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
        assertThat(it.hasNext(), is(false));
    }
}