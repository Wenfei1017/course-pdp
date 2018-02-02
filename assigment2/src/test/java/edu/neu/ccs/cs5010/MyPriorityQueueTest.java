package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xwenfei on 10/2/17.
 */
public class MyPriorityQueueTest {

    private MyPriorityQueue<Integer> pqueue;

    @Before
    public void setUp() throws Exception {
        MyPriorityQueue<Integer> pqueue = new MyPriorityQueue<Integer>();
    }

    @Test
    public void insert() throws Exception {
        MyPriorityQueue<Integer> pqueue = new MyPriorityQueue<Integer>();
        pqueue.insert(new Integer(1));
        pqueue.insert(new Integer(2));
        pqueue.insert(new Integer(3));
        pqueue.insert(new Integer(4));
    }

    @Test
    public void front() throws Exception {
        MyPriorityQueue<Integer> pqueue = new MyPriorityQueue<Integer>();
        pqueue.insert(new Integer(2));
        pqueue.insert(new Integer(4));
        pqueue.insert(new Integer(1));
        int testInt = pqueue.front();
        assertEquals(testInt, 1);
    }

    @Test
    public void remove() throws Exception {
        MyPriorityQueue<Integer> pqueue = new MyPriorityQueue<Integer>();
        pqueue.insert(new Integer(3));
        pqueue.insert(new Integer(5));
        pqueue.insert(new Integer(7));
        pqueue.remove();
        assertEquals((int) pqueue.front(), 5);
    }

    @Test
    public void isEmpty() throws Exception {
        MyPriorityQueue<Integer> pqueue = new MyPriorityQueue<Integer>();
        assertEquals(pqueue.isEmpty(), true);

        pqueue.insert(new Integer(3));
        assertEquals(pqueue.isEmpty(), false);

        pqueue.remove();
        assertEquals(pqueue.isEmpty(), true);
    }

    @Test
    public void testForwardTraversal() throws Exception {
        MyPriorityQueue<Integer> pqueue = new MyPriorityQueue<Integer>();
        pqueue.insert(new Integer(4));
        pqueue.insert(new Integer(2));
        pqueue.insert(new Integer(9));
        pqueue.insert(new Integer(7));

        List<Integer> forward;
        forward = pqueue.testForwardTraversal();
        Iterator<Integer> iter = forward.iterator();

        System.out.println("Forward traverse:");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Test
    public void testReverseTraversal() throws Exception {
        MyPriorityQueue<Integer> pqueue = new MyPriorityQueue<Integer>();
        pqueue.insert(new Integer(3));
        pqueue.insert(new Integer(0));
        pqueue.insert(new Integer(7));
        pqueue.insert(new Integer(1));

        List<Integer> backward;
        backward = pqueue.testReverseTraversal();
        Iterator<Integer> iter = backward.iterator();

        System.out.println("Reverse traverse:");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }



}