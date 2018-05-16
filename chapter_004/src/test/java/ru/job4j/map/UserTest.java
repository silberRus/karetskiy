package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void dontCoverEqualsAndHexCode() {

        Calendar birthday = Calendar.getInstance();
        User user1 = new User("man", 2, birthday);
        User user2 = new User("man", 2, birthday);

        Map<User, String> map = new HashMap<>();
        map.put(user1, "man");
        map.put(user2, "man");

        System.out.println(map);
    }
}