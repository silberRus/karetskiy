package ru.job4j.changingmoney;

/**
 * Class типов монет.
 * @author karetskiy
 * @since 13.02.2017
 * @version 1
 */
public class TypeMoney {

    /**
     * Тип монеты в виде строки.
     */
    final private String name;

    /**
     * При создании сразу задаем тип.
     */
    public TypeMoney(String name) {
        this.name = name;
    }

    /**
     * Возвращаем строковое представление типа.
     * @return строковое представление.
     */
    public String toString() {
        return this.name;
    }
}
