package ru.job4j.sortFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class обработки потоков.
 * @author karetskiy
 * @since 13.03.2017
 * @version 5
 */
public class Service {

    /**
     * Получаем файл, сортируем его по длине строк по возрастанию, результат записываем в другой файл.
     * @param source входной файл.
     * @param distance выходной отсортированный файл.
     */
    public void sort(File source, File distance) throws IOException {

        String seporator = System.lineSeparator();
        int lenSeporator = seporator.getBytes().length;

        Index index = new Index(source);

        try (RandomAccessFile fileS = new RandomAccessFile(distance,"rw")) {
        //try (BufferedOutputStream fileS = new BufferedOutputStream(new FileInputStream(source))) {

            RandomAccessFile fileR = new RandomAccessFile(source, "r");
            //BufferedInputStream fileR = new BufferedInputStream(new FileInputStream(source));

            String str = fileR.readLine();
            while (str != null) {

                Marker marker = index.getMarker(str.length());
                long begin = marker.getBegin();

                fileS.seek(begin);
                fileS.writeBytes(String.format("%s%s", str, seporator));
                marker.setBegin(begin+=str.length() + lenSeporator);

                str = fileR.readLine();
            }
            fileS.close();
            fileR.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}