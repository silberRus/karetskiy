package ru.job4j.changingmoney;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by silbe on 14.02.2017.
 */
public class MoneyTest {

    @Test
    public void getCost() throws Exception {

        final int expect = 5;
        final Money result = new Money(new TypeMoney("монета"),5);

        assertThat(result.getCost(), is(expect));
    }

}