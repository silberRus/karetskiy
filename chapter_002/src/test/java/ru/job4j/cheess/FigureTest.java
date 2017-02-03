package ru.job4j.cheess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class тестировани фигур и их поведения.
 * @author karetskiy
 * @since 04.02.2017
 * @version 1
 */
public class FigureTest {


    /**
     * Двигаем фигуру в ячейке, а фигуры в ячейки нет.
     */
    @Test
    public void figueEmpty() throws FigureNotFoundException, OccupiedWayException, Exception, ImposibleMoveException {

        Board board = newBoard();
        Cell start = board.getCell(3,8);
        Cell setPos = board.getCell(1,1);

        boolean pass = false;

        try {
            moveFigure(new Figure[]{new Bishop(start, 'B')}, setPos, start, board);
        } catch (FigureNotFoundException fn) {
            pass = true;
        }

        assertThat(pass, is(true));
    }

    /**
     * Проверям движение фигуры слона C8 -> H3 и смотрим чтобы слон оказался
     * в финишной ячейке, путь свободный.
     */
    @Test
    public void bishopMoveClearPatch() throws FigureNotFoundException, OccupiedWayException, Exception, ImposibleMoveException {

        Board board = newBoard();
        Cell start = board.getCell(3,8);
        Cell finish = board.getCell(8,3);

        moveFigure(new Figure[]{new Bishop(start, 'B')}, start, finish, board);
    }

    /**
     * Проверям движение фигуры слона C8 -> H3 и смотрим чтобы на пути столял другой слон.
     */
    @Test
    public void bishopMoveNoWay() throws FigureNotFoundException, OccupiedWayException, Exception, ImposibleMoveException {

        Board board = newBoard();
        Cell start = board.getCell(3,8);
        Cell finish = board.getCell(8,3);
        Cell banditPos = board.getCell(7,4);

        boolean pass = false;

        try {
            moveFigure(new Figure[]{new Bishop(start, 'B'), new Bishop(banditPos, 'W')}, start, finish, board);
        } catch (OccupiedWayException oc) {
            pass = true;
        }

        assertThat(pass, is(true));
    }


    /**
     * Проверям движение фигуры, смотрим чтобы фигура оказалась на финише,
     * а на старте где стояла фигура раньше должно стать пусто.
     * @param start откуда
     * @param finish куда
     * @param figures набор фигур на доске.
     * @param board шахматная доска.
     */
    private void moveFigure(Figure[] figures, Cell start, Cell finish, Board board) throws Exception, ImposibleMoveException, OccupiedWayException, FigureNotFoundException {

        board.setFigures(figures);

        boolean moved = board.move(start, finish);
        boolean finished = finish.equals(figures[0].position);
        boolean started = start.itsClear(figures);

        assertThat(moved && finished && started, is(true));
    }

    /**
     *  Создает новую доску.
     * @return новая доска.
     */
    private Board newBoard() {

        Board board = new Board();
        board.initCells();

        return board;
    }
}