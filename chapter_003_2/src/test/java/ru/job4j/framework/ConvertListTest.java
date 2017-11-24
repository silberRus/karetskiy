package ru.job4j.framework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test convertCollection.
 *
 * @author Karetskiy
 * @version 2
 * @since 24.11.2017
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
        list.addAll(Arrays.asList(1,2,3,4,5));

        int[][] array = convertList.toArray(list,3);

        assertThat(array.length, is(2));
        assertThat(array[0].length, is(3));
        assertThat(array[1][2], is(0));
    }

    /**
     * Проверяем созданный список по строковому представлению.
     */
    @Test
    public void convert() throws Exception
    {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});

        assertThat(convertList.convert(list).toString(), is("[1, 2, 3, 4, 5, 6]"));
    }
}