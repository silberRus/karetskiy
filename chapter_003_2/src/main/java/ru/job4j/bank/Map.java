package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class мап пользователей и их счетов для банков.
 * @author karetskiy
 * @since 17.12.2017
 * @version 1
 */
public class Map {

    /**
     * Коллекция для хранения пользователей и их счетов.
     */
    private java.util.Map<User, List<Account>> map = new HashMap<>();

    /**
     * Добавляет пользователя а коллекцию.
     * @param user - Добавляемый пользователь.
     */
    public void addUser(User user) {

        map.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удаляет пользователя из коллекции.
     * @param user - Добавляемый пользователь.
     */
    public void deleteUser(User user) {

        map.remove(user);
    }

    /**
     * Добавляет счет пользователю.
     * @param user - Добавляемый пользователь.
     */
    public void addAccountToUser(User user, Account account) {

        map.computeIfPresent(user, (key, list) -> {
            list.add(account);
            return list;});
    }

    /**
     * Удаляет счет пользователю.
     * @param user - Добавляемый пользователь.
     */
    public void deleteAccountFromUser(User user, Account account) {

        List<Account> acc = getUserAccounts(user);
        if (acc != null) {
            acc.remove(account);
        }
    }

    /**
     * Возвращает список счетов пользователя.
     * @param user - Пользователь счета которого получаем.
     * @return список счетов пользователя.
     */
    public List<Account>getUserAccounts (User user) {
        return map.get(user);
    }

    /**
     * Переводит деньги с одного счета на другой.
     * @param srcUser - Пользователь от которого перевдим деньги.
     * @param srcAccount - Счет пользовтеля от которого перевдим деньги.
     * @param dstUser - Пользователь которому переводим деньги.
     * @param dstAccount - Счет пользователя от которого переводим деньги.
     * @param amount - Сумма денег которую переводим.
     * @return true если операция удалась, false в случае неудачи.
     */
    public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {

        return srcAccount.changeValue(-amount) && dstAccount.changeValue(amount);

    }

    /**
     * Проверяет одинаковые банковские мапы или нет.
     * @param map2 - Мап с которым сравниваем.
     * @return true если одинаковые и false если разные.
     */
    public boolean equals(Map map2) {

        final boolean[] equals = new boolean[]{map.size() == map2.size()};

        if (equals[0]) {
            map.forEach((user, list) -> {

                ArrayList<Account> list2 = (ArrayList<Account>) map2.getUserAccounts(user);

                if (list2 == null || list2.size() != list.size()) {

                    equals[0] = false;

                } else {
                    for (int ind = 0; ind < list.size(); ind++) {

                        if (!list2.get(ind).equals(list.get(ind))) {
                            equals[0] = false;
                            break;
                        }
                    }
                }
            });
        }
        return equals[0];
    }

    /**
     * Проверяет размер мапа.
     * @return количество записей пользователей в мапе.
     */
    public int size() {
        return map.size();
    }

    /**
     * представление мапа.
     * @return Представление мапа.
     */
    @Override
    public String toString() {

        final String LS = System.lineSeparator();

        StringBuilder sb = new StringBuilder();
        map.forEach((user, list) -> sb.append(String.format("%s: Accounts%s%s", user, list, LS)));

        return String.format("Map{%s%s}", LS, sb);
    }
}