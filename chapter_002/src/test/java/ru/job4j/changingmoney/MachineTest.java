package ru.job4j.changingmoney;

import org.junit.Test;

import javax.crypto.Mac;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class тестировани автомата размена монет.
 * @author karetskiy
 * @since 22.02.2017
 * @version 2
 */
public class MachineTest {

    /**
     * Один общий автомат для тестов.
     */
    final private Machine machine;

    /**
     * При создании сразу иницилизируем готовый автомат для проверок.
     */
    public MachineTest () {

        TypeMoney moneta = new TypeMoney("монета");
        TypeMoney note = new TypeMoney("блокнота");

        this.machine = new Machine(new Variant(new Money[]{
                new Money(moneta, 10),
                new Money(moneta, 5),
                new Money(moneta, 3),
                new Money(moneta, 1),
                new Money(note, 100)}));
    }

    /**
     * Проверяем размен 10 рублей, должно быть 5 и 5.
     */
    @Test
    public void TenBittOneVariant() throws Exception {

        final Money money = new Money(new TypeMoney("блокнота"), 10);
        final int[] expect  = new int[]{5, 5};
        final int[] result  = toArray(this.machine.razmen(money));

        assertThat(result, is(expect));
    }

    /**
     * Проверяем все возможные варианты размена 10 рублей.
     */
    @Test
    public void TenBitt() throws Exception {

        final int cost = 10;
        final int[][] expect  = new int[][]{{10},
                                            {5,5},
                                            {5,3,1,1},
                                            {5,1,1,1,1,1},
                                            {3,3,3,1},
                                            {3,3,1,1,1,1},
                                            {3,1,1,1,1,1,1,1},
                                            {1,1,1,1,1,1,1,1,1,1}};
        final int[][] result  = toArray(this.machine.getAllVariants(cost));

        assertThat(result, is(expect));
    }

    /**
     * Преобразует вариант в массив чисел для дальнейших проверок.
     */
    static private int[] toArray(Variant variant) {

        int[] array = new int[variant.getLength()];
        int ind = 0;
        for (Money coin: variant.getManeys()) {
            array[ind++] = coin.getCost();
        }
        return array;
    }

    /**
     * Преобразует массив вариантов в двухмерный массив чисел для дальнейших проверок.
     */
    static private int[][] toArray(Variant[] variants) {

        int[][] array = new int[variants.length][];
        for (int ind = 0; ind < variants.length; ind++) {
            array[ind] = toArray(variants[ind]);
        }
        return array;
    }
}