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

public class ProfessionTest {

    /**
     * Увеличиваем опыт.
     */
    @Test
    public void addExperience() {

        final Profession profession = new Profession();
        profession.addExperience();

        assertThat(profession.getExperience(), is(1));
    }
}