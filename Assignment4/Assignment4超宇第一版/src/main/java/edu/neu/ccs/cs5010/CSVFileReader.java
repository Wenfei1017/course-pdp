package edu.neu.ccs.cs5010;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileReader{
    public static final int nameIndex = 0;
    public static final int sizeIndex = 1;

    /**
     * Read file and store the line in String[] using separator ",".
     *
     * @param fileName the fileName
     * @return the String array of the file
     * @throws FileNotFoundException if file can not be found
     */
    public String[] readFile(String fileName) throws FileNotFoundException {
        String line;
        String[] dreamList = null;
        String separator = new String(",");
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        try {
            line = fileReader.readLine();
            dreamList = line.split(separator);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
            return dreamList;
        }
    }

    /**
     * From the file reader, get the child's dreamList in lower case.
     *
     * @param fileContent the line read from the file
     * @return the child's dream arraylist
     */
    public ArrayList<Candy> getDreamList(String[] fileContent){
        ArrayList<Candy> dreamList = new ArrayList<>();
        String name = null;
        String size = null;

        for (String str: fileContent) {
            str = str.trim();
            str = str.toLowerCase();
            if (!str.contains("size")) {
                dreamList.add(new Candy(str, "regular"));
            } else {
                name = str.split("size")[sizeIndex].trim();
                size = str.split("size")[nameIndex].trim();
                dreamList.add(new Candy(name, size));
            }
        }
        return dreamList;
    }

    /**
     * Given the child's dream list, print the dream list.
     *
     * @param dreamList the line read from the file
     */
    public void printDreamList(ArrayList<Candy> dreamList){
        for (Candy candy: dreamList) {
            candy.printCandy();
        }
    }

    /**
     * Check whether the dreamList is illegal.
     *
     * @param dreamList child's dreamList
     * @return the child's dream arraylist
     */
    public boolean checkList(ArrayList<Candy> dreamList){
        String candyNameSet = Candy.candyNameSet.toLowerCase();
        String candySizeSet = Candy.candySizeSet.toLowerCase();
        for (Candy candy: dreamList) {
            if (candyNameSet.contains(candy.getCandyName()) && candySizeSet.contains(candy.getCandySize())) {
                continue;
            } else {
                System.out.println("\nInvalid candy type: ");
                System.out.println("name: " + candy.getCandyName() + "\nsize: " + candy.getCandySize());
                return false;
            }
        }
        return true;
    }
}
