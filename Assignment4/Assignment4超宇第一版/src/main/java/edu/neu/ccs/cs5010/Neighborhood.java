package edu.neu.ccs.cs5010;

import java.util.ArrayList;

/**
 * Created by bikegcy on 10/23/17.
 */
public class Neighborhood implements INeighborhood {
    INeighborhood[] households;
    ArrayList<Candy> neighborCandy;

    /**
     * General neighborhood constructor.
     * add all the candy from historical data
     */
    public Neighborhood(ArrayList<Candy> dreamList){
        households = new INeighborhood[] {new Mansion(), new Detached(), new Duplex(), new Townhome()};
        neighborCandy = dreamList;
    }

    @Override
    public void accept(INeighborhoodVisitor ineighborhoodVisitor){
        ineighborhoodVisitor.visit(this);
        for (int i = 0; i < households.length; i++) {
            households[i].accept(ineighborhoodVisitor);
        }

    }
}
