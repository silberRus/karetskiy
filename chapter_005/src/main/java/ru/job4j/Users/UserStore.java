package ru.job4j.Users;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Class хранилище пользователей.
 *
 * @author karetskiy
 * @version 1
 * @since 20.09.2018
 */
@ThreadSafe
public class UserStore {

    /**
     * Монитор блока.
     */
    private final Object lock = new Object();

    /**
     * Коллекция пользователей.
     */
    @GuardedBy("lock")
    private final ConcurrentMap<Integer, User> users = new ConcurrentHashMap<>();

    /**
     * Добавляет пользователя а коллекцию.
     * @param user добавляеммый пользоваетель.
     */
    public void add(User user) {
        synchronized (lock) {
            users.putIfAbsent(user.getId(), user);
        }
    }

    /**
     * Ищет пользователя с таким же id как у передоваемого пользователя
     * и заменяет пользователя, новый пользователем.
     * @param user ползователь на которого заменяем.
     */
    public void update(User user) {
        synchronized (lock) {
            users.putIfAbsent(user.getId(), user);
        }
    }

    /**
     * @param user удаляем пользователя из хранилища.
     */
    public void delete(User user) {
        synchronized (lock) {
            users.remove(user.getId());
        }
    }

    /**
     * Перводит деньги на счете от одного пользователя другому.
     * @param id1 идентификтаор пользователя от которого переводят деньги.
     * @param id2 идентификтаор пользователя к которому переводят деньги.
     * @param amount сумма переводимых денег.
     */
    public void transfer(int id1, int id2, int amount) {

        synchronized (lock) {

            User us1 = users.get(id1);
            User us2 = users.get(id2);

            us1.changeAmount(-amount);
            us2.changeAmount(amount);
        }
    }
}
