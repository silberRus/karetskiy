package ru.job4j.tracker;

import org.junit.Test;

/**
 * Test user interface.
 *
 * @author Karetskiy
 * @version 1
 * @since 21.01.2017
 */
public class StartUITest {

    /**
     * Проверяем выход из трекера.
     * Нажать: 0
     * рзультатом будет успешный выход из программы, а не зависание в бесконечном цикле.
     */
    @Test
    public void input0ThenExit() {

        final String[] answers = {"0"};
        new StartUI(new StubInput(answers)).allTimeAsk();;
    }

    /**
     * Проверяем ввод заявки
     * Нажать: 1, имя, описание
     */
    @Test
    public void inputNewItem() {

        final String[] answers = {"1", "имя", "описание", "0"};
        new StartUI(new StubInput(answers)).allTimeAsk();
    }

    /**
     * Проверяем редактирование заявки и ввывод списка всех заявок
     * Нажать: 2, id, новое имя, новое описание, 4, 0
     */
    @Test
    public void editItemNumber2() {

        Tracker tracker = newTracker();
        String id = tracker.getByIndex(1).getID();

        final String[] answers = {"2", id, "новое имя", "новое описание", "4", "0"};
        new StartUI(new StubInput(answers), tracker).allTimeAsk();
    }

    /**
     * Проверяем удаление первой и последней заявки и ввывод списка всех заявок.
     * Нажать: 3, id первого, 3, id второго, 4, 0
     */
    @Test
    public void deleteItemNumber1andNumber3() {

        Tracker tracker = newTracker();
        String idFirst = tracker.getByIndex(0).getID();
        String idLast = tracker.getByIndex(2).getID();

        final String[] answers = {"3", idFirst, "3", idLast, "4", "0"};
        new StartUI(new StubInput(answers), tracker).allTimeAsk();
    }

    /**
     * Проверяем поиск заявки по имени.
     * Нажать: 5, имя одинаковое, 0
     */
    @Test
    public void findForNameTwoItems() {

        final String[] answers = {"5", "имя одинаковое", "0"};
        new StartUI(new StubInput(answers)).allTimeAsk();
    }

    /**
     * Проверяем поиск заявки по id.
     * Нажать: 6, id, 0
     */
    @Test
    public void findForIDNumberTwo() {

        Tracker tracker = newTracker();
        String id = tracker.getByIndex(1).getID();

        final String[] answers = {"6", id, "0"};
        new StartUI(new StubInput(answers), tracker).allTimeAsk();
    }

    private Tracker newTracker() {
        return new TrackerTest().newTracker();
    }
}