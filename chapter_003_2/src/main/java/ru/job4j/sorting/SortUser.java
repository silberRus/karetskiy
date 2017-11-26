package ru.job4j.sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class сортировки пользователь.
 * @author karetskiy
 * @since 26.11.2017
 * @version 1
 */
public class SortUser {

    /**
     * Возвращает отсортированное дерево
     * @param users - список пользователей.
     * @return сортированное дерево.
     *
     */
    public Set<User> sort(List<User> users)
    {
        Set<User> treeSet = new TreeSet();
        users.forEach(user -> treeSet.add(user));
        return treeSet;
    }
}
