package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class теста.
 * @author karetskiy
 * @since 22.05.2018
 * @version 2
 */
public class LinkedSetTest {

    /**
     * Тестируем сет.
     */
    @Test
    public void add() {

        LinkedSet<Integer> mySet = new LinkedSet<>();

        mySet.add(1);
        mySet.add(2);
        mySet.add(2);
        mySet.add(4);

        assertThat(mySet.toString(), is("1;2;4;"));
    }
}