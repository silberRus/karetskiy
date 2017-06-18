package ru.job4j.fileManager.server;

import ru.job4j.fileManager.*;
import ru.job4j.fileManager.client.Client;

import java.io.*;
import java.net.ServerSocket;

/**
 * Created by silbe on 18.04.2017.
 */
public class Server implements Socket {

    private Property property;

    private FileSystem fileSystem;

    public Server(Property property, FileSystem fileSystem) {

        this.property = property;
        this.fileSystem = fileSystem;
    }

    @Override
    public void loop() throws IOException {


        java.net.Socket socket = new ServerSocket(this.property.port).accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String ask = null;
        boolean isExit = false;

        while (!isExit) {

            //out.print("wait command ...");
            String command = in.readLine();
            System.out.println(command);

            if ("".equals(command)) {
                isExit = true;
                out.println("");
            } else {

                //out.print("command: " + command);

                if (command.startsWith("cd ")) {
                    String[] rStr = command.split(" ");
                    if (rStr.length > 1) {
                        this.fileSystem.enter(rStr[1]);
                    }
                } else if ("cd .".equals(command)) {
                    this.fileSystem.enterBegin();
                } else if ("cd ..".equals(command)) {
                    this.fileSystem.enterReturn();
                }
            out.println(this.fileSystem.scan().toString());
            }
        }
    }

    /**
     * Вход консоля.
     * @param args параметры консоля.
     */
    public static void main(String[] args) throws IOException {

        File fs = new File("");
        System.out.println("Server in start");

        new Server(new Property(), new WindowsFileSystem(".")).loop();
    }
}
