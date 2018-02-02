package edu.neu.ccis.cs5010.assignment7;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/19/17.
 */
public class SkierThreadTest {
    
    private SkierThread skierThread;
    private Queue<int[]> skierQueue;
    
    @Before
    public void setUp() throws Exception {
        skierQueue = new LinkedBlockingDeque<>();
        skierThread = new SkierThread(skierQueue);
    }

    @Test
    public void run() throws Exception {
        Thread thread = new Thread(skierThread);
        Long time = System.currentTimeMillis();
        thread.start();
        System.out.print("Concurrent Solution : " + (System.currentTimeMillis() - time) + " ms");

        for (int i = 1, j = 1; i < 100; i++, j++) {
            int[] array = new int[]{i * i, i * j + 2};
            skierQueue.add(array);
        }
        for (int i = 1, j = 1; i < 100; i += 2, j += 2) {
            int[] array = new int[]{i * i, i * j + 2};
            skierQueue.add(array);
        }
        thread = new Thread(skierThread);
        time = System.currentTimeMillis();
        thread.start();
        System.out.print("\nConcurrent Solution : " + (System.currentTimeMillis() - time) + " ms");
    }

}