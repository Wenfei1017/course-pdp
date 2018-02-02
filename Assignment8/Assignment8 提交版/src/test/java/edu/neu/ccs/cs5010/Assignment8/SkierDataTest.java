package edu.neu.ccs.cs5010.Assignment8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/27/17.
 */
public class SkierDataTest {

    private SkierData skierData;

    @Before
    public void setUp() throws Exception {
        skierData = new SkierData();
    }

    @Test
    public void read() throws Exception {
        skierData.read(5);
    }

    @Test
    public void write() throws Exception {
        skierData.write(2);
    }

}