package ru.job4j.service;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test класса сервиса.
 * @author Karetskiy
 * @version 1
 * @since 28.02.2017
 */

public class MyIOServiceTest {

    /**
     * Проверим что в потоке есть четное число
     */
    @Test
    public void isNumberEven() throws Exception {

        MyIOService myIO = new MyIOService();

        final boolean expect = true;
        final boolean result = myIO.isNumber(new ByteArrayInputStream("есть четное число 144 в этом потоке".getBytes()));

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