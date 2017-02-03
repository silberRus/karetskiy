package ru.job4j.cheess;

/**
 * Class исключения, когда пытаются продвинуть фигуру, но на ее пути находятся другие фигуры.
 * @author karetskiy
 * @since 04.02.2017
 * @version 1
 */
public class OccupiedWayException extends Throwable {

    public OccupiedWayException(Cell start, Cell finish) {

        System.out.println(String.format("Не могу пройти путь, мешают другие фигуры [%s:%s] -> [%s:%s]",
                String.valueOf(start.x()),
                String.valueOf(start.y()),
                String.valueOf(finish.x()),
                String.valueOf(finish.y())));
    }

}
