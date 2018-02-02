package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xwenfei on 10/23/17.
 */
public class DuplexTest {

    private Duplex duplex;

    @Before
    public void setUp() throws Exception {
        duplex = new Duplex();
    }

    @Test
    public void print() throws Exception {
        System.out.print("duplex:\n");
        for (Candy candy: duplex.candyList){
            System.out.print("size: " + candy.candySize + "\t\tname: " + candy.candyName + "\n");
        }
    }

    @Test
    public void accept() throws Exception {

    }

}