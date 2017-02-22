package ru.job4j.changingmoney;

/**
 * Class деньги.
 * @author karetskiy
 * @since 13.02.2017
 * @version 1
 */
public class Money {

    /**
     * Номинал монеты.
     */
    final private int cost;

    /**
     * Тип монеты.
     */
    final TypeMoney type;

    /**
     * Сразу создаем монету с неизменяемыми номиналом и типом.
     */
    public Money(TypeMoney type, int cost) {

        this.cost = cost;
        this.type = type;
    }

    /**
     * Возвращаем представление монеты.
     * @return представление монеты.
     */
    public String toString() {

        return String.format("%s %s", this.type, this.cost);
    }

    /**
     * Сравниваем монеты по номиналу.
     * @param money сравниваемая монета
     * @return результат сравнения.
     */
    public boolean equals(Money money) {
        return this.cost == money.getCost();
    }

    /**
     * Получаем номинал монеты.
     * @return номинал монеты.
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Создаем новую моент с точно такими же характеристиками.
     * @return клон текущей монеты.
     */
    public Money clone() {
        return new Money(this.type, this.cost);
    }
}