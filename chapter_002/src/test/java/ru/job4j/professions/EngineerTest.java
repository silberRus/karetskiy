package ru.job4j.professions;

import org.junit.Test;


/**
 * Test.
 *
 * @author Karetskiy
 * @version 1
 * @since 17.01.2017
 */
public class EngineerTest {

    /**
     * Инженер работает, пока ниче не делает..
     */
    @Test
    public void work() {

        Engineer engineer = new Engineer();
        engineer.work();

    }

}