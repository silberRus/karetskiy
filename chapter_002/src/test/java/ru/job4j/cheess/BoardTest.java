package ru.job4j.cheess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class тестировани шахмотной доски.
 * @author karetskiy
 * @since 04.02.2017
 * @version 1
 */
public class BoardTest {

    /**
     * Проверяем получение ячеек по диагонали.
     * F1 -> H3. H4 -> D8. A4 -> E8.
     */
    @Test
    public void pathDiagonal() throws Exception, ImposibleMoveException {

        int[][][] expect = new int[3][][];

        expect[0] = new int[][] {{6,1},{7,2},{8,3}};
        expect[2] = new int[][] {{8,4},{7,5},{6,6},{5,7},{4,8}};
        expect[1] = new int[][] {{2,4},{3,3},{4,2},{5,1}};

        testPatch(expect, "diagonal");
    }

    /**
     * Проверяем получение ячеек по линии.
     * F1 -> B1. H4 -> H8. A4 -> A1.
     */
    @Test
    public void pathLine() throws Exception, ImposibleMoveException {

        int[][][] expect = new int[3][][];

        expect[0] = new int[][] {{6,1},{7,1},{8,1}};
        expect[1] = new int[][] {{8,4},{8,5},{8,6},{8,7},{8,8}};
        expect[2] = new int[][] {{1,4},{1,3},{1,2}};

        testPatch(expect, "line");
    }

    /**
     * Тестирует пути
     * @param expect - массив внутри которого массивы путей внутри которых x и y [0,1].
     */
    private void testPatch(int [][][] expect, String type) throws ImposibleMoveException {

        Board board = new Board();
        board.initCells();

        for (int[][] test: expect) {

            Cell start = new Cell(test[0][0], test[0][1]);
            Cell finish = new Cell(test[test.length - 1][0], test[test.length - 1][1]);

            if ("diagonal".equals(type)) {
                assertThat(cellToArray(board.pathDiagonal(start, finish)), is(test));
            } else if("line".equals(type)) {
                assertThat(cellToArray(board.pathLine(start, finish)), is(test));
            }
        }
    }

    /**
     * Преобразует массив ячеек в массив двухмерных массивов.
     * @param cells - массив ячеек доски.
     * @return массив элементами которого массивы из двух чисел x/y
     */
    public static int[][] cellToArray(Cell[] cells) {

        int[][] array = new int[cells.length][2];

        for (int ind = 0; ind < cells.length; ind++) {
            array[ind][0] = cells[ind].x();
            array[ind][1] = cells[ind].y();
        }
        return array;
    }
}