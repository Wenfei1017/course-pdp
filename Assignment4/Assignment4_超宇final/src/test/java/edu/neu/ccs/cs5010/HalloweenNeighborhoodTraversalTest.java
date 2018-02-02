package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xwenfei on 10/23/17.
 */
public class HalloweenNeighborhoodTraversalTest {

    private HalloweenNeighborhoodTraversal halloween;

    @Before
    public void setUp() throws Exception {
        halloween = new HalloweenNeighborhoodTraversal();
    }

    @Test
    public void traverse() throws Exception {
        String[] testLine = {"2", "DreamCandy2.csv", "DreamCandy1.csv"};
        halloween.setNeighbor(testLine);
    }

}