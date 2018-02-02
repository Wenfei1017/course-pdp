package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bikegcy on 10/23/17.
 */
public class fortest {

    public static void main(String[] args) {
        String fruit = "apple, pear, banana, orange";
        String apple = "apple";

        if (fruit.contains(apple)) {
            System.out.println("yeeees!");
        }

        List<Candy> testCandy = new ArrayList<Candy>();
        testCandy.add(new Candy("das", "super"));
        testCandy.add(new Candy("dasds", "super"));
        testCandy.add(new Candy("dasdasda", "super"));
        testCandy.add(new Candy("dasdasdadad", "super"));

        Candy candy = new Candy("dasds", "super");

        if (testCandy.contains(candy)) {
            System.out.print("yeahhhhhh!");
        } else {
            System.out.print("noooooooo!");
        }
    }
}
