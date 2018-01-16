package ru.job4j.departments;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test map for subdivisions.
 *
 * @author Karetskiy
 * @version 1
 * @since 17.01.2017
 */
public class SubdivisionTest {

    private final String LS = System.lineSeparator();

    /**
     * Возвращает дефольный список подразделений для тестов.
     */
    private Subdivision defaultSubdivision() {

        return new Subdivision(
                new Subdivision("K1",
                        new Subdivision("SK1",
                                new Subdivision("SSK1"),
                                new Subdivision("SSK2")),
                        new Subdivision("SK2")),
                new Subdivision("K2",
                        new Subdivision("SK1",
                                new Subdivision("SSK1"),
                                new Subdivision("SSK2"))));
    }

    /**
     * Проверим сортирову по возрастанию.
     */
    @Test
    public void getSortedAsc() {

        StringBuilder exp = new StringBuilder();
        defaultSubdivision().getSortedAsc().forEach(code -> exp.append(String.format("%s%s", code, LS)));

        StringBuilder res = new StringBuilder();
        res.append("K1" + LS);
        res.append("K1\\SK1" + LS);
        res.append("K1\\SK1\\SSK1" + LS);
        res.append("K1\\SK1\\SSK2" + LS);
        res.append("K1\\SK2" + LS);
        res.append("K2" + LS);
        res.append("K2\\SK1" + LS);
        res.append("K2\\SK1\\SSK1" + LS);
        res.append("K2\\SK1\\SSK2" + LS);

        assertThat(exp.toString(), is(res.toString()));
    }

    /**
     * Проверим сортирову по убыванию.
     */
    @Test
    public void getSortedDesc() {

        StringBuilder exp = new StringBuilder();
        defaultSubdivision().getSortedDesc().forEach(code -> exp.append(String.format("%s%s", code, LS)));

        StringBuilder res = new StringBuilder();
        res.append("K2" + LS);
        res.append("K2\\SK1" + LS);
        res.append("K2\\SK1\\SSK2" + LS);
        res.append("K2\\SK1\\SSK1" + LS);
        res.append("K1" + LS);
        res.append("K1\\SK2" + LS);
        res.append("K1\\SK1" + LS);
        res.append("K1\\SK1\\SSK2" + LS);
        res.append("K1\\SK1\\SSK1" + LS);

        assertThat(exp.toString(), is(res.toString()));

    }
}