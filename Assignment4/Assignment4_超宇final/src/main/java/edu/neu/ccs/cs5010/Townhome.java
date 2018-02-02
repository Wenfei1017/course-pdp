package edu.neu.ccs.cs5010;

import java.util.ArrayList;

/**
 * Created by xwenfei on 10/22/17.
 */
public class Townhome implements INeighborhood {
    public ArrayList<Candy> candyList;

    /**
     * General townhome constructor.
     * add all the candy from historical data
     */
    public Townhome() {
        candyList = new ArrayList<Candy>();
        candyList.add(new Candy("Twix", "Regular"));
        candyList.add(new Candy("Snickers", "Regular"));
        candyList.add(new Candy("Mars", "Regular"));
        candyList.add(new Candy("Kit Kat", "Regular"));
        candyList.add(new Candy("Whoopers", "Regular"));
        candyList.add(new Candy("Toblerone", "Regular"));
        candyList.add(new Candy("Baby Ruth", "Regular"));
        candyList.add(new Candy("Almond Joy", "Regular"));
    }

    @Override
    public void accept(INeighborhoodVisitor INeighborhoodVisitor){
        INeighborhoodVisitor.visit(this);
    }
}
