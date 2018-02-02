package edu.neu.ccis.cs5010.assignment7;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/19/17.
 */
public class SkiDataProcessorTest {

    private SkiDataProcessor skiDataProcessor;
    private String file;

    @Before
    public void setUp() throws Exception {
        file = new String("PDPAssignment.csv");
        skiDataProcessor = new SkiDataProcessor();
    }

    @Test
    public void process() throws Exception {
        file = "testFile.csv";
        skiDataProcessor.process(file);
        file = "PDPAssignment.csv";
        skiDataProcessor.process(file);
    }

    @Test
    public void processThread() throws Exception {
        skiDataProcessor.process(file, 1);
    }

    @Test
    public void output() throws Exception {
        skiDataProcessor.process(file);
        skiDataProcessor.output();
    }

    @Test
    public void outputThread() throws Exception {
        skiDataProcessor.process(file, 1);
        skiDataProcessor.output(1);
    }

    @Test
    public void main() throws Exception {
        //skiDataProcessor.main(null);
    }

}