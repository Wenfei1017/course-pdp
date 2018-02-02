package edu.neu.ccs.cs5010;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * The type Recommendation system.
 */
public class RecommendationSystem {
    private GetUserInfo getUserInfo;
    private FollowerGraph followerGraph;
    private static Recommend recommend;
    private UserVertex[] userVertexList;
    private Users[] userList;
    private List<int[]> edges;
    private HashSet<Integer> newUserRecommend;
    private HashSet<Integer> friendOfFriend;
    private HashSet<Integer> influenceUser;
    private Queue<Users> queue;
    private static final int MINILEN = 4;
    private static final int RECOMMENDATIONS = 15;
    private static final int NUMBEROFUSERS = 100;
    private static final int FULLLEN = 6;
    private static final int MEDLEN = 5;
    private static final int TOP = 10;

    private List<Users> setRecommend1(UserVertex userVertex) throws IOException {
        newUserRecommend = new HashSet<>();
        recommend = new Recommend();
        newUserRecommend = recommend.findTheMostOne(userVertexList,userVertex);
        List<Users> recommendList = hashSetToUserArray(userList,newUserRecommend);
        return recommendList;
    }

    private List<Users> setRecommend2(UserVertex userVertex) throws IOException {
        friendOfFriend = new HashSet<>();
        recommend = new Recommend();
        friendOfFriend = recommend.friendOfFriend(userVertexList,userVertex);
        List<Users> recommendList = hashSetToUserArray(userList,friendOfFriend);
        return recommendList;
    }

    private List<Users> setRecommend3() throws IOException {
        influenceUser = new HashSet<>();
        recommend = new Recommend();
        influenceUser = recommend.followInfluencer(userVertexList);
        List<Users> recommendList = hashSetToUserArray(userList,influenceUser);
        return recommendList;
    }

//    private static Users setRecommend4(UserVertex[] userVertexList){
//        recommend = new Recommend();
//        return recommend.branchOut(userVertexList);
//    }
//

    /**
     *
     * @param userList the List generated in GetInfo class and contains all users information
     * @param set the hashset contains the user's ID(followers or friends set)
     * @return the users list
     */
    private static List<Users> hashSetToUserArray(Users[] userList, HashSet<Integer> set){

        List<Users> usersList = new ArrayList<>();

        List<Integer> userIDList = new ArrayList(new HashSet(set));
        for(int i = 0; i < userList.length; i++) {
            for (Integer idNum : userIDList) {
                if (idNum == userList[i].getUsersID()){
                    usersList.add(userList[i]);
                }
            }
        }
        //System.out.println(usersList);
        return usersList;
    }

