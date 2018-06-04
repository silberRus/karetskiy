package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TreeTest {

    /**
     * Тестируем дерево.
     */
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    /**
     * Тестируем дерево.
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    /**
     * Проверим итереатор.
     */
    @Test
    public void iteratorTest() {

        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        tree.add(1, 7);

        assertThat(tree.toString(), is("1234756"));
    }

    /**
     * Проверим что второй такойже child добавить нельзя.
     */
    @Test
    public void childIsUnikum() {

        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 6);
        tree.add(1, 2);

        assertThat(tree.toString(), is("1236"));
    }

    /**
     * Проверим дерево бинарное.
     */
    @Test
    public void treeIsBinary() {

        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 5);
        tree.add(5, 6);

        assertThat(tree.isBinary(), is(true));
    }

    /**
     * Проверим дерево не бинарное.
     */
    @Test
    public void treeIsNotBinary() {

        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 5);
        tree.add(5, 6);
        tree.add(1, 7);

        assertThat(tree.isBinary(), is(false));
    }
}