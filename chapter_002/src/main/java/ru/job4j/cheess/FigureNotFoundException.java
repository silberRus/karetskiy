package ru.job4j.cheess;

/**
 * Class исключения, когда на клетке нет, а мы пытаемся ее схватить.
 * @author karetskiy
 * @since 04.02.2017
 * @version 1
 */
public class FigureNotFoundException extends Throwable {

    public FigureNotFoundException(Cell pos) {

        System.out.println(String.format("На клетке [%s:%s] нет фигуры.",
                String.valueOf(pos.x()),
                String.valueOf(pos.y())));
    }
}
