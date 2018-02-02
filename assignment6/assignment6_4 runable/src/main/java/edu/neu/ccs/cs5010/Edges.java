package edu.neu.ccs.cs5010;

import java.util.List;

public class Edges {

    //public int adjVertex;//adjVertex is the vertex's user's ID number
    public int adjVertexID;
    public Edges next;

    /*public Edges(UserVertex userVertex, Edges nextEdge){
        this.adjVertex = userVertex;
        this.next = nextEdge;
    }*/



    public void setAdjVex(int userVertexID) {
        this.adjVertexID = userVertexID;
    }

    public void setNext(Edges edges) {
        this.next = edges;
    }

    public int getadjVex() {
        return this.adjVertexID;
    }

    public Edges getNext() {
        return this.next;
    }
}
