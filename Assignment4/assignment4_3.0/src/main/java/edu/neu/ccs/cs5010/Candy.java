package edu.neu.ccs.cs5010;

import java.util.HashSet;
import java.lang.String;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Candy{
    public static Set<String> candyNameSet = Stream.of("Twix","Snikers","Mars","Kit Kat","Whoopers",
            "Milky Way","Toblerorn","Crunch","Baby Ruth","Almond Joy").collect(Collectors.toSet());

    public static Set<String> candySizeSet = Stream.of("Super","King","Regular","Fun").collect(Collectors.toSet());

    String name;
    String size;
    String house;

    //private Set<String> getAllCandyName;
    /*public Candy(String size,String name){
        this.size = size;
        this.name = name;
    }*/


    public String getCandyName(){
        return this.name;
    }

    public String getCandySize(){
        return this.size;
    }

    public String getCandyHouse(){
        return this.house;
    }

    public void setCandyHouse(String house){
        this.house = house;
    }



    //Set<String> candynameset = Stream.of("Twix","Snikers","Mars","Kit Kat","Whoopers",
            //"Milky Way","Toblerorn","Crunch","Baby Ruth","Almond Joy").collect(Collectors.toSet());

    //Set<String> candysizeset = Stream.of("Super","King","Regular","Fun").collect(Collectors.toSet());


    /*public Candy createCandy(String size,String name){
        this.name = name;
        this.size = size;
        Candy candy = new Candy(name,size);
        return candy;
       // this.house = house;
    }*/



    /*public HashSet creatSize(){
        allCandySize = new HashSet<>();
        allCandySize.add("Super");
        allCandySize.add("King");
        allCandySize.add("Regular");
        allCandySize.add("Fun");
        return allCandySize;
    }*/

}
