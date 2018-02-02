package edu.neu.ccis.cs5010.assignment7;

import org.junit.Before;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/19/17.
 */
public class LiftThreadTest {

    private LiftThread liftThread;
    private Queue<Integer> liftQueue;

    @Before
    public void setUp() throws Exception {
        liftQueue = new LinkedBlockingDeque<>();
        liftThread = new LiftThread(liftQueue);
    }

    @Test
    public void run() throws Exception {
        Thread thread = new Thread(liftThread);
        Long time = System.currentTimeMillis();
        thread.start();
        System.out.print("Concurrent Solution : " + (System.currentTimeMillis() - time) + " ms");

        for (int i = 0; i < 100; i++) {
            liftQueue.add(i);
        }
        for (int i = 1; i < 100; i += 2) {
            liftQueue.add(i);
        }
        thread = new Thread(liftThread);
        time = System.currentTimeMillis();
        thread.start();
        System.out.print("\nConcurrent Solution : " + (System.currentTimeMillis() - time) + " ms");
    }

}