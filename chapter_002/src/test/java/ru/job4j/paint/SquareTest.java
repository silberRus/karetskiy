package ru.job4j.paint;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Karetskiy
 * @version 1
 * @since 17.01.2017
 */

public class SquareTest {

    /**
     * Проверяем отображение квадрата
     */
    @Test
    public void pic() {

        String rn = System.getProperty("line.separator");
        final String expectId = "Квадрат: " + rn +
                "---" + rn +
                "| |" + rn +
                "---";
        Square square = new Square();
        String result = square.pic();

        assertThat(result, is(expectId));
    }
}