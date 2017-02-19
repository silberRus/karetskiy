package ru.job4j.changingmoney;

import org.junit.Test;

import javax.crypto.Mac;

import static org.hamcrest.core.Is.is;
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
                new Money(moneta, 10),
                new Money(moneta, 5),
                new Money(moneta, 3),
                new Money(moneta, 1),
                new Money(note, 100),
                new Money(note, 500),
                new Money(note, 1000)});
    }

    public Machine getMachine() {
        return this.machine;
    }

    @Test
    public void TenBitt() throws Exception {

        final int cost = 10;
        final int[][] expect  = new int[][]{{10},
                                            {5,5},
                                            {5,3,1,1},
                                            {3,3,3,1},
                                            {3,3,1,1,1,1},
                                            {3,1,1,1,1,1,1,1},
                                            {1,1,1,1,1,1,1,1,1,1}};
        final int[][] result  = toArray(this.machine.getAllVariants(cost));

        assertThat(result, is(expect));
    }

    static private int[] toArray(Money[] moneys) {

        int[] array = new int[moneys.length];
        for (int ind = 0; ind < moneys.length; ind++) {
            array[ind] = moneys[ind].getCost();
        }
        return array;
    }

    static private int[][] toArray(Money[][] moneys) {

        int[][] array = new int[moneys.length][];
        for (int ind = 0; ind < moneys.length; ind++) {
            array[ind] = toArray(moneys[ind]);
        }
        return array;
    }
}