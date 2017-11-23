package ru.job4j.framework;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test convertCollection.
 *
 * @author Karetskiy
 * @version 1
 * @since 23.11.2017
 */

public class ConvertListTest {

    /**
     * Класс конвертации.
     */
    private ConvertList convertList = new ConvertList();

    /**
     * Проверяем созданный список по строковому представлению.
     */
    @Test
    public void toList() throws Exception {

        int[][] array = new int[][]{{1,2,3},{2,3,4}};
        assertThat(convertList.toList(array).toString(), is("[1, 2, 3, 2, 3, 4]"));
    }

    /**
     * Проверяем размер массива и чтобы последним числом был 0
     * так как количество некратное.
     */
    @Test
    public void toArray() throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int[][] array = convertList.toArray(list,3);

        assertThat(array.length, is(2));
        assertThat(array[0].length, is(3));
        assertThat(array[1][2], is(0));
    }
}