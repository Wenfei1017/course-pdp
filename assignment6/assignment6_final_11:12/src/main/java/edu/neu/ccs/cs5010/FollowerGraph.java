package edu.neu.ccs.cs5010;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * The type Follower graph.
 */
public class FollowerGraph implements IGraph {
    private int usersNum;
    private int edgesNum;
    private UserVertex[] vertexNodeList;// vertex
    private static int sourse = 0;
    private static int destination = 1;


    /**
     * Create follower graph user vertex [ ].
     *
     * @param userList user list generated in GetUserInfo class getInfo method.
     * @param edge     edge List generated in GetUserInfo class getEdge method.
     * @return the user vertex [ ]
     * @throws IOException this method generated the graph which denote those users each user followed.
     */
//创建每个user follow哪些人的图并且返回头节点
    public UserVertex[] createFollowerGraph(Users[] userList,List<int[]> edge) throws IOException {
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
            int follower = getIDNumber(edge.get(i)[sourse],userList);
            int followed = getIDNumber(edge.get(i)[destination],userList);

            if(followed <= 0 || follower <= 0){continue;}

            edgeNode.adjVertexID = edge.get(i)[destination];
            edgeNode.next = vertexNodeList[follower-1].firstEdge;
            vertexNodeList[follower-1].firstEdge = edgeNode;
        }
        UserVertex[] copy = vertexNodeList;
        return copy;
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
    public Users getVexElement(UserVertex vertex) throws Exception {
        return vertex.user;
    }


    /**
     * Gets id number.
     *
     * @param idNum    the ID number of the user that this vertex include
     * @param userList the list return by getInfo method in GetUserInfo class
     * @return return the edges position
     */
    public int getIDNumber(int idNum, Users[] userList) {
        for(int i = 0; i < usersNum; i++) {
            if(userList[i].getUsersID() == idNum) {
                return idNum;
            }
        }
        return -1;
    }

    /**
     * print the graph built.
     */
    /*public void printGraph(){
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
    }*/

    /**
     * Count friends hash set.
     *
     * @param userVertex the user vertex
     * @return the list contains each users followers hashset
     */
    public HashSet<Integer> countFriends(UserVertex userVertex){

        //use HashSet to count the followers because there are same followers ID follow some user in the file
        HashSet<Integer> followerSet = new HashSet<>();
        if(userVertex.firstEdge != null){
            Edges mEdgeNode = userVertex.firstEdge;
            followerSet.add(mEdgeNode.adjVertexID);
            while(mEdgeNode.next != null){
                mEdgeNode = mEdgeNode.next;
                if(followerSet.contains(mEdgeNode.getadjVex())){
                    continue;
                }
                followerSet.add(mEdgeNode.getadjVex());//add each friends into hashset
            }
        }

        //System.out.println(userVertex.getUserID() + "---->" + followerSet);
        return followerSet;
    }

    /**
     * Get friend list list.
     *
     * @param userVertex this uservertex contains user's information
     * @return the friends of this user in this uservertex node
     */
    public List<Integer> getFriendList(UserVertex userVertex){

        List<Integer> list = new ArrayList(countFriends(userVertex));
        return list;

    }

}
