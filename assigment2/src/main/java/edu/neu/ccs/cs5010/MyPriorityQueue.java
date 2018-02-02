package edu.neu.ccs.cs5010;
/**
 * created by xwenfei on 9/28
 */

import java.util.*;

public class MyPriorityQueue<E extends Comparable<E>>{

    public ArrayList<E> PQ;

    /**
     * Empty constructor
     */
    public MyPriorityQueue(){
        PQ = new ArrayList<E>();
    }

    /**
     * insert() inserts an patient in the queue.
     */
    public void insert(E e) {
        if (e == null) {
            throw new IllegalArgumentException("item to be inserted is null");
        } else {
            PQ.add(e);
            PQ.sort(new Comparator<E>(){
                public int compare(E e1, E e2) {
                    return e1.compareTo(e2);
                }
            });
        }
    }

    /**
     * @return the first item from the queue and remove it.  If the
     *  list is empty, do nothing.
     */
    public E remove(){
        if (PQ == null) {
            return null;
        }
        else{
            E removed = PQ.get(0);
            PQ.remove(0);
            return removed;
        }
    }

    /**
     * @return the first item from the queue.  If the
     *  list is empty, do nothing.
     */
    public E front(){
        if(PQ == null){
            return null;
        }else{
            return PQ.get(0);
        }
    }

    /**
     * @return if the queue is empty.  If the
     *  list is empty, return true, else return false.
     */
    public boolean isEmpty(){
        return PQ.isEmpty();
    }

    /**
     *
     * @return the priority list in forward order
     */
    public ArrayList testForwardTraversal(){
        if(PQ == null){
            throw new NoSuchElementException("the queue is empty");
        }else{
            return this.PQ;
        }

    }

    /**
     * @return the reversed priority
     */
    public  ArrayList testReverseTraversal()throws Exception{
        if(PQ == null){
            throw new NoSuchElementException("the queue is empty");
        }else{
            int num = PQ.size() - 1;
            ArrayList<E> reverseT = new ArrayList<E>();
            while(num >= 0){
                reverseT.add(PQ.get(num));
                num--;
            }
            return reverseT;
        }
    }
}

