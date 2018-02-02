package edu.neu.ccs.cs5010;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOnly {
    private static GetUserInfo getUserInfo = new GetUserInfo();

    private static List<UserVertex> testList = new ArrayList<>();;
    private static List<int[]> testarray = new ArrayList<>();
    UsersGraph usersGraph;

    public void test() throws IOException {
        //testList = getUserInfo.getInfo("nodes_small.csv");
        //System.out.println(testList);
        //testarray = getUserInfo.getEdge("edges_small.csv");
        //System.out.println(testarray);
        //usersGraph = new UsersGraph(testList,testarray);
    }
    public static void main(String[] args) throws IOException {
        testList = getUserInfo.getInfo("nodes_small.csv");
        testarray = getUserInfo.getEdge("edges_small.csv");
        UsersGraph usersGraph = new UsersGraph(testList,testarray);
        usersGraph.printGraph();
        //TestOnly testOnly = new TestOnly();
        //testOnly.test();
    }
}

