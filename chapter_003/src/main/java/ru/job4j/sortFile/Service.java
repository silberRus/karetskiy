package ru.job4j.sortFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Class обработки потоков.
 * @author karetskiy
 * @since 10.03.2017
 * @version 4
 */
public class Service {

    /**
     * Перевод строки.
     */
    final private static String SEPORATOR = System.lineSeparator();

    /**
     * Длина перевода строки в байтах.
     */
    final private static int LEN_SEPORATOR = SEPORATOR.getBytes().length;

    /**
     * Получаем файл, сортируем его по длине строк по возрастанию, результат записываем в другой файл.
     * @param source входной файл.
     * @param distance выходной отсортированный файл.
     */
    public void sort(File source, File distance) throws IOException {

        List<Anchors> index = createIndex(source);

        try (RandomAccessFile fileS = new RandomAccessFile(distance,"rw")) {

            RandomAccessFile fileR = new RandomAccessFile(source, "r");
            fileS.setLength(fileR.length());

            for (Anchors anchors : index) {
                for (Long anchor : anchors.getAnchors()) {

                    fileR.seek(anchor);
                    fileS.writeBytes(String.format("%s%s", fileR.readLine(), SEPORATOR));
                }
            }
            fileS.close();
            fileR.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Создает индекс файла по длинам строк и возвращает индекс.
     * @return индекс блоков файла.
     */
    private List<Anchors> createIndex(File source) throws IOException {

        List<Anchors> anchors = new ArrayList();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {

            String tekStr   = bufferedReader.readLine();
            long tekPoz     = 1;

            while (tekStr != null) {

                int len = tekStr.getBytes().length + LEN_SEPORATOR;
                int ind = anchors.indexOf(len);

                if (ind == -1) {
                    ind = anchors.size();
                    anchors.add(new Anchors(len));
                }
                anchors.get(ind).add(tekPoz);
                tekPoz+=len;
                tekStr = bufferedReader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        anchors.sort(Anchors.COMPARE_BY_LENGHT);
        return anchors;
    }
}