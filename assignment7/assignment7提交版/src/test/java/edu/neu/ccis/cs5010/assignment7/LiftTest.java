package edu.neu.ccis.cs5010.assignment7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/19/17.
 */
public class LiftTest {

    private Lift lift;

    @Before
    public void setUp() throws Exception {
        lift = new Lift(9527);
    }

    @Test
    public void addRide() throws Exception {
        lift.addRide();
    }

    @Test
    public void getId() throws Exception {
        assertEquals(lift.getId(), 9527);
    }

    @Test
    public void getRides() throws Exception {
        lift.addRide();
        assertEquals(lift.getRides(), 1);
        for (int i = 0; i < 100; i++) {
            lift.addRide();
        }
        assertEquals(lift.getRides(), 101);
    }

}