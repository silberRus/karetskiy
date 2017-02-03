package ru.job4j.cheess;

/**
 * Class описание фигуры.
 * @author karetskiy
 * @since 04.02.2017
 * @version 2
 */
public abstract class Figure {

    /**
     * Позиция ячейки на доске.
     */
    final Cell position;

    /**
     * Команда, белая W или черная B.
     */
    final char team;

    /**
     * При создании сразу ставим фигуру на место и назначаем команду.
     */
    protected Figure(Cell position, char team) {

        this.position = position;
        this.team = team;
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
