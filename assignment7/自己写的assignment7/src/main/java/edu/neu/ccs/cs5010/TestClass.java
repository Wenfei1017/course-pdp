package edu.neu.ccs.cs5010;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestClass {
    private SkierInfo skierInfo;
    private ReadCSVFile readCSVFile;

    public void testOnly(String fileName) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();

        readCSVFile = new ReadCSVFile(fileName);

        map = readCSVFile.getTotalVerticalforEachID(readCSVFile.readInfoFromFile(fileName));

        List<Map.Entry<String, Integer>> list = readCSVFile.sortByValue(map);
        Iterator<Map.Entry<String, Integer>> iterator = list.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            //System.out.println(entry.getKey() + " " + entry.getValue());

            //System.out.println("yes");

            }
        SkierQueue skierQueue = new SkierQueue(map);
        skierQueue.setQueue(map);
        while(!skierQueue.isEmpty()) {
            //System.out.println("yes");
            System.out.println(skierQueue.dequeue());
        }
    }


    public static void main(String[] args) throws IOException {
        TestClass testClass = new TestClass();
        testClass.testOnly("PDPAssignment.csv");
    }
}

