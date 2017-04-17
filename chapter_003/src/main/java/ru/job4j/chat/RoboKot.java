package ru.job4j.chat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * Class чата.
 * @author karetskiy
 * @since 02.04.2017
 * @version 1
 */

public class RoboKot {

    /**
     * фраза при которой чат перестает отвечать.
     */
    private final String CONTINUE = "продолжить";
    /**
     * фраза при которой чат продолжает отвечать.
     */
    private final String STOP = "стоп";
    /**
     * фраза при которой происходит выход.
     */
    private final String EXIT = "закончить";

    /**
     * режм при котором чат отвечает.
     */
    private boolean askMode = true;
    /**
     * Курсор в файле ответа.
     */
    private long position = 1;
    /**
     * файл ответов чата.
     */
    private File words = null;

    /**
     * класс логирования диалога.
     */
    private Log log = new Log("log.txt");

    /**
     * генератор случайных чисел для управления курсором.
     */
    private static final Random RN = new Random();

    /**
     * При созании указываем файл с которого будем считывать ответы.
     * @param pathFile путь к файлу ответов
     */
    public RoboKot(String pathFile) {
        words = new File(pathFile);
    }

    /**
     * Основной цикл чата. Завершается когда произносится фраза выхода.
     * @param api интерфейс взаимодействия с чатом.
     */
    public void play(Api api) throws IOException {

        String ask = api.input().toLowerCase();
        while (!this.EXIT.equals(ask)) {

            this.log.save(String.format("user: %s", ask));

            if (this.STOP.equals(ask)) {
                this.askMode = false;
                this.log.save("roboKot: <больше не разговаривает>");
            } else if (this.CONTINUE.equals(ask)) {
                this.askMode = true;
                this.log.save("roboKot: <продолжает разговор>");
            } else {
                String answer = readRandWord();
                this.log.save(String.format("roboKot: %s", answer));
                api.out(answer);
            }
            ask = api.input().toLowerCase();
        }
        this.log.save("roboKot: <закончил разговор>");
    }

    /**
     * Считывает ответ из файла ответов.
     * @return фраза ответ из файла.
     */
    public String readRandWord() throws FileNotFoundException {

        String word = "";

        try(RandomAccessFile fileR = new RandomAccessFile(this.words, "r")) {

            fileR.seek(this.position);
            String line = new String(fileR.readLine().getBytes("ISO-8859-1"));
            String[] words = line.split("\\p{P}?[ \\t\\n\\r]+");
            word = words[RN.nextInt(words.length - 1)];

        } catch (IOException e) {
            e.printStackTrace();
        }
        return word;
    }
}
