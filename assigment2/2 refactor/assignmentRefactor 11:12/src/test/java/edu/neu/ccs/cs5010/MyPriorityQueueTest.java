package edu.neu.ccs.cs5010;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by xwenfei on 10/2/17.
 */
public class MyPriorityQueueTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private MyPriorityQueue<Integer> pQueue = new MyPriorityQueue<Integer>();

    @Test
    public void insert() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("item to be inserted is null");
        Integer nullInput = null;
        pQueue.insert(nullInput);

        pQueue.insert(new Integer(1));
        pQueue.insert(new Integer(2));
        pQueue.insert(new Integer(3));
        pQueue.insert(new Integer(4));
    }


    /*

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyPriorityQueue<?> that = (MyPriorityQueue<?>) o;

        return priorityQueue != null ? priorityQueue.equals(that.priorityQueue) : that.priorityQueue == null;
    }
    @Override
    public int hashCode() {
        return priorityQueue != null ? priorityQueue.hashCode() : 0;
    }
     */

    @Test
    public void equals() {

        MyPriorityQueue<Integer> pQueue2 = new MyPriorityQueue<Integer>();
        assertEquals(pQueue.equals(pQueue), true);
        assertEquals(pQueue.equals(pQueue2), true);
        assertEquals(pQueue.equals(null), false);
    }

    @Test
    public void hashCodeTest() throws Exception {
        assertEquals(pQueue.hashCode(), pQueue.hashCode());
    }

    @Test
    public void hashCodeTestException() throws Exception {
        thrown.expect(NullPointerException.class);
        MyPriorityQueue<Integer> pQueue2 = null;
        assertEquals(pQueue2.hashCode(), 0);
    }

    @Test
    public void front() {
        assertNull(pQueue.front());

        pQueue = new MyPriorityQueue<Integer>();
        pQueue.insert(new Integer(2));
        pQueue.insert(new Integer(4));
        pQueue.insert(new Integer(1));

        int testInt = pQueue.front();
        assertEquals(testInt, 1);
    }

    @Test
    public void remove() {
        assertNull(pQueue.remove());

        pQueue.insert(new Integer(3));
        pQueue.insert(new Integer(5));
        pQueue.insert(new Integer(7));
        pQueue.remove();
        assertEquals((int) pQueue.front(), 5);
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(pQueue.isEmpty(), true);

        pQueue.insert(new Integer(3));
        assertEquals(pQueue.isEmpty(), false);

        pQueue.remove();
        assertEquals(pQueue.isEmpty(), true);
    }

    @Test
    public void testForwardTraversalException() throws Exception {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("the queue is empty");
        pQueue.testForwardTraversal();
    }

    @Test
    public void testForwardTraversal() throws Exception {
        pQueue.insert(new Integer(4));
        pQueue.insert(new Integer(2));
        pQueue.insert(new Integer(9));
        pQueue.insert(new Integer(7));

        List<Integer> forward;
        forward = pQueue.testForwardTraversal();
        Iterator<Integer> iter = forward.iterator();

        System.out.println("Forward traverse:");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Test
    public void testReverseTraversalException() throws Exception {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("the queue is empty");
        pQueue.testReverseTraversal();
    }

    @Test
    public void testReverseTraversal() throws Exception {
        pQueue.insert(new Integer(3));
        pQueue.insert(new Integer(0));
        pQueue.insert(new Integer(7));
        pQueue.insert(new Integer(1));

        List<Integer> backward;
        backward = pQueue.testReverseTraversal();
        Iterator<Integer> iter = backward.iterator();

        System.out.println("Reverse traverse:");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }



}