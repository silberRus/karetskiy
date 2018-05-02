package ru.job4j.list;

import org.junit.Test;
import java.util.ConcurrentModificationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ListTest {

    private void initList(List<Integer> list) {

        list.add(2);
        list.add(1);
        list.add(7);
    }

    private ArrayList getNewMyArrayList() {

        ArrayList<Integer> myArrayList = new ArrayList<Integer>();
        initList(myArrayList);
        return myArrayList;
    }

    private LinkedList getNewMyLinkedList() {

        LinkedList<Integer> myLinkedList = new LinkedList<>();
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

        ArrayList<Integer> myArrayList = getNewMyArrayList();
        myArrayList.add(1);
        myArrayList.add(1);

        LinkedList<Integer> myLinkedList = getNewMyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(1);

        assertThat(myArrayList.getLastIndex(), is(4));
        assertThat(myLinkedList.getLastIndex(), is(4));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void ConcurrentModificationException_arrayList(){

        ArrayList<Integer> myArrayList = getNewMyArrayList();
        for (Object number:myArrayList) {
            myArrayList.add(3);
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void ConcurrentModificationException_linkedList(){

        LinkedList<Integer> myLinkedList = getNewMyLinkedList();
        for (Object number:myLinkedList) {
            myLinkedList.add(3);
        }
    }
}