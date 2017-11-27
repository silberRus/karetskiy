package ru.job4j.generalization;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test user.
 *
 * @author Karetskiy
 * @version 1
 * @since 24.11.2017
 */
public class UserTest {

    /**
     * Проверяем что id устанавливается.
     */
    @Test
    public void setId() throws Exception {

        User user = new User("Ваня", "Даосити");
        assertThat(user.toString(), is("Ваня (Даосити)"));
    }
}