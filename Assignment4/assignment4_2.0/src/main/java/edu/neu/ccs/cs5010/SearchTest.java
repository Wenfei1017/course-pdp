package edu.neu.ccs.cs5010;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * to search candy in different houses one by one
 * @return the list that delete candy which has been found
 */
public class SearchTest {
    Set<Candy> set; //the candy each house has
    List<Candy> list; //the dream list
    public  List findCandy(House house, List dreamcandy) throws FileNotFoundException {
        //dreamcandy = new CSVFileReader().readFile();
        set = new HashSet<>(house.getCandy());//transfer the candy list in specific house to set
        list = dreamcandy;
        for(int i=0;i<list.size();i++){
            if(set.contains(list.get(i))){//to check if the candy set contains the candy in the list
                list.remove(i);//remove this candy in the readm list if finded in house
                System.out.println(house.getHouseName());//print the house which find the candy
            }
        }return list;
    }
}
