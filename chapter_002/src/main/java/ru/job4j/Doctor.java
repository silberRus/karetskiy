package ru.job4j;

/**
 * Class врача.
 * @author karetskiy
 * @since 14.01.2017
 * @version 1
 */
public class Doctor extends Profession{

    /**
     * Специлизация.
     */
    private String specialty;

    /**
     * Эффективность врача, добавляет к 100% здоровье еще и эту величину.
     */
    private int efficiency;

    /**
     * Лечит человека.
      @param people - больной
     *
     */
    public void cure(People people) {

        people.restoreHealth();
    }
}
