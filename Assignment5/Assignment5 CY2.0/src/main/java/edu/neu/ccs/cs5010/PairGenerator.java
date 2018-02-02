package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by wenfei on 10/30/17.
 */
public class PairGenerator {
    public static final int messageIndex = 0;
    public static final int signatureIndex = 1;
    public static final int messageBound = 0;

    /**
     * Generate message & signature pairs
     */
    public static BigInteger[] generatePairs(float fraction, Client client) {
        RandomNumber randomNumber = new RandomNumber();
        float prob;
        int message;
        Random rdn = new Random();
        RSASignature signature = new RSASignature();
        BigInteger[] pair = new BigInteger[2];
        prob = randomNumber.getRandomFloat();

        message = randomNumber.getRandom(messageBound + 1);
        pair[messageIndex] = new BigInteger(String.valueOf(message));
        if (prob > fraction) {
            pair[signatureIndex] = signature.generateSignature(message, client);
        } else {
            pair[signatureIndex] = new BigInteger(RSAKeyGenerator.keyLength, rdn);
        }

        return pair;
    }
}
