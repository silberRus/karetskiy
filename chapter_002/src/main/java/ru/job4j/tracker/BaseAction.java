package ru.job4j.tracker;

/**
 * Class действий пользователя.
 * @author karetskiy
 * @since 30.01.2017
 * @version 1
 */
public abstract class BaseAction {

    /**
     * Идентификтор действия.
     * @return идентификатор.
     */
    abstract String execute(Input input, Tracker tracker);

    /**
     * Действие.
     * @return результат действия.
     */
    abstract String key();

    /**
     * Информация об действии.
     * @return Информацию об действии.
     */
    abstract String info();

    /**
     * Информация об действии в форматированном тексте.
     * @return Информацию об действии.
     */
    public String fomatInfo(String info) {
        return String.format("%s - %s", key(), info);
    }
}
