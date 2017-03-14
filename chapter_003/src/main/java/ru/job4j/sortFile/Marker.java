package ru.job4j.sortFile;

import java.util.Comparator;

/**
 * Created by silbe on 11.03.2017.
 */
public class Marker {

    private int sizeLine;
    private long begin;
    private long lenght;

    public Marker(int sizeLine, long lenght) {

        this.sizeLine = sizeLine;
        this.lenght = lenght;
    }

    public int getSizeLine() {
        return this.sizeLine;
    }

    public long getLenght() {
        return this.lenght;
    }

    public long getBegin() {
        return this.begin;
    }
    public void setBegin(long begin) {
        this.begin = begin;
    }

    public void addLenght(long lenght) {
        this.lenght+=lenght;
    }

    /**
     * Компаратор для сортиовки списка.
     * Нужен чтобы выполнить сортировку по длине строки.
     */
    public static final Comparator<Marker> COMPARE_BY_LENGHT = Comparator.comparingInt(Marker::getSizeLine);
}
