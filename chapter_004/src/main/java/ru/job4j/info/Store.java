package ru.job4j.info;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Class Хранилища коллекций.
 *
 * @author karetskiy
 * @version 2
 * @since 11.09.2018
 */
class Store {

    /**
     * Class пользователя.
     */
    public static class User {

        /**
         * Уникальный идентификатор пользователя.
         */
        int id;

        /**
         * Имя пользователя.
         */
        String name;

        /**
         * Конструктор пользователья.
         * @param id - уникальный идентификатор пользователя.
         * @param name - имя пользователя.
         */
        public User(int id, String name) {

            this.id = id;
            this.name = name;
        }

        /**
         * Сравнивает пользователей.
         * @param o - пользователь с которым сравниваем.
         */
        @Override
        public boolean equals(Object o) {
            User user = (User) o;
            return id == user.id;
        }
    }

    /**
     * Получаем следущего в коллекции пользователя.
     * @param it итератор коллекции пользователей.
     * @return следующий пользователь коллекции если возможно.
     */
    private User nextUsr(Iterator<User> it) {
        return it.hasNext() ? it.next() : null;
    }

    /**
     * Проверяем статистику по изменениям коллекции
     * @param previous - список до изменений.
     * @param current - текущий список.
     * @return статистику изменений списка.
     */
    public Info diff(List<User> previous, List<User> current) {

        Info info = new Info();

        Comparator<User> comparator = Comparator.comparingInt(o -> o.id);
        previous.sort(comparator);
        current.sort(comparator);

        Iterator<User> it1 = previous.iterator();
        Iterator<User> it2 = current.iterator();

        User us1 = it1.next();
        User us2 = it2.next();

        while (us1 != null && us2 != null) {

            if (us2 == null || us1.id < us2.id) {
                info.delete();
                us1 = nextUsr(it1);
            } else if(us1 == null || us1.id > us2.id) {
                info.add();
                us2 = nextUsr(it2);
            } else {
                if(us1.name != us2.name) {
                    info.change();
                }
                us1 = nextUsr(it1);
                us2 = nextUsr(it2);
            }
        }
        return info;
    }
}