    /**
     * Recommendaion.
     *
     * @param nodeFile       the file contains users information
     * @param edgeFile       edge csv file
     * @param outputDir      the output dir
     * @param processingFlag the processing flag
     * @param numberOfUsers  the number of users
     * @param recommendNum   the numbers of users shoule be recommend
     * @throws IOException the io exception
     */
    public void recommendaion(String nodeFile, String edgeFile, String outputDir, String processingFlag, int numberOfUsers, int recommendNum) throws IOException {
        HashMap<Integer,List<Integer>> recomendMap = new HashMap<>();
        queue = new PriorityQueue<>(TOP, new Comparator<Users>() {
            @Override
            public int compare(Users user1, Users user2) {
                return user1.getRecommendTimes() - user1.getRecommendTimes();
            }
        });
        getUserInfo = new GetUserInfo();
        try {
            userList = getUserInfo.getInfo(nodeFile, processingFlag);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        edges = getUserInfo.getEdge(edgeFile);
        followerGraph = new FollowerGraph();
        this.userVertexList = followerGraph.createFollowerGraph(userList,edges);

        for(int i = 0; i < userVertexList.length && i < numberOfUsers; i++){
            List<Integer> recomendList = new ArrayList<>();
            List<Users> recommendC = new ArrayList<>();
            List<Users> recommend1 = new ArrayList<>(setRecommend1(userVertexList[i]));
            List<Users> recommend2 = new ArrayList<>(setRecommend2(userVertexList[i]));
            List<Users> recommend3  = new ArrayList<>(setRecommend3());
            //Users user = setRecommend4();

            List<Integer> idList1 = new ArrayList<>();
            List<Integer> idList2 = new ArrayList<>();
            List<Integer> idList3 = new ArrayList<>();
            //transfer user list to ID list because we want to output users ID
            for(Users users: recommend1){
                idList1.add(users.getUsersID());
            }
            //transfer user list to ID list
            for(Users user: recommend2){
                idList2.add(user.getUsersID());
            }
            //transfer user list to ID list
            for(Users user: recommend3){
                idList3.add(user.getUsersID());
            }
            recomendList.addAll(idList1);
            recomendList.addAll(idList2);
            recomendList.addAll(idList3);
            recommendC.addAll(recommend1);
            recommendC.addAll(recommend2);
            recommendC.addAll(recommend3);
            if(recomendList.size() <= recommendNum){
                for(Users user : recommendC) {
                    user.increaseRecommendTimes();
                    check(user);
                }
                recomendMap.put(userVertexList[i].user.getUsersID(), recomendList);
                while(recomendMap.size() < recommendNum) {
                    Users newUser = recommend.branchOut(userVertexList);
                    if(!recomendMap.containsKey(newUser.getUsersID())){
                        newUser.increaseRecommendTimes();
                        check(newUser);
                        recomendMap.get(userVertexList[i].getUserID()).add(newUser.getUsersID());
                    }
                }
            }else {
                List<Users> subList = recommendC.subList(0,recommendNum);
                for(Users user : subList) {
                    user.increaseRecommendTimes();
                    check(user);
                }
                recomendMap.put(userVertexList[i].user.getUsersID(),recomendList.subList(0,recommendNum));
            }
        }
        GenerateFile generateFile = new GenerateFile();
        generateFile.writeFile(recomendMap, outputDir);
        output();
    }

    private void output() {
        System.out.println("Top ten most frequently recommended node IDs are :");
        while(!queue.isEmpty()) {
            Users user = queue.poll();
            System.out.println(user.getUsersID());
        }
    }

    private void check(Users user) {
        if(queue.size() < TOP) {
            queue.offer(user);
        }
        else if(queue.peek().getRecommendTimes() < user.getRecommendTimes()) {
            queue.poll();
            queue.offer(user);
        }
    }
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            String line;
            if((line = bufferedReader.readLine()) != null) {
                String[] inputs = line.split(" ");
                if(inputs.length < MINILEN) {
                    System.out.println("The input is invalid, some arguments are missing");
                    throw new IllegalArgumentException();
                }
                String file1 = inputs[0];
                String file2 = inputs[1];
                String outputDir = inputs[2];
                String processingFlag = inputs[3];
                int numberOfUsers = 0;
                int numberOfRec = 0;
                if(inputs.length == FULLLEN) {
                    numberOfUsers = Integer.parseInt(inputs[4]);
                    numberOfRec = Integer.parseInt(inputs[5]);
                }
                else if(inputs.length == MEDLEN) {
                    numberOfUsers = Integer.parseInt(inputs[4]);
                    numberOfRec = RECOMMENDATIONS;
                }
                else {
                    numberOfUsers = NUMBEROFUSERS;
                    numberOfRec = RECOMMENDATIONS;
                }
                RecommendationSystem recommendationSystem = new RecommendationSystem();
                recommendationSystem.recommendaion(file1,file2, outputDir, processingFlag, numberOfUsers, numberOfRec);
            }
            else {
                throw new NullPointerException();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //setRecommend1("nodes_small.csv","edges_small copy.csv");
        //setRecommend2("nodes_small.csv","edges_small copy.csv");
        //setRecommend3("nodes_small.csv","edges_small copy.csv");
    }


}
