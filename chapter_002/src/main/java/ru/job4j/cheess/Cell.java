package ru.job4j.cheess;

import java.util.PrimitiveIterator;

/**
 * Class шахматная клетка.
 * @author karetskiy
 * @since 01.02.2017
 * @version 1
 */
public class Cell {

    private Vector2 pos;

    public Cell(Vector2 pos) {
        this.pos = pos;
    }

    public Vector2 pos() {

        return this.pos;
    }

    /**
     * Проверяет что позиция ячеек одинаковая;
     * @param cell ячейка которую сравниваем.
     * @return истина если это одна и таже позиция.
     */
    public boolean equals(Cell cell) {
        return cell.pos().x == this.pos().x && this.pos.y == this.pos().y;
    }

    /**
     * Возвращает фигуру ячейки;
     * @return фигуру.
     */
    public Figure getFigure(Figure[] figures) {

        for (Figure figure: figures) {
            if (figure.position.equals(this)) {
                return figure;
            }
        }
        return null;
    }

    /**
     * Возвращает модуль числа.
     * @param num число.
     * @return модуль.
     */
    private int modul(int num) {
        return num > 0 ? num : -num;
    }

    /**
     * Возвращает массив ячеек по указаному пути от текущей ячейки.
     * @param way путь до конечной станции.
     * @param cells ячейки достки.
     * @return фигуру.
     */
    public Cell[] way(Vector2 way, Cell[][] cells) {

        int sizeX = modul(way.x);
        int sizeY = modul(way.y);
        int size = sizeX > sizeY ? sizeX : sizeY;

        Cell[] patch = new Cell[size];

        for (int ind = 0; ind < size; ind ++, way.GoToZero()) {
            patch[ind] = cells[this.pos.x + sizeX - way.x][this.pos.y + sizeY - way.y];
        }
        return patch;
    }

    /**
     * Внутренний класс вектора 2D.
     */
    static class Vector2 {

        /**
         * Координаты точки.
         */
        public int x, y;

        /**
         * Создает точку.
         */
        public Vector2(int x, int y) {

            this.x = x;
            this.y = y;
        }

        /**
         * Создает копию вектора на основании переданного в направлении дистанции.
         */
        public Vector2(Vector2 vector, Vector2 napravlenie) {

            this.x = vector.x;
            this.y = vector.y;
        }

        /**
         * Возвращает вектор размер между двумя точками в виде позиции.
         * @param pos позицию до которой нужно вычислить длину.
         * @return позции в которой x будет длина по x, y длина по y.
         */
        public Vector2 length(Vector2 pos) {
            return new Vector2(pos.x - this.x, pos.y - this.y);
        }

        /**
         * Уменьшает вектор стремясь к нулю
         */
        private void GoToZero() {

            this.x = this.x - this.x == 0 ? 0 : this.x > 0 ? 1 : -1;
            this.y = this.y - this.y == 0 ? 0 : this.y > 0 ? 1 : -1;
        }
    }
}
