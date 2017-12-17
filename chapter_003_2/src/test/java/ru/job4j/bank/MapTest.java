package ru.job4j.bank;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test map for bank.
 *
 * @author Karetskiy
 * @version 1
 * @since 17.12.2017
 */
public class MapTest {

    private class Values {

        User vite = new User("Vitek", "324353");
        Account moneyVite = new Account("22222222222",20000);

        User vane = new User("Ivan", "102324");
        Account moneyVane = new Account("11111111111",200);

    }

    private final Values val = new Values();

    /**
     * Добавление пользователя в мап.
     */
    @Test
    public void addUser() throws Exception {

        Map map = new Map();
        map.addUser(val.vane);
        map.addUser(val.vite);

        assertThat(map.toString(), is("Map{\r\nVitek #324353: Accounts[]\r\nIvan #102324: Accounts[]\r\n}"));
    }

    /**
     * удление пользователя из мапа.
     */
    @Test
    public void deleteUser() throws Exception {

        Map map = new Map();
        map.addUser(val.vane);
        map.addUser(val.vite);

        map.deleteUser(val.vite);
        assertThat(map.toString(), is("Map{\r\nIvan #102324: Accounts[]\r\n}"));
    }

    /**
     * Добавление счета пользователю.
     */
    @Test
    public void addAccountToUser() throws Exception {

        Map map = new Map();
        map.addUser(val.vane);
        map.addUser(val.vite);

        map.addAccountToUser(val.vite, val.moneyVite);
        assertThat(map.toString(), is("Map{\r\nVitek #324353: Accounts[22222222222: $20000.0]\r\nIvan #102324: Accounts[]\r\n}"));
    }

    /**
     * Удаление счета пользователя.
     */
    @Test
    public void deleteAccountFromUser() throws Exception {

        Map map = new Map();
        map.addUser(val.vane);
        map.addUser(val.vite);
        map.addAccountToUser(val.vane, val.moneyVane);
        map.addAccountToUser(val.vite, val.moneyVite);

        map.deleteAccountFromUser(val.vite, val.moneyVite);
        assertThat(map.toString(), is("Map{\r\nVitek #324353: Accounts[]\r\nIvan #102324: Accounts[11111111111: $200.0]\r\n}"));

    }

    /**
     * Получение счета пользователя.
     */
    @Test
    public void getUserAccounts() throws Exception {

        Map map = new Map();
        map.addUser(val.vane);
        map.addUser(val.vite);
        map.addAccountToUser(val.vite, val.moneyVite);
        map.addAccountToUser(val.vite, val.moneyVane);

        List<Account> accounts = map.getUserAccounts(val.vite);
        assertThat(accounts.toString(), is("[22222222222: $20000.0, 11111111111: $200.0]"));
    }

    /**
     * Перевод денег.
     */
    @Test
    public void transferMoney() throws Exception {

        Map map = new Map();
        map.addUser(val.vane);
        map.addUser(val.vite);
        map.addAccountToUser(val.vite, val.moneyVite);
        map.addAccountToUser(val.vane, val.moneyVane);

        map.transferMoney(val.vite, val.moneyVite, val.vane, val.moneyVane, 1200);
        assertThat(map.toString(), is("Map{\r\nVitek #324353: Accounts[22222222222: $18800.0]\r\nIvan #102324: Accounts[11111111111: $1400.0]\r\n}"));
    }

    /**
     * Сравниваем два мапа.
     */
    @Test
    public void equals() throws Exception {

        Map map1 = new Map();
        map1.addUser(val.vane);
        map1.addAccountToUser(val.vane, val.moneyVane);

        Map map2 = new Map();
        map2.addUser(val.vane);
        map2.addAccountToUser(val.vane, val.moneyVane);

        assertThat(map1.equals(map2), is(true));
    }
}