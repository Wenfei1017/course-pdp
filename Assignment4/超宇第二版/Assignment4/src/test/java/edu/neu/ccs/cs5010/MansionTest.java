package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;


/**
 * Created by bikegcy on 10/23/17.
 */
public class MansionTest {

    private Mansion masion;

    @Before
    public void setUp() throws Exception {
        masion = new Mansion();
    }

    @Test
    public void print() throws Exception {
        System.out.print("masion:\n");
        for (Candy candy: masion.candyList){
            System.out.print("size: " + candy.candySize + "\t\tname: " + candy.candyName + "\n");
        }
    }

    @Test
    public void accept() throws Exception {

    }

}