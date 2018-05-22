package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Class теста.
 * @author karetskiy
 * @since 22.05.2018
 * @version 2
 */
public class UserTest {

    /**
     * Проверяем пользователя.
     */
    @Test
    public void dontCoverEqualsAndHexCode() {

        Calendar birthday = Calendar.getInstance();
        User user1 = new User("man", 2, birthday);
        User user2 = new User("man", 2, birthday);

        Map<User, String> map = new HashMap<>();
        map.put(user1, "man");
        map.put(user2, "man");

        System.out.println(user1.equals(user2));
        System.out.println(map);
    }
}