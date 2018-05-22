package ru.job4j.map;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class теста.
 * @author karetskiy
 * @since 22.05.2018
 * @version 2
 */
public class HashMapTest {

    /**
     * Проверяем мап.
     */
    @Test
    public void insert() {

        int added = 0;
        HashMap<Integer, String> hashMap = new HashMap<>();
        added += hashMap.insert(1, "один") ? 1 : 0;
        added += hashMap.insert(2, "два") ? 1 : 0;
        added += hashMap.insert(3, "три") ? 1 : 0;
        added += hashMap.insert(4, "четыре") ? 1 : 0;
        added += hashMap.insert(5, "пять") ? 1 : 0;
        added += hashMap.insert(6, "шесть") ? 1 : 0;
        added += hashMap.insert(7, "семь") ? 1 : 0;

        assertThat(added, is(hashMap.size()));
    }

    /**
     * Проверяем мап.
     */
    @Test
    public void get() {

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.insert(1, "один");
        hashMap.insert(2, "два");

        assertThat(hashMap.get(2), is("два"));

    }

    /**
     * Проверяем мап.
     */
    @Test
    public void delete() {

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.insert(1, "один");
        hashMap.insert(2, "два");

        hashMap.delete(2);

        assertThat(hashMap.toString(), is("1:один" + System.lineSeparator()));

    }
}