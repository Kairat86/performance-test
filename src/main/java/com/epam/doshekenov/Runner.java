package com.epam.doshekenov;

import java.util.*;

public class Runner implements Comparable<Runner> {

    private int id;
    private final static int ITERATION_NUM = 110000;

    public Runner(int id) {
        this.id = id;
    }

    public static void main(String[] args) {

        List<Object> aList = new ArrayList<>();
        List<Object> lList = new LinkedList<>();


        System.out.println("List.add() operation check: ArrayList vs. LinkedList");
        System.out.println("Time consumed for adding 110000 objects: ");
        System.out.println("ArrayList:" + testAddPerformance(aList, null));
        System.out.println("LinkedList:" + testAddPerformance(lList, null));
        System.out.println("---------------------------------------------------");
        System.out.println("List.remove() operation check: ArrayList vs. LinkedList");
        System.out.println("Time consumed for removing 110000 objects: ");
        System.out.println("ArrayList:" + testRemovePerformance(aList));
        System.out.println("LinkedList:" + testRemovePerformance(lList));
        System.out.println("----------------------------------------------------");
        System.out.println("List.contains() operation check:ArrayList vs. LinkedList");
        System.out.println("Time consumed to find an Object with id=12354 among 110000 objects: ");
        System.out.println("ArrayList:" + testSearchPerformance(new ArrayList<>(), 12354));
        System.out.println("LinkedList:" + testSearchPerformance(new LinkedList<>(), 12354));
        System.out.println("Time consumed to find an Object with id=100000 among 110000 objects: ");
        System.out.println("ArrayList:" + testSearchPerformance(new ArrayList<>(), 55555));
        System.out.println("LinkedList:" + testSearchPerformance(new LinkedList<>(), 55555));
        System.out.println("########################################################");

        Set hashSet = new HashSet<>();
        Set treeSet = new TreeSet<>();
        System.out.println("Set.add() operation check: HashSet vs. TreeSet");
        System.out.println("Time consumed for adding 110000 objects: ");
        Runner[] array = new Runner[ITERATION_NUM];
        for (int i = 0; i < ITERATION_NUM; i++) {
            array[i] = new Runner(i);
        }
        System.out.println("HashSet:" + testAddPerformance(hashSet, array));
        System.out.println("TreeSet:" + testAddPerformance(treeSet, array));
        System.out.println("Set.contains() operation check:HashSet vs. TreeSet");
        System.out.println("Time consumed to find an Object with id=12354 among 110000 objects: ");
        System.out.println("HashSet:" + testSearchPerformance(new HashSet<>(), 12354));
        System.out.println("TreeSet:" + testSearchPerformance(new TreeSet<>(), 12354));
        System.out.println("Time consumed to find an Object with id=100000 among 110000 objects: ");
        System.out.println("HashSet:" + testSearchPerformance(new HashSet<>(), 100000));
        System.out.println("TreeSet:" + testSearchPerformance(new TreeSet<>(), 100000));
        System.out.println("Set.remove() operation check:HashSet vs. TreeSet");
        System.out.println("Time consumed to remove 110000 objects: ");
        System.out.println("HashSet:" + testRemovePerformance(hashSet));
        System.out.println("TreeSet:" + testRemovePerformance(treeSet));
        System.out.println("##########################################################");
        System.out.println("Map.put operation check: HashMap vs. TreeMap");
        System.out.println("Time consumed for putting 110000 objects: ");
        Map<Integer, Object> hMap = new HashMap<>();
        Map<Integer, Object> tMap = new TreeMap<>();
        System.out.println("HashMap:" + testMapPutPerformance(hMap));
        System.out.println("TreeMap:" + testMapPutPerformance(tMap));
        System.out.println("---------------------------------------------------------------");
        System.out.println("Map.containsValue()  operation check HashMap vs. TreeMap");
        System.out.println("Time consumed to find a Runner object with id=66666 among 110000 objects: ");
        System.out.println("HashMap: " + testContainsValuePerformance(new HashMap<>(), 66666));
        System.out.println("TreeMap: " + testContainsValuePerformance(new TreeMap<>(), 66666));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Map.remove operation check: HashMap vs. TreeMap");
        System.out.println("Time consumed to remove all 110000 objects: ");
        System.out.println("HashMap: " + testMapRemovePerformance(hMap));
        System.out.println("TreeMap:" + testMapRemovePerformance(tMap));

    }

    private static long testMapRemovePerformance(Map<Integer, Object> map) {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < ITERATION_NUM; i++) {
            map.remove(i);
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    private static long testContainsValuePerformance(Map<Integer, Runner> map, int queryId) {
        Runner runner = new Runner(queryId);
        for (int i = 0; i < ITERATION_NUM; i++) {
            map.put(i, new Runner(i));
        }
        long t1 = System.currentTimeMillis();
        map.containsValue(runner);
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    private static long testMapPutPerformance(Map<Integer, Object> map) {
        Object o = new Object();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < ITERATION_NUM; i++) {
            map.put(i, o);
        }
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    private static long testAddPerformance(Collection<Object> collection, Runner[] array) {
        long t1, t2;
        if (array == null) {
            Object e = new Object();
            t1 = System.currentTimeMillis();
            for (int i = 0; i < ITERATION_NUM; i++) {
                collection.add(e);
            }
            t2 = System.currentTimeMillis();
        } else {
            t1 = System.currentTimeMillis();
            for (int i = 0; i < ITERATION_NUM; i++) {
                collection.add(array[i]);
            }
            t2 = System.currentTimeMillis();
        }

        return t2 - t1;
    }

    private static long testSearchPerformance(Collection<Object> collection, int queryId) {

        for (int i = 0; i < ITERATION_NUM; i++) {
            collection.add(new Runner(i));
        }
        Runner objToFind = new Runner(queryId);
        long t1 = System.currentTimeMillis();
        collection.contains(objToFind);
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    private static long testRemovePerformance(Collection<Object> collection) {

        long t1 = System.currentTimeMillis();
        collection.removeAll(collection);
        long t2 = System.currentTimeMillis();
        return t2 - t1;
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
