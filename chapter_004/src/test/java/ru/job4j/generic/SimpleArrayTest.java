package ru.job4j.generic;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    private final String LS = System.lineSeparator();

    private SimpleArray<Integer> newSimpleArray() {

        SimpleArray<Integer> sa = new SimpleArray<>();

        sa.add(1);
        sa.add(3);
        sa.add(2);

        return sa;
    }

    @Test
    public void add_1_3_2() {

        assertThat(newSimpleArray().toString(), is(String.format("%s%s%s%s%s%s%s%s",
                            "SimpleArray:", LS,
                                        "1", LS,
                                        "3", LS,
                                        "2", LS)));
    }

    @Test
    public void delete_ind1_result_1_2() {

        SimpleArray<Integer> sa = newSimpleArray();
        sa.delete(1);

        assertThat(sa.toString(), is(String.format("%s%s%s%s%s%s",
                "SimpleArray:", LS,
                "1", LS,
                "2", LS)));
    }

    @Test
    public void set_ind1_val4_result_1_4_2() {

        SimpleArray<Integer> sa = newSimpleArray();
        sa.set(1, 4);

        assertThat(sa.toString(), is(String.format("%s%s%s%s%s%s%s%s",
                "SimpleArray:", LS,
                "1", LS,
                "4", LS,
                "2", LS)));
    }

    @Test
    public void get_ind2_result_2() {
        assertThat(newSimpleArray().get(2), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void saOfNextMethodShouldThrowNoSuchElementException(){

        IteratotorArray<Integer> it = new IteratotorArray<>(newSimpleArray());

        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        it.next();
    }
}
