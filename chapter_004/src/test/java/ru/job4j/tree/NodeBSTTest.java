package ru.job4j.tree;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class теста.
 * @author karetskiy
 * @since 25.06.2018
 * @version 2
 */
public class NodeBSTTest {

    /**
     * Тестируем дерево.
     */
    @Test
    public void add() {

        Bst<Integer> tree = new Bst<>();
        tree.add(8);
        tree.add(5);
        tree.add(3);
        tree.add(3);
        tree.add(12);
        tree.add(10);
        tree.add(8);

        assertThat(tree.toString(), is("8512310"));
    }

    /**
     * Тестируем исключение итератора.
     */
    @Test(expected = NoSuchElementException.class)
    public void testThrow() {

        Bst<Integer> tree = new Bst<>();
        tree.add(8);
        tree.add(5);

        IteratorBST<Integer> iterator = tree.iterator();
        assertThat(iterator.next(), is(8));
        assertThat(iterator.next(), is(5));

        iterator.next();
    }
}