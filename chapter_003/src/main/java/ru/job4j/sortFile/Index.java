package ru.job4j.sortFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class для сортировки больших файлов текстовых по возрастанию длины строк.
 * @author karetskiy
 * @since 13.03.2017
 * @version 5
 */
public class Index {

    final int SIZE_SEPORATOR = System.lineSeparator().length();

    /**
     * Хранилище маркеров в файле.
     */
    private List<Marker> list = new ArrayList<>();

    /**
     * При инициализации создает индекс файла по длинам строк.
     * После считывания, сортируем элементы списка по длине строки,
     * а затем заполняем размеры блоков.
     * @return индекс блоков файла.
     */
    public Index(File source) throws IOException {

        final int byteSeporator = System.lineSeparator().getBytes()[0];

        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(source))) {

            int lineSize = getLineSizeInStream(stream, byteSeporator);
            while (lineSize != 0) {

                stream.skip(SIZE_SEPORATOR - 1);
                add(new Marker(lineSize, lineSize));
                lineSize = getLineSizeInStream(stream, byteSeporator);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        this.list.sort(Marker.COMPARE_BY_LENGHT);

        long begin = 0;
        for (Marker marker: this.list) {
            marker.setBegin(begin);
            begin+=(marker.getLenght() + SIZE_SEPORATOR);
        }
    }

    static private int getLineSizeInStream(InputStream stream, int codeEnd) throws IOException {

        int size = 0;
        int symbol = stream.read();

        while (symbol != -1) {

            if (codeEnd == symbol) {
                break;
            } else {
                size++;
            }
            symbol = stream.read();
        }
        return size;
    }

    /**
     * добавляет маркер в список. Если такой марке есть тогда увеличивает его размер. 
     * @param marker якорь (блок в файле).
     */
    private void add(Marker marker) {
        
        int ind = findListIndex(marker.getSizeLine());
        if (ind == -1) {
            this.list.add(marker);
        } else {
            this.list.get(ind).addLenght(marker.getLenght() + SIZE_SEPORATOR);
        }
    }

    public Marker getMarker(int index) {
        return this.list.get(findListIndex(index));
    }

    /**
     * Ищет маркер по длине строки,
     * не умею еще искать в списке, поэтому тупо перебираю.
     * @param sizeLine длина строки с которой ищется маркер.
     * @return индекс маркера в списке.
     */
    private int findListIndex(int sizeLine) {

        for (int ind = 0; ind < this.list.size(); ind++) {
            if (this.list.get(ind).getSizeLine() == sizeLine) {
                return ind;
            }
        }
        return -1;
    }
}
