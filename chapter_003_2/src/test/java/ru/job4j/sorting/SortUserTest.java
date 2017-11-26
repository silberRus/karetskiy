package ru.job4j.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {

    @Test
    public void sort() throws Exception {

        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Ваня", 25));
        list.add(new User("Игорь", 21));
        list.add(new User("Вика", 21));

        SortUser sortUser = new SortUser();
        TreeSet<User> map = (TreeSet<User>) sortUser.sort(list);

        assertThat(map.toString(), is("[Вика age:21, Игорь age:21, Ваня age:25]"));

    }
}