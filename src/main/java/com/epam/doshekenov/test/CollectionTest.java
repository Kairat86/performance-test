package com.epam.doshekenov.test;

import com.epam.doshekenov.Runner;

import java.util.Collection;
import java.util.TreeSet;

public class CollectionTest {

    public static long testAddPerformance(Collection<Runner> collection, int iterationNum) {
        System.out.println("Time consumed for " + collection.getClass().getSimpleName() + " to add " + iterationNum + " objects (ms)");
        if (collection instanceof TreeSet) {
            return testTreeSetAddPerformance(collection, iterationNum);
        }
        long t1, t2;
        Runner e = new Runner();
        t1 = System.currentTimeMillis();
        for (int i = 0; i < iterationNum; i++) {
            e.setId(i);
            collection.add(e);
        }
        t2 = System.currentTimeMillis();
        long delta = t2 - t1;
        System.out.println(delta);
        return delta;
    }

    private static long testTreeSetAddPerformance(Collection<Runner> collection, int iterationNum) {
        Runner[] runner = new Runner[iterationNum];
        for (int i = 0; i < iterationNum; i++) {
            runner[i] = new Runner(i);
        }

        long t1 = System.currentTimeMillis();
        for (Runner runnerObj : runner) {
            collection.add(runnerObj);
        }
        long t2 = System.currentTimeMillis();
        long delta = t2 - t1;
        System.out.println(delta);
        return delta;
    }

    public static long testRemovePerformance(Collection<Runner> collection) {
        System.out.println("Time consumed for " + collection.getClass().getSimpleName() + " to remove " + collection.size() + " objects (ms)");
        long t1 = System.currentTimeMillis();
        collection.removeAll(collection);
        long t2 = System.currentTimeMillis();
        long delta = t2 - t1;
        System.out.println(delta);
        return delta;
    }


    private static long testContainsPerformance(Collection<Object> collection, int queryId, int iterationNum) {

        for (int i = 0; i < iterationNum * 10; i++) {
            collection.add(new Runner(i));
        }
        Runner objToFind = new Runner(queryId);
        long t1 = System.currentTimeMillis();
        collection.contains(objToFind);
        long t2 = System.currentTimeMillis();
        long delta = t2 - t1;

        return delta;
    }
}
