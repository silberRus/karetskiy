package ru.job4j.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class индекса.
 * В индексе мы храним 2D массив, в котором индекс массива является размером строки,
 * а в значении массив якорей (позиций в файле) где начинаются блоки.
 * @author karetskiy
 * @since 03.03.2017
 * @version 1
 */
public class IndexLineSize {

    /**
     * Содежржит индексы по размеру строки (x) и якорей (y) для считывания блоков
     */
    private long[][] anchors;

    /**
     * Минимальная порция увиличения массива.
     */
    final static private int CAPSIZE = 1000;

    /**
     * Создает индекс файла по длинам строк и возвращает индекс.
     * @return индекс блоков файла.
     */
    public long[][] createIndex(File source) throws IOException {

        final int seporatorLen = System.lineSeparator().getBytes().length;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {

            String tekStr   = bufferedReader.readLine();
            long anchor     = 1;

            while (tekStr != null) {

                int len = tekStr.getBytes().length + seporatorLen;

                memberAnchor(tekStr.length(), anchor, len);
                anchor+=len;
                tekStr = bufferedReader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return this.anchors;
    }

    /**
     * Добавляет новый якорь в текущий индекс.
     * Если индекса недостаочно тогда увеличивает его.
     * @param index длина строки.
     * @param anchor якорь в файле (начало блока).
     * @param length длина блока.
     */
    private void memberAnchor(int index, long anchor, int length) {

        if (index > getSize()) {
            increase(index);
        }
        addAnchor(index, anchor);
    }

    /**
     * Добавляет якорь в массив.
     * Если размера массива не достаточно тогда увеличиваем его на x2.
     * @param index текущий индекс строки (длина строки) куда добавляем.
     * @param anchor якорь в файле где начинается блок.
     */
    private void addAnchor(int index, long anchor) {

        long[] anchors;

        if (this.anchors[index] == null) {
            anchors = new long[1];
            anchors[0] = anchor;
        } else {

            anchors = new long[this.anchors[index].length * 2];
            System.arraycopy(this.anchors[index],0, anchors, 0, this.anchors[index].length);

            for (int ind = 0; ind < anchors.length; ind++) {
                if (anchors[ind] == 0) {
                    anchors[ind] = anchor;
                    break;
                }
            }
        }
        this.anchors[index] = anchors;
    }

    /**
     * Увеличивает массив.
     * Если число увеличения меньше чанка тогда увеличиваем на 1 чанк.
     * @param length новая длина массива.
     */
    private void increase(int length) {

        int tekLen = getSize();
        long[][] newArray = new long[length - tekLen < CAPSIZE ? tekLen + CAPSIZE : length][];

        for (int ind = 0; ind < length; ind++) {
            if (newArray[ind] != null) {
                newArray[ind] = this.anchors[ind];
            }
        }
        this.anchors = newArray;
    }

    /**
     * Возввращает текущюю длину массива.
     * @return текущая длина;
     */
    private int getSize() {
        return this.anchors == null ? 0 : this.anchors.length;
    }
}