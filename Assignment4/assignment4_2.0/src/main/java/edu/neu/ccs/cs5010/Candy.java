package edu.neu.ccs.cs5010;

import java.util.HashSet;
import java.lang.String;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public   class Candy {

    String name;
    String size;
   // String house;

    //private Set<String> getAllCandyName;
    public Candy(String size,String name){
        this.size = size;
        this.name = name;
    }

    Set<String> candynameset = Stream.of("Twix","Snikers","Mars","Kit Kat","Whoopers",
            "Milky Way","Toblerorn","Crunch","Baby Ruth","Almond Joy").collect(Collectors.toSet());

    Set<String> candysizeset = Stream.of("Super","King","Regular","Fun").collect(Collectors.toSet());

    public Candy createCandy(String size,String name){
        Candy candy = new Candy(size,name);
        this.name = name;
        this.size = size;
        return candy;
       // this.house = house;
    }


    /*public HashSet creatSize(){
        allCandySize = new HashSet<>();
        allCandySize.add("Super");
        allCandySize.add("King");
        allCandySize.add("Regular");
        allCandySize.add("Fun");
        return allCandySize;
    }*/

}
