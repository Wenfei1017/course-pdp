package edu.neu.ccs.cs5010;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

public class FollowedGraphTest {

    private FollowedGraph followedGraph = new FollowedGraph();
    GetUserInfo getTestInfo = new GetUserInfo();
    Users[] usersList = getTestInfo.getInfo("nodes_small.csv","s");
    List<int[]> edgeList = new ArrayList<>(getTestInfo.getEdge("edges_small.csv"));
    UserVertex[] userVertices = followedGraph.createFollowedGraph(usersList, edgeList);
    Users user1 = new Users(1,"1/1/09","F","22","Seattle");

    public FollowedGraphTest() throws IOException {

    }

    @Test
    public void createFollowedGraph() throws Exception {
        UserVertex[] t = followedGraph.createFollowedGraph(usersList, edgeList);
    }

    @Test
    public void getVexNum() throws Exception {
        assertEquals(100,followedGraph.getVexNum());
    }

    @Test
    public void getEdgeNum() throws Exception {
        assertEquals(1970,followedGraph.getEdgeNum());
    }

    @Test
    public void getVexElement() throws Exception {
        assertEquals(1,userVertices[0].user.getUsersID());

    }


    @Test
    public void printGraph() throws Exception {
    }

    @Test
    public void countFriends() throws Exception {
        HashSet<Integer> test = new HashSet<>();
        test.add(96);
        test.add(1);
        test.add(97);
        test.add(99);
        test.add(72);
        test.add(74);
        test.add(48);
        test.add(86);
        test.add(55);
        test.add(88);
        test.add(25);
        test.add(93);
        test.add(94);
        test.add(95);
        assertEquals(followedGraph.countFollowers(userVertices[0]),test);
    }

    @Test
    public void getfollowerList() throws Exception {
        List<Integer> testList = new ArrayList<Integer>();
        List<Integer> test = new ArrayList<>();
        test = followedGraph.getfollowerList(userVertices[0]);

        testList.add(96);
        testList.add(1);
        testList.add(97);
        testList.add(99);
        testList.add(72);
        testList.add(74);
        testList.add(48);
        testList.add(86);
        testList.add(55);
        testList.add(88);
        testList.add(25);
        testList.add(93);
        testList.add(94);
        testList.add(95);

        Collections.sort(testList);
        Collections.sort(test);
        assertEquals(test,testList);
    }

}