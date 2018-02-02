package edu.neu.ccs.cs5010;

/**
 * Created by wenfei on 10/22/17.
 */
public class Candy implements ICandy{
    public static final String candyNameSet = "Twix, Snickers, Mars, Kit Kat, Whoopers, Milky Way, Toblerone, Crunch, Baby Ruth, Almond Joy";
    public static final String candySizeSet = "Super, King, Regular, Fun";

    public String candyName;
    public String candySize;
    public String candyHouse;

    /**
     * General candy constructor.
     */
    public Candy(String candyName, String candySize){
        this.candyName = candyName;
        this.candySize = candySize;
    }

    /**
     * Given a candy object, return the name.
     *
     * @return the name of the candy
     */
    public String getCandyName() {
        return this.candyName;
    }

    /**
     * Given a candy object, return the candy size.
     *
     * @return the size of the candy
     */
    public String getCandySize() {
        return this.candySize;
    }

    /**
     * Given a candy object, print its name and size info.
     *
     */
    public void printCandy(){
        System.out.println("\nCandy name: " + this.getCandyName());
        System.out.println("Candy size: " + this.getCandySize());
    }

    /**
     * Set candy house.
     */
    public void setCandyHouse(String house){
        this.candyHouse = house;
    }

    /**
     * Given a candy object, get its house info.
     *
     */
    public String getCandyHouse(){
        return this.candyHouse;
    }

}
