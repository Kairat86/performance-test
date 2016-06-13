package com.epam.doshekenov;

import com.epam.doshekenov.test.CollectionTest;
import com.epam.doshekenov.test.MapTest;

import java.util.*;

public class Runner implements Comparable<Runner> {

    public static final int MILLION_ITERATIONS = 1000_000;

    public Runner() {

    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public Runner(int id) {
        this.id = id;
    }

    public static void main(String[] args) {

        ArrayList<Runner> aList = new ArrayList<>();
        LinkedList<Runner> lList = new LinkedList<>();
        HashSet<Runner> hSet = new HashSet<>();
        TreeSet<Runner> tSet = new TreeSet<>();
        HashMap<Integer, Runner> hMap = new HashMap<>();
        TreeMap<Integer, Runner> tMap = new TreeMap<>();
        CollectionTest.testAddPerformance(aList, MILLION_ITERATIONS);
        CollectionTest.testAddPerformance(lList, MILLION_ITERATIONS);
        CollectionTest.testAddPerformance(hSet, MILLION_ITERATIONS);
        CollectionTest.testAddPerformance(tSet, MILLION_ITERATIONS);

        CollectionTest.testRemovePerformance(aList);
        CollectionTest.testRemovePerformance(lList);
        CollectionTest.testRemovePerformance(hSet);
        CollectionTest.testRemovePerformance(tSet);

        MapTest.testMapPutPerformance(hMap, MILLION_ITERATIONS);
        MapTest.testMapPutPerformance(tMap, MILLION_ITERATIONS);

        MapTest.testContainsValuePerformance(hMap, 500000);
        MapTest.testContainsValuePerformance(tMap, 500000);

        MapTest.testMapRemovePerformance(hMap);
        MapTest.testMapRemovePerformance(tMap);


    }


    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Runner) obj).getId();
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Runner o) {
        return id - o.getId();
    }
}
