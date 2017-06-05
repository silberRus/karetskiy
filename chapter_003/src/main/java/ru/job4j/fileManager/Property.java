package ru.job4j.fileManager;

/**
 * Created by silbe on 18.04.2017.
 */
public class Property {

    public int port = 5005;
    public String server = "127.0.0.1";


    public Property(){
    }

    public Property(int port){
        this.port = port;
    }

    public Property(int port, String server){
        this.server = server;
        this.port = port;
    }
}
