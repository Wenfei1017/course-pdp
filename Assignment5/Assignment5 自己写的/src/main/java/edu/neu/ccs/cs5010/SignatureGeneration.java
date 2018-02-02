package edu.neu.ccs.cs5010;

import com.sun.jdi.DoubleValue;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.Random;


public class SignatureGeneration {

    //http://blog.csdn.net/wangqiuyun/article/details/42143957
    public static BigInteger sign(Client client, RSAPrivateKey privateKey) throws NoSuchAlgorithmException {
        int message = client.getMessage();
        RSAPairCreator  rsaPairCreator = new RSAPairCreator();
        //PrivateKey privateKey;
        //privateKey = rsaPairCreator.createKeys(client).getPrivateKey();
        BigInteger temp;

        BigInteger signature;
        BigInteger a = privateKey.getA();
        BigInteger n = privateKey.getN();

        temp = new BigInteger(Double.toString(Math.pow(message, a.doubleValue())));
        signature = temp.mod(n);

        return signature;
    }

}
