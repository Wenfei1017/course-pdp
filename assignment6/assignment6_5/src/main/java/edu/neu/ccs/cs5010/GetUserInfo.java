package edu.neu.ccs.cs5010;

import java.io.BufferedReader;
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

    /**
     *
     * @param csvFile the file which store the information of each users
     * @return a list store the vertex as Listnode
     * @throws IOException
     */
    public Users[] getInfo(String csvFile) throws NumberFormatException, IOException {
        List<Users> usersList = new ArrayList<>();
        Users[] users = null;
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

            usersList.add(thisUser);
            }
            //transfer list to array here
            users = new Users[usersList.size()];
            for(int i = 0; i < usersList.size(); i++){
                users[i] = usersList.get(i);
            }
            return users;
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
        List<int[]> edge = new ArrayList<>();
        String[] edgeInfo = new String[2];
        int[] transfer;

        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line = null;
        if(csvFile == null){
            throw new IllegalArgumentException("Template file should not be null");
        }
        try{
            while((line= reader.readLine())!=null && line.length() > 0){

                edgeInfo = line.split(",");
                transfer = new int[2];
                transfer[0] = Integer.parseInt(edgeInfo[0]);
                transfer[1] = Integer.parseInt(edgeInfo[1]);
                //transfer the string array to integer array
                edge.add(transfer);
            }

        }catch (Exception e) {
            e.printStackTrace();

        }
        return edge;
    }
}
