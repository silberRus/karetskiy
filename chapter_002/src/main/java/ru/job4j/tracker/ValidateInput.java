package ru.job4j.tracker;

/**
 * Class пользователского интрфейса с проверкой корректного меню.
 * @author karetskiy
 * @since 28.01.2017
 * @version 1
 */
public class ValidateInput extends ConsoleInput{

    public String ask(String question, String[] listAsks) {

        String out = "";
        boolean err = true;

        do {
            try {
                out = super.ask(question, listAsks);
                err = false;
            } catch (MenuOutExeption moe) {
                System.out.println("Нет такого пункта в меню выбора");
            }

        } while (err);
       return out;
    }
}
