package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test User.
 *
 * @author Karetskiy
 * @version 1
 * @since 06.12.2017
 */
public class UserTest {

    /**
     * Проверяем представление пользователя.
     */
    @Test
    public void testToString() throws Exception {

        User user = new User("Ivan", "102324");
        assertThat(user.toString(), is("Ivan #102324"));
    }
}