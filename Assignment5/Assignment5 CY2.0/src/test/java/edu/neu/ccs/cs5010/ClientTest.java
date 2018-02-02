package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.security.interfaces.RSAKey;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 10/29/17.
 */
public class ClientTest {

    private Client client;
    private BigInteger[][] keyPair;
    private RSAKeyGenerator keyGenerator;
    private RandomNumber randomNum;

    @Before
    public void setUp() throws Exception {
        keyGenerator = new RSAKeyGenerator();
        keyPair = keyGenerator.generateKey();
        randomNum = new RandomNumber();

        client = new Client(
                102193,
                keyPair[RSAKeyGenerator.publicKeyIndex], keyPair[RSAKeyGenerator.privateKeyIndex],
                1000,
                300
        );
    }

    @Test
    public void getClientID() throws Exception {
        assertEquals(client.clientID, 102193);
    }

    @Test
    public void getPublicKey() throws Exception {
        System.out.println(client.getPublicKey()[RSASignature.keyPart]);
        System.out.println(client.getPublicKey()[RSASignature.publicPart]);
    }

    @Test
    public void getPrivateKey() throws Exception {
        System.out.println(client.getPrivateKey()[RSASignature.keyPart]);
        System.out.println(client.getPrivateKey()[RSASignature.publicPart]);
    }

    @Test
    public void getDepositLimt() throws Exception {
        assertEquals(client.getDepositLimt(), 1000);
    }

    @Test
    public void getWithdrawalLimt() throws Exception {
        assertEquals(client.getWithdrawalLimt(), 300);
    }

    @Test
    public void printInfo() throws Exception {
        client.printInfo();
    }

}