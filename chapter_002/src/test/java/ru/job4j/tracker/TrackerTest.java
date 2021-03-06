package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Karetskiy
 * @version 1
 * @since 16.01.2017
 */
public class TrackerTest {

    /**
     * Проверяем добавление заявки.
     * при добавлении заявки id должен быть заполнен и первый элемент не должен быть null.
     */
    @Test
    public void add() {

        Tracker tracker = new Tracker();
        final boolean expect = true;
        tracker.add(new Item("Имя 1", "Описание 1"));
        Item item = tracker.getByIndex(0);
        final boolean result = item != null && !item.getID().isEmpty();

        assertThat(result, is(expect));
    }

    /**
     * Проверяем обновление заявки.
     * при обновлении имя должно изменится.
     */
    @Test
    public void update() {

        int ind = 1;
        final String expect = "имя обновлено";
        Tracker tracker = newTracker();

        Item item = tracker.getByIndex(ind);
        item.setName(expect);

        tracker.update(item);

        assertThat(tracker.getByIndex(ind).getName(), is(expect));
    }

    /**
     * Проверяем уделение.
     * удаляем 2 заявку, при удалениии на месте 2ой заявек будет 3я .
     */
    @Test
    public void delete() {

        Tracker tracker = newTracker();

        int delInd = 1;
        final String expect = tracker.getByIndex(delInd + 1).getName();

        tracker.delete(tracker.getByIndex(delInd));

        assertThat(tracker.getByIndex(delInd).getName(), is(expect));
    }

    /**
     * Проверяем что возвращает все
     * Проверяем что количество добавленных элементов равна 4.
     */
    @Test
    public void findAll() {

        Tracker tracker = newTracker();
        final int expect = 4;

        final ArrayList<Item> findItems = tracker.findAll();

        assertThat(findItems.size(), is(expect));
    }

    /**
     * Ищем по имени.
     * Проверяем что будет найдено 2 заявки.
     */
    @Test
    public void findByName() {

        Tracker tracker = newTracker();
        final int expect = 2;

        final ArrayList<Item> findItems = tracker.findByName("имя одинаковое");

        assertThat(findItems.size(), is(expect));
    }

    /**
     * Ищем по id.
     */
    @Test
    public void findById() {

        Tracker tracker = newTracker();
        final boolean expect = true;
        String id = tracker.getByIndex(0).getID();

        Item findItem = tracker.findById(id);

        assertThat(findItem.getID().equals(id), is(expect));
    }

    /**
     * Быстро создает трекер с заполненными заявками.
     * @return заполненный трекер для тестов
     */
    Tracker newTracker() {

        Tracker tracker = new Tracker();
        tracker.add(new Item("1 имя", "1 описание"));
        tracker.add(new Item("2 имя", "2 описание"));
        tracker.add(new Item("имя одинаковое", "3 описание"));
        tracker.add(new Item("имя одинаковое", "4 описание"));

        return tracker;
    }
}