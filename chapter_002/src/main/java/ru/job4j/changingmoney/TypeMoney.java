package ru.job4j.changingmoney;

import java.security.PublicKey;

/**
 * Created by silbe on 13.02.2017.
 */
public class TypeMoney {

    final private String name;

    public TypeMoney(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
