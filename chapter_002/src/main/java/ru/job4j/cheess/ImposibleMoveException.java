package ru.job4j.cheess;

/**
 * Class исключения, когда мы задаем путь для прохождения, но такой путь не возмоен в шахматах.
 * @author karetskiy
 * @since 04.02.2017
 * @version 1
 */
public class ImposibleMoveException extends Throwable {

    public ImposibleMoveException(Cell start, Cell finish) {

        System.out.println(String.format("Не могу построить путь [%s:%s] -> [%s:%s]",
                String.valueOf(start.x()),
                String.valueOf(start.y()),
                String.valueOf(finish.x()),
                String.valueOf(finish.y())));
    }
}