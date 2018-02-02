package edu.neu.ccs.cs5010;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class CSVFileReaderTest {
    Candy candy1;
    Candy candy2;
    Candy candy3;
    Candy candy4;
    Candy candy5;
    Candy candy6;
    Candy candy7;
    Candy candy8;
    Candy candy9;
    Candy candy10;
    private CSVFileReader csvFileReader;
    @Test
    public void readFile() throws Exception {
        List testList =  new ArrayList();
        List realList = new ArrayList();
        realList.add("Super Size Twix");
        realList.add("Snickers");
        realList.add("King Size Hershey’s");
        realList.add("Kit Kat");
        realList.add("Fun Size Toblerone");
        realList.add("Almond Joy");
        realList.add("King Size Baby Ruth");
        realList.add("Super Size Milky Way");
        realList.add("King Size Mars");
        realList.add("Crunch");

        csvFileReader = new CSVFileReader();
        testList = csvFileReader.readFile("DreamCandy2.csv");
        assertEquals(testList,realList);
    }

    @Test
    public void matchCandy() throws Exception {
        candy1 = new Candy("super size","twix");
        candy2 = new Candy("regular","snickers");
        candy3 = new Candy("king size","hershey's");
        candy4 = new Candy("regular","kit kat");
        candy5 = new Candy("fun size","toblerone");
        candy6 = new Candy("regular","almond joy");
        candy7 = new Candy("king size","baby ruth");
        candy8 = new Candy("super size","milky way");
        candy9 = new Candy("king size","mars");
        candy10 = new Candy("regular","crunch");

        List test2 = new ArrayList();
        List realList2= new ArrayList();

        csvFileReader = new CSVFileReader();
        List testmatch = new ArrayList();
        testmatch = csvFileReader.readFile("DreamCandy2.csv");
        test2 = csvFileReader.matchCandy(testmatch);
        realList2.add(candy1);
        realList2.add(candy2);
        realList2.add(candy3);
        realList2.add(candy4);
        realList2.add(candy5);
        realList2.add(candy6);
        realList2.add(candy7);
        realList2.add(candy8);
        realList2.add(candy9);
        realList2.add(candy10);

        for(int i = 0;i<10;i++) {
            System.out.println(test2.get(i));
            System.out.println(realList2.get(i));
            System.out.println("\n");

            assertEquals(test2.get(i).equals(realList2.get(i)), false);
        }


    }

    @Test
    public void checkList() throws Exception {
        assertEquals(true,csvFileReader.checkList("DreamCandy1.csv"));
        assertEquals(false,csvFileReader.checkList("DreamCandy2.csv"));
    }

}