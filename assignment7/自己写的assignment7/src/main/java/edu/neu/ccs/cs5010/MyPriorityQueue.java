package edu.neu.ccs.cs5010;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/**
 * A binary heap implementation of priority queue with generic type
 * @param <E> element of generic type
 */

public class MyPriorityQueue<E extends Comparable<E>> {
    private List<E> list= new ArrayList<>();

    public void insert(E e) {
        list.add(e);
        Comparator<E> comp = new Comparator<E>() {
            @Override
            public int compare(E e1, E e2) {
                return e1.compareTo(e2);
            }
        };
        Collections.sort(list, comp);
    }


    public E remove() {
        if (list.isEmpty()) {
            return null;
        }
        E e = list.get(0);
        list.remove(0);
        return e;
    }


    public E front() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }


    public boolean isEmpty() {
        return list.isEmpty();
    }


    public List<E> testForwardTraversal() {
        return list;
    }


    public List<E> testReverseTraversal() {
        List<E> res = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            res.add(list.get(i));
        }
        return res;
    }
}
