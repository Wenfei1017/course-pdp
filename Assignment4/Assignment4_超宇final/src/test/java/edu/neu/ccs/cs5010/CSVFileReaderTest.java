package edu.neu.ccs.cs5010;

import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by wenfei on 10/22/17.
 */
public class CSVFileReaderTest {

    private CSVFileReader fileReader;

    @Test
    public void readFile() throws Exception {
        String fileName = new String("DreamCandy1.csv");
        fileReader = new CSVFileReader();
        String[] fileContent = fileReader.readFile(fileName);
        for (String str: fileContent) {
            str = str.trim();
            str = str.toLowerCase();
            if (!str.contains("size")){
                System.out.println("\n" + str + "\nthis is regular size\n");
            } else {
                System.out.println("\n" + str);
                System.out.println("size:" + str.split("size")[0].trim());
                System.out.println("name:" + str.split("size")[1].trim());
            }
            //System.out.println("$$" + str + "$$");
        }
    }

    @Test
    public void getDreamList() throws Exception {
        String fileName = new String("DreamCandy1.csv");
        fileReader = new CSVFileReader();
        String[] fileContent = fileReader.readFile(fileName);
        ArrayList<Candy> dreamList = fileReader.getDreamList(fileContent);

        //fileReader.printDreamList(dreamList);

        String candyNameSet = Candy.candyNameSet.toLowerCase();
        String candySizeSet = Candy.candySizeSet.toLowerCase();
        System.out.println(candyNameSet + "\n" + candySizeSet);

        if (fileReader.checkList(dreamList)) {
            fileReader.printDreamList(dreamList);
        } else {
            System.out.println("wrong format!");
        }

        Candy candyCola = new Candy("cola", "500ml");
        dreamList.add(candyCola);

        if (fileReader.checkList(dreamList)) {
            fileReader.printDreamList(dreamList);
        } else {
            System.out.println("wrong format!");
        }

    }

}