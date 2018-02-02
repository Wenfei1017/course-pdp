package edu.neu.ccs.cs5010;

import java.util.ArrayList;

/**
 * Created by wenfei on 10/23/17.
 */
public class NeighborhoodVisitor implements INeighborhoodVisitor {
    public static ArrayList<Candy> dreamList;
    public static ArrayList<Candy> currentCandy;

    /**
     * Given the child's dream list, traverse the house and return the left result.
     */
    public void askCandy(ArrayList<Candy> candyList, String house){
        boolean isCandyFound = false;

        for (Candy dreamCandy: dreamList) {
            for (Candy candyInHouse: candyList) {
                if (dreamCandy.getCandyName().equals(candyInHouse.getCandyName().toLowerCase()) &&
                        dreamCandy.getCandySize().equals(candyInHouse.getCandySize().toLowerCase())) {
                    isCandyFound = true;
                    break;
                }
            }
            if (isCandyFound) {
                System.out.println("candy found!" + dreamCandy.getCandyName() + " " + dreamCandy.getCandySize());
                dreamCandy.setCandyHouse(house);
                currentCandy.add(dreamCandy);
            }
            isCandyFound = false;
        }
    }

    @Override
    public void visit(Neighborhood neighborhood){
        currentCandy = new ArrayList<>();
        dreamList = neighborhood.neighborCandy;
    }

    @Override
    public void visit(Mansion masion){;
        askCandy(masion.candyList, "Masion");
    }

    @Override
    public void visit(Detached detached){
        askCandy(detached.candyList, "Detached");
    }

    @Override
    public void visit(Duplex duplex){
        askCandy(duplex.candyList, "Duplex");
    }

    @Override
    public void visit(Townhome townhome){
        askCandy(townhome.candyList, "townhome");
    }
}
