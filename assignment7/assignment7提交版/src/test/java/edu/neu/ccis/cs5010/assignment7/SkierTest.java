package edu.neu.ccis.cs5010.assignment7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/19/17.
 */
public class SkierTest {

    private Skier skier;

    @Before
    public void setUp() throws Exception {
        skier = new Skier(89757);
    }

    @Test
    public void increaseVertical() throws Exception {
        skier.increaseVertical(3);
        skier.increaseVertical(13);
        skier.increaseVertical(23);
        skier.increaseVertical(33);
    }

    @Test
    public void getId() throws Exception {
        assertEquals(skier.getId(), 89757);
    }

    @Test
    public void getVertical() throws Exception {
        skier.increaseVertical(3);
        assertEquals(skier.getVertical(), 200);
        skier.increaseVertical(13);
        assertEquals(skier.getVertical(), 500);
        skier.increaseVertical(23);
        assertEquals(skier.getVertical(), 900);
        skier.increaseVertical(33);
        assertEquals(skier.getVertical(), 1400);

    }

}