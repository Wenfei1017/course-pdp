package edu.neu.ccs.cs5010;

import java.io.FileNotFoundException;

/**
 * define all of four houses in this neighborhood here and execute accept method
 */
public class HouseHold  {
    private Mansion mansion = new Mansion();
    private DetachedHouse detachedHouse = new DetachedHouse();
    private Duplexe duplexe = new Duplexe();
    private TownHome townHome = new TownHome();


    public void accept(Visitor visitor) throws FileNotFoundException {

        visitor.visit(this);
        mansion.accept(visitor);
        detachedHouse.accept(visitor);
        duplexe.accept(visitor);
        townHome.accept(visitor);

        //visitor.visit(this);
    }
}
