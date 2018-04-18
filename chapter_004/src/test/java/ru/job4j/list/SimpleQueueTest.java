package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleQueueTest {

    private SimpleQueue getNewQuene(){

        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(4);
        simpleQueue.push(5);
        simpleQueue.push(7);
        simpleQueue.push(2);

        return simpleQueue;
    }

    @Test
    public void poll() {

        SimpleQueue<Integer> simpleQueue = getNewQuene();

        assertThat(simpleQueue.poll(), is(4));
        assertThat(simpleQueue.poll(), is(5));
        assertThat(simpleQueue.poll(), is(7));
        assertThat(simpleQueue.poll(), is(2));
    }

    @Test
    public void push() {

        assertThat(getNewQuene().toString(), is("4;5;7;2;"));
    }
}