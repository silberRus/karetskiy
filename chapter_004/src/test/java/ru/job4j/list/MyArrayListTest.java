package ru.job4j.list;

import org.junit.Test;
import java.util.ConcurrentModificationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MyArrayListTest {

    private MyArrayList newMyArrayList() {

        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(2);
        myArrayList.add(1);
        myArrayList.add(7);

        return myArrayList;
    }

    @Test
    public void add() {

        assertThat(newMyArrayList().toString(), is("2;1;7;"));
    }

    @Test
    public void get() {

        assertThat(newMyArrayList().get(1), is(1));
    }

    @Test
    public void getLastIndex() {
        assertThat(newMyArrayList().getLastIndex(), is(2));
    }

    @Test
    public void getModCount() {

        MyArrayList<Integer> myArrayList = newMyArrayList();
        myArrayList.add(1);
        myArrayList.add(1);

        assertThat(myArrayList.getLastIndex(), is(4));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void ConcurrentModificationException(){

        MyArrayList<Integer> myArrayList = newMyArrayList();
        for (Object number:myArrayList) {
            myArrayList.add(3);
        }
    }

}