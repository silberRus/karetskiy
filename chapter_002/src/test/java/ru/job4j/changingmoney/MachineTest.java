package ru.job4j.changingmoney;

import org.junit.Test;

import javax.crypto.Mac;

import static org.junit.Assert.*;

/**
 * Created by silbe on 14.02.2017.
 */
public class MachineTest {

    final private Machine machine;

    public MachineTest () {

        TypeMoney moneta = new TypeMoney("монета");
        TypeMoney note = new TypeMoney("блокнота");

        this.machine = new Machine(new Money[]{
                new Money(moneta, 1),
                new Money(moneta, 5),
                new Money(moneta, 10),
                new Money(note, 100),
                new Money(note, 500),
                new Money(note, 1000)});
    }

    public Machine getMachine() {
        return this.machine;
    }

    @Test
    public void change() throws Exception {

    }

    @Test
    public void allVariants() throws Exception {

    }

}