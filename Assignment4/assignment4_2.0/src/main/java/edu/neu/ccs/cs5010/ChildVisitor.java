package edu.neu.ccs.cs5010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


/**
 *
 */
public class ChildVisitor implements Visitor {
    SearchTest searchTest;
    List childrenList; //the candy list returned by csvfilereader

    CSVFileReader csvFileReader;
    String csvFile; //children's list file(csv file)

    //Set<String> candynameset = Stream.of("Twix","Snikers","Mars","Kit Kat","Whoopers",
            //"Milky Way","Toblerorn","Crunch","Baby Ruth","Almond Joy").collect(Collectors.toSet());
    //Set<String> candysizeset = Stream.of("Super","King","Regular","Fun").collect(Collectors.toSet());

    public ChildVisitor(String csvFile) throws FileNotFoundException {
        this.csvFile = csvFile;
        childrenList = csvFileReader.matchCandy(csvFileReader.readFile(csvFile));
    }

    @Override
    //visit mansion house and find candy
    public void visit(Mansion mansion) throws FileNotFoundException {

        //childrenList = csvFileReader.readFile(csvFile);
        //searchTest = new SearchTest();
        searchTest.findCandy(mansion,childrenList);
    }

    @Override
    //vist detached house and find candy
    public void visit(DetachedHouse detachedHouse) throws FileNotFoundException {
        //childrenList = csvFileReader.readFile(dreamFile);
        //searchTest = new SearchTest();
        searchTest.findCandy(detachedHouse,childrenList);
    }

    @Override
    //visit duplexe house and find candy
    public void visit(Duplexe duplexe) throws FileNotFoundException {
        //childrenList = csvFileReader.readFile(dreamFile);
        //searchTest = new SearchTest();
        searchTest.findCandy(duplexe,childrenList);
    }

    @Override
    //visit town house and find candy
    public void visit(TownHome townHome) throws FileNotFoundException {
        //childrenList = csvFileReader.readFile(dreamFile);
        //searchTest = new SearchTest();
        searchTest.findCandy(townHome,childrenList);
    }

    @Override
    public void visit(HouseHold houseHold) throws FileNotFoundException {
    }
}
