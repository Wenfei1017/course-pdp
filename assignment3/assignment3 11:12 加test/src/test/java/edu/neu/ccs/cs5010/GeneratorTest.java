package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GeneratorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    Generator generator;
    String testOutPut;
    String[] testString;
    @Before
    public void setUp() throws Exception {
        generator = new Generator();
        testOutPut = "--email-template <file> \t accepts a filename that holds the email template.\n" +
                "\n" +
                "--output-dir <path>     \t accepts the name of a folder, all output is placed\n" +
                "                        \t in this folder\n" +
                "\n" +
                "--csv-file <path>       \t accepts the name of the csv file to process, in\n" +
                "                        \t a following format\n" +
                "                        \t Flight<id>From<departure-city>To<destination-city>.csv\n" +
                "\n" +
                "--event <details>       \t specifies if the delay refers to departure/arrival ";
        testString = new String[]{"--csv-file", "test_data/FlightUA101FromABCToDEF.csv", "--output-dir", "output",
                "--event", "departure", "--email-template", "email-template.txt"};
    }

    @Test
    public void printUsage() throws Exception {
        generator.printUsage();
    }

    @Test
    public void getInput() throws Exception {
        generator.getInput(testString);
    }

    @Test
    public void main() throws Exception {
    }

}