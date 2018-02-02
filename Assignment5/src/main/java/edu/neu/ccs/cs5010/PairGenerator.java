package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by wenfei on 10/30/17.
 */
public class PairGenerator {
    public static final int clientIDIndex = 0;
    public static final int messageIndex = 1;
    public static final int signatureIndex = 2;
    public static final int messageBound = 30000;

    /**
     * Generate message and signature pairs.
     *
     * pairs have 3 elements: clientID, message, signature
     *
     * @return pairs
     */
    public static BigInteger[] generatePairs(double fraction, Client client) {
        RandomNumber randomNumber = new RandomNumber();
        float prob;
        int message;
        Random rdn = new Random();
        RSASignature signature = new RSASignature();
        BigInteger[] pair = new BigInteger[3];
        prob = randomNumber.getRandomFloat();

        message = randomNumber.getRandom(messageBound + 1);
        pair[clientIDIndex] = new BigInteger(String.valueOf(client.clientID));
        pair[messageIndex] = new BigInteger(String.valueOf(message));
        if (prob > fraction) {
            pair[signatureIndex] = signature.generateSignature(message, client);
        } else {
            pair[signatureIndex] = new BigInteger(30000 + Math.abs(RSAKeyGenerator.keyLength), rdn);
        }

        return pair;
    }
}
