
package ru.job4j.fileManager.client;

import ru.job4j.fileManager.Property;
import ru.job4j.fileManager.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by silbe on 05.06.2017.
 */
public class Client implements Socket {

    /**
     * Цикл отправлений в сокет пока не будет закрыт.
     */
    @Override
    public void loop() throws IOException {

        Property property = new Property();
        java.net.Socket socket = new java.net.Socket(property.server, property.port);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str;
        do {
            out.println(System.in.read());
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

        new Client().loop();
    }
}
