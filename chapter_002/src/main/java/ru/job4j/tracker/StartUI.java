package ru.job4j.tracker;

/**
 * Class пользовательской работы трекера через консоль.
 * @author karetskiy
 * @since 18.01.2017
 * @version 1
 */
public class StartUI {

    /**
     * Интерфейс с которым работаем.
     */
    private Input input = new ConsoleInput();

    /**
     * Меню пользователя.
     */
    private Menu menu = new Menu();

    /**
     * Трекер с которым работаем.
     */
    private Tracker tracker = new Tracker();

    /**
     * Кадр игрового цикла, все аремя спрашиваем пользователя - что делать.
     */
    public void allTimeAsk() {

        String out = "";
        System.out.println(this.menu.getShowFullMenu());
        do {
            System.out.println("------------------------------");
            out = this.menu.action(this.input.ask("Выберите действие:"), this.tracker, this.input);
            System.out.println(out);

        } while (!out.equals(""));
    }

    /**
     * Вход в программу.
     * @param args параметры консоля
     */
    public static void main(String[] args) {

        StartUI startUI = new StartUI();
        startUI.allTimeAsk();
        System.out.print("Спасибо за использование.");
    }
}
