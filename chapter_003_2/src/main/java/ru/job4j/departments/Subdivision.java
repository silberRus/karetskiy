package ru.job4j.departments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class справочника подразделения.
 * @author karetskiy
 * @since 17.01.2017
 * @version 1
 */
public class Subdivision {

    /**
     * Код подразделения.
     */
    private String code;

    /**
     * Список подчиненных подразделений.
     */
    private List<Subdivision> units = new ArrayList<>();

    /**
     * Конструктор.
     * @param code - код подразделения.
     */
    public Subdivision(String code) {

        this.code = code;
    }

    /**
     * Конструктор.
     * @param code - код подразделения.
     * @param units - подчиненные подразделения.
     */
    public Subdivision(String code, Subdivision ... units) {

        this.code = code;
        addUnits(units);
    }

    /**
     * Конструктор.
     * @param units - подчиненные подразделения.
     */
    public Subdivision(Subdivision ... units) {

        addUnits(units);
    }

    /**
     * Добавляет подчиненные подразделения.
     * @param units - подчиненные подразделения.
     */
    private void addUnits(Subdivision ... units) {
        for (Subdivision unit : units) {
            this.units.add(unit);
        }
    }

    /**
     * Рекурсивно вытаскивает код подразделения и коды подчиненных
     * подразделений и помещает в список.
     * @param comparator - Компаратор для сортировки.
     * @return список кодов подразделений.
     */
    private ArrayList<String> getCodes(Comparator<Subdivision> comparator) {

        ArrayList<String> codes = new ArrayList<>();
        this.units.sort(comparator);

        if (code != null) {
            codes.add(code);
        }

        units.forEach(unit-> unit.getCodes(comparator).forEach(unitsChild->
                codes.add(String.format("%s%s", code == null ? "": code + "\\", unitsChild))));
        return codes;
    }

    /**
     * Сортирует по возрастанию коды подчиненных подразделений.
     * @return Список подразделений по возрастанию.
     */
    public ArrayList<String> getSortedAsc() {

        return getCodes(new Comparator<Subdivision>() {
            public int compare(Subdivision o1, Subdivision o2) {
                return o1.code.compareTo(o2.code);
            }
        });
    }

    /**
     * Сортирует по убыванию коды подчиненных подразделений.
     * @return Список подразделений по убыванию.
     */
    public ArrayList<String> getSortedDesc() {

        return getCodes(new Comparator<Subdivision>() {
            public int compare(Subdivision o1, Subdivision o2) {
                return o2.code.compareTo(o1.code);
            }
        });
    }

    /**
     * Преставление подразделения.
     * @return представление подразделения.
     */
    @Override
    public String toString() {
        return this.code;
    }
}