package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test Acoount.
 *
 * @author Karetskiy
 * @version 1
 * @since 06.12.2017
 */
public class AccountTest {

    /**
     * Добавим денег потом уберем чтобы и чтобы хватило
     */
    @Test
    public void changeValue() throws Exception {

        Account account = new Account("102101002039423", 200);
        boolean firstOpp = account.changeValue(50);
        assertThat(account.toString(), is("102101002039423: $250.0"));

        boolean secondOpp = account.changeValue(-90);
        assertThat(account.toString(), is("102101002039423: $160.0"));

        assertThat(firstOpp && secondOpp, is(true));
    }

    /**
     * Уберем денег болше чем есть
     */
    @Test
    public void changeValueManeyEmpty() throws Exception {

        Account account = new Account("102101002039423", 200);
        final boolean Opp = account.changeValue(-300);

        assertThat(Opp, is(false));
    }

    /**
     * Проверяем представление счета.
     */
    @Test
    public void testToString() throws Exception {

        Account account = new Account("102101002039423", 140000000);
        assertThat(account.toString(), is("102101002039423: $1.4E8"));

    }

}