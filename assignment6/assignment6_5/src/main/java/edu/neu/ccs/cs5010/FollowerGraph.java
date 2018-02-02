package edu.neu.ccs.cs5010;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FollowerGraph implements IGraph {
    private int usersNum;
    private int edgesNum;
    private UserVertex[] vertexNodeList;// vertex
    private static int sourse = 0;
    private static int destination = 1;

    public FollowerGraph(){

    }

    /**
     *
     * @param userList user list generated in GetUserInfo class getInfo method.
     * @param edge edge List generated in GetUserInfo class getEdge method.
     * @throws IOException
     * this method generated the graph which denote those users each user followed.
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
        return vertexNodeList;
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


    //应该不能直接在这里返回list，可能返回的是空的list

    @Override
    public int firsrAdjVex(UserVertex userVertex) throws Exception {
        return userVertex.firstEdge.getadjVex();
    }

    @Override
    public int nextAdjVex(int V, int W) throws Exception {
        return 0;
    }

    /**
     *
     * @param IDNum the ID number of the user that this vertex include
     * @param userList the list return by getInfo method in GetUserInfo class
     * @return return the edges position
     */
    public int getIDNumber(int IDNum, Users[] userList) {
        for(int i = 0; i < usersNum; i++) {
            if(userList[i].getUsersID() == IDNum) {
                return IDNum;
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
                Edges mEdgeNode = new Edges();
                mEdgeNode = vertexNodeList[i].firstEdge;
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
     *
     * @return the list contains each users followers hashset
     */
     public HashSet<Integer> countFriends(UserVertex userVertex){
        //ID is the only mark of different users
        int ID = userVertex.getUserID();
        //use HashSet to count the followers because there are same followers ID follow some user in the file
        HashSet<Integer> followerSet = new HashSet<>();
        if(userVertex.firstEdge != null){
            Edges mEdgeNode = new Edges();
            mEdgeNode = userVertex.firstEdge;
            followerSet.add(userVertex.getUserID());
            while(mEdgeNode.next != null){
                mEdgeNode = mEdgeNode.next;
                if(followerSet.contains(mEdgeNode.getadjVex())){
                    continue;
                }
                followerSet.add(mEdgeNode.getadjVex());//add each friends into hashset
            }
        }

        System.out.println(userVertex.getUserID() + "---->" + followerSet);
        return followerSet;
    }


    /**
     *
     * @param userVertex this uservertex contains user's information
     * @return the friends of this user in this uservertex node
     */
    public List<Integer> getFriendList(UserVertex userVertex){
        List<Integer> list = new ArrayList(countFriends(userVertex));
        return list;
    }

}
