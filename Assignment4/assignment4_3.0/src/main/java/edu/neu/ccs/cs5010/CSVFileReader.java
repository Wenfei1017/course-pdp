package edu.neu.ccs.cs5010;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVFileReader{
    Candy candy;
    List candyList;

    /**
     *
     * @param csvFile the dreamCandy file to be readed
     * @return the list form of candy children want
     * @throws FileNotFoundException if file can not be found
     */



    public String[] readFile(String csvFile) throws FileNotFoundException {
        String line;
        String[] dreamList = null;
        String seperator = new String(",");
        BufferedReader fileReader = new BufferedReader(new FileReader(csvFile));
        try {
            line = fileReader.readLine();
            dreamList = line.split(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            } return dreamList;
        }
    }

    /**
     *
     * @param candyList the list returned by readFile method
     * @param
     * @return
     */
    public List<Candy> matchCandy(String[] candyList){

        List dreamList = new ArrayList();
        String name = null;
        String size = null;

        for(String str:candyList){
            str = str.trim();
            str = str.toLowerCase();
            if(str.contains("size")){
                size = str.split("size")[0];
                name = str.split("size")[1];
                dreamList.add(new Candy(size,name));
            }else {
                dreamList.add(new Candy("regular",str));
            }
        }return dreamList;


    }

    /**
     *
     * @return true if the dream candy list is valid(all candy are there in the neignborhood)
     * @throws FileNotFoundException
     */
    public boolean checkList(List<Candy> dreamList) throws FileNotFoundException {
        String candyNameSet = Candy.candyNameSet.toString().toLowerCase();
        String candySizeSet = Candy.candySizeSet.toString().toLowerCase();
        for (Candy candy:dreamList){
            if(candyNameSet.toString().contains(candy.getCandyName()) &&
                    candySizeSet.toString().contains(candy.getCandySize())){
                    continue;
            }else {
                System.out.println("Invalid dreamlist");
                System.out.println(candy.getCandySize() + candy.getCandyName() + "can't be found in this neighborhood");
                return false;
            }
        }
        return true;
    }
}
