package ru.job4j.set;

import org.junit.Test;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class теста.
 * @author karetskiy
 * @since 22.05.2018
 * @version 2
 */
public class HashTableSetTest {

    /**
     * Возвращаем сортированную стрку.
     * @param string исходная строка.
     * @return сортированную строку.
     */
    private String sortedText(String string) {

        char[] chasrs = string.toCharArray();
        Arrays.sort(chasrs);
        return Arrays.toString(chasrs);
    }

    /**
     * Возвращаем хешампу.
     * @return хешампу.
     */
    private HashTableSet<String> hashSet() {

        HashTableSet<String> hashSet = new HashTableSet<>();

        hashSet.add("first");
        hashSet.add("second");
        hashSet.add("second");
        hashSet.add("five");
        hashSet.add("seven");
        hashSet.add("ten");

        return hashSet;
    }

    /**
     * Проверяем хештаблицу.
     */
    @Test
    public void add() {

        assertThat(sortedText(hashSet().toString()), is(sortedText("first;second;five;seven;ten;")));
    }

    /**
     * Проверяем хештаблицу.
     */
    @Test
    public void contains() {

        HashTableSet<String> hashSet = hashSet();
        assertThat(hashSet.contains("second"), is(true));
    }

    /**
     * Проверяем хештаблицу.
     */
    @Test
    public void remove() {

        HashTableSet<String> hashSet = hashSet();
        hashSet.remove("second");
        assertThat(sortedText(hashSet.toString()), is(sortedText("first;five;seven;ten;")));
    }
}