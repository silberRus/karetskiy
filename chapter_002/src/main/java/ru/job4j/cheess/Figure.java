package ru.job4j.cheess;

/**
 * Class описание фигуры.
 * @author karetskiy
 * @since 01.02.2017
 * @version 1
 */
public abstract class Figure {

    /**
     * Позиция ячейки на доске.
     */
    final Cell position;

    /**
     * При создании сразу ставим фигуру на место.
     */
    protected Figure(Cell position) {
        this.position = position;
    }

    /**
     * Копирует копию фигуры в звдвнной ячейке.
     * @param position - ячейка докоторой нужно дойти.
     * @return новую фигуру.
     */
    abstract Figure clone(Cell position);

    /**
     * Проходим путь до цели.
     * @param dist - ячейка докоторой нужно дойти.
     * @return массив ячеек которые прошла фигура.
     */
    abstract Cell[] way(Cell dist, Board board) throws ImposibleMoveException;
}
