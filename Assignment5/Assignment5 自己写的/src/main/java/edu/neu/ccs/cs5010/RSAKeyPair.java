package edu.neu.ccs.cs5010;

import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAKeyPair {

    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;

    public RSAKeyPair(RSAPublicKey publicKey, RSAPrivateKey privateKey){
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }
    public RSAPrivateKey getPrivateKey() {
        return this.privateKey;
    }
    public RSAPublicKey getPublicKey() {
        return this.publicKey;
    }

}
