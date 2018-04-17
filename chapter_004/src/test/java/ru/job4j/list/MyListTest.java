package ru.job4j.list;

import org.junit.Test;
import java.util.ConcurrentModificationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MyListTest {

    private void initList(MyList<Integer> myList) {

        myList.add(2);
        myList.add(1);
        myList.add(7);
    }

    private MyArrayList getNewMyArrayList() {

        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        initList(myArrayList);
        return myArrayList;
    }

    private MyLinkedList getNewMyLinkedList() {

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        initList(myLinkedList);
        return myLinkedList;
    }

    @Test
    public void add() {

        assertThat(getNewMyArrayList().toString(), is("2;1;7;"));
        assertThat(getNewMyLinkedList().toString(), is("2;1;7;"));
    }

    @Test
    public void get() {

        assertThat(getNewMyArrayList().get(1), is(1));
        assertThat(getNewMyLinkedList().get(1), is(1));
    }

    @Test
    public void getLastIndex() {

        assertThat(getNewMyArrayList().getLastIndex(), is(2));
        assertThat(getNewMyLinkedList().getLastIndex(), is(2));
    }

    @Test
    public void getModCount() {

        MyArrayList<Integer> myArrayList = getNewMyArrayList();
        myArrayList.add(1);
        myArrayList.add(1);

        MyLinkedList<Integer> myLinkedList = getNewMyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(1);

        assertThat(myArrayList.getLastIndex(), is(4));
        assertThat(myLinkedList.getLastIndex(), is(4));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void ConcurrentModificationException_arrayList(){

        MyArrayList<Integer> myArrayList = getNewMyArrayList();
        for (Object number:myArrayList) {
            myArrayList.add(3);
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void ConcurrentModificationException_linkedList(){

        MyLinkedList<Integer> myLinkedList = getNewMyLinkedList();
        for (Object number:myLinkedList) {
            myLinkedList.add(3);
        }
    }
}