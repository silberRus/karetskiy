package ru.job4j.changingmoney;

/**
 * Created by silbe on 13.02.2017.
 */
public class Money {

    final private int cost;
    final TypeMoney type;

    public Money(TypeMoney type, int cost) {

        this.cost = cost;
        this.type = type;
    }

    public String toString() {

        return String.format("%s %s", this.type, this.cost);
    }

    public boolean equals(Money money) {
        return this.cost == money.getCost();
    }

    public int getCost() {
        return this.cost;
    }

    public Money clone() {
        return new Money(this.type, this.cost);
    }
}

