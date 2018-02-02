package edu.neu.ccs.cs5010;

import java.io.FileNotFoundException;

public class MainTest {
    public static void main(String[] args) throws FileNotFoundException {
        CSVFileReader csvFileReader = new CSVFileReader();
        csvFileReader.readFile("DreamCandy1.csv");
        Candy candyBox = new Candy();
        //System.out.println(candyBox.candynameset);
        //candyName.iterator();
        //candySize.iterator();
        //System.out.println(candyBox.candysizeset);
        //System.out.println(candyBox.creatSize());
        //CSVFileReader readTest = new CSVFileReader();
        //readTest.readFile("DreamCandy1.csv");
        if(csvFileReader.checkList("DreamCandy1.csv")){
            System.out.println("Valid dream list");
        }
        //System.out.println();

        HouseHold houseHold = new HouseHold();
        houseHold.accept(new ChildVisitor());
    }
}
