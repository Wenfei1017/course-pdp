package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class EmailGeneratorTest {
    private EmailGenerator emailGenerator;
    @Before
    public void setUp() throws Exception {
        emailGenerator = new EmailGenerator();
    }

    @Test
    public void createFileDir() throws Exception {
        File testFile = new File("testFile");
        emailGenerator.createFileDir("testFile");
        assert(testFile.exists());
    }

}