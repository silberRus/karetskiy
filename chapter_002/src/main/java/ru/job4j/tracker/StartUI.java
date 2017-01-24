package ru.job4j.tracker;

/**
 * Class пользовательской работы трекера через консоль.
 * @author karetskiy
 * @since 25.01.2017
 * @version 2
 */
public class StartUI {

    /**
     * Интерфейс с которым работаем.
     */
    private Input input;

    /**
     * Меню пользователя.
     */
    private Menu menu = new Menu();

    /**
     * Трекер с которым работаем.
     */
    private Tracker tracker = new Tracker();

    /**
     * Иницилизация с интерфейсом и тректроа.
     * @param input интерфейс.
     * @param tracker трекер.
     */
    public StartUI(Input input, Tracker tracker) {

        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Иницилизация с интерфейсом.
     * @param input интерфейс.
     */
    public StartUI(Input input) {

        this.input = input;
    }

    /**
     * Кадр игрового цикла, все аремя спрашиваем пользователя - что делать.
     */
    public void allTimeAsk() {

        String out = "";
        System.out.println(this.menu.getShowFullMenu());
        do {
            System.out.println("-----------------------------");
            out = this.menu.action(this.input.ask("Выберите действие:"), this.tracker, this.input);
            System.out.println(out);

        } while (!"".equals(out));
    }

    /**
     * Возвращает трекер.
     * @return трэкер:
     */
    public Tracker getTracker() {
        return this.tracker;
    }

    /**
     * Вход в программу.
     * @param args параметры консоля
     */
    public static void main(String[] args) {

        StartUI startUI = new StartUI(new ConsoleInput());
        startUI.allTimeAsk();
        System.out.print("Спасибо за использование.");
    }
}