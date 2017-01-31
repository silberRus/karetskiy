package ru.job4j.cheess;

/**
 * Class шахматная доска.
 * @author karetskiy
 * @since 01.02.2017
 * @version 1
 */
public class Board {

    /**
     * Размер  шахматной доски.
     */
    final static private int size = 8;

    /**
     * Ячейки шахматной доски.
     */
    static private Cell[][] cells;

    /**
     * Фигуры шахматной доски.
     */
    static private Figure[] figures;

    /**
     * Иницилизация новой игры. Расставляем фигуры на карте, обнуляем ячейки;
     */
    public void newGame() {

        cells = new Cell[size][size];

    }

    /**
     * Двгаем фигуру.
     * @param source - ячейка с которой двигаем фигуру.
     * @param distance - ячейка на которую двигаем фигуру.
     * @return Истина если удалось подвинуть фигуру.
     */
    public boolean move(Cell source, Cell distance) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException{

        Figure figure = source.getFigure(figures);
        if (figure == null) {
            throw new FigureNotFoundException();
        }

        Cell[] way = figure.way(distance, this);
        if (!wayClear(way)) {
            throw new OccupiedWayException();
        }

        figure = figure.clone(distance);
        return true;
    }

    /**
     * Проверяет чистый или нет путь, исключая первую клетку.
     * @return Истина если чисто.
     */
    private boolean wayClear(Cell[] way) {

        for (int ind = 1; ind < way.length; ind ++) {
            if (way[ind].getFigure(figures) != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Возвращает ячейки по диоганали между указанными точками.
     * @param start - начало отрезка.
     * @param finish - конец отрезка.
     * @return массив ячеек которые составляют путь между точками.
     */
    public Cell[] pathDiagonal(Cell start, Cell finish) throws ImposibleMoveException {

        Cell.Vector2 way = start.pos().length(finish.pos());

        if (start.equals(finish) || way.x != way.y) {
            throw new ImposibleMoveException();
        }
        return start.way(way, cells);
    }

    /**
     * Возвращает ячейки по линии между указанными точками.
     * @param start - начало отрезка.
     * @param finish - конец отрезка.
     * @return массив ячеек которые составляют путь между точками.
     */
    public Cell[] pathLine(Cell start, Cell finish) throws ImposibleMoveException {

        Cell.Vector2 way = start.pos().length(finish.pos());

        if (start.equals(finish) || (way.x * way.y != 0)) {
            throw new ImposibleMoveException();
        }
        return start.way(way, cells);
    }
}
