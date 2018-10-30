package ru.job4j.nonblock;

/**
 * Class моделей.
 * Храним упращено, только версию модели и id.
 * @author karetskiy
 * @since 31.10.2018
 * @version 1
 */
public class Base {

    /**
     * Идентификатор модели.
     */
    private int id;

    /**
     * Версия модели
     */
    private int version = 0;

    /**
     * Конструктор можели.
     * @param id идентификатор новой модели.
     */
    Base(int id) {
        this.id = id;
    }

    /**
     * возвращает версию модели.
     * @return Версия модели.
     */
    public int getVersion() {
        return this.version;
    }

    /**
     * Возвращает идентификатор модели.
     * @return идентификатор модели.
     */
    public int getId() {
        return id;
    }

    /**
     * Изменяет модел, при изменрении увеличивает версию модели,
     * в случае если версия не совпадает генерирует иклюение.
     * @param model модель на которую изменяем текущюю.
     * @return измененную модель.
     */
    public Base change(Base model) {

        if (this.version != model.getVersion()) {
            throw new OptimisticException(String.format("Version [%s] incorrect %s != %s",this, this.id, model.id));
        } else {
            this.version++;
        }
        return this;
    }
}