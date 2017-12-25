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

    private final String LS = System.lineSeparator();

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

        assertThat(map.toString(), is(String.format("Map{%sVitek #324353: Accounts[]%sIvan #102324: Accounts[]%s}", LS, LS, LS)));
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
        assertThat(map.toString(), is(String.format("Map{%sIvan #102324: Accounts[]%s}", LS, LS)));
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
        assertThat(map.toString(), is(String.format("Map{%sVitek #324353: Accounts[22222222222: $20000.0]%sIvan #102324: Accounts[]%s}", LS, LS, LS)));
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
        assertThat(map.toString(), is(String.format("Map{%sVitek #324353: Accounts[]%sIvan #102324: Accounts[11111111111: $200.0]%s}", LS, LS, LS)));

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
        assertThat(map.toString(), is(String.format("Map{%sVitek #324353: Accounts[22222222222: $18800.0]%sIvan #102324: Accounts[11111111111: $1400.0]%s}", LS, LS, LS)));
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