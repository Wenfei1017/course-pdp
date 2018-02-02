package edu.neu.ccs.cs5010;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Get user info.
 */
public class GetUserInfo {
    private final static int USERSID = 0;
    private final static int DATE = 1;
    private final static int GENDER = 2;
    private final static int USERSAGE = 3;
    private final static int CITY = 4;

    /**
     * Get info users [ ].
     *
     * @param csvFile        the file which store the information of each users
     * @param processingFlag the processing flag
     * @return a list store the vertex as Listnode
     * @throws NumberFormatException the number format exception
     * @throws IOException           the io exception
     */
    public Users[] getInfo(String csvFile, String processingFlag) throws NumberFormatException, IOException {
        List<Users> usersList = new ArrayList<>();
        Users[] users = null;
        String [] userInfo;
        String line;
        InputStream inputStream = new FileInputStream(csvFile);
        Reader rder = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader reader = new BufferedReader(rder);
        if(csvFile == null){
            throw new IllegalArgumentException("File should not be null");
        }
        try{
            while((line = reader.readLine()) != null && line.length() > 0){
            userInfo = line.split(",");
            //create a new user based on the information read
            int userID = Integer.parseInt(userInfo[USERSID]);
            Users thisUser = new Users(userID,userInfo[DATE],userInfo[GENDER],userInfo[USERSAGE],userInfo[CITY]);

            usersList.add(thisUser);
            }
            if(processingFlag.equals("e")) {
                Collections.reverse(usersList);
            }
            else if(processingFlag.equals("r")) {
                Collections.shuffle(usersList);
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
     * Gets edge.
     *
     * @param csvFile the file stores the edges information
     * @return a list stores the edges
     * @throws IOException the io exception
     */
    public List<int[]> getEdge(String csvFile) throws IOException {
        List<int[]> edge = new ArrayList<>();
        int[] transfer;
        InputStream inputStream = new FileInputStream(csvFile);
        Reader rder = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader reader = new BufferedReader(rder);
        String line = null;
        if(csvFile == null){
            throw new IllegalArgumentException("Template file should not be null");
        }
        try{
            while((line= reader.readLine())!=null && line.length() > 0){

                String[] edgeInfo = line.split(",");
                transfer = new int[2];
                transfer[0] = Integer.parseInt(edgeInfo[0]);
                transfer[1] = Integer.parseInt(edgeInfo[1]);
                //transfer the string array to integer array
                edge.add(transfer);
            }
            reader.close();
        }catch (Exception e) {
            e.printStackTrace();

        }
        return edge;
    }
}
