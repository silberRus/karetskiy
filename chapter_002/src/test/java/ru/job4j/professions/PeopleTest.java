package ru.job4j.professions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Karetskiy
 * @version 1
 * @since 17.01.2017
 */
public class PeopleTest {

    /**
     * Получаем здоровье.
     */
    @Test
    public void getHealt() {

        int expect = 100;

        final People people = new People();
        final int result = people.getHealt();

        assertThat(result, is(expect));
    }

    /**
     * Получаем образование.
     */
    @Test
    public void getEducation() {

        int expect = 3;

        final People people = new People(100, expect, new Profession());
        final int result = people.getEducation();

        assertThat(result, is(expect));
    }

    /**
     * Получаем профессию.
     */
    @Test
    public void getProfession() {

        Profession profession = new Profession();

        final People people = new People(100, 1, profession);
        final Profession result = people.getProfession();

        assertThat(result, is(profession));
    }

    /**
     * Работаем инжинером.
     */
    @Test
    public void workEngineer() {

        People people = new People(100, 3, new Engineer());
        people.work();
    }

    /**
     * Работаем врачем.
     */
    @Test
    public void workDoctor() {

        People people = new People(100, 3, new Doctor());
        people.work();
    }
}