package edu.neu.ccs.cs5010;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    public static void setRecommend1(String nodeFile, String edgeFile) throws IOException {
        newUserRecommend = new HashSet<>();
        getUserInfo = new GetUserInfo();
        userList = getUserInfo.getInfo(nodeFile);
        edges = getUserInfo.getEdge(edgeFile);
        followerGraph = new FollowerGraph();
        userVertexList = followerGraph.createFollowerGraph(userList,edges);
        recommend = new Recommend();

        for(int i = 0; i< userVertexList.length; i++) {
            newUserRecommend = recommend.findTheMostOne(userVertexList,userVertexList[i]);
            Users[] recomendArray = hashSetToUserArray(userList,newUserRecommend);
            //System.out.println(newUserRecommend);
            GenerateFile generateFile = new GenerateFile();
            generateFile.writeFile(recomendArray,"recommend1" + " " + userVertexList[i].getUserID());

        }
    }

    public static void setRecommend2(String nodeFile, String edgeFile) throws IOException {
        friendOfFriend = new HashSet<>();
        getUserInfo = new GetUserInfo();
        userList = getUserInfo.getInfo(nodeFile);
        edges = getUserInfo.getEdge(edgeFile);
        followerGraph = new FollowerGraph();
        userVertexList = followerGraph.createFollowerGraph(userList,edges);
        recommend = new Recommend();

        for(int i = 0; i < userVertexList.length; i++){
            friendOfFriend = recommend.friendOfFriend(userVertexList,userVertexList[i]);
            Users[] friendOfFriendArray = hashSetToUserArray(userList,friendOfFriend);
            GenerateFile generateFile = new GenerateFile();
            generateFile.writeFile(friendOfFriendArray,"recommend2" + " " + userVertexList[i].getUserID());
        }
    }

    public static void setRecommend3(String nodeFile, String edgeFile) throws IOException {
        influenceUser = new HashSet<>();
        getUserInfo = new GetUserInfo();
        userList = getUserInfo.getInfo(nodeFile);
        edges = getUserInfo.getEdge(edgeFile);
        followerGraph = new FollowerGraph();
        userVertexList = followerGraph.createFollowerGraph(userList,edges);
        recommend = new Recommend();

        for(int i = 0; i < userVertexList.length; i++){
            influenceUser = recommend.followInfluencer(userVertexList);
            Users[] influenceArray = hashSetToUserArray(userList,influenceUser);
            GenerateFile generateFile = new GenerateFile();
            //generateFile.createFileDir("testFile");
            //FileWriter fileWriter = new FileWriter("testFile");
            generateFile.writeFile(influenceArray,"testFile");
        }
    }


    public static Users[] hashSetToUserArray(Users[] userList, HashSet<Integer> set){

        Users[] userArray = new Users[set.size()];
        int j = 0;

        List<Integer> userIDList = new ArrayList(new HashSet(set));
        for(int i = 0; i < userList.length; i++) {
            for (Integer IDnum : userIDList) {
                if (IDnum == userList[i].getUsersID()){
                    userArray[j] = userList[i];
                    j ++;
                }
            }
        }
        System.out.println(userArray);
        return userArray;
    }

    public static void main(String[] args) throws IOException {
        //setRecommend1("nodes_small.csv","edges_small copy.csv");
        //setRecommend2("nodes_small.csv","edges_small copy.csv");
        setRecommend3("nodes_small.csv","edges_small copy.csv");
    }


}
