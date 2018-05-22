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
public class ArraySetTest {

    /**
     * Проверяем сет.
     */
    @Test
    public void add() {

        ArraySet<String> mySet = new ArraySet<>();

        mySet.add("first");
        mySet.add("second");
        mySet.add("second");
        mySet.add("ten");

        assertThat(mySet.toString(), is("first;second;ten;"));
    }
}