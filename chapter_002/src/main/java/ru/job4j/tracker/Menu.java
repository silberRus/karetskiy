package ru.job4j.tracker;

/**
 * Class хранилище меню.
 * @author karetskiy
 * @since 25.01.2017
 * @version 1
 */
public class Menu {

    /**
     * Вараинты меню.
     */
    private UserActions[] actions = {
            new AddItem(),
            new EditItem(),
            new DeleteItem(),
            new ShowAllItem(),
            new FindByNameItems(),
            new FindByIDItems()};

    /**
     * Выполняет определенные действия в зависимости от выбора пользователя.
     * @param ask введеный запрос пользователем.
     * @param tracker трекер.
     * @param input интерфейс ввода.
     * @return ответ в консоль на действие пользователя.
     */
    public String action(String ask, Tracker tracker, Input input) {

        for (UserActions action : this.actions) {
            if(ask.equals(action.key())) {
                return action.execute(input, tracker);
            }
        }
        return "";
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
        for (UserActions action : this.actions) {
            strMenu.append(action.info()).append(rn);
        }
        strMenu.append("любой другой символ - выход").append(rn);
        return strMenu.toString();
    }

    private String formatMenuLine(UserActions action, String text) {
        return String.format("%s - %s", action.key(), text);
    }

    /**
     * Class действий, внутренний - добавление заявки.
     */
    class AddItem implements UserActions {

        /**
         * Ключ действия.
         * @return ключ действия.
         */
        public String key() {
            return "1";
        }

        /**
         * Добавляет заявку в трекер.
         * @param input - интрфейс.
         * @param tracker - трекер.
         * @return результат добавления заявки.
         */
        public String execute(Input input, Tracker tracker) {
            Item item = tracker.add(inputItem(input));
            return "Заявка добавлена в трекер: " + item.toString();
        }

        /**
         * Информация о действии.
         * @return информацию.
         */
        public String info() {
            return formatMenuLine(this, "Создать заявку");
        }
    }

    /**
     * Class действий, внутренний - редактирование заявки.
     */
    class EditItem implements UserActions {

        /**
         * Ключ действия.
         * @return ключ действия.
         */
        public String key() {
            return "2";
        }

        /**
         * Добавляет заявку в трекер.
         * @param input - интрфейс.
         * @param tracker - трекер.
         * @return результат редактирования заявки.
         */
        public String execute(Input input, Tracker tracker) {

            Item oldItem = tracker.findById(input.ask("Введите ID:"));
            if (oldItem == null) {
                return "не найдено";
            } else {

                Item newItem = inputItem(input);
                newItem.setID(oldItem.getID());
                tracker.update(newItem);
                return "Заявка отредактирована";
            }
        }

        /**
         * Информация о действии.
         * @return информацию.
         */
        public String info() {
            return formatMenuLine(this, "Редактировать заявку");
        }
    }

    /**
     * Class действий, внутренний - удаление заявки.
     */
    class DeleteItem implements UserActions {

        /**
         * Ключ действия.
         * @return ключ действия.
         */
        public String key() {
            return "3";
        }

        /**
         * Удаляет заявки.
         * @param input - интрфейс.
         * @param tracker - трекер.
         * @return результат удаления.
         */
        public String execute(Input input, Tracker tracker) {

            Item item = tracker.findById(input.ask("Введите ID:"));
            if (item == null) {
                return "не найдено";
            } else {
                tracker.delete(item);
                return  "заявка удалена";
            }
        }

        /**
         * Информация о действии.
         * @return информацию.
         */
        public String info() {
            return formatMenuLine(this, "Удалить заявку");
        }
    }

    /**
     * Class действий, внутренний - показывает все заявки.
     */
    class ShowAllItem implements UserActions {

        /**
         * Ключ действия.
         * @return ключ действия.
         */
        public String key() {
            return "4";
        }

        /**
         * Показывает все заявки в трекере.
         * @param input - интрфейс.
         * @param tracker - трекер.
         * @return все заявки.
         */
        public String execute(Input input, Tracker tracker) {

            String allItems = listItems(tracker.findAll());
            return new StringBuilder("Все заявки:").append(System.getProperty("line.separator")).append(allItems).toString();
        }

        /**
         * Информация о действии.
         * @return информацию.
         */
        public String info() {
            return formatMenuLine(this, "Все заявки");
        }
    }

    /**
     * Class действий, внутренний - поиск заявок по имени.
     */
    class FindByNameItems implements UserActions {

        /**
         * Ключ действия.
         * @return ключ действия.
         */
        public String key() {
            return "5";
        }

        /**
         * Ищет по имени заявки.
         * @param input - интрфейс.
         * @param tracker - трекер.
         * @return результат поиска заявок по имени.
         */
        public String execute(Input input, Tracker tracker) {

            Item[] items = tracker.findByName(input.ask("Введите имя:"));
            return items.length == 0 ? "Завявки с таким именем не найдены" : listItems(items);
        }

        /**
         * Информация о действии.
         * @return информацию.
         */
        public String info() {
            return formatMenuLine(this, "Найти заявки по имени");
        }
    }

    /**
     * Class действий, внутренний - поиск заявки по ID.
     */
    class FindByIDItems implements UserActions {

        /**
         * Ключ действия.
         * @return ключ действия.
         */
        public String key() {
            return "6";
        }

        /**
         * Ищет по ID заявку.
         * @param input - интрфейс.
         * @param tracker - трекер.
         * @return результат поиска заявки по ID.
         */
        public String execute(Input input, Tracker tracker) {

            Item item = tracker.findById(input.ask("Введите ID:"));
            return item == null ? "Завявка с таким ID не найдена" : item.toString();
        }

        /**
         * Информация о действии.
         * @return информацию.
         */
        public String info() {
            return formatMenuLine(this, "Найти заявку по ID");
        }
    }
}