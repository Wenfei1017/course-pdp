package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 11/13/17.
 */
public class SecureBankVerificationSimulatorTest {

    SecureBankVerificationSimulator secureBankVerificationSimulator;

    @Before
    public void setUp() throws Exception {
        secureBankVerificationSimulator = new SecureBankVerificationSimulator();
    }

    @Test
    public void simulate() throws Exception {
        String[] testLine = {"1000", "500", "0.1", "outputTest.csv"};
        secureBankVerificationSimulator.simulate(testLine);
    }

    @Test
    public void main() throws Exception {

    }

}