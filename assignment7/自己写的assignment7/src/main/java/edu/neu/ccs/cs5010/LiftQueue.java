package edu.neu.ccs.cs5010;

import java.util.*;

public class LiftQueue implements IQueue {
    private HashMap<String,String> map;
    private Deque<Map.Entry<String,String>> queue;

    public LiftQueue(HashMap<String,String> map) {
        this.map = map;
        queue = new LinkedList<>();

    }

    public void setQueue(HashMap<String,String> map){
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            HashMap.Entry pair = (Map.Entry)iterator.next();
            System.out.println(pair);
            enqueue(pair);
        }
    }
    @Override
    public void enqueue(Map.Entry mapEntry) {

    }

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
