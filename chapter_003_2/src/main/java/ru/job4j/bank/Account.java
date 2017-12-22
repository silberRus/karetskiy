package ru.job4j.bank;

import java.util.Objects;

/**
 * Class банковских счетов.
 * @author karetskiy
 * @since 17.12.2017
 * @version 1
 */
public class Account {

    /**
     * Сумма денег на счете.
     */
    private double value;

    /**
     * Реквизиты счета.
     */
    private String requisites;

    /**
     * Конструктор.
     * @param requisites - реквизиты счета.
     * @param value - сумма денег на счете.
     *
     */
    public Account(String requisites, float value) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Изменяет деньги на счете.
     * @param dec - умма денег на которое изменяется счет.
     * @return true если при изменении суммы хватило денег и false если нет.
     */
    public boolean changeValue(double dec) {

        double result = this.value + dec;
        boolean accept = result >= 0;
        if (accept) {
            this.value = result;
        }
        return accept;
    }

    /**
     * Представление мапа.
     * @return строковое представление мапа.
     */
    @Override
    public String toString() {
        return String.format("%s: $%s", requisites, value);
    }

    /**
     * Хеш объекта из реквизитов счета.
     * @return хеш объекта.
     */
    @Override
    public int hashCode() {

        return Objects.hash(requisites, value);
    }
}
