package edu.neu.ccs.cs5010;

import java.util.ArrayList;

/**
 * Created by wenfei on 10/22/17.
 */
public class Duplex implements INeighborhood {
    public ArrayList<Candy> candyList;

    /**
     * General duplex constructor.
     * add all the candy from historical data
     */
    public Duplex(){
        candyList = new ArrayList<Candy>();
        candyList.add(new Candy("Toblerone", "Super"));
        candyList.add(new Candy("Baby Ruth", "Super"));
        candyList.add(new Candy("Almond Joy", "Super"));

        candyList.add(new Candy("Twix", "King"));
        candyList.add(new Candy("Snickers", "King"));
        candyList.add(new Candy("Mars", "King"));

        candyList.add(new Candy("Kit Kat", "Fun"));
        candyList.add(new Candy("Whoopers", "Fun"));
        candyList.add(new Candy("Milky Way", "Fun"));
        candyList.add(new Candy("Crunch", "Fun"));
    }

    @Override
    public void accept(INeighborhoodVisitor INeighborhoodVisitor){
        INeighborhoodVisitor.visit(this);
    }
}
