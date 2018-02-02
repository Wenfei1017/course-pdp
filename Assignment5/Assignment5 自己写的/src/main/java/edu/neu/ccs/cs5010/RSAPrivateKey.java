package edu.neu.ccs.cs5010;

import java.math.BigInteger;

public class RSAPrivateKey {
    private BigInteger a;
    private BigInteger n;

    public RSAPrivateKey(BigInteger a, BigInteger n){
        this.a = a;
        this.n = n;
    }

    public BigInteger getA(){
        return this.a;
    }

    public BigInteger getN() {
        return n;
    }
}
