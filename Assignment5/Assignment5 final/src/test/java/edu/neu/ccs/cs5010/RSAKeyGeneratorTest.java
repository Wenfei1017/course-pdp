package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by wenfei on 10/29/17.
 */
public class RSAKeyGeneratorTest {

    private RSAKeyGenerator keyGenerator;

    @Before
    public void setUp() throws Exception {
        keyGenerator = new RSAKeyGenerator();
    }

    @Test
    public void generateKey() throws Exception {
        BigInteger[][] testKey = keyGenerator.generateKey();
        System.out.println(testKey[RSAKeyGenerator.publicKeyIndex][RSASignature.keyPart]);
        System.out.println(testKey[RSAKeyGenerator.privateKeyIndex][RSASignature.keyPart]);
        System.out.println(testKey[RSAKeyGenerator.publicKeyIndex][RSASignature.publicPart]);
        System.out.println(testKey[RSAKeyGenerator.privateKeyIndex][RSASignature.publicPart]);
    }

}