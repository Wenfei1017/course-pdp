package edu.neu.ccs.cs5010;

import java.io.IOException;
import java.util.List;

public class UsersGraph implements IGraph {
    private int usersNum;
    private int edgesNum;
    private UserVertex[] vertexNodeList;// vertex
    private List<UserVertex> userVertexList;
    private List<int[]> edge;

    public UsersGraph(UserVertex[] vertexNodeList,List<int[]> edge) {
        this.vertexNodeList = vertexNodeList;
        this.edge = edge;
    }

    @Override
    public void createGraph(String nodeCsvFile,String edgeCsvFile) throws IOException {
        GetUserInfo getUserInfo = new GetUserInfo();
        userVertexList = getUserInfo.getInfo(nodeCsvFile);
        edge = getUserInfo.getEdge(edgeCsvFile);
        usersNum = userVertexList.size();
        edgesNum = edge.size();

        vertexNodeList = new UserVertex[usersNum];
        //build the vertex list
        for(int i = 0; i < usersNum; i++) {
            vertexNodeList[i] = new UserVertex();
            vertexNodeList[i] = userVertexList.get(i);
            vertexNodeList[i].firstEdge = null;
        }

        //create adjacency list
        for(int i = 0; i < edgesNum; i++) {
            Edges edgeNode = new Edges();
            int sourse = getPosition(edge.get(i)[0],userVertexList);
            //int sourse = getPosition(edges[i][0],vertex);
            int destination = getPosition(edge.get(i)[1],userVertexList);

            edgeNode.adjVertex = edge.get(i)[1];
            edgeNode.next = vertexNodeList[sourse].firstEdge;
            vertexNodeList[sourse].firstEdge = edgeNode;
        }
    }
    @Override
    public int getVexNum() {
        return usersNum;
    }

    @Override
    public int getEdgeNum() {
        return edgesNum;
    }

    @Override
    public Users getVexElement(int v) throws Exception {
        return null;
    }

    @Override
    public int getLocate(UserVertex userVertex) {
        return 1;
    }

    @Override
    public int firsrAdjVex(UserVertex userVertex) throws Exception {
        return 0;
    }

    @Override
    public int nextAdjVex(int V, int W) throws Exception {
        return 0;
    }

    /**
     *
     * @param IDNum the ID number of the user that this vertex include
     * @param vertex the vertex list return by getInfo method in GetUserInfo class
     * @return return the edges position
     */
    public int getPosition(int IDNum, List<UserVertex> vertex) {
        for(int i = 0; i < usersNum; i++) {
            if(vertex.get(i).user.getUsersID() == IDNum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * print the graph built.
     */
    public void printGraph(){
        System.out.println("AdjList:\n");
        for (int i = 0; i < usersNum; i++) {
            System.out.print(vertexNodeList[i].user + "-->");
            if (vertexNodeList[i].firstEdge != null) {
                Edges mEdgeNode = new Edges();
                mEdgeNode = vertexNodeList[i].firstEdge;
                System.out.print(mEdgeNode.adjVertex);
                while (mEdgeNode.next != null) {
                    mEdgeNode = mEdgeNode.next;
                    System.out.print(mEdgeNode.adjVertex + " ");
                }
                System.out.print("\n");
            } else {
                System.out.print("\n");
            }
        }
    }
}
