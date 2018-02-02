package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by wenfei on 10/29/17.
 */
public class RandomNumber {
    public SecureRandom randomNum;

    /**
     * Given a random range, return a true random number in that range.
     *
     * @return a int random number
     */
    public int getRandom(int range) {
        randomNum = new SecureRandom();
        int randomNumber = randomNum.nextInt(range);
        return randomNumber;
    }

    /**
     * Given a random range, return a true random number in that range.
     *
     * @return a int random number
     */
    public float getRandomFloat() {
        randomNum = new SecureRandom();
        float randomNumber = randomNum.nextFloat();
        return randomNumber;
    }

}
