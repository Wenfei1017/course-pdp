package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by wenfei on 10/29/17.
 */
public class RSAKeyGenerator {
    public static final int certainty = 1000;
    public static final int keyLength = 64;
    public static final int publicKeyIndex = 0;
    public static final int privateKeyIndex = 1;
    // The bit length is keyBit ~ 2 keyBit

    public BigInteger publicKey;
    public BigInteger privateKey;

    /**
     * Given a key generator object, return the public key and private key.
     *
     * @return the key pair
     */
    public BigInteger[][] generateKey() {
        RandomNumber rand = new RandomNumber();
        Random rnd = new Random();
        BigInteger primeP;
        BigInteger primeQ;
        BigInteger phi;
        BigInteger publicN;

        primeP = new BigInteger(rand.getRandom(keyLength) + keyLength, certainty, rnd);
        primeQ = new BigInteger(rand.getRandom(keyLength) + keyLength, certainty, rnd);
        publicN = primeP.multiply(primeQ);
        phi = primeP.subtract(BigInteger.ONE).multiply(primeQ.subtract(BigInteger.ONE));

        do {
            privateKey = new BigInteger(rand.getRandom(keyLength) + keyLength, rnd);
        } while (!privateKey.gcd(publicN).equals(BigInteger.ONE) || !privateKey.gcd(phi).equals(BigInteger.ONE));
        do {
            publicKey = privateKey.modInverse(phi);
        } while (!publicKey.multiply(privateKey).mod(phi).equals(BigInteger.ONE));

        BigInteger[][] keyPair = new BigInteger[2][2];
        keyPair[publicKeyIndex][0] = publicKey;
        keyPair[publicKeyIndex][1] = publicN;
        keyPair[privateKeyIndex][0] = privateKey;
        keyPair[privateKeyIndex][1] = publicN;
        return keyPair;
    }

}
