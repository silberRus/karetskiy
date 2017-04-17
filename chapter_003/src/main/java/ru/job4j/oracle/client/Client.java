package ru.job4j.oracle.client;

import ru.job4j.chat.Api;
import ru.job4j.chat.ConsoleApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Класс клиента чата
 * @author karetskiy
 * @since 17.04.2017
 * @version 1
 */
public class Client {

    /**
     * Порт сокета.
     */
    private final int PORT = 5005;

    /**
     * Адрес сокета.
     */
    private final String IP = "127.0.0.1";

    /**
     * Петля внутри которой система ожидает вопросов из интрфейса.
     * @param api интрфейс ввода.
     */
    public void loop(Api api) throws IOException {

        Socket socket = new Socket(InetAddress.getByName(IP), PORT);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str;
        do {
            out.println(api.input());
            while (!(str = in.readLine()).isEmpty()) {
                System.out.println(str);
            }
        } while (!socket.isClosed());
    }

    /**
     * Вход консоля.
     * @param args параметры консоля.
     */
    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.loop(new ConsoleApi());
    }
}
