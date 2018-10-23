package ru.job4j.stock;

import java.util.*;

public class Glass implements Iterator {

    private PriorityQueue<Order> orders;

    public void add(Order order) {

        orders.add(order);
    }

    public void delete(Order order) {

        orders.remove(order);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Order next() {
        return null;
    }

}
