package edu.neu.ccs.cs5010;

import java.math.BigInteger;

/**
 * Created by wenfei on 10/30/17.
 */
public class RSASignature {
    public static final int keyPart = 0;
    public static final int publicPart = 1;

    /**
     * Given a message and a client, return the client signature on the message.
     *
     * @return the signature
     */
    public BigInteger generateSignature(int message, Client client) {
        BigInteger newMessage = new BigInteger(String.valueOf(message));
        BigInteger[] key = client.privateKey;
        //BigInteger signature = newMessage.pow(key[keyPart].intValue()).mod(key[publicPart]);
        BigInteger signature = newMessage.modPow(key[keyPart], key[publicPart]);
        return signature;
    }

    /**
     * Given a message and a client signature, return whether the .
     *
     * @return the verified message
     */
    public int verifySignature(BigInteger signature, Client client) {
        BigInteger[] key = client.publicKey;
        //BigInteger newMessage = signature.pow(key[keyPart].intValue()).mod(key[publicPart]);
        BigInteger newMessage = signature.modPow(key[keyPart], key[publicPart]);
        return newMessage.intValue();
    }
}
