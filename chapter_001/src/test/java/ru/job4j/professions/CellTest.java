package ru.job4j.professions;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Karetskiy
 * @version 1
 * @since 11.01.2017
 */
public class CellTest {

    /**
     * Проверяем сравнение двух ячеек когда вшли за индекс массива.
     * правильный ответ: false
     */
    @Test
    public void compareTwoArraysOutRange() {

        final int[] array1 = {1, 2};
        final int[] array2 = {3, 4, 5};
        final int ind = 2;

        Cell cell = new Cell();
        boolean result = cell.compare(array1, array2, ind);
        final boolean expect = false;

        assertThat(result, is(expect));
    }

    /**
     * Проверяем сравнение двух ячеек когда не вышли за индекс массива.
     * правильный ответ: true
     */
    @Test
    public void compareTwoArraysInd0() {

        final int[] array1 = {1, 2};
        final int[] array2 = {3, 4, 5};
        final int ind = 0;

        Cell cell = new Cell();
        boolean result = cell.compare(array1, array2, ind);
        final boolean expect = true;

        assertThat(result, is(expect));
    }
}