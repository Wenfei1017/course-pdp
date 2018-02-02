package edu.neu.ccs.cs5010;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by xwenfei on 10/23/17.
 */
public class GenerateFile {

    private static final  String HEADER = "Node ID, Recommended nodes";

    /**
     * Get the current candy list and file name, create the file.
     *
     * @param recomendMap the recomend map
     * @param dirName     the fileName
     * @throws IllegalArgumentException if file is not created successfully
     */
    public void writeFile(Map<Integer, List<Integer>> recomendMap, String dirName) throws IllegalArgumentException {
        if (dirName== null || recomendMap == null) {
            throw new IllegalArgumentException("filename and friendList should not be null");
        }
        //java.io.FileWriter Writer = null;
        File directory = new File(dirName);
        boolean res = directory.mkdir();
        if (!res)  {
            System.out.print("");
        }
        File outputFile = new File(directory.getPath(), "file3.csv");
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile.getPath()));
            writer.write(HEADER);
            writer.write("\n");
            Iterator<Map.Entry<Integer, List<Integer>>> iterator = recomendMap.entrySet().iterator();
            while(iterator.hasNext()) {
                StringBuffer stringBuffer = new StringBuffer();
                Map.Entry<Integer, List<Integer>> entry = iterator.next();
                int userID = entry.getKey();
                stringBuffer.append(userID + "        ");
                List<Integer> list = entry.getValue();
                for(int i=0; i<list.size(); i++) {
                    stringBuffer.append(list.get(i) + " ");
                }
                writer.write(stringBuffer.toString());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            Writer = new FileWriter(dirName);
//            Writer.write("User's ID, Gender, Age, City\n");
//            for (Users user: friendList) {
//                Writer.write("Recomend ID" + " "+ user.getUsersID() + " ");
//                Writer.write("Gender" + " " +  user.getGender() + " ");
//                Writer.write("Age" + " " + user.getAge() + " ");
//                Writer.write("City" + " " + user.getCity() + "\n");
//            }
//        } catch(IOException e) {
//            e.getStackTrace();
//        } finally {
//            if (Writer != null) {
//                try {
//                    Writer.close();
//                } catch (IOException e) {
//                    e.getStackTrace();
//                }
//            }
//        }
    }
}

