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

        return String.format("%1 %2", type, cost);
    }

    public boolean equals(Money money) {
        return this.cost == money.getCost();
    }
    public boolean equals(Money money1, Money money2) {
        return this.cost == money1.getCost() + money2.getCost();
    }

    public int getCost() {
        return this.cost;
    }

    public boolean lesser(Money money) {
        return this.cost > money.getCost();
    }
    public Money clone() {
        return new Money(this.type, this.cost);
    }

    /**
     * Возвращает количество возможных враиантов, для подсчета длины будующего массива.
     * @param moneys монеты которые можно использовать.
     * @return количество возможных составов числа.
     */
    static private int deep(Money base, Money[] moneys) {

        int len = 0;

        for (Money money1: moneys) {
            for (Money money2 : moneys) {
                if (money1.lesser(money2)) {

                    if (base.equals(money1, money2)) {
                        len++;
                    }
                }
            }
            len += deep(money1, moneys);
        }
        return len;
    }

    /**
     * Возвращает массив возможных составов числа.
     * @param moneys монеты которые можно использовать.
     * @return массив возможных монет.
     */
    static public Money[][] parts(Money base, Money[] moneys) {

        Money[][] parts = new Money[deep(base, moneys)][];
        int ind = 0;

        for (Money money1: moneys) {
            for (Money money2 : moneys) {
                if (money1.lesser(money2)) {

                    if (base.equals(money1, money2)) {
                        parts[ind++] = new Money[] {money1.clone(), money2.clone()};
                    }
                }
            }
            Money[][] dobMoney = parts(money1, moneys);
            for (Money[] locMoneys: dobMoney) {
                parts[ind++] = locMoneys;
            }
        }
        return parts;
    }
}
