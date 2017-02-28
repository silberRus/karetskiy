package ru.job4j.service;

import java.io.*;

/**
 * Class обработки потоков.
 * @author karetskiy
 * @since 29.02.2017
 * @version 2
 */
public class MyIOService {

    /**
     * Код символа ACII - 0 (ноль) с него начинаются цифры.
     */
    private static int codeBegin = 48;
    /**
     * Код символа ACII - 9 (девять) на ней заканчиваются цифры.
     */
    private static int codeEnd = 57;

    /**
     * Убирает из входного потока запрещенные слова и помещает в выходной поток.
     * @param in входящий символьный поток:
     * @param out выходящий символьный поток:
     * @param abuse запрещенные слова которые нужно вырезать.
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {

        final byte[] seporator = System.lineSeparator().getBytes();
        boolean seporatorOn = false;
        String tekStr = "";

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {

            while (tekStr != null) {

                tekStr = bufferedReader.readLine();

                if (tekStr != null) {

                    if (seporatorOn) {
                        out.write(seporator);
                    } else {
                        seporatorOn = true;
                    }

                    if (tekStr != null) {

                        for (String str : abuse) {
                            tekStr = tekStr.replaceAll(str, "");
                        }
                        out.write(tekStr.getBytes());
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Проверяет что в потоке есть четное число.
     * @param in байтовый поток:
     * @return Истина если есть четное число
     */
    public boolean isNumber(InputStream in) throws IOException {

        boolean isEven      = false;
        int codeSymb        = 0;
        long nextNum        = 0;

        try (BufferedReader bs = new BufferedReader(new InputStreamReader(in))) {

            while (codeSymb != -1) {
                codeSymb = (int) bs.read();
                if (codeSymb >= codeBegin && codeSymb <= codeEnd) {
                    nextNum *= 10;
                    nextNum += codeSymb - codeBegin;
                } else {
                    if (nextNum != 0 && nextNum % 2 == 0) {
                        isEven = true;
                        break;
                    } else {
                        nextNum = 0;
                    }
                }
            }
            isEven = nextNum != 0 && nextNum % 2 == 0;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return isEven;
    }
}