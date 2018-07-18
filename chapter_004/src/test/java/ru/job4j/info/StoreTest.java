package ru.job4j.info;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class теста.
 * @author karetskiy
 * @since 18.07.2018
 * @version 1
 */
public class StoreTest {

    /**
     * Проверим удаление изменение и добавление списка.
     */
    @Test
    public void diff() {

        List<Store.User> oldList = new ArrayList<>();
        List<Store.User> curList = new ArrayList<>();

        Store.User kolya = new Store.User(12, "Коля");

        oldList.add(new Store.User(1, "Иван"));
        oldList.add(new Store.User(2, "Владимир"));
        oldList.add(new Store.User(3, "Олег"));
        oldList.add(new Store.User(4, "Маша"));
        oldList.add(new Store.User(12, "Коля"));
        oldList.add(new Store.User(5, "Таня"));


        curList.add(new Store.User(12, "Николай")); // изменили
        curList.add(new Store.User(1, "Иван"));
        //curList.add(new Store.User(2, "Владимир")); - удалили
        curList.add(new Store.User(3, "Олег"));
        //curList.add(new Store.User(4, "Маша")); - удалили
        curList.add(new Store.User(5, "Таня"));
        curList.add(new Store.User(6, "Женя")); // добавили

        Store store = new Store();

        assertThat(store.diff(oldList, curList).toString(), is("Info{changed=1, added=1, deleted=2}"));

    }
}