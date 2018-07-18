package ru.job4j.info;

import java.util.HashSet;
import java.util.List;

/**
 * Class Хранилища коллекций.
 *
 * @author karetskiy
 * @version 1
 * @since 18.07.2018
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
     * Проверяем статистику по изменениям коллекции
     * @param previous - список до изменений.
     * @param current - текущий список.
     * @return статистику изменений списка.
     */
    public Info diff(List<User> previous, List<User> current) {

        Info info = new Info();
        HashSet<User> isDel = new HashSet<>();

        current.forEach(user -> {

            boolean isNew = true;

            for (User olden: previous) {

                if (user.equals(olden)) {

                    isNew = false;
                    if (!user.name.equals(olden.name)) {
                        info.change();
                    }
                    break;

                } else if (!isDel.contains(olden) && !current.contains(olden)) {

                    isDel.add(olden);
                    info.delete();
                }
            }
            if (isNew) {
                info.add();
            }
        });
        return info;
    }
}