package ru.job4j.nonblock;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Class неблокирующего потокобезопасного кеша.
 * @author karetskiy
 * @since 31.10.2018
 * @version 1
 */
public class Cache {

    /**
     * Коллекция для хранения моделей.
     */
    ConcurrentHashMap<Integer, Base> cash = new ConcurrentHashMap<>();

    /**
     * Идентификатор для новых добовляемых объектов.
     */
    private volatile int id = 0;

    /**
     * Возвращает новую модель с установленным идентификатором.
     * @return новая модель.
     */
    public Base newModel() {
        return new Base(++id);
    }

    /**
     * Добавляет новую модель в кеш.
     * @param model добавляеммая модель.
     */
    public void add(Base model) {
        cash.put(model.getId(), model);
    }

    /**
     * Обновляет модель в кеше.
     * @param model обновляеммая модель.
     */
    public void update(Base model) {
        cash.computeIfPresent(model.getId(), (k,v) -> v.change(model));
    }

    /**
     * Удаляет модель из кеша.
     * @param model удаляемая модель.
     */
    public void delete(Base model) {
        cash.remove(model.getId());
    }
}