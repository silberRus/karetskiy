package ru.job4j.threadsCollections;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.ArrayList;
import ru.job4j.list.List;

import java.util.Iterator;

/**
 * Class Безопасной коллекции.
 *
 * @author karetskiy
 * @version 1
 * @since 09.10.2018
 */
@ThreadSafe
public class ListTreadsSafe<T> extends List<T> {

    /**
     * Потоконебезпасная коллекция, (композиция переменной).
     */
    @GuardedBy("this")
    private final ArrayList<T> array = new ArrayList<>();

    /**
     * Добавляет элемент в коллекцию.
     * @param value - добовляемый элемент.
     * @return true если элемент был добавлен в коллекцию.
     */
    @Override
    public synchronized boolean add(T value) {
        return this.array.add(value);
    }

    /**
     * Удаляет элемент из коллекци.
     * @param ind - индекс удаляемого элемента.
     */
    public synchronized void remove(int ind) {
        this.array.remove(ind);
    }

    /**
     * Получает элемент из коллекции.
     * @param index - индекс элемента который нужно получить.
     * @return значение элемента коллеции.
     */
    @Override
    public synchronized T get(int index) {
        return array.get(index);
    }

    /**
     * Возвращает итератор коллекции. Итератор получается за счет слипка
     * текущего состояния коллекции (fail-safe).
     * @return итератор коллекции.
     */
    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.array).iterator();
    }

    /**
     * Возвращает слипок коллеции.
     * @param copyList - копируеммая коллеция.
     * @return новую скоппируваемую коллекцию.
     */
    private ArrayList<T> copy(ArrayList<T> copyList) {

        ArrayList<T> arrayList = new ArrayList<T>();
        copyList.forEach(arrayList::add);
        return arrayList;
    }
}