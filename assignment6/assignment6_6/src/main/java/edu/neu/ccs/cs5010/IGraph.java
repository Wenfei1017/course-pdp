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
    Users getVexElement(int vertex) throws Exception;//return the users in this vertex

    /**
     * Firsr adj vex int.
     *
     * @param userVertex the user vertex
     * @return the int
     * @throws Exception the exception
     */
    int firsrAdjVex(UserVertex userVertex) throws Exception; //return the first adjacent of this node

    /**
     * Next adj vex int.
     *
     * @param vertex the v
     * @param wage the w
     * @return the int
     * @throws Exception the exception
     */
    int nextAdjVex(int vertex, int wage) throws Exception;//return the next asjacent of V with w
}
