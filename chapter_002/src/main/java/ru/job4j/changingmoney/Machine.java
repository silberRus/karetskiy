package ru.job4j.changingmoney;

/**
 * Created by silbe on 13.02.2017.
 */
public class Machine {

    /**
     * Виды монет с которыми работает разменник.
     */
    final private Money[] support;

    public Machine (Money[] support) {

        this.support = support;
    }

    /**
     * Возвращает массив вариантов все возможных монет на требуемую мумму.
     * @param cost сумма на которую рассчитываем все сварианты.
     * @return массив вариантов, варианты это массив монет.
     */
    public Money[][] getAllVariants(int cost) {

        Money[][] variants = null;

        for (Money coin: this.support) {
            if (cost >= coin.getCost()) {

                int ost = cost - coin.getCost();
                if (ost == 0) {

                    variants = addVariants(variants, new Money[][]{new Money[]{new Money(coin.type, cost)}});

                } else {

                    Money[][] childVariants = getAllVariants(ost);
                    boolean added = false;

                    for (int ind = 0; ind < childVariants.length; ind++) {
                        childVariants[ind] = addMoney(childVariants[ind], coin);
                    }
                    variants = addVariants(variants, childVariants);
                }
            }
        }
        return variants;
    }

    /**
     * ищет максимальную монету по стоиммости.
     * @param cost сумма деньги.
     * @return максимально близкую монету по стоимости.
     */
    private Money getMaxCoin(int cost) {

        Money maxCoin = null;
        for (Money money: this.support) {
            if (maxCoin == null || money.getCost() > maxCoin.getCost()) {
                maxCoin = money;
            }
        }
        return maxCoin;
    }

    /**
     * Копирует вариант 1 в другой вариант и возвращает объедененный вариант.
     * @param variants1 первый вариант монет.
     * @param variants2 второй вариант монет.
     * @return результат объединения двух ваиантов монет.
     */
    static private Money[][] addVariants(Money[][] variants1, Money[][] variants2) {

        if (variants1 == null) {
            return variants2;
        }

        int len = variants1.length + variants2.length;
        Money[][] newVariants = new Money[len][];
        for (int ind = 0; ind < len; ind++) {
            newVariants[ind] = ind < variants1.length ? variants1[ind] : variants2[ind-variants1.length];
        }
        return newVariants;
    }

    /**
     * Добавляет в вариант монету в начало варанта.
     * @param variant вариант монет.
     * @param coin монета ля добавления
     * @return новый вариант с добавленной монетой.
     */
    static private Money[] addMoney(Money[] variant, Money coin) {

        Money[] newVariant = new Money[variant.length + 1];
        newVariant[0] = coin;

        for (int ind = 0; ind < variant.length; ind++) {
            newVariant[ind + 1] = variant[ind];
        }
        return newVariant;
    }

    static private boolean isPresent(Money[][] variants, Money[] variant) {

        if (variants != null) {
            for (Money[] tekVariant : variants) {
                if (tekVariant.length == variant.length) {
                    boolean equal = true;
                    for (Money money : variant) {
                        if (count(variant, money) != count(tekVariant, money)) {
                            equal = false;
                            break;
                        }
                    }
                    if (equal) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static private int count(Money[] variant, Money money) {

        int count = 0;

        for (Money tekMoney: variant) {
            if (money.equals(tekMoney)) {
                count++;
            }
        }
        return count;
    }
}
