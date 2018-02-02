package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class ClientTest {
    Client client;
    Client client1;
    Client client2;
    Client client3;
    @Before
    public void setUp() throws Exception {
        client = new Client((double) 00,00,00);
    }

    @Test
    public void createClient() throws Exception {
        int i = 1101;
        int j = 2302;
        int k = 1101;
        client1 = new Client((double) 1101,20,30);
        assertEquals(2,client.clientHashSet.size());
    }

    @Test
    public void printClientList() throws Exception {
        List listtest = new ArrayList();
        listtest.add(client1);
        listtest.add(client2);
        assertEquals(listtest,client.clientList);
    }

    @Test
    public void getClientID() throws Exception {
        client3 = new Client((double) 3401,30,56);
        assertEquals(java.util.Optional.of((double) 3401),client3.getClientID());
    }

    @Test
    public void getDepositLimit() throws Exception {
    }

    @Test
    public void getWithdrawalLimit() throws Exception {
    }

    @Test
    public void getMessage() throws Exception {
    }

    @Test
    public void getRsaKeyPair() throws Exception {
    }

}