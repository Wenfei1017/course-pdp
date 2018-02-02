package edu.neu.ccs.cs5010;

/**
 * The interface Graph.
 */
public interface IGraph {

    /**
     * Gets vex num.
     *
     * @return the vex num
     */
    int getVexNum();// return vertex numbers in this graph

    /**
     * Gets edge num.
     *
     * @return the edge num
     */
    int getEdgeNum();//return the edges number in this graph;

    /**
     * Gets vex element.
     *
     * @param vertex the vertex
     * @return the vex element
     * @throws Exception the exception
     */
    Users getVexElement(UserVertex vertex) throws Exception;//return the users in this vertex

}
