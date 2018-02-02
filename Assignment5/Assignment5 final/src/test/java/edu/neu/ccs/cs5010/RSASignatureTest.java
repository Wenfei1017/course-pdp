package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 10/30/17.
 */
public class RSASignatureTest {

    private Client client;
    private BigInteger[][] keyPair;
    private RSAKeyGenerator keyGenerator;
    private RandomNumber randomNum;
    private RSASignature signature;

    @Before
    public void setUp() throws Exception {
        keyGenerator = new RSAKeyGenerator();
        keyPair = keyGenerator.generateKey();
        randomNum = new RandomNumber();
        signature = new RSASignature();

        client = new Client(
                102193,
                keyPair[RSAKeyGenerator.publicKeyIndex], keyPair[RSAKeyGenerator.privateKeyIndex],
                1000,
                300
        );
    }

    @Test
    public void generateSignature() throws Exception {
        int message = 22324;
        BigInteger sig = signature.generateSignature(message, client);
        int newMessage = signature.verifySignature(sig, client);
        assertEquals(message, newMessage);
    }


}