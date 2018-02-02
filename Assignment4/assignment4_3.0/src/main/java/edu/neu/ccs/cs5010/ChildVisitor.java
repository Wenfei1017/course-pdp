package edu.neu.ccs.cs5010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class ChildVisitor implements Visitor {
    //SearchTest searchTest;
    public static List<Candy> dreamList; //the candy list returned by csvfilereader
    public static List<Candy> leftList;

    //CSVFileReader csvFileReader;
    //String csvFile; //children's list file(csv file)

    //Set<String> candynameset = Stream.of("Twix","Snikers","Mars","Kit Kat","Whoopers",
            //"Milky Way","Toblerorn","Crunch","Baby Ruth","Almond Joy").collect(Collectors.toSet());
    //Set<String> candysizeset = Stream.of("Super","King","Regular","Fun").collect(Collectors.toSet());

    //public ChildVisitor(String csvFile) throws FileNotFoundException {
        //this.csvFile = csvFile;

    //}

    public  List findCandy(House house, List candyList) throws FileNotFoundException {
        //candyList = new CSVFileReader().matchCandy();
        //set = new HashSet<>(house.getCandy());//transfer the candy list in specific house to set
        leftList = dreamList;
        for(Candy candy:dreamList){
            if(candyList.contains(dreamList)){//to check if the candy set contains the candy in the list
                leftList.remove(candy);//remove this candy in the dream list if found in house
                System.out.println(house.getHouseName());//print the house which find the candy
                System.out.println(candy.size + candy.name);
            }
        }return leftList;
    }

    @Override
    public void visit(HouseHold houseHold) throws FileNotFoundException {

    }

    @Override
    //visit mansion house and find candy
    public void visit(Mansion mansion) throws FileNotFoundException {

        //childrenList = csvFileReader.readFile(csvFile);
        //searchTest = new SearchTest();
        //searchTest.findCandy(mansion,childrenList);
        findCandy(mansion,mansion.mansionList);

    }

    @Override
    //vist detached house and find candy
    public void visit(DetachedHouse detachedHouse) throws FileNotFoundException {
        //childrenList = csvFileReader.readFile(dreamFile);
        //searchTest = new SearchTest();
        //searchTest.findCandy(detachedHouse,childrenList);
        findCandy(detachedHouse,detachedHouse.detachedList);
    }

    @Override
    //visit duplexe house and find candy
    public void visit(Duplexe duplexe) throws FileNotFoundException {
        //childrenList = csvFileReader.readFile(dreamFile);
        //searchTest = new SearchTest();
        //searchTest.findCandy(duplexe,childrenList);
        findCandy(duplexe,duplexe.duplexeList);
    }

    @Override
    //visit town house and find candy
    public void visit(TownHome townHome) throws FileNotFoundException {
        //childrenList = csvFileReader.readFile(dreamFile);
        //searchTest = new SearchTest();
        //searchTest.findCandy(townHome,childrenList);
        findCandy(townHome,townHome.townhomeList);
    }


}
