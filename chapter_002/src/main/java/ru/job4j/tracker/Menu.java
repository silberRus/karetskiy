package ru.job4j.tracker;

/**
 * Class хранилище меню.
 * @author karetskiy
 * @since 18.01.2017
 * @version 1
 */

public class Menu {

    /**
     * Вараинты меню.
     */
    private Action[] actions = {
            new Action("Создать заявку", "1"),
            new Action("Редактировать заявку", "2"),
            new Action("Удалить заявку", "3"),
            new Action("Показать все заявки", "4"),
            new Action("Найти по имени", "5"),
            new Action("Найти по ID", "6"),
            new Action("Выйти из трекера", "0")
    };

    /**
     * Выполняет определенные действия в зависимости от выбора пользователя.
     * @param ask введеный запрос пользователем.
     * @param tracker трекер.
     * @param input интерфейс ввода.
     * @return ответ трекера на действие пользователя.
     */
    public String action(String ask, Tracker tracker, Input input) {

        String out;

        if (ask.equals("1")) {

            Item item = tracker.add(inputItem(input));
            out = "Заявка добавлена в трекер: " + item.toString();

        } else if (ask.equals("2")) {

            Item oldItem = tracker.findById(input.ask("Введите ID:"));
            if (oldItem == null) {
                out = "не найдено";
            } else {

                Item newItem = inputItem(input);
                newItem.setID(oldItem.getID());
                tracker.update(newItem);
                out = "Заявка отредактирована";
            }

        } else if (ask.equals("3")) {

            Item item = tracker.findById(input.ask("Введите ID:"));
            if (item == null) {
                out = "не найдено";
            } else {
                tracker.delete(item);
                out = "заявка удалена";
            }

        } else if (ask.equals("4")) {

            String allItems = listItems(tracker.findAll());
            out = new StringBuilder("Все заявки:").append(System.getProperty("line.separator")).append(allItems).toString();

        } else if (ask.equals("5")) {

            Item[] items = tracker.findByName(input.ask("Введите имя:"));
            out = items.length == 0 ? "Завявки с таким именем не найдены" : listItems(items);

        } else if (ask.equals("6")) {

            Item item = tracker.findById(input.ask("Введите ID:"));
            out = item == null ? "Завявка с таким ID не найдена" : item.toString();

        } else if (ask.equals("0")) {

            out = "";

        } else {

            out = "не известная команда: " + ask;
        }
        return out;
    }

    /**
     * Вводит информацию о новой заявке.
     * @param input интерфейс ввода.
     * @return новую заявку.
     */
    private Item inputItem(Input input) {

        return new Item(input.ask("Имя заявки:"), input.ask("Описание заявки:"));
    }

    /**
     * Возвращает представление списка заявок.
     * @param items список заявок.
     * @return представление списка.
     */
    private String listItems(Item[] items) {

        StringBuilder string = new StringBuilder();
        String rn = System.getProperty("line.separator");

        for (Item item : items) {
            string.append(item.toString()).append(rn);
        }
        return string.toString();
    }

    /**
     * Возвращает полное меню с описанием возможностей трекеров.
     * @return описание меню.
     */
    public String getShowFullMenu() {

        String rn = System.getProperty("line.separator");
        StringBuilder strMenu = new StringBuilder();

        strMenu.append("Трекер заявок").append(rn);
        for (Action action : this.actions) {
            strMenu.append(action.getShow()).append(": ").append(action.getAsk()).append(rn);
        }
        return strMenu.toString();
    }
}