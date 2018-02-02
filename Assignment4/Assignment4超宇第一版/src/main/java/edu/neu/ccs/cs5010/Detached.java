package edu.neu.ccs.cs5010;

import java.util.ArrayList;

/**
 * Created by wenfei on 10/22/17.
 */
public class Detached implements INeighborhood {
    public ArrayList<Candy> candyList;

    /**
     * General detached constructor.
     * add all the candy from historical data
     */
    public Detached(){
        candyList = new ArrayList<Candy>();
        candyList.add(new Candy("Kit Kat", "Super"));
        candyList.add(new Candy("Whoopers", "Super"));
        candyList.add(new Candy("Crunch", "Super"));
        candyList.add(new Candy("Milky Way", "Super"));

        candyList.add(new Candy("Toblerone", "King"));

        candyList.add(new Candy("Twix", "Fun"));
        candyList.add(new Candy("Snickers", "Fun"));
        candyList.add(new Candy("Mars", "Fun"));
    }

    @Override
    public void accept(INeighborhoodVisitor INeighborhoodVisitor){
        INeighborhoodVisitor.visit(this);
    }
}
