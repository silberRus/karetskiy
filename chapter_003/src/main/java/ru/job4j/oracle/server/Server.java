package ru.job4j.oracle.server;

import ru.job4j.chat.RoboKot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Класс сервера чата.
 * @author karetskiy
 * @since 17.04.2017
 * @version 1
 */
public class Server {

    /**
     * Порт на котором слушает сокет.
     */
    private final int PORT = 5005;

    /**
     * Фраза которую нужно произнести серверу чтобы он прекратил работу.
     */
    private final String EXIT = "пока";

    /**
     * Петля внутри которой сервер ожидает вопросов в сокет.
     * @param roboKot робот который будет отвечать на вопросы.
     */
    public void loop(RoboKot roboKot) throws IOException {

        Socket socket =  new ServerSocket(PORT).accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String ask = null;
        boolean isExit = false;

        while (!isExit){

            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);

            if ("hello".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            }
            isExit = EXIT.equals(ask);

            if (isExit) {
                System.out.println("im stop ...");
                out.close();
            } else {
                out.println(roboKot.readRandWord());
                out.println("");
            }
        }
    }

    /**
     * Вход консоля.
     * @param args параметры консоля.
     */
    public static void main(String[] args) throws IOException {

        Server server = new Server();
        RoboKot roboKot = new RoboKot("E:\\java\\projects\\karetskiy\\chapter_003\\src\\test\\java\\ru\\job4j\\chat\\misha.txt");

        server.loop(roboKot);
    }
}