package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {

    private SimpleStack<Integer> getNewSimpleStack(){

        SimpleStack<Integer> simpletack = new SimpleStack<>();
        simpletack.push(4);
        simpletack.push(5);
        simpletack.push(7);
        simpletack.push(2);

        return simpletack;
    }

    @Test
    public void poll() {

        SimpleStack<Integer> simpleStack = getNewSimpleStack();

        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(7));
        assertThat(simpleStack.poll(), is(5));
        assertThat(simpleStack.poll(), is(4));
    }

    @Test
    public void push() {

        assertThat(getNewSimpleStack().toString(), is("4;5;7;2;"));
    }
}