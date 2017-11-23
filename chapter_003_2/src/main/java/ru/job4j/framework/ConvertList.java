package ru.job4j.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Class конвертаций коллекций.
 * @author karetskiy
 * @since 24.11.2017
 * @version 2
 */
public class ConvertList
{
    /**
     * Конвертация массива в коллекцию.
     * @param array - Массив который конвертируем.
     * @return сконвертированную коллекцию.
     */
    public List<Integer> toList(int[][] array)
    {
        List<Integer> list = new ArrayList();

        for (int col = 0; col < array.length; col++)
        {
            for (int row = 0; row < array[col].length; row++)
            {
                list.add(array[col][row]);
            }
        }
        return list;
    }

    /**
     * Конвертация коллекцию в двухмерный массив.
     * @param list - коллекция которую конвертируем.
     * @param rows - Число записей в одной строке.
     * @return сконвертированный двухмерный массив.
     */
    public int[][] toArray (List<Integer> list, int rows)
    {
        int size = list.size();
        int colums = size / rows;
        if (size % rows != 0) colums++;

        int[][] array = new int[colums][rows];

        int row = 0; int col = 0;
        for (Integer num: list)
        {
            array[row][col] = num;

            col++;
            if (col == rows) {
                col = 0;
                row++;
            }
        }
        return array;
    }

    /**
     * Конвертация коллекциb массивов в коллекцию чисел.
     * @param list - коллекция из которой конвертируем.
     * @return сконвертированную коллекци чисел.
     */
    public List<Integer> convert (List<int[]> list)
    {
        ArrayList<Integer> newList = new ArrayList<>();
        list.forEach(array -> {
            for (int num: array) {
                newList.add(num);
            }
        });
        return newList;
    }
}