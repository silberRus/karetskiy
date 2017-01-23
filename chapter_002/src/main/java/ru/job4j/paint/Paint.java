package ru.job4j.paint;

/**
 * Class псевдографики.
 * @author karetskiy
 * @since 23.01.2017
 * @version 1
 */
public class Paint {

    /**
     * Выводить фигуру в псевдографике на консоль.
     * @param shape фигура:
     */
    public void draw(Shape shape) {

        System.out.println(shape.pic());
    }

    /**
     * Выводит треугольник потом квадрат в псевдографике.
     * @param args ключи в консоле:
     */
    public static void main(String[] args) {

        Paint paint = new Paint();

        paint.draw(new Triangle());
        paint.draw(new Square());
    }
}
