package edu.neu.ccs.cs5010;

import java.util.ArrayList;

/**
 * Created by xwenfei on 10/22/17.
 */
public class Mansion implements INeighborhood {
    public ArrayList<Candy> candyList;

    /**
     * General mansion constructor.
     * add all the candy from historical data
     */
    public Mansion() {
        candyList = new ArrayList<Candy>();
        candyList.add(new Candy("Twix", "Super"));
        candyList.add(new Candy("Snickers", "Super"));
        candyList.add(new Candy("Mars", "Super"));

        candyList.add(new Candy("Kit Kat", "King"));
        candyList.add(new Candy("Whoopers", "King"));
        candyList.add(new Candy("Crunch", "King"));

        candyList.add(new Candy("Toblerone", "Fun"));
        candyList.add(new Candy("Baby Ruth", "Fun"));
        candyList.add(new Candy("Almond Joy", "Fun"));
    }

    @Override
    public void accept(INeighborhoodVisitor INeighborhoodVisitor){
        INeighborhoodVisitor.visit(this);
    }


}
