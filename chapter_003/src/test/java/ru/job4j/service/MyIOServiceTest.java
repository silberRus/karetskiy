package ru.job4j.service;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test класса сервиса.
 * @author Karetskiy
 * @version 3
 * @since 03.03.2017
 */

public class MyIOServiceTest {

    /**
    * Проверим вырание запрещенных слов в потоке.
    * Пошлем поток и запрещенные слова, проверим чтою в выходном потоке не было запрещенных слов.
    */
    @Test
    public void testCenzura() throws Exception {

        MyIOService myIO = new MyIOService();

        String[] abuse  = new String[]{"текст","остаться","некоторых"};

        String fraza    =   "этот текст должен остаться без некоторых слов" + System.lineSeparator() +
                            "и этот нижний текст тоже";

        String expect   =   "этот  должен  без  слов" + System.lineSeparator() +
                            "и этот нижний  тоже";

        ByteArrayInputStream in     = new ByteArrayInputStream(fraza.getBytes());
        ByteArrayOutputStream out   = new ByteArrayOutputStream();

        myIO.dropAbuses(in, out, abuse);
        String result = out.toString();

        assertThat(result, is(expect));
    }

    /**
    * Проверим что в потоке есть четное число
    */
    @Test
    public void isNumberEven() throws Exception {

        MyIOService myIO = new MyIOService();

        final boolean expect = true;
        final boolean result = myIO.isNumber(new ByteArrayInputStream("есть 3 и четное число в этом потоке 144".getBytes()));

        assertThat(result, is(expect));
    }

    /**
     * Проверим что в потоке нет четного числа
     */
    @Test
    public void isNumberNotEven() throws Exception {

        MyIOService myIO = new MyIOService();

        final boolean expect = false;
        final boolean result = myIO.isNumber(new ByteArrayInputStream("а это не четное число 23 в этом потоке".getBytes()));

        assertThat(result, is(expect));
    }
}