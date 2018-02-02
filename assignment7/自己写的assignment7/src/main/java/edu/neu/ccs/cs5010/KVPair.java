package edu.neu.ccs.cs5010;

import java.util.Comparator;

public class KVPair implements Comparator<KVPair> {
    private  String keySkierID;
    private String valueLiftID;

    public KVPair(String keySkierID,String valueLiftID){
        this.keySkierID = keySkierID;
        this.valueLiftID = valueLiftID;
    }

    public String getKeySkierID() {
        return keySkierID;
    }

    public String getValueLiftID() {
        return valueLiftID;
    }

    @Override
    public int compareTo(KVPair o1 ,KVPair o2) {
        return Integer.parseInt(o1.valueLiftID)-Integer.parseInt(o2.valueLiftID);
    }

    @Override
    public int compare(KVPair o1, KVPair o2) {
        return o1.valueLiftID - ;
    }
}
