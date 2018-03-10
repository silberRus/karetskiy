package ru.job4j.generic;

/**
 * Class коллекции объектов.
 * @author karetskiy
 * @since 10.03.2018
 * @version 1
 */
public class SimpleArray<T> {

    /**
     * Массив для хранения объектов коллекции.
     */
    private Object[] objects;
    /**
     * Указывает индекс самого поледнего элемента в массиве.
     */
    private int lastIndex = -1;

    /**
     * Возвращает последний индекс коллекции.
     * @return последний индекс коллекции.
     *
     */
    public int getLastIndex() {
        return lastIndex;
    }

    /**
     * Добавление элемента в коллекцию.
     * @param model - добавляемый объект в коллекцию.
     */
    public void add(T model) {

        if (this.objects == null || lastIndex == this.objects.length - 1) {

            Object[] newObj = new Object[(lastIndex + 2) * 2];
            if (objects != null) {
                IteratotorArray<T> it = new IteratotorArray(this);
                int ind = 0;
                while (it.hasNext()) {
                    newObj[ind++] = it.next();
                }
            }
            this.objects = newObj;
        }
        lastIndex++;
        this.objects[lastIndex] = model;
    }

    /**
     * Удаление элемента из коллекции.
     * @param index - индекс удаляемого элемента в коллекции.
     */
    public void delete(int index) {

        if (index <= lastIndex) {
            for (int ind = index; ind < lastIndex; ind++) {
                this.objects[ind] = this.objects[ind + 1];
            }
            lastIndex--;
        }
    }

    /**
     * Устанавливает элемент в коллекцию по указанному индексу.
     * @param index - индекс вставляемого элемента в коллекции.
     * @param model - вставляемый объект.
     */
    public void set(int index, T model) {

        if (index <= lastIndex) {
            this.objects[index] = model;
        }
    }

    /**
     * Возвращает элемент по указангому индексу в коллекции.
     * @param index - индекс возвращаемого элемента в коллекции.
     * @return объект из коллекции.
     */
    public T get(int ind) {
        return (T) objects[ind];
    }

    /**
     * Строковое представление коллекции.
     * @return строковое представление.
     */
    @Override
    public String toString() {

        final String LS = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        for (int ind = 0; ind <= lastIndex; ind++) {
            sb.append(String.format("%s%s", objects[ind], LS));
        }
        return String.format("%s%s%s", "SimpleArray:", LS, sb.toString());
    }
}