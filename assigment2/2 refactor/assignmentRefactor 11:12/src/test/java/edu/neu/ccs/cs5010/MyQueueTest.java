package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {
    MyQueue myQueue;
    @Before
    public void setUp() throws Exception {
        myQueue = new MyQueue();
    }

    @Test
    public void enqueue() throws Exception {
        myQueue.enqueue(3);
        myQueue.enqueue(5);
    }

    @Test
    public void dequeue() throws Exception {
        myQueue.dequeue();
    }

    @Test
    public void front() throws Exception {
        int front = myQueue.front();
        assertEquals(5,front);
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(false,myQueue.isEmpty());
    }

}