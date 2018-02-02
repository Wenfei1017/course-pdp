package edu.neu.ccs.cs5010;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetUserInfo {
    private final static int usersID = 0;
    private final static int date = 1;
    private final static int gender = 2;
    private final static int usersage = 3;
    private final static int city = 4;
    //String[] readUsers;

    /**
     *
     * @param csvFile the file which store the information of each users
     * @return a list store the vertex as Listnode
     * @throws IOException
     */
    public UserVertex[] getInfo(String csvFile) throws NumberFormatException, IOException {
        List<UserVertex> vertex = new ArrayList<>();
        UserVertex[] vex;
        //Users[] users = null;
        String [] userInfo;
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        if(csvFile == null){
            throw new IllegalArgumentException("File should not be null");
        }
        try{
            while((line = reader.readLine()) != null && line.length() > 0){
            userInfo = line.split(",");
            //create a new user based on the information read
            int ID = Integer.parseInt(userInfo[usersID]);
            Users thisUser = new Users(ID,userInfo[date],userInfo[gender],userInfo[usersage],userInfo[city]);

            UserVertex thisVertex = new UserVertex();
            //create the user info for this vertex
            thisVertex.user = thisUser;
            vertex.add(thisVertex);
            }
            //transfer list to array here
            vex = new UserVertex[vertex.size()];
            for(int i = 0; i < vertex.size(); i++){
                vex[i] = vertex.get(i);
                //System.out.println(vex[i].getUser().getUsersID());
            }

            return vex;
        }finally {
            reader.close();

        }

    }

    /**
     *
     * @param csvFile the file stores the edges information
     * @return a list stores the edges
     * @throws IOException
     */
    public List<int[]> getEdge(String csvFile) throws IOException {
        //List<Edge> edges = new ArrayList<>();
        List<int[]> edge = new ArrayList<>();
        String[] edgeInfo = new String[2];
        int[] transfer;
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line = null;
        if(csvFile == null){
            throw new IllegalArgumentException("Template file should not be null");
        }
        try{
            while((line= reader.readLine())!=null && line.length() > 0){

                edgeInfo = line.split(",");
                //System.out.println(edgeInfo[0]);
                //System.out.println(edgeInfo[1]);
                transfer = new int[2];
                transfer[0] = Integer.parseInt(edgeInfo[0]);
                transfer[1] = Integer.parseInt(edgeInfo[1]);
                //transfer the string array to integer array
                edge.add(transfer);
            }

        }catch (Exception e) {
            e.printStackTrace();

        }//System.out.println(edge);
        return edge;

    }
}
