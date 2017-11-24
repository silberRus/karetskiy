package ru.job4j.generalization;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test convert user.
 *
 * @author Karetskiy
 * @version 1
 * @since 24.11.2017
 */
public class UserConvertTest {


    /**
     * проверим как список полользователей сконвертируется в хэшмап.
     */
    @Test
    public void process() throws Exception
    {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Ваня", "Доваосити"));
        list.add(new User("Игорь", "Муйне"));
        list.add(new User("Вика", "Пуорто"));

        UserConvert convert = new UserConvert();
        HashMap<Integer, User> map = convert.process(list);

        assertThat(map.toString(), is("{0=#0 Ваня (Доваосити), 1=#1 Игорь (Муйне), 2=#2 Вика (Пуорто)}"));
    }
}