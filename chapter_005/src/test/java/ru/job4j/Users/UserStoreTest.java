package ru.job4j.Users;

import org.junit.Test;
import ru.job4j.Threads.Count;
import ru.job4j.Threads.CountTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class теста.
 * @author karetskiy
 * @since 30.08.2018
 * @version 1
 */
public class UserStoreTest {

    /**
     * Класс описывает нить для перевода денег между пользователями.
     */
    private class ThreadUserStore extends Thread {

        /**
         * Хранилище пользователей.
         */
        private final UserStore userStore;

        /**
         * сумма для перевода
         */
        private final int amount;

        /**
         * id пользователя от которого переводим.
         */
        private final int id1;

        /**
         * id пользователя r котороve переводим.
         */
        private final int id2;

        /**
         * Класс инициализации нити
         * @param userStore Храниище польователей.
         * @param id1 идентификатор первого пользователя.
         * @param id2 идентификатор второго пользователя.
         * @param amount сумма переводимых денег.
         */
        private ThreadUserStore(final UserStore userStore, int id1, int id2, int amount) {
            this.userStore = userStore;
            this.amount = amount;
            this.id1 = id1;
            this.id2 = id2;
        }

        /**
         * Запускает перевод денег.
         */
        @Override
        public void run() {
            userStore.transfer(id1, id2, amount);
        }
    }

    /**
     * Проверим перевод денег сразу двум нитями.
     */
    @Test
    public void transfer() throws InterruptedException {

        UserStore store = new UserStore();

        User user1 = new User(1, 100);
        User user2 = new User(2, 200);

        store.add(user1);
        store.add(user2);

        Thread first = new ThreadUserStore(store, 1, 2, 90);
        Thread second = new ThreadUserStore(store, 2, 1, 110);

        first.start();
        second.start();

        first.join();
        second.join();

        assertThat(user1.toString(), is("User{id=1, amount=120}"));
        assertThat(user2.toString(), is("User{id=2, amount=180}"));
    }
}