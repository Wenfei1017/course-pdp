package edu.neu.ccs.cs5010;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOnly {
    private static GetUserInfo getUserInfo = new GetUserInfo();

    private static Users[] testList;
    private static List<int[]> testarray = new ArrayList<>();
    private static FollowerGraph followerGraph = new FollowerGraph();
    private static FollowedGraph followedGraph = new FollowedGraph();
    private static UserVertex[] follower;
    private static UserVertex[] followed;


    public static void main(String[] args) throws IOException {
        testList = getUserInfo.getInfo("nodes_small.csv");
        testarray = getUserInfo.getEdge("edges_small.csv");

        followerGraph.createFollowerGraph(testList,testarray);
        followerGraph.printGraph();

        followedGraph.createFollowedGraph(testList,testarray);
        followedGraph.printGraph();

        //follower = followerGraph.getVetexList();
        //followed = followedGraph.getVetexList();

        /*for(int i = 0; i < testList.length; i++) {
            //UserVertex userVertex = new UserVertex();
            followerGraph.countFriends(testList[i]);
        }*/
        Recommend recommend1 = new Recommend();

    }
}

