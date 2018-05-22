package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class теста.
 * @author karetskiy
 * @since 22.05.2018
 * @version 2
 */
public class SimpleStackTest {

    /**
     * Получаем буфер.
     * @return буфер.
     */
    private SimpleStack<Integer> getNewSimpleStack() {

        SimpleStack<Integer> simpletack = new SimpleStack<>();
        simpletack.push(4);
        simpletack.push(5);
        simpletack.push(7);
        simpletack.push(2);

        return simpletack;
    }

    /**
     * Проверяем буфер.
     */
    @Test
    public void poll() {

        SimpleStack<Integer> simpleStack = getNewSimpleStack();

        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(7));
        assertThat(simpleStack.poll(), is(5));
        assertThat(simpleStack.poll(), is(4));
    }

    /**
     * Проверяем буфер.
     */
    @Test
    public void push() {

        assertThat(getNewSimpleStack().toString(), is("4;5;7;2;"));
    }
}