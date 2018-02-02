package edu.neu.ccs.cs5010;

import java.io.FileNotFoundException;
import java.util.List;

public interface House {

    void accept(Visitor visitor) throws FileNotFoundException;
    List getCandy();
    String getHouseName();


}
