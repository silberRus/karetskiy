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

public class TriangleTest {

    /**
     * Проверяем отображение треугольника
     */
    @Test
    public void pic() {

        String rn = System.getProperty("line.separator");
        final String expect = "Это треугольник:" + rn +
                "  ^" + rn +
                " / \\" + rn +
                "/___\\ ";

        Triangle triangle = new Triangle();
        String result = triangle.pic();

        assertThat(result, is(expect));
    }
}