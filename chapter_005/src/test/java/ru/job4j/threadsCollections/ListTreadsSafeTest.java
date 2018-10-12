package ru.job4j.threadsCollections;

import org.junit.Test;
import ru.job4j.Users.User;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class теста потокобезопасной коллекции.
 * @author karetskiy
 * @since 09.10.2018
 * @version 1
 */
public class ListTreadsSafeTest {

    /**
     * Класс описывает нить для работы с коллекцией.
     */
    private class ThreadList extends Thread {

        /**
         * Коллекция.
         */
        private final ListTreadsSafe<String> listTreadsSafe;

        /**
         * Имя потока.
         */
        private String nameThred;

        /**
         * Инициализация потока.
         * @param listTreadsSafe  коллекция с которой работает поток.
         * @param nameThred имя пототка.
         */
        private ThreadList(final ListTreadsSafe listTreadsSafe, String nameThred) {
            this.listTreadsSafe = listTreadsSafe;
            this.nameThred = nameThred;
        }

        /**
         * Запускает поток.
         */
        @Override
        public void run() {
            int i;
            for (i = 0; i < 100; i++) {
                listTreadsSafe.add("obj" + i);
            }
            System.out.println(String.format("%s added %s, cont list = %s", nameThred, i, listTreadsSafe.getSize()));

            for (i = 99; i > 0; i--) {
                listTreadsSafe.remove(i);
            }
            System.out.println(String.format("%s deleted, list size = %s", nameThred, i, listTreadsSafe.getSize()));
        }
    }

    /**
     * Проверим добавления и удаления одновременно двух потоков одной коллекции.
     * @throws InterruptedException
     */
    @Test
    public void modAnyCollectSomeThreds() throws InterruptedException {

        ListTreadsSafe<String> listTreadsSafe = new ListTreadsSafe();

        User user1 = new User(1, 100);
        User user2 = new User(2, 200);

        Thread first = new ThreadList(listTreadsSafe, "Thred1");
        Thread second = new ThreadList(listTreadsSafe, "Thred2");

        assertThat(listTreadsSafe.getSize(), is(0));

        first.start();
        second.start();

        assertThat(listTreadsSafe.getSize(), is(0));
    }
}