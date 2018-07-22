package ru.job4j.Threads;

import javafx.scene.shape.Rectangle;

/**
 * Class пингпонг игра наверное.
 * Тред управляющий движением объекта.
 *
 * @author karetskiy взято с rujob4j
 * @version 1
 * @since 23.07.2018
 */
public class RectangleMove implements Runnable {

    /**
     * Скорость квадрата.
     */
    private double speed = 9;

    /**
     * Ограничение экрана по X.
     */
    private int limitX;

    /**
     * Ограничение экрана по Y.
     */
    private int limitY;

    /**
     * Квадрат.
     */
    private final Rectangle rect;

    /**
     * Конструктор треда движения.
     */
    public RectangleMove(Rectangle rect, int limitX, int limitY)
    {
        this.rect = rect;
        this.limitX = limitX;
        this.limitY = limitY;
    }

    /**
     * В случаи когда квадрат залетает за край экрана,
     * меняет расположение вектора на противоположный.
     * @param coord текущая координата объекта.
     * @param maxSize максимальная значение координаты объекта.
     * @return текущий вектор направления.
     */
    private int reverse(double coord, int maxSize) {

        return coord < 0 || coord > maxSize ? -1 : 1;
    }

    /**
     * Запуск нити управления движением кавадрата.
     * Бесконечный цикл треда.
     */
    @Override
    public void run() {

        double vectorX = 1;
        double vectorY = 1;

        while (true) {

            double x = this.rect.getX();
            double y = this.rect.getY();

            vectorX = vectorX * reverse(x, limitX);
            vectorY = vectorY * reverse(y, limitY);

            this.rect.setX(x + vectorX * speed);
            this.rect.setY(y + vectorY * speed);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}