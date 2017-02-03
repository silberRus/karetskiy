package ru.job4j.cheess;

/**
 * Class фигуры Слона.
 * @author karetskiy
 * @since 04.02.2017
 * @version 2
 */
public class Bishop extends Figure{

    /**
     * При создании сразу ставим фигуру на место.
     * @param position позиция
     * @param team команда
     */
    protected Bishop(Cell position, char team) {
        super(position, team);
    }

    /**
     * Проверим перемещение слона по заданному пути.
     * @param dist - путь куда надо переместить слона.
     * @param board - шахматная доска.
     * @return массив ячеек которые пройдет слон.
     */
    public Cell[] way(Cell dist, Board board) throws ImposibleMoveException {
        return board.pathDiagonal(this.position, dist);
    }

    /**
     * Копирует копию фигуры в ячейке.
     * @param position - ячейка куда копируем.
     * @return нового слона.
     */
    public Figure clone(Cell position) {
        return new Bishop(position, team);
    }
}
