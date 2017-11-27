package ru.job4j.generalization;

import java.util.HashMap;
import java.util.List;

/**
 * Class конвертации пользователей.
 * @author karetskiy
 * @since 24.11.2017
 * @version 1
 */
public class UserConvert {

    /**
     * преобразует список в хэшмап и устанавливает каждому пользователю новый id.
     * @param list - коллекция пользователей.
     * @return сконвертированный хэшмап пользователей.
     */
    public HashMap<Integer, User> process(List<User> list)
    {
        HashMap<Integer, User> map = new HashMap<>();
        list.forEach(user -> map.put(user.getId(), user));
        return map;
    }
}