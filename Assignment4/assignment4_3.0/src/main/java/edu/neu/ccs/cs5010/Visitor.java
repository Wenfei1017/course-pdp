package edu.neu.ccs.cs5010;

import java.io.FileNotFoundException;

public interface Visitor {
    void visit(HouseHold houseHold) throws FileNotFoundException;
    void visit(Mansion mansion) throws FileNotFoundException;
    void visit(DetachedHouse detachedHouse) throws FileNotFoundException;
    void visit(Duplexe duplexe) throws FileNotFoundException;
    void visit(TownHome townHome) throws FileNotFoundException;

}
