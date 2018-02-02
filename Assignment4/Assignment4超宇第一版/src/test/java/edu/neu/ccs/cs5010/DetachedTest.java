package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bikegcy on 10/23/17.
 */
public class DetachedTest {

    private Detached detached;

    @Before
    public void setUp() throws Exception {
        detached = new Detached();
    }

    @Test
    public void print() throws Exception {
        System.out.print("detached:\n");
        for (Candy candy: detached.candyList){
            System.out.print("size: " + candy.candySize + "\t\tname: " + candy.candyName + "\n");
        }
    }

    @Test
    public void accept() throws Exception {

    }

}