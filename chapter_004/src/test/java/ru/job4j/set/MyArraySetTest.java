package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MyArraySetTest {

    @Test
    public void add() {

        MyArraySet<String> mySet = new MyArraySet<>();

        mySet.add("first");
        mySet.add("second");
        mySet.add("second");
        mySet.add("ten");

        assertThat(mySet.toString(), is("first;second;ten;"));
    }
}