package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GetUserInfoTest {
    private GetUserInfo getUserInfo;
    private List<UserVertex> userList;
    private List<int[]> edgeList;
    private Users users1;
    private Users users2;
    private Users users3;
    private Edges edges1;
    private Edges edges2;
    private Edges edges3;
    @Before
    public void setUp() throws Exception {
        getUserInfo = new GetUserInfo();
    }

    @Test
    public void getInfo() throws Exception {
        users1 = new Users(1,"1/1/09","F","22","Seattle");
        users2 = new Users(35,"11/24/2011","0","18","Frankfurt");
        users3 = new Users(87,"7/23/2016","M","14","Washington");
        userList = getUserInfo.getInfo("nodes_small.csv");
        assertEquals(users1, userList.get(1).user);
        assertEquals(users2, userList.get(35).user);
        assertEquals(users3, userList.get(87).user);
    }

    @Test
    public void getEdge() throws Exception {
        edges1 = new Edges();
        edgeList = getUserInfo.getEdge("edges_small.csv");
    }

}