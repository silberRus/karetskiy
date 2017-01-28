package ru.job4j.tracker;

/**
 * Class пользовательской работы трекера через консоль.
 * @author karetskiy
 * @since 28.01.2017
 * @version 4
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
    private Tracker tracker;

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
     * Кадр игрового цикла, все время спрашиваем пользователя - что делать.
     */
    public void allTimeAsk() throws MenuOutExeption {

        String ask = "";
        System.out.println(this.menu.getShowFullMenu());
        do {
            System.out.println("-----------------------------");
            ask = this.input.ask("Выберите действие:", this.menu.listAsks());
            System.out.println(this.menu.action(ask, this.tracker, this.input));

        } while (!ask.equals(this.menu.askExit()));
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
    public static void main(String[] args) throws MenuOutExeption {

        StartUI startUI = new StartUI(new ValidateInput(), new Tracker());
        startUI.allTimeAsk();
    }
}