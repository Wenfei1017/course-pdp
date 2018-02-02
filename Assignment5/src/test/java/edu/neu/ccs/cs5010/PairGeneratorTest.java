package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by bikegcy on 10/31/17.
 */
public class PairGeneratorTest {

    private Client client;
    private BigInteger[][] keyPair;
    private RSAKeyGenerator keyGenerator;
    private RandomNumber randomNum;
    private PairGenerator pairGenerator;

    @Before
    public void setUp() throws Exception {
        keyGenerator = new RSAKeyGenerator();
        keyPair = keyGenerator.generateKey();
        randomNum = new RandomNumber();
        pairGenerator = new PairGenerator();

        client = new Client(
                101791,
                keyPair[RSAKeyGenerator.publicKeyIndex], keyPair[RSAKeyGenerator.privateKeyIndex],
                2000,
                500
        );
    }

    @Test
    public void generatePairs() throws Exception {
        Double fraction = 0.5;
        BigInteger[] pair;
        pair = pairGenerator.generatePairs(fraction, client);

    }

}