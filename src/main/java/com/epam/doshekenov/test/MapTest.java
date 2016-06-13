package com.epam.doshekenov.test;

import com.epam.doshekenov.Runner;

import java.util.Map;

public class MapTest {

    public static long testMapPutPerformance(Map<Integer, Runner> map, int iterationNum) {
        System.out.println("Time consumed for " + map.getClass().getSimpleName() + " to put " + iterationNum + " objects (ms)");
        Runner o = new Runner();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < iterationNum; i++) {
            map.put(i, o);
        }
        long t2 = System.currentTimeMillis();
        long delta = t2 - t1;
        System.out.println(delta);
        return delta;
    }

    public static long testContainsValuePerformance(Map<Integer, Runner> map, int queryId) {
        System.out.println("Time consumed for a " + map.getClass().getSimpleName() + " to find an object with query id=" + queryId + ", among " + map.size());
        Runner runner = new Runner(queryId);
        long t1 = System.currentTimeMillis();
        map.containsValue(runner);
        long t2 = System.currentTimeMillis();
        long delta = t2 - t1;
        System.out.println(delta);
        return delta;
    }

    public static long testMapRemovePerformance(Map<Integer, Runner> map) {
        System.out.println("Time consumed for " + map.getClass().getSimpleName() + " to remove " + map.size() + " objects");
        long t1 = System.currentTimeMillis();
        for (int i=0;i<map.size();i++){
            map.remove(i);
        }
        long t2 = System.currentTimeMillis();
        long delta = t2 - t1;
        System.out.println(delta);
        return delta;
    }
}
