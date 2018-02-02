package edu.neu.ccs.cs5010;

import java.util.*;

/**
 *An abstract class that implements priority queue.
 *
 * @author wenfei
 *
 * @version 2.0
 */

public class MyPriorityQueue<E extends Comparable<E>> implements IPriorityQueue {
    public ArrayList<E> priorityQueue;

    /**
     * Empty constructor.
     */
    public MyPriorityQueue() {
        priorityQueue = new ArrayList<E>();
    }

    @Override
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

    /**
     * insert() inserts an patient in the queue.
     * @param  element  the item to be added to the priority queue
     */
    public void insert(E element) {
        if (element == null) {
            throw new IllegalArgumentException("item to be inserted is null");
        } else {
            priorityQueue.add(element);
            priorityQueue.sort(new Comparator<E>(){
                public int compare(E e1, E e2) {
                    return e1.compareTo(e2);
                }
            });
        }
    }

    /**
     * If queue is null return null.
     *
     * @return the first item from the queue and remove it
     */
    public E remove() {
        if (priorityQueue.size() == 0) {
            return null;
        } else {
            E removedElement = priorityQueue.get(0);
            priorityQueue.remove(0);
            return removedElement;
        }
    }

    /**
     * Get the first element of the queue in O(1) time.
     *
     * @return the first item from the queue
     */
    public E front() {
        if (priorityQueue.size() == 0) {
            return null;
        } else {
            return priorityQueue.get(0);
        }
    }

    /**
     * Check if the queue is empty.
     *
     * @return if the queue is empty
     */
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    /**
     * Used for test forward traversal.
     *
     * @return the priority list in forward order
     */
    public ArrayList testForwardTraversal() {
        if (priorityQueue.size() == 0) {
            throw new NoSuchElementException("the queue is empty");
        } else {
            return this.priorityQueue;
        }
    }

    /**
     * Used for test reverse traversal.
     *
     * @return the reversed priority
     */
    public  ArrayList testReverseTraversal() {
        if (priorityQueue.size() == 0) {
            throw new NoSuchElementException("the queue is empty");
        } else {
            int num = priorityQueue.size() - 1;
            ArrayList<E> reverseT = new ArrayList<E>();
            while (num >= 0) {
                reverseT.add(priorityQueue.get(num));
                num--;
            }
            return reverseT;
        }
    }

}

