package ru.job4j.changingmoney;

import sun.misc.resources.Messages_pt_BR;

/**
 * Class автомата размена денег.
 * @author karetskiy
 * @since 22.02.2017
 * @version 3
 */
public class Machine {

    /**
     * Виды монет с которыми работает разменник.
     */
    final private Variant support;

    /**
     * При создании сразу определяем какие монеты можно пихать в автомат.
     */
    public Machine (Variant support) {

        this.support = support;
    }

    /**
     * Разменивает монету. Отдает самыми крупными монетами.
     * @param money монета для размена.
     * @return вариант размена.
     */
    public Variant razmen(Money money) {

        return getAllVariants(money.getCost())[1];
    }

    /**
     * Возвращает массив вариантов все возможных монет на требуемую сумму.
     * @param cost сумма на которую рассчитываем все сварианты.
     * @return массив вариантов, варианты это массив монет.
     */
    public Variant[] getAllVariants(int cost) {

        Variant[] variants = null;

        for (Money coin: this.support.getManeys()) {
            if (cost >= coin.getCost()) {

                int ost = cost - coin.getCost();
                if (ost == 0) {

                    variants = addVariants(variants, new Variant[]{new Variant(new Money[]{coin.clone()})});

                } else {

                    Variant[] childVariants = getAllVariants(ost);

                    for (int ind = 0; ind < childVariants.length; ind++) {
                        childVariants[ind].addMoney(coin);
                    }
                    variants = addVariants(variants, childVariants);
                }
            }
        }
        return variants;
    }

    /**
     * Копирует вариант 1 в другой вариант и возвращает объедененный вариант.
     * Если копируемый вариант уже есть то пропускает, так чтобы остались только уникальные наборы.
     * @param variants1 первый вариант монет.
     * @param variants2 второй вариант монет.
     * @return результат объединения двух ваиантов монет.
     */
    static private Variant[] addVariants(Variant[] variants1, Variant[] variants2) {

        if (variants1 == null) {
            return variants2;
        } else if (variants2 == null) {
            return variants1;
        }

        int len = variants1.length + variants2.length;
        int tekInd = 0;

        Variant[] newVariants = new Variant[len];

        for (int ind = 0; ind < len; ind++) {
            Variant variant = ind < variants1.length ? variants1[ind] : variants2[ind-variants1.length];
            if (!variant.isPresents(newVariants)) {
                newVariants[tekInd++] = variant;
            }
        }
        if (tekInd == len) {

            return newVariants;

        } else {

            Variant[] urVariants = new Variant[tekInd];
            System.arraycopy(newVariants, 0, urVariants,0, tekInd);
            return urVariants;
        }
    }
}
