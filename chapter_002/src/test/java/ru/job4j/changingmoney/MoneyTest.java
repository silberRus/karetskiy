package ru.job4j.changingmoney;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by silbe on 14.02.2017.
 */
public class MoneyTest {

    @Test
    public void lesser() throws Exception {

        final TypeMoney moneta = new TypeMoney("монета");

        final Money fiveRub = new Money(moneta,5);
        final Money tenRub = new Money(moneta,10);

        final boolean expect = true;
        final boolean result = tenRub.lesser(fiveRub);

        assertThat(result, is(expect));
    }

    @Test
    public void TenBitt5And5() throws Exception {

        final TypeMoney moneta = new TypeMoney("монета");

        final Money[] expect = new Money[]{new Money(moneta, 5), new Money(moneta, 5)};
        final Money[] result = new MachineTest().getMachine().getSupport();

        assertThat(result, is(expect));
    }
}