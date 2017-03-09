package ru.job4j.sortFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class для сортировки больших файлов текстовых по возрастанию длины строк.
 * @author karetskiy
 * @since 10.03.2017
 * @version 4
 */
public class Anchors {

    /**
     * Хранилище якорей (мест в файле где начинается строка).
     */
    private List<Long> list = new ArrayList<Long>();

    /**
     * Длина строки.
     */
    final private int lenght;

    /**
     * Конструктр, при создании указываем длину строки.
     * @param len длина строки.
     */
    public Anchors(int len) {
        this.lenght = len;
    }

    /**
     * Возвращает доину строки.
     * @return длина строки.
     */
    public int getlenght() {
        return this.lenght;
    }

    /**
     * добавляет якорь в хрвнилище.
     * @param anchor якорь (блок в файле).
     */
    public void add(long anchor) {
        list.add(anchor);
    }

    /**
     * Возвращает список якорей (мест в файле) где начинаются строки текущей длины.
     * @return  anchor якорь (блок в файле).
     */
    public Long[] getAnchors() {
        return (Long[]) this.list.toArray();
    }

    /**
     * Сравнивает список я корей с текщим. Если их длины одинаковые значит они одинаковые.
     * @return Истина если одинаковые.
     */
    public boolean equals(int lenght) {
        return this.lenght == lenght;
    }

    /**
     * Компаратор для сортиовки списка.
     * Нужен чтобы выполнить сортировку по длине строки.
     */
    public static final Comparator<Anchors> COMPARE_BY_LENGHT = Comparator.comparingInt(Anchors::getlenght);
}
