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
public class NodeTest {

    /**
     * Проверяем ноду.
     */
    @Test
    public void hasCycle() {

        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);

        assertThat(Node.hasCycle(first), is(true));
    }

    /**
     * Проверяем ноду.
     */
    @Test
    public void hasNotCycle() {

        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);

        assertThat(Node.hasCycle(first), is(false));
    }
}