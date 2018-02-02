package edu.neu.ccis.cs5010.assignment7;

import org.junit.Before;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * Created by wenfei on 11/19/17.
 */
public class HourThreadTest {

    private HourThread hourThread;
    Queue<int[]> hourQueue;

    @Before
    public void setUp() throws Exception {
        hourQueue = new LinkedBlockingDeque<>();
        hourThread = new HourThread(hourQueue);
    }

    @Test
    public void run() throws Exception {
        Thread thread = new Thread(hourThread);
        Long time = System.currentTimeMillis();
        thread.start();
        System.out.print("Concurrent Solution : " + (System.currentTimeMillis() - time) + " ms");

        for (int i = 0, j = 2; i < 100; i++) {
            int[] testArray = new int[]{i, i * j + j};
            hourQueue.add(testArray);
        }
        hourQueue.add(new int[] {0, 2});
        thread = new Thread(hourThread);
        time = System.currentTimeMillis();
        thread.start();
        System.out.print("\nConcurrent Solution : " + (System.currentTimeMillis() - time) + " ms");
    }

}