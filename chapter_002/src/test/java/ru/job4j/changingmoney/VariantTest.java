package ru.job4j.changingmoney;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class тестировани списков монет.
 * @author karetskiy
 * @since 22.02.2017
 * @version 1
 */
public class VariantTest {

    /**
     * Проверим что 5 и 3 рубля не равны 5 и 1 рубль.
     */
    @Test
    public void equalsFalse() throws Exception {

        final TypeMoney moneta = new TypeMoney("монета");
        final Variant variant1 = new Variant(new Money[]{new Money(moneta, 5), new Money(moneta, 3)});
        final Variant variant2 = new Variant(new Money[]{new Money(moneta, 5), new Money(moneta, 1)});

        assertThat(variant1.equals(variant2), is(false));
    }

    /**
     * Проверим что 5 и 3 рубля равны 3 и 5 рублей.
     */
    @Test
    public void equalsTrue() throws Exception {

        final TypeMoney moneta = new TypeMoney("монета");
        final Variant variant1 = new Variant(new Money[]{new Money(moneta, 5), new Money(moneta, 3)});
        final Variant variant2 = new Variant(new Money[]{new Money(moneta, 3), new Money(moneta, 5)});

        assertThat(variant1.equals(variant2), is(true));
    }
}