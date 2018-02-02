package edu.neu.ccs.cs5010.Assignment8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/27/17.
 */
public class LiftRidesDataTest {

    private LiftRidesData liftRidesData;

    @Before
    public void setUp() throws Exception {
        liftRidesData = new LiftRidesData();
    }

    @Test
    public void read() throws Exception {
        liftRidesData.read(10);
        liftRidesData.read(2);
    }

    @Test
    public void write() throws Exception {
        liftRidesData.write(2);
    }

}