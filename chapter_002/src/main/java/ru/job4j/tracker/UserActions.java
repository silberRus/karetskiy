package ru.job4j.tracker;

/**
 * Interface запроса.
 * @author karetskiy
 * @since 25.01.2017
 * @version 1
 */
public interface UserActions {

    /**
     * Идентификтор действия.
     * @return идентификатор.
     */
    String key();

    /**
     * Дйествие.
     * @return результат действия.
     */
    String execute(Input input, Tracker tracker);

    /**
     * Информация об действии.
     * @return Информацию об действии.
     */
    String info();
}
