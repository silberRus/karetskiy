package ru.job4j.changingmoney;

/**
 * Created by silbe on 13.02.2017.
 */
public class Machine {

    final private Money[] support;

    public Machine (Money[] support) {

        this.support = support;
    }

    public Money[] getSupport() {

        return this.support;
    }

    public Money[] change(Money note) {

        return Money.parts(note, this.support)[0];

    }

    public Money[][] allVariants(Money note) {

        return Money.parts(note, this.support);
    }

    static public void main(String[] args) {



    }
}
