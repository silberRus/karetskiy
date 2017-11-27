package ru.job4j.framework;

import java.util.*;

/**
 * Class замера производительности коллекций.
 * @author karetskiy
 * @since 22.11.2017
 * @version 1
 */
public class TestCollection
{
    /**
     * Замер времени добавление произвольного колличества строк.
     * @param collection - Коллекция в которую добавляем строки.
     * @param amount - сколько строк добавляем.
     * @return Время в милисекундах на затраченную операцию.
     */
    public long add(Collection<String> collection, int amount)
    {
        long start = System.currentTimeMillis();
        for (int ind = 0; ind < amount; ind++)
        {
            collection.add(String.format("Строка %s", ind));
        }
        return System.currentTimeMillis() - start;
    }

    /**
     * Замер времени удаления произвольного колличества строк коллекции.
     * @param collection - Коллекция в которой будем удалять строки.
     * @param amount - сколько строк удаляем.
     * @return Время в милисекундах на затраченную операцию.
     */
    public long delete(Collection<String> collection, int amount)
    {
        long start = System.currentTimeMillis();

        if (collection instanceof TreeSet)
        {
            deleteTreeSet((TreeSet<String>) collection, amount);
        }
        else
        {
            deleteCollection(collection, amount);
        }
        return System.currentTimeMillis() - start;
    }

    /**
     * Удаляет стоки из дерева коллекции.
     * @param collection - Коллекция дерево из которой будем удалять строки.
     * @param amount - сколько строк удаляем.
     */
    private void deleteTreeSet(TreeSet<String> collection, int amount)
    {
        int ind = 0;
        while (ind < amount)
        {
            ind++;
            if (collection.isEmpty()) break;
            collection.remove(collection.first());
        }
    }
    /**
     * Удаляет стоки из коллекции.
     * @param collection - Коллекция из которой будем удалять строки.
     * @param amount - сколько строк удаляем.
     */
    private void deleteCollection(Collection<String> collection, int amount)
    {
        for (int ind = 0; ind < amount; ind++)
        {
            collection.remove(0);
        }
    }

    /**
     * Вход консоля.
     * Создадим три коллекции и выведем результаты работы времени.
     * @param args параметры консоля.
     */
    public static void main(String[] args)
    {
        int amount = 10000;
        TestCollection testCollection = new TestCollection();

        System.out.println(String.format("Amount = %s", amount));

        LinkedList linkedList = new LinkedList<String>();
        System.out.println(String.format("LinkedList add time is: %s", testCollection.add(linkedList, amount)));
        System.out.println(String.format("LinkedList delete time is: %s", testCollection.delete(linkedList, amount)));

        ArrayList arrayList = new ArrayList<String>();
        System.out.println(String.format("ArrayList add time is: %s", testCollection.add(arrayList, amount)));
        System.out.println(String.format("ArrayList delete time is: %s", testCollection.delete(arrayList, amount)));

        TreeSet treeSet = new TreeSet<String>();
        System.out.println(String.format("TreeSet add time is: %s", testCollection.add(treeSet, amount)));
        System.out.println(String.format("TreeSet delete time is: %s", testCollection.delete(treeSet, amount)));
    }
}