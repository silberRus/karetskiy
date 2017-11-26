package ru.job4j.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test sort users.
 *
 * @author Karetskiy
 * @version 2
 * @since 27.11.2017
 */
public class SortUserTest {

    /**
     * Проверяем сортировку по возрасту + имя.
     */
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

    /**
     * Проверяем сортировку по длине имени.
     */
    @Test
    public void sortForLengthName() throws Exception {

        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Александр", 25));
        list.add(new User("Игорь", 21));
        list.add(new User("Вика", 21));

        SortUser sortUser = new SortUser();
        ArrayList<User> sortList = (ArrayList<User>) sortUser.sortNameLength(list);

        assertThat(sortList.toString(), is("[Вика age:21, Игорь age:21, Александр age:25]"));
    }

    /**
     * Проверяем сортировку по имени + возрасту.
     */
    @Test
    public void sortForNameAndAge() throws Exception {

        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Александр", 25));
        list.add(new User("Игорь", 21));
        list.add(new User("Вика", 21));

        SortUser sortUser = new SortUser();
        ArrayList<User> sortList = (ArrayList<User>) sortUser.sortByAllFields(list);

        assertThat(sortList.toString(), is("[Александр age:25, Вика age:21, Игорь age:21]"));
    }
}