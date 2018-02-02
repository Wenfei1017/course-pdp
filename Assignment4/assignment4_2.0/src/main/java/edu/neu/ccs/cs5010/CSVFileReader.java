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

    Set<String> candynameset = Stream.of("Twix","Snikers","Mars","Kit Kat","Whoopers",
            "Milky Way","Toblerorn","Crunch","Baby Ruth","Almond Joy").collect(Collectors.toSet());

    Set<String> candysizeset = Stream.of("Super","King","Regular","Fun").collect(Collectors.toSet());

    public List<String> readFile(String csvFile) throws FileNotFoundException {
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

    /**
     *
     * @param candyList the list returned by readFile method
     * @param
     * @return
     */
    public List<Candy> matchCandy(List<String> candyList){
        Candy candy;
        List<Candy> finalCandy = new ArrayList<Candy>();
        StringBuilder sizebuild = null;
        StringBuilder namebuild = null;
        String candySize;
        String candyName;

        for(int i = 0;i<candyList.size();i++){
            String[] sizeCheck = candyList.get(i).split("\\s+");
            sizebuild = new StringBuilder();
            sizebuild.append(sizeCheck[0]);
            sizebuild.append(" ");
            sizebuild.append(sizeCheck[1]);
            candySize = sizebuild.toString();

            namebuild.append(sizeCheck[2]);
            candyName = namebuild.toString();

            candy = new Candy(candySize,candyName);

            finalCandy.add(candy);
            System.out.println(finalCandy);
        }return finalCandy;
    }

    /**
     *
     * @param csvFile
     * @return true if the dream candy list is valid(all candy are there in the neignborhood)
     * @throws FileNotFoundException
     */
    public boolean checkList(String csvFile) throws FileNotFoundException {

        List candylist = new CSVFileReader().readFile(csvFile);
        boolean validOrNot = candynameset.containsAll(candylist);
        return validOrNot;
    }
}
