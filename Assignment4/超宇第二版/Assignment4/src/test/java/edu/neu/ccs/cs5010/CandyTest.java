package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bikegcy on 10/23/17.
 */
public class CandyTest {

    private Candy candy;

    @Before
    public void setUp() throws Exception {
        candy = new Candy("mars", "super");
    }

    @Test
    public void getCandyName() throws Exception {
        assertEquals(candy.getCandyName(), "mars");
    }

    @Test
    public void getCandySize() throws Exception {
        assertEquals(candy.getCandySize(), "super");
    }

    @Test
    public void printCandy() throws Exception {
        candy.printCandy();
    }

}