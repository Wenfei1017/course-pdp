package edu.neu.ccs.cs5010;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVFileReader{
    List candyList;

    public List readFile(String csvFile) throws FileNotFoundException {
        String line;
        Candy candy;
        candyList = new ArrayList();
        //String[] candyList = null;
        BufferedReader fileReader = new BufferedReader(new FileReader(csvFile));
        Pattern candypattern = Pattern.compile(",");
        String[] info = null;
        //Matcher candyMatcher = candypattern.matcher(csvFile);
        try {
            line = fileReader.readLine();
            info = candypattern.split(line);
            //System.out.println(info);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fileReader != null){
                try{
                    fileReader.close();
                }catch(IOException e){
                    e.getStackTrace();
                }
            }
        }for(int i = 0; i< info.length;i++){
            candyList.add(info[i]);
        }//System.out.println(candyList);
        return candyList;
    }

    public boolean checkList(String csvFile) throws FileNotFoundException {
        Candy allCandy = new Candy();
        List candylist = new CSVFileReader().readFile(csvFile);
        boolean validOrNot = allCandy.candynameset.containsAll(candylist);
        return validOrNot;
    }
}
