package ru.job4j.cheess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class тестировани клеток шахматной доски.
 * @author karetskiy
 * @since 04.02.2017
 * @version 1
 */
public class CellTest {

    /**
     * Проверяем постройку пути.
     */
    @Test
    public void way() throws Exception {

        final Cell start = new Cell(3, 8);
        final Cell way = new Cell(2, -2);

        final int[][] expect = new int[][]{{3, 8}, {4, 7}, {5, 6}};

        Board board = new Board();
        board.initCells();

        int[][] result = BoardTest.cellToArray(start.way(way, board.getCells()));

        assertThat(result, is(expect));
    }

    /**
     * Проверяем сравнения позиций шахматной доски.
     */
    @Test
    public void equals() throws Exception {

        final Cell cell1 = new Cell(1, 1);
        final Cell cell2 = new Cell(1, 1);

        final boolean expect = true;
        final boolean result = cell1.equals(cell2);

        assertThat(result, is(expect));
    }

    /**
     * Проверяем вычисление длины вектора между двумя клетками шахматной доски.
     */
    @Test
    public void length() throws Exception {

        final Cell cell1 = new Cell(2, 5);
        final Cell cell2 = new Cell(5, 1);

        final int[] expect = new int[]{3, -4};
        final Cell cell = cell1.length(cell2);

        int[] result = new int[]{cell.x(), cell.y()};

        assertThat(result, is(expect));
    }
}