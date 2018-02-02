package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserVertexTest {
    GetUserInfo getUserInfo;
    Users[] users;
    List<int[]> edgeList;
    FollowerGraph followerGraph;
    UserVertex[] testVertexList;
    UserVertex userVertex;
    Users testUser;
    Users users1;
    @Before
    public void setUp() throws Exception {
        getUserInfo = new GetUserInfo();
        users = getUserInfo.getInfo("nodes_small.csv","");
        edgeList = getUserInfo.getEdge("edges_small.csv");
        followerGraph = new FollowerGraph();
        testVertexList = followerGraph.createFollowerGraph(users,edgeList);
        userVertex = new UserVertex();
        users1 = testVertexList[0].user;
        testUser = new Users(1,"1/1/09","F","22","Seattle");
    }

    @Test
    public void setUser() throws Exception {
        userVertex.setUser(userVertex.setUser(users1));
        assertEquals(users1.getUsersID(),testUser.getUsersID());
    }

    @Test
    public void getUserID() throws Exception {
        userVertex.user = users1;
        assertEquals(userVertex.getUserID(),1);
    }

    @Test
    public void getFirstEdge() throws Exception {
        Edges edges = new Edges();
        edges.adjVertexID = 1;
        userVertex.firstEdge = edges;
        assertEquals(userVertex.getFirstEdge(),edges);

    }

}