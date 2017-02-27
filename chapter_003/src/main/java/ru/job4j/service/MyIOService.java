package ru.job4j.service;

import java.io.*;

/**
 * Class обработки потоков.
 * @author karetskiy
 * @since 28.02.2017
 * @version 1
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
     * Проверяет что в потоке есть четное число.
     * @param in байтовый поток:
     * @return Истина если есть четное число
     */
    boolean isNumber(InputStream in) throws IOException {

        String strNum = "";
        int codeSymb = 0;
        BufferedReader bs = new BufferedReader(new InputStreamReader(in));

        while (codeSymb != -1) {

            codeSymb = (int) bs.read();

            if (codeSymb >= codeBegin && codeSymb <= codeEnd) {
                strNum += (char) codeSymb;
            } else if (!"".equals(strNum)) {
                if (numIsEven(strNum)) {
                    return true;
                } else {
                    strNum = "";
                }
            }
        }
        return numIsEven(strNum);
    }

    /**
     * Проверяет что переданое число четное.
     * @param strNumber стринг проверяемого числа:
     * @return Истина если четное число.
     */
    private boolean numIsEven(String strNumber) {

        if ("".equals(strNumber)) {
            return false;
        } else {
            int number = Integer.valueOf(strNumber);
            return number == number / 2 * 2;
        }
    }
}