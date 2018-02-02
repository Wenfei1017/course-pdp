package edu.neu.ccs.cs5010.Assignment8;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/27/17.
 */
public class SkiQueryProcessorTest {
    private final static int factor = 20;

    private SkiQueryProcessor skiQueryProcessor;

    @Before
    public void setUp() throws Exception {
        skiQueryProcessor = new SkiQueryProcessor();

    }

    @Test
    public void query() throws Exception {
        String file = "PDPAssignment8.csv";
        int queries = 20;
        skiQueryProcessor.query(file, queries);
    }

    @Test
    public void main() throws Exception {
        //skiQueryProcessor.main(new String[]{"PDPAssignment8.csv", "40"});
    }

}