package ru.job4j.set;

import org.junit.Test;
import ru.job4j.list.MyLinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MyLinkedSetTest {

    @Test
    public void add() {

        MyLinkedSet<Integer> mySet = new MyLinkedSet<>();

        mySet.add(1);
        mySet.add(2);
        mySet.add(2);
        mySet.add(4);

        assertThat(mySet.toString(), is("1;2;4;"));
    }
}