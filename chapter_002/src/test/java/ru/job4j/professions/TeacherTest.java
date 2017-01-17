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
public class TeacherTest {

    /**
     * Учитель учит и образование увеличивается, было 0 стало 1.
     */
    @Test
    public void learn()  {

        People student = new People();
        final Teacher teacher = new Teacher();

        teacher.learn(student);
        final int result = student.getEducation();

        assertThat(result, is(1));

    }

}