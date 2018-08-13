package ru.job4j.Threads;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Class пингпонг игра наверное.
 *
 * @author karetskiy взято с rujob4j
 * @version 1
 * @since 23.07.2018
 */
public class PingPong extends Application {

    /**
     * Представление приложения.
     */
    private static final String JOB4J = "Пинг-понг www.job4j.ru";

    /**
     * Стартова точка запуска приложения.
     */
    @Override
    public void start(Stage stage) throws InterruptedException {
        int limitX = 300;
        int limitY = 300;
        Group group = new Group();
        Rectangle rect = new Rectangle(50, 100, 10, 10);
        group.getChildren().add(rect);
        Thread thread = new Thread(new RectangleMove(rect, limitX, limitY));
        thread.start();
        stage.setScene(new Scene(group, limitX, limitY));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
        stage.setOnCloseRequest(event -> thread.interrupt());
    }
}