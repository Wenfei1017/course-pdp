package edu.neu.ccs.cs5010;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Recommend {
    private FollowedGraph followedGraph;
    private FollowerGraph followerGraph;
    private GetUserInfo getUserInfo;
    private UserVertex[] usersList;//通过getUserInfo传递

    //每个用户follow的人有哪些，从follow的人中找出friends最多的user并进行推荐

    /**
     *
     * @param followerList generated in FollowerGraph, it's the uservetex node in graph
     * @param userVertex we want to get the friend list of the user in this uservertex
     * @return the list contains the largest amount of friends of user's friends in this uservertex
     * @throws IOException
     */
    public HashSet<Integer> findTheMostOne(UserVertex[] followerList,UserVertex userVertex) throws IOException {
        HashSet<Integer> largestNumSet = new HashSet<>();

        List<Integer> friendList = new ArrayList<>();

        followerGraph = new FollowerGraph();

        friendList = followerGraph.getFriendList(userVertex);//ID list of friends of this userVertex

        for(int i = 0; i < friendList.size(); i++) {

            int largestFriends = 0;
            int friendID = friendList.get(i);
            UserVertex thisUser = followerList[friendID-1];
            int friendsNum = followerGraph.countFriends(thisUser).size();

            if(friendsNum > largestFriends) {
                largestFriends = friendsNum;
                largestNumSet = followerGraph.countFriends(thisUser);
            }
        }
        return largestNumSet;
    }

    /**
     *
     * @param followerList generated in FollowerGraph, it's the uservetex node in graph
     * @param userVertex we want to get the friend list of the user in this uservertex
     * @return the heshset contains all the friends of this user's friends
     */
    public HashSet<Integer> friendOfFriend(UserVertex[] followerList,UserVertex userVertex){
        HashSet<Integer> friendOfFriend = new HashSet<>();
        List<Integer> friendList = new ArrayList<>();
        followerGraph = new FollowerGraph();
        friendList = followerGraph.getFriendList(userVertex);
        HashSet<Integer> friendSet = new HashSet<>();

        for(int i = 0; i < friendList.size(); i++){
            UserVertex thisUser = followerList[userVertex.getUserID()-1];
            friendSet = followerGraph.countFriends(thisUser);
            friendOfFriend.addAll(friendList);
        }
        return friendOfFriend;
    }

    public HashSet<Integer> followInfluencer(UserVertex[] followerList){
        HashSet<Integer> influenceSet = new HashSet<>();
        HashSet<Integer> friendSet;
        followedGraph = new FollowedGraph();
        for(int i = 0; i< followerList.length; i++){
            friendSet = new HashSet<>();
            friendSet = followedGraph.countFollowers(followerList[i]);
            if(friendSet.size() >= 15){
                //System.out.println("true");
                influenceSet.add(followerList[i].getUserID());
            }
            //else System.out.println("false");
        }
        //System.out.println(influenceSet);
        return influenceSet;
    }

    /*public HashSet<Integer> branchOut(){

    }*/
}
