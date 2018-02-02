package edu.neu.ccs.cs5010.Assignment8;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/27/17.
 */
public class ReadersWritersTest {

    private ReadersWriters readersWriters;
    private BlockingQueue<int[]> queryQueue;
    private Database[] databases;

    @Before
    public void setUp() throws Exception {
        queryQueue = new LinkedBlockingDeque<>();
        //queryQueue.add(new int[]{1,2});
        databases = new Database[10];
        readersWriters = new ReadersWriters(2, queryQueue, databases);
    }

    @Test
    public void getId() throws Exception {
        assertEquals(readersWriters.getId(), 2);
    }

    @Test
    public void run() throws Exception {
        readersWriters.run();
    }

}