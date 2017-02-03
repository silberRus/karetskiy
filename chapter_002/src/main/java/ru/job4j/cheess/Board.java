package ru.job4j.cheess;

import static java.lang.String.valueOf;

/**
 * Class шахматная доска.
 * @author karetskiy
 * @since 04.02.2017
 * @version 2
 */
public class Board {

    /**
     * Размер  шахматной доски.
     */
    final static private int size = 8;

    /**
     * Ячейки шахматной доски.
     */
    private Cell[][] cells;

    /**
     * Фигуры шахматной доски.
     */
    private Figure[] figures;

    /**
     * Иницилизация новой игры. Расставляем фигуры на карте, обнуляем ячейки.
     * Шахматная достка 2D массив (ширина это x начинается слева от 1 до 8
     *                              длина это y начинается снизу от 1 до 8)
     * белые (W) сверху, черныее (B)снизу
     */
    public void newGame() {

        initCells();

        setFigures(new Figure[] {
            new Bishop(getCell(3,1), 'W'),
            new Bishop(getCell(6,1), 'W'),
            new Bishop(getCell(3,8), 'W'),
            new Bishop(getCell(6,8), 'W')});
    }

    /**
     * Иницилизацирует ячейки доски.
     */
    public void initCells() {

        this.cells = new Cell[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                this.cells[x][y] = new Cell(x + 1, y + 1);
            }
        }
    }

    /**
     * Двгаем фигуру.
     * @param source - ячейка с которой двигаем фигуру.
     * @param distance - ячейка на которую двигаем фигуру.
     * @return Истина если удалось подвинуть фигуру.
     */
    public boolean move(Cell source, Cell distance) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException{

        if (source.itsClear(figures)) {
            throw new FigureNotFoundException(source);
        }

        int indFigure = source.getIndFigure(figures);
        Figure figure = figures[indFigure];

        Cell[] way = figure.way(distance, this);
        if (!wayClear(way)) {
            throw new OccupiedWayException(source, distance);
        }
        figures[indFigure] = figure.clone(distance);
        return true;
    }

    /**
     * Проверяет чистый или нет путь, исключая первую клетку.
     * @return Истина если чисто.
     */
    private boolean wayClear(Cell[] way) {

        for (int ind = 1; ind < way.length; ind ++) {
            if (!way[ind].itsClear(figures)) {
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

        Cell way = start.length(finish);

        if (start.equals(finish) || modul(way.x()) != modul(way.y())) {
            throw new ImposibleMoveException(start, finish);
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

        Cell way = start.length(finish);

        if (start.equals(finish) || (way.x() * way.y() != 0)) {
            throw new ImposibleMoveException(start, finish);
        }
        return start.way(way, cells);
    }

    /**
     * Возвращает массив ячеек.
     * @return массив ячеек.
     */
    public Cell[][] getCells() {
        return this.cells;
    }

    /**
     * Возвращает ячейку.
     * @param x - по горизонтали, начало с 1 слева.
     * @param y - по вертикале, начало 1 снизу.
     * @return ячееку.
     */
    public Cell getCell(int x, int y) {
        return this.cells[x - 1][size - y];
    }

    /**
     * Возвращает фигуры доски.
     * @return фигуры.
     */
    public Figure[] getFigures() {
        return this.figures;
    }

    /**
     * Устанавливает фигуру.
     * @param figures - фигуры для доски.
     */
    public void setFigures(Figure[] figures) {
        this.figures = figures;
    }

    /**
     * Возвращает модуль числа.
     * @param num число.
     * @return модуль.
     */
    public static int modul(int num) {
        return num > 0 ? num : -num;
    }

}
