package ru.job4j.stock;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Stock {

    private HashMap<Order.action, PriorityQueue<Order>> glasses = new HashMap<>();
    private final String LS = System.lineSeparator();

    public Stock() {

        glasses.put(Order.action.ask, new PriorityQueue<Order>());
        glasses.put(Order.action.bid, new PriorityQueue<Order>());
    }

    /**
     * Добавляет заявку на биржу.
     * @param order добавляемая заявка.
     */
    public void addOrder(Order order) {

        turn(order);
        if (order.getVolume() != 0) {
            glasses.get(order.getAction()).add(order);
        }
    }

    /**
     * Убирает заявку с биржи.
     * @param order удаляемоя заявка.
     */
    public void deleteOrder(Order order) {

        glasses.get(order.getAction()).poll();
    }

    private Order.action inverse(Order.action action) {
        return action == Order.action.ask ? Order.action.bid : Order.action.ask;
    }

    private boolean operatinAccess(Order o1, Order o2) {

        return o1.getAction() == Order.action.ask ? o1.getPrice() <= o2.getPrice() : o1.getPrice() >= o2.getPrice();

    }

    private void turn(Order order) {

        int need = order.getVolume();
        PriorityQueue<Order> glass = glasses.get(inverse(order.getAction()));

        Order o = glass.peek();
        while (o != null) {

            if (!operatinAccess(o, order)) {
                break;
            }

            int vol = o.getVolume();
            int take = need < vol ? need : vol;
            need -= take;

            System.out.println("Покупка акций:" + o + " объем:" + take);

            if (o.changeVol(take) && o.getVolume() == 0) {
                glass.remove(o);
                o = glass.peek();
            }

            if (order.changeVol(take)) {
                break;
            }
        }
        //order.changeVol(need - order.getVolume());

    }

    private String glassString(PriorityQueue<Order> glass) {

        StringBuilder sb = new StringBuilder();
        glass.forEach(order -> {sb.append(order); sb.append(LS);});
        return sb.toString();
    }

    @Override
    public String toString() {
        return  "ask{" + LS +
                    glassString(glasses.get(Order.action.ask)) + "}" + LS +
                "bid{" + LS +
                    glassString(glasses.get(Order.action.bid)) + "}";
    }
}
