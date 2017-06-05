package ru.job4j.fileManager;

import java.io.File;

/**
 * Created by silbe on 07.05.2017.
 */
public class WindowsFileSystem implements FileSystem {

    String entry = "";

    String patch = "";


    public WindowsFileSystem() {
    }

    public WindowsFileSystem(String entry) {
        this.entry = entry;
        this.patch = entry;
    }

    public String[] scan() {

        File file = new File(this.patch);
        return file.list();
    }

    public boolean enter(String patch) {

        File dir = new File(this.patch + File.separator + patch);

        if (dir.exists() && dir.isDirectory()) {
            this.patch = dir.getPath();
            return true;
        } else {
            return false;
        }
    }

    public void enterBegin() {

        this.patch = this.entry;
    }

    public void enterReturn() {

        if (!this.entry.equals(this.patch)) {

            File dir = new File(this.patch);
            String nameDir = dir.getName();

            this.patch = this.patch.substring(0, this.patch.length() - nameDir.concat(File.separator).length());
        }
    }
}