package edu.neu.ccs.cs5010.Assignment8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/27/17.
 */
public class LiftDataTest {

    private LiftData liftData;

    @Before
    public void setUp() throws Exception {
        liftData = new LiftData();
    }

    @Test
    public void read() throws Exception {
        liftData.read(5);
    }

    @Test
    public void write() throws Exception {
        liftData.write(4);
    }

}