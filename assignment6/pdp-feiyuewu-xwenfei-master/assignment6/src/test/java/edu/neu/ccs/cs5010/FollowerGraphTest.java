package edu.neu.ccs.cs5010;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

public class  FollowerGraphTest {

	private FollowerGraph followerGraph = new FollowerGraph();
	GetUserInfo getTestInfo = new GetUserInfo();
	Users[] usersList = getTestInfo.getInfo("nodes_small.csv","s");
	List<int[]> edgeList = new ArrayList<>(getTestInfo.getEdge("edges_small.csv"));
	UserVertex[] userVertices = followerGraph.createFollowerGraph(usersList, edgeList);
	Users user1 = new Users(1,"1/1/09","F","22","Seattle");

	public FollowerGraphTest() throws IOException {

  }

	@Test
	public void createFollowedGraph() throws Exception {
		UserVertex[] t = followerGraph.createFollowerGraph(usersList, edgeList);
  }

	@Test
	public void getVexNum() throws Exception {
        assertEquals(100,followerGraph.getVexNum());
	}

	@Test
	public void getEdgeNum() throws Exception {
        assertEquals(1970,followerGraph.getEdgeNum());
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
		test.add(80);
		test.add(81);
		test.add(79);
		test.add(23);
		test.add(39);
		assertEquals(followerGraph.countFriends(userVertices[0]),test);
	}

	@Test
	public void getfollowerList() throws Exception {
		List<Integer> testList = new ArrayList<Integer>();
		List<Integer> test = new ArrayList<>();
		test = followerGraph.getFriendList(userVertices[0]);

		testList.add(80);
		testList.add(81);
		testList.add(79);
		testList.add(23);
		testList.add(39);

		Collections.sort(testList);
		Collections.sort(test);
		assertEquals(test,testList);
	}

}