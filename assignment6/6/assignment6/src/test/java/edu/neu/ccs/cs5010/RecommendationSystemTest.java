package edu.neu.ccs.cs5010;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;

import static org.junit.Assert.*;

/**
 * The type Recommendation system test.
 */
public class RecommendationSystemTest {

    /**
     * The Recommendation system.
     */
    RecommendationSystem recommendationSystem;

    /**
     * Recommendaion.
     *
     * @throws Exception the exception
     */
    @Test
    public void recommendaion() throws Exception {
        //String lines = "nodes_small.csv edges_small.csv abc s 100 15";
        recommendationSystem = new RecommendationSystem();
        recommendationSystem.recommendaion("nodes_small.csv", "edges_small.csv", "abc", "s", 100, 15);
    }

    @Test
    public void main() throws Exception {
        recommendationSystem = new RecommendationSystem();
        InputStream inputStream = new StringBufferInputStream("nodes_small.csv edges_small.csv abc s 100 15");
        System.setIn(inputStream);
    }
}