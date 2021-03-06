package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Karetskiy
 * @version 1
 * @since 16.01.2017
 */
public class ItemTest {

    /**
     * Устанавливаем id заявке.
     * правильный ответ: "id 1"
     */
    @Test
    public void setID()  {

        final String expectId = "id 1";

        Item item = new Item("название", "описание");
        item.setID(expectId);
        String resultId = item.getID();

        assertThat(resultId, is(expectId));
    }
}