package edu.neu.ccs.cs5010;

/**
 * The type Edges.
 */
public class Edges {

    /**
     * The Adj vertex id.
     */
//public int adjVertex;//adjVertex is the vertex's user's ID number
    public int adjVertexID;
    /**
     * The Next.
     */
    public Edges next;

    /*public Edges(UserVertex userVertex, Edges nextEdge){
        this.adjVertex = userVertex;
        this.next = nextEdge;
    }*/


    /**
     * Sets adj vex.
     *
     * @param userVertexID the user vertex id
     */
    public void setAdjVex(int userVertexID) {
        this.adjVertexID = userVertexID;
    }

    /**
     * Sets next.
     *
     * @param edges the edges
     */
    public void setNext(Edges edges) {
        this.next = edges;
    }

    /**
     * Gets vex.
     *
     * @return the vex
     */
    public int getadjVex() {
        return this.adjVertexID;
    }

    /**
     * Gets next.
     *
     * @return the next
     */
    public Edges getNext() {
        return this.next;
    }
}
