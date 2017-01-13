package ru.job4j;

/**
 * Class учителя.
 * @author karetskiy
 * @since 14.01.2017
 * @version 1
 */

public class Teacher extends Profession{

    /**
     * Номер класса
     */
    private int classRoom;

    /**
     * Буква класса
     */
    private char letter;

    /**
     * обучает человека, повышая его образование.
     * @param people - ученик
     */
    public void learn(People people) {

        people.addEducation();
    }
}
