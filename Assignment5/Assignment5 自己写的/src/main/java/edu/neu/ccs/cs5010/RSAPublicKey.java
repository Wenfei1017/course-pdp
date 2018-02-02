package edu.neu.ccs.cs5010;

import java.math.BigInteger;

public class RSAPublicKey {
    private BigInteger b;
    private BigInteger n;

    public RSAPublicKey(BigInteger b,BigInteger n){
        this.b = b;
        this.n = n;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getB() {
        return b;
    }
}


