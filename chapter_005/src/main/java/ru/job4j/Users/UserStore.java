package ru.job4j.Users;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * Class хранилище пользователей.
 *
 * @author karetskiy
 * @version 1
 * @since 29.08.2018
 */
@ThreadSafe
public class UserStore {

    /**
     * Коллекция пользователей.
     */
    @GuardedBy("this")
    private Map<Integer, User> users = new HashMap();

    /**
     * Добавляет пользователя а коллекцию.
     * @param user добавляеммый пользоваетель.
     * @return true если пользователь был добавлен в коллекцию.
     */
    public boolean add(User user) {

        int id = user.getId();
        boolean isPresent = users.containsKey(id);

        if (!isPresent) {
            users.put(id, user);
        }
        return !isPresent;
    }

    /**
     * Ищет пользователя с таким же id как у передоваемого пользователя
     * и заменяет пользователя, новый пользователем.
     * @param user ползователь на которого заменяем.
     * @return true если пользователь был заменен.
     */
    public boolean update(User user) {
        int id = user.getId();
        return users.replace(id, users.get(id), user);
    }

    /**
     *
     * @param user удаляем пользователя из хранилища.
     * @return true если пользователь был удвлен.
     */
    public boolean delete(User user) {
        return users.remove(user.getId(), user);
    }

    /**
     * Перводит деньги на счете от одного пользователя другому.
     * @param id1 идентификтаор пользователя от которого переводят деньги.
     * @param id2 идентификтаор пользователя к которому переводят деньги.
     * @param amount сумма переводимых денег.
     */
    public synchronized void transfer(int id1, int id2, int amount) {
        users.get(id1).changeAmount(-amount);
        users.get(id2).changeAmount(amount);
    }
}
