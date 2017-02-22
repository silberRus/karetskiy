package ru.job4j.changingmoney;

/**
 * Class работы с вариантами (цепочками) монет.
 * @author karetskiy
 * @since 22.02.2017
 * @version 2
 */
class Variant {

    /**
     * Хранилище для списка монет.
     */
    private Money[] moneys;

    /**
     * Задаем список монет при создании
     */
    public Variant(Money[] moneys) {
        this.moneys = moneys;
        sort();
    }

    /**
     * Возвращает массив монет.
     * @return массив монет.
     */
    public Money[] getManeys() {
        return this.moneys;
    }

    /**
     * Возвращает количество монет в варианте.
     * @return количество монет.
     */
    public int getLength() {
        return this.moneys.length;
    }

    /**
     * Добавляет монету и сортирует.
     * @param money монета для добавления
     */
    public void addMoney(Money money) {

        Money[] monies = new Money[this.moneys.length + 1];
        System.arraycopy(this.moneys,0,monies,0,this.moneys.length);
        monies[monies.length - 1] = money;
        this.moneys = monies;
        sort();
    }

    /**
     * Проверяет есть или нет текущий вариант в массиве вариантов.
     * @param variants массив вариантов.
     * @return Истина если есть.
     */
    public boolean isPresents(Variant[] variants) {

        for (Variant variant: variants) {
            if (this.equals(variant)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверяет на равенство варианты, одинаковые будут если порядк и число монет одинаковое.
     * @param variant сравнивыемый вариант.
     * @return Истина если одинаковые.
     */
    public boolean equals(Variant variant) {

        boolean equals = false;
        if (variant != null) {

            Money[] monies = variant.getManeys();

            if (monies.length == this.moneys.length) {
                for (int ind = 0; ind < monies.length; ind++) {
                    if (!monies[ind].equals(this.moneys[ind])) {
                        return false;
                    }
                }
                equals = true;
            }
        }
        return equals;
    }

    /**
     * Сортирует вариант по убыванию.
     */
    private void sort() {

        boolean sorting;
        int size = this.moneys.length;

        do {
            sorting = true;
            for (int ind = 1; ind < size; ind++) {

                if (this.moneys[ind - 1].getCost() < this.moneys[ind].getCost()) {

                    Money money = this.moneys[ind - 1].clone();
                    this.moneys[ind - 1] = this.moneys[ind];
                    this.moneys[ind] = money;
                    sorting = false;
                }
            }
        } while (!sorting);
    }
}