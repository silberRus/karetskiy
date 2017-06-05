package ru.job4j.fileManager;

import java.util.ArrayList;

/**
 * Created by silbe on 18.04.2017.
 */
public interface FileSystem {

    String entry = "";

    String patch = "";

    String[] scan();

    public boolean enter(String patch);

    public void enterBegin();

    public void enterReturn();

}
