package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xwenfei on 10/23/17.
 */
public class TownhomeTest {

    private Townhome townhome;

    @Before
    public void setUp() throws Exception {
        townhome = new Townhome();
    }

    @Test
    public void print() throws Exception {
        System.out.print("townhome:\n");
        for (Candy candy: townhome.candyList){
            System.out.print("size: " + candy.candySize + "\t\tname: " + candy.candyName + "\n");
        }
    }

    @Test
    public void accept() throws Exception {

    }

}