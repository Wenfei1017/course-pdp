package edu.neu.ccs.cs5010;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by xwenfei on 10/23/17.
 */
public class GenerateFile {

    /*public void createFileDir(String dirName) throws IOException {
        if(dirName == null){
            throw new IllegalArgumentException("Output direction name should not be null");
        }
        File newFile = new File(dirName);
        //newFile.createNewFile();
        if(newFile.mkdir()){
            System.out.println("Completed Recommend saved in " + dirName);
        }
        else{
            if(newFile.exists()){
                System.out.println(dirName + " already exists");
            } else{
                throw new IOException("Fail creating the folder " + dirName);
            }
        }
    }*/

    /**
     * Get the current candy list and file name, create the file.
     *
     * @param
     * @param dirName the fileName
     *
     * @throws IllegalArgumentException if file is not created successfully
     */
    public void writeFile(Users[] friendList, String dirName) throws IllegalArgumentException {
        if (dirName== null || friendList == null) {
            throw new IllegalArgumentException("filename and friendList should not be null");
        }
        java.io.FileWriter Writer = null;
        File OutFile = new File(dirName);
        OutFile.mkdir();

        try {
            Writer = new FileWriter(dirName);
            Writer.write("User's ID, Gender, Age, City\n");
            for (Users user: friendList) {
                Writer.write("Recomend ID" + " "+ user.getUsersID() + " ");
                Writer.write("Gender" + " " +  user.getGender() + " ");
                Writer.write("Age" + " " + user.getAge() + " ");
                Writer.write("City" + " " + user.getCity() + "\n");
            }
        } catch(IOException e) {
            e.getStackTrace();
        } finally {
            if (Writer != null) {
                try {
                    Writer.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        }
    }
}

