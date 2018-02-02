package edu.neu.ccs.cs5010.Assignment8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/27/17.
 */
public class HourDataTest {

    private HourData hourData;

    @Before
    public void setUp() throws Exception {
        hourData = new HourData();
    }

    @Test
    public void read() throws Exception {
        hourData.read(1);
        hourData.read(2);
        hourData.read(3);
        hourData.read(4);
        hourData.read(5);
        hourData.read(6);
    }

    @Test
    public void write() throws Exception {
        hourData.write(2);
    }

}