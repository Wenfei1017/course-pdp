package edu.neu.ccs.cs5010;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class RecommendationSystem {
    private static GetUserInfo getUserInfo;
    private static FollowerGraph followerGraph;
    private static Recommend recommend;
    private static UserVertex[] userVertexList;
    private static Users[] userList;
    private static List<int[]> edges;
    private static HashSet<Integer> newUserRecommend;
    private static HashSet<Integer> friendOfFriend;
    private static HashSet<Integer> influenceUser;

    public static void setRecommend(String nodeFile, String edgeFile) throws IOException {
        newUserRecommend = new HashSet<>();
        friendOfFriend = new HashSet<>();
        influenceUser = new HashSet<>();
        getUserInfo = new GetUserInfo();
        userList = getUserInfo.getInfo(nodeFile);
        edges = getUserInfo.getEdge(edgeFile);
        followerGraph = new FollowerGraph();
        userVertexList = followerGraph.createFollowerGraph(userList,edges);
        recommend = new Recommend();

        for(int i = 0; i< userVertexList.length; i++){
            System.out.println(recommend.findTheMostOne(userVertexList,userVertexList[i]));
        }
    }

    public static void main(String[] args) throws IOException {
        setRecommend("nodes_small.csv","edges_small copy.csv");
    }
}
