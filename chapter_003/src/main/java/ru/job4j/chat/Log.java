package ru.job4j.chat;

import java.io.*;

/**
 * Class логирования в текстовый файл.
 * @author karetskiy
 * @since 02.04.2017
 * @version 1
 */
public class Log {

    /**
     * Файл куда выводим лог.
     */
    private File file;

    /**
     * При создании указываем путь к файлу.
     * @param patch путь к файлу.
     */
    public Log (String patch){

        this.file = new File(patch);
    }

    /**
     * Выводит лог в файл.
     * @param line текст лога.
     */
    public void save(String line) throws IOException {

        try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))){
            out.write(String.format("%s: %s%s", System.currentTimeMillis(), line, System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
