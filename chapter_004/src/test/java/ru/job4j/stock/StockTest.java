package ru.job4j.stock;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StockTest {

    @Test
    public void addOrder() {

        Stock stock = new Stock();
        stock.addOrder(new Order("GazProm", Order.action.ask, 110, 60));
        stock.addOrder(new Order("GazProm", Order.action.ask, 100, 40));
        stock.addOrder(new Order("GazProm", Order.action.ask, 180, 150));

        stock.addOrder(new Order("GazProm", Order.action.bid, 80, 50));
        stock.addOrder(new Order("GazProm", Order.action.bid, 150, 20));

        assertThat(stock.toString(), is("Биржа на"));
    }

    @Test
    public void deleteOrder() {
    }
}