package edu.neu.ccs.cs5010;

public class HouseHold implements House {

    House[] houses;

    public HouseHold(){
        houses = new House[]{new Mansion(),new DetachedHouse(),new Duplexe(),new TownHome()};
    }
    @Override
    public void accept(Visitor visitor) {
        for(int i = 0; i < houses.length; i++){
            houses[i].accept(visitor);
        }
        //visitor.visit(this);
    }
}
