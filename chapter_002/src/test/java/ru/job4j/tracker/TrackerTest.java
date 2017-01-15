package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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
    public void add() throws Exception {

        Tracker tracker = new Tracker();
        final boolean expect = true;
        tracker.add(new Item("Имя 1", "Описание 1"));
        Item item = tracker.getByIndex(0);
        final boolean result = item != null && item.id != "";

        assertThat(result, is(expect));
    }

    /**
     * Проверяем обновление заявки.
     * при обновлении имя должно изменится.
     */
    @Test
    public void update() throws Exception {

        int ind = 1;
        final String expect = "имя обновлено";
        Tracker tracker = newTracker();

        Item item = tracker.getByIndex(ind);
        item.name = expect;

        tracker.update(item);

        assertThat(tracker.getByIndex(ind).name, is(expect));
    }

    /**
     * Проверяем уделение.
     * удаляем 2 заявку, при удалениии на месте 2ой заявек будет 3я .
     */
    @Test
    public void delete() throws Exception {

        Tracker tracker = newTracker();

        int delInd = 1;
        final String expect = tracker.getByIndex(delInd + 1).name;

        tracker.delete(tracker.getByIndex(delInd));

        assertThat(tracker.getByIndex(delInd).name, is(expect));
    }

    /**
     * Проверяем что возвращает все
     * Проверяем что количество добавленных элементов равна 4.
     */
    @Test
    public void findAll() throws Exception {

        Tracker tracker = newTracker();
        final int expect = 4;

        final Item[] findItems = tracker.findAll();

        assertThat(findItems.length, is(expect));
    }

    /**
     * Ищем по имени.
     * Проверяем что будет найдено 2 заявки.
     */
    @Test
    public void findByName() throws Exception {

        Tracker tracker = newTracker();
        final int expect = 2;

        final Item[] findItems = tracker.findByName("имя одинаковое");

        assertThat(findItems.length, is(expect));
    }

    /**
     * Ищем по id.
     */
    @Test
    public void findById() throws Exception {

        Tracker tracker = newTracker();
        final boolean expect = true;
        String id = tracker.getByIndex(0).id;

        Item findItem = tracker.findById(id);

        assertThat(findItem.id == id, is(expect));
    }

    /**
     * Быстро создает трекер с заполненными заявками
     * @return заполненный трекер для тестов
     */
    private Tracker newTracker(){

        Tracker tracker = new Tracker();
        tracker.add(new Item("1 имя", "1 описание"));
        tracker.add(new Item("2 имя", "2 описание"));
        tracker.add(new Item("имя одинаковое", "3 описание"));
        tracker.add(new Item("имя одинаковое", "4 описание"));

        return tracker;
    }
}