package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by wenfei on 10/29/17.
 */
public class TestOnly {
    public static final int bound = 64;
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            //System.out.println(s.nextInt(11));
        }

        Random rnd = new Random();
        RandomNumber rd = new RandomNumber();
        BigInteger bi;
        BigInteger bi2;
        BigInteger phi;
        BigInteger n;

        for (int i = 0; i < 100; i++) {
            bi = new BigInteger(bound, 10000, rnd);
            bi2 = new BigInteger(bound,10000, rnd);
            phi = bi.subtract(BigInteger.ONE).multiply(bi2.subtract(BigInteger.ONE));
            n = bi.multiply(bi2);
            //System.out.println(phi.toString());
            //System.out.println(n.toString());

            //System.out.println(rnd);
            //System.out.println(bi.toString());
            if (!bi.isProbablePrime(10000)) {
                System.out.println("wrong prime number");
            }

        }

        BigInteger ss = new BigInteger("3423532314342");
        BigInteger xx = new BigInteger("3532523455435");
        BigInteger pp = ss.subtract(BigInteger.ONE).multiply(xx.subtract(BigInteger.ONE));

        System.out.println(pp.mod(xx));


        for (int i = 0; i < 100; i++) {
            BigInteger sss = new BigInteger(bound, rnd);
            //System.out.println(sss);
        }

        for (int i = 0; i < 100; i++) {
            SecureRandom s = new SecureRandom();
            float qqq = s.nextFloat();
            //System.out.println(qqq);
        }

        ss = new BigInteger("3");
        pp = new BigInteger("20");
        xx = ss.modInverse(pp);
        System.out.println(xx.toString());


    }
}
