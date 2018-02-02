package edu.neu.ccs.cs5010;

import java.io.IOException;

public interface IGraph {
    //void createGraph(String nodeCsvFile,String edgeCsvFile) throws IOException;
    int getVexNum();// return vertex numbers in this graph
    int getEdgeNum();//return the edges number in this graph;
    Users getVexElement(int v) throws Exception;//return the users in this vertex
    int getLocate(UserVertex userVertex);// return the users position in this graph
    int firsrAdjVex(UserVertex userVertex) throws Exception; //return the first adjacent of this node
    int nextAdjVex(int V, int W) throws Exception;//return the next asjacent of V with w
}
