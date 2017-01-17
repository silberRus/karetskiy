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
public class DoctorTest {

    /**
     * Докот лечит больного, у него здоровье после лечения должно быть 100.
     */
    @Test
    public void cure()  {

        int healtInvalid = 80;

        People invalid = new People(healtInvalid, 1, new Profession());
        final Doctor doctor = new Doctor();

        doctor.cure(invalid);
        final int result = invalid.getHealt();

        assertThat(result, is(100));

    }

}