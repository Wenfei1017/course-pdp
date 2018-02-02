package edu.neu.ccs.cs5010;

import java.util.List;

public class Edges {

    public int adjVertex;//adjVertex is the vertex's user's ID number
    public Edges next;

    /*public Edges(UserVertex userVertex, Edges nextEdge){
        this.adjVertex = userVertex;
        this.next = nextEdge;
    }*/



    public void setAdjVex(int userVertex) {
        this.adjVertex = userVertex;
    }

    public void setNext(Edges edges) {
        this.next = edges;
    }

    public int getadjVex() {
        return this.adjVertex;
    }

    public Edges getNext() {
        return this.next;
    }
}
