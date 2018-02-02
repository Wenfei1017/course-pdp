package edu.neu.ccis.cs5010.assignment7;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/19/17.
 */
public class HourTest {

    private Hour hour;

    @Before
    public void setUp() throws Exception {
        hour = new Hour(20);
    }

    @Test
    public void addLift() throws Exception {
        hour.addLift(3);
    }

    @Test
    public void getMap() throws Exception {
        Map<Integer, Integer> map;
        hour.addLift(3);
        hour.addLift(4);
        hour.addLift(5);
        hour.addLift(4);
        map  = hour.getMap();
        assertEquals(map.get(new Integer(3)), new Integer(1));
        assertEquals(map.get(new Integer(4)), new Integer(2));
        assertEquals(map.get(new Integer(5)), new Integer(1));
    }

    @Test
    public void getHour() throws Exception {
        assertEquals(hour.getHour(), 20);
    }

}