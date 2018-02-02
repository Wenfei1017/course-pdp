package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.security.PublicKey;

public class Verifacation {

    public BigInteger verify(int message, BigInteger signatre, RSAPublicKey publickey) {
        BigInteger temp;
        BigInteger m;
        BigInteger σ = signatre;
        BigInteger n = publickey.getN();
        BigInteger b = publickey.getB();
        temp = new BigInteger(Double.toString(Math.pow(signatre.doubleValue(),b.doubleValue())));
        m = temp.mod(n);
        return m;
    }
}
