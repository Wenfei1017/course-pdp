package edu.neu.ccs.cs5010;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * The type Followed graph.
 */
public class FollowedGraph implements IGraph {
    private int usersNum;
    private int edgesNum;
    private UserVertex[] vertexNodeList;

    /**
     * Create followed graph.
     *
     * @param userList user array generated in GetUserInfo class getInfo method.
     * @param edge     edge List generated in GetUserInfo class getEdge method.
     * @throws IOException this method generates the graph contains the information about who follows each user/each user followed by who
     */
    public void createFollowedGraph(Users[] userList,List<int[]> edge) throws IOException {

        usersNum = userList.length;
        edgesNum = edge.size();

        vertexNodeList = new UserVertex[usersNum];
        //build the vertex list
        for(int i = 0; i < usersNum; i++) {
            vertexNodeList[i] = new UserVertex();
            vertexNodeList[i].user = userList[i];
            vertexNodeList[i].firstEdge = null;
        }

        //create adjacency list
        for(int i = 0; i < edgesNum; i++) {
            Edges edgeNode = new Edges();
            int follower = getIDNumber(edge.get(i)[0],userList);
            int followed = getIDNumber(edge.get(i)[1],userList);
            if(followed <= 0 || follower <= 0){continue;}
            /*get the position of the one to be folloed in the edge file*/

            edgeNode.adjVertexID = follower;
            edgeNode.next = vertexNodeList[followed-1].firstEdge;
            vertexNodeList[followed-1].firstEdge = edgeNode;
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
    public Users getVexElement(int element) throws Exception {
        return null;
    }

    /**
     * Get vetex list user vertex [ ].
     *
     * @return the user vertex [ ]
     */
    public UserVertex[] getVetexList() {
        UserVertex[] copy = vertexNodeList;
        return copy;
    }

    @Override
    public int firsrAdjVex(UserVertex userVertex) throws Exception {
        return userVertex.firstEdge.getadjVex();
    }

    @Override
    public int nextAdjVex(int vertex, int userId) throws Exception {
        return 0;
    }

    /**
     * Gets id number.
     *
     * @param idNum    the ID number of the user that this vertex include
     * @param userList the vertex list return by getInfo method in GetUserInfo class
     * @return return the edges position
     */
    public int getIDNumber(int idNum, Users[] userList) {
        for(int i = 0; i < usersNum; i++) {
            if(userList[i].getUsersID() == idNum) {
                return userList[i].getUsersID();
            }
        }
        return -1;
    }

    /**
     * print the graph built.
     */
    public void printGraph(){
        System.out.println("Graph:\n");
        for (int i = 0; i < usersNum; i++) {
            System.out.print(vertexNodeList[i].user.getUsersID() + "-->");
            if (vertexNodeList[i].firstEdge != null) {
                Edges mEdgeNode = vertexNodeList[i].firstEdge;
                System.out.print("[" + mEdgeNode.adjVertexID + "]" + " ");
                while (mEdgeNode.next != null) {
                    mEdgeNode = mEdgeNode.next;
                    System.out.print("[" + mEdgeNode.adjVertexID + "]" + " ");
                }
                System.out.print("\n");
            } else {
                System.out.print("\n");
            }
        }
    }

    /**
     * Count followers hash set.
     *
     * @param userVertex the user vertex
     * @return the list contains each users followers hashset
     */
    public HashSet<Integer> countFollowers(UserVertex userVertex){
        //use HashSet to count the followers because there are same followers ID follow some user in the file
        HashSet<Integer> followerSet = new HashSet<>();
            if(userVertex.firstEdge != null){
                 Edges mEdgeNode = userVertex.firstEdge;
                 followerSet.add(userVertex.getUserID());
                 while(mEdgeNode.next != null){
                     mEdgeNode = mEdgeNode.next;
                     if(followerSet.contains(mEdgeNode.getadjVex())){
                         continue;
                     }
                     followerSet.add(mEdgeNode.getadjVex());//add each followers into hashset
                 }
            }

            //System.out.println(userVertex.getUserID() + "---->" + followerSet);
        return followerSet;
    }

    /**
     * Getfollower list list.
     *
     * @param userVertex the vertex node which contains users information
     * @return folloers list of this user in this uservertex
     */
    public List<Integer> getfollowerList(UserVertex userVertex){
        List<Integer> list = new ArrayList(countFollowers(userVertex));
        return list;
    }
}
