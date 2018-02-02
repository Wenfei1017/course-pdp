package edu.neu.ccs.cs5010;

import java.util.Map;

public interface IQueue<E> {
    void enqueue(Map.Entry mapEntry);
    E dequeue();
    boolean isEmpty();

}
