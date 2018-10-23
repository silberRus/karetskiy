package ru.job4j.stock;

public class Order implements Comparable<Order>{

    enum action{bid,ask};

    private int id;
    private String book;
    private action action;
    private final float price;
    private int volume;

    public Order(String book, action action, float price, int volume) {

        this.book = book;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    public action getAction() {
        return action;
    }

    public float getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public boolean changeVol(int delta) {
        volume -= delta;
        return volume == 0;
    }

    @Override
    public int compareTo(Order o) {
        return (int)(this.price - o.getPrice());
    }

    public String getBook() {
        return book;
    }

    @Override
    public String toString() {
        return book + " $" + price + " vol:" + String.valueOf(volume);
    }
}
