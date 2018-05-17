package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HashMapTest {

    @Test
    public void insert() {

        int added = 0;
        HashMap<Integer, String> hashMap = new HashMap<>();
        added+=hashMap.insert(1, "один") ? 1 : 0;
        added+=hashMap.insert(2, "два") ? 1 : 0;
        added+=hashMap.insert(3, "три") ? 1 : 0;
        added+=hashMap.insert(4, "четыре") ? 1 : 0;
        added+=hashMap.insert(5, "пять") ? 1 : 0;
        added+=hashMap.insert(6, "шесть") ? 1 : 0;
        added+=hashMap.insert(7, "семь") ? 1 : 0;

        assertThat(added, is(hashMap.size()));
    }

    @Test
    public void get() {

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.insert(1, "один");
        hashMap.insert(2, "два");

        assertThat(hashMap.get(2), is("два"));

    }

    @Test
    public void delete() {

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.insert(1, "один");
        hashMap.insert(2, "два");

        hashMap.delete(2);

        assertThat(hashMap.toString(), is("1:один" + System.lineSeparator()));

    }
}