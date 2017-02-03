package ru.job4j.cheess;

import java.util.PrimitiveIterator;

/**
 * Class шахматная клетка.
 * @author karetskiy
 * @since 04.02.2017
 * @version 2
 */
public class Cell {

    private int x, y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает x по горизонтали.
     * @return позицию по горизонтали.
     */
    public int x() {
        return this.x;
    }

    /**
     * Возвращает y по вертикали.
     * @return позицию по вертикали.
     */
    public int y() {
        return this.y;
    }

    /**
     * Проверяет что позиция ячеек одинаковая;
     * @param cell ячейка которую сравниваем.
     * @return истина если это одна и таже позиция.
     */
    public boolean equals(Cell cell) {
        return cell.x() == this.x && cell.y() == this.y;
    }

    /**
     * Возвращает фигуру ячейки;
     * @return фигуру.
     */
    public int getIndFigure(Figure[] figures) {

        int ind = -1;

        for (ind = 0; ind < figures.length; ind++) {
            if (figures[ind].position.equals(this)) {
                break;
            }
        }
        return ind;
    }

    /**
     * Проверяет чистая ячейка или на ней ктото стоит.
     * @param figures фигуры которые проверяются.
     * @return true если чистая.
     */
    public boolean itsClear(Figure[] figures) {
        int ind = getIndFigure(figures);
        return ind < 0 || ind >= figures.length;
    }

    /**
     * Возвращает вектор размер между двумя точками в виде позиции.
     * @param pos позицию до которой нужно вычислить длину.
     * @return позции в которой x будет длина по x, y длина по y.
     */
    public Cell length(Cell pos) {
        //return new Cell(lenght(pos.x(), this.x), lenght(pos.y(), this.y));
        return new Cell(pos.x() - this.x, pos.y() - this.y);
    }

    /**
     * Возвращает массив ячеек по указаному пути от текущей ячейки.
     * @param way путь расстояние до конечной станции в виде клетки (вектора).
     * @param cells ячейки достки.
     * @return фигуру.
     */
    public Cell[] way(Cell way, Cell[][] cells) {

        int sizeX = way.x();
        int sizeY = way.y();

        int size = Board.modul(sizeX) > Board.modul(sizeY) ? Board.modul(sizeX) : Board.modul(sizeY);

        Cell[] patch = new Cell[size + 1];

        for (int ind = 0; ind <= size; ind ++) {
            patch[ind] = cells[this.x + sizeX - way.x() - 1][this.y + sizeY - way.y() - 1];
            way.GoToZero();
        }
        return patch;
    }

    /**
     * Вычисляет длину расстояния между 1D точками, сколько нужно пройти клеток чтобы достигнуть цель.
     * @param num1 позиция начала.
     * @param num2 позиция финиша.
     * @return количество клеток сколько нужно пройти.
     */
    private int lenght(int num1, int num2) {

        if (num2 > num1) {
            return num1 - num2 - 1;
        } else if (num1 > num2) {
            return num1 - num2 + 1;
        } else {
            return 0;
        }
    }

    /**
    * Уменьшает вектор стремясь к нулю
    */
    private void GoToZero() {

        this.x = this.x - (this.x == 0 ? 0 : this.x > 0 ? 1 : -1);
        this.y = this.y - (this.y == 0 ? 0 : this.y > 0 ? 1 : -1);
    }
}
