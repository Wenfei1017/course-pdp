package edu.neu.ccs.cs5010;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * The type Recommend.
 */
public class Recommend {
    private FollowedGraph followedGraph;
    private FollowerGraph followerGraph;


    /**
     * Find the most one hash set.
     *
     * @param userVertexList generated in FollowerGraph, it's the uservetex node in graph
     * @param userVertex     we want to get the friend list of the user in this uservertex
     * @return the list contains the largest amount of friends of user's friends in this uservertex
     * @throws IOException the io exception
     */
    public HashSet<Integer> findTheMostOne(UserVertex[] userVertexList,UserVertex userVertex) throws IOException {
        HashSet<Integer> largestNumSet = new HashSet<>();

        followerGraph = new FollowerGraph();

        List<Integer> friendList = followerGraph.getFriendList(userVertex);//ID list of friends of this userVertex

        for(int i = 0; i < friendList.size(); i++) {

            int largestFriends = 0;
            int friendsNum = followerGraph.countFriends(userVertex).size();

            if(friendsNum > largestFriends) {
                largestNumSet = followerGraph.countFriends(userVertex);
            }
        }
        return largestNumSet;
    }

    /**
     * Friend of friend hash set.
     *
     * @param userVertexList generated in FollowerGraph, it's the uservetex node in graph
     * @param userVertex     we want to get the friend list of the user in this uservertex
     * @return the heshset contains all the friends of this user's friends
     */
    public HashSet<Integer> friendOfFriend(UserVertex[] userVertexList,UserVertex userVertex){
        HashSet<Integer> friendOfFriend = new HashSet<>();
        followerGraph = new FollowerGraph();
        List<Integer> friendList = followerGraph.getFriendList(userVertex);
        for(int i = 0; i < friendList.size(); i++){
            friendOfFriend.addAll(friendList);
        }
        return friendOfFriend;
    }

    /**
     * Follow influencer hash set.
     *
     * @param userVertexList the user vertex list
     * @return the hash set
     */
    public HashSet<Integer> followInfluencer(UserVertex[] userVertexList){
        HashSet<Integer> influenceSet = new HashSet<>();
        HashSet<Integer> friendSet;
        followedGraph = new FollowedGraph();
        for(int i = 0; i< userVertexList.length; i++){
            friendSet = followedGraph.countFollowers(userVertexList[i]);
            if(friendSet.size()/userVertexList.length >= 0.025){
                //System.out.println("true");
                influenceSet.add(userVertexList[i].getUserID());
            }
        }
        return influenceSet;
    }

    /**
     * Branch out users.
     *
     * @param userVertexList the user vertex list
     * @return the users
     */
    public Users branchOut(UserVertex[] userVertexList){
        Random random = new Random();
        return userVertexList[random.nextInt(userVertexList.length-1)].user;
    }
}
