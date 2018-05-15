package ru.job4j.set;

import org.junit.Test;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HashTableSetTest {

    private String sortedText(String string) {

        char[] chasrs = string.toCharArray();
        Arrays.sort(chasrs);
        return Arrays.toString(chasrs);
    }

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

    @Test
    public void add() {

        assertThat(sortedText(hashSet().toString()), is(sortedText("first;second;five;seven;ten;")));
    }

    @Test
    public void contains() {

        HashTableSet<String> hashSet = hashSet();
        assertThat(hashSet.contains("second"), is(true));
    }

    @Test
    public void remove() {

        HashTableSet<String> hashSet = hashSet();
        hashSet.remove("second");
        assertThat(sortedText(hashSet.toString()), is(sortedText("first;five;seven;ten;")));
    }
}