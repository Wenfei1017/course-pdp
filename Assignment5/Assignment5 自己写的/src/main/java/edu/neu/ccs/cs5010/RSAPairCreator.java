package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.security.*;
import java.util.Date;

public class RSAPairCreator {



    public RSAKeyPair createKeys(Client client) throws NoSuchAlgorithmException {
        BigInteger p;
        BigInteger q;
        BigInteger n;
        BigInteger n0;
        BigInteger a;
        BigInteger b;


        SecureRandom random=new SecureRandom();
        random.setSeed(new Date().getTime());

        p = BigInteger.probablePrime(2048,random);//generate prime p;
        q = BigInteger.probablePrime(2048,random);//generate prime q

        n = p.multiply(q);
        n0 = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        a = new BigInteger(String.valueOf(65537));
        b = new BigInteger(String.valueOf(0000000));//欧几里得算法求解b
        RSAPrivateKey privateKey = new RSAPrivateKey(a, n);
        RSAPublicKey publicKey = new RSAPublicKey(b, n);

        return new RSAKeyPair(publicKey, privateKey);




        /*HashMap<Client,RsaKeyPair> clientMap = new HashMap();
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        KeyPair pair = generator.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) pair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) pair.getPublic();
        RsaKeyPair rsaKeyPair = new RsaKeyPair(publicKey,privateKey);

        return rsaKeyPair;
        */
    }

    //hashmap save the client and clientkeys

}
