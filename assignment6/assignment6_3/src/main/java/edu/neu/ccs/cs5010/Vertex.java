package edu.neu.ccs.cs5010;

import java.util.List;

public interface Vertex<V> {
    V getElement();
    //List<Vertex<V>> setNext();
    Edges getNext();

}
