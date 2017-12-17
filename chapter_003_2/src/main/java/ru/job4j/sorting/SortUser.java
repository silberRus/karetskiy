package ru.job4j.sorting;

import java.util.*;

/**
 * Class сортировки пользователь.
 * @author karetskiy
 * @since 27.11.2017
 * @version 2
 */
public class SortUser {

    /**
     * Возвращает отсортированное дерево
     * @param users - список пользователей.
     * @return сортированное дерево.
     */
    public Set<User> sort(List<User> users)
    {
        Set<User> treeSet = new TreeSet();
        users.forEach(user -> treeSet.add(user));
        return treeSet;
    }

    /**
     * Возвращает отсортированный список по длине имени.
     * @param users - список пользователей.
     * @return отсортированный список.
     */
    public List<User> sortNameLength(List<User> users)
    {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.name.length(), o2.name.length());
            }
        });
        return users;
    }

    /**
     * Возвращает отсортированный список по имя + возраст.
     * @param users - список пользователей.
     * @return отсортированный список.
     */
    public List<User> sortByAllFields (List<User> users)
    {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {

                int rsl = o2.age - o1.age;
                return rsl != 0 ? rsl : o1.name.compareTo(o2.name);

            }
        });
        return users;
    }
}