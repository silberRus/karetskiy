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

    private void outListString(String[] list,  PrintWriter out) {

        StringBuilder sb = new StringBuilder();
        for (String line: list) {
            out.print(line);
        }
        out.println("");
    }

    @Override
    public void loop() throws IOException {


        java.net.Socket socket = new ServerSocket(this.property.port).accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String ask = null;
        boolean isExit = false;

        while (!isExit) {

            String command = in.readLine();
            System.out.println(command);

            if (this.property.STOP.equals(command)) {
                isExit = true;
                out.println(this.property.STOP);
            } else {

                if (command.startsWith("cd ")) {

                    String[] rStr = command.split(" ");
                    out.println(String.format("entring %s", rStr[1]));
                    if (rStr.length > 1) {
                        this.fileSystem.enter(rStr[1]);
                        outListString(this.fileSystem.scan(), out);
                    }

                } else if ("cd .".equals(command)) {

                    out.println("entring begin");
                    this.fileSystem.enterBegin();
                    outListString(this.fileSystem.scan(), out);

                } else if ("cd ..".equals(command)) {

                    out.println("entring parent");
                    this.fileSystem.enterReturn();
                    outListString(this.fileSystem.scan(), out);

                } else if ("dir".equals(command)) {

                    out.println("list curent dir");
                    String[] list = this.fileSystem.scan();
                    outListString(this.fileSystem.scan(), out);

                } else {

                    out.println("unknown command");
                }
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
