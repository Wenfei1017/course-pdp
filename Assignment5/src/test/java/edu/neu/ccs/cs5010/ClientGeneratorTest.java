package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 10/30/17.
 */
public class ClientGeneratorTest {

    private ClientGenerator clientGenerator;
    private HashMap<Integer, Client> clientData;

    @Before
    public void setUp() throws Exception {
        clientData = new HashMap<>();
        clientGenerator = new ClientGenerator(200);
    }

    @Test
    public void generateClientData() throws Exception {

    }

}