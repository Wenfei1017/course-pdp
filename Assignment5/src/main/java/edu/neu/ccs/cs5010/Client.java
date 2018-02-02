package edu.neu.ccs.cs5010;

import java.math.*;

/**
 * Created by wenfei on 10/29/17.
 */
public class Client {

    public int clientID;
    public BigInteger[] publicKey;
    public BigInteger[] privateKey;
    // First is public, second is private
    public int depositLimit;
    public int withdrawalLimit;

    /**
     * Client constructor.
     */
    public Client(int clientID, BigInteger[] publicKey, BigInteger[] privateKey,
                  int depositLimit, int withdrawalLimit){
        this.clientID = clientID;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.depositLimit = depositLimit;
        this.withdrawalLimit = withdrawalLimit;
    }

    /**
     * Given a client object, return the client ID.
     *
     * @return the ID of the client
     */
    public int getClientID() {
        return this.clientID;
    }

    /**
     * Given a client object, return the public key.
     *
     * @return the public key of the client
     */
    public BigInteger[] getPublicKey() {
        return this.publicKey;
    }

    /**
     * Given a client object, return the private key.
     *
     * @return the private of the client
     */
    public BigInteger[] getPrivateKey() {
        return this.privateKey;
    }

    /**
     * Given a client object, return the deposit limit.
     *
     * @return the deposit limit of the client
     */
    public int getDepositLimt() {
        return this.depositLimit;
    }

    /**
     * Given a client object, return the withdrawal limit.
     *
     * @return the withdrawal limit of the client
     */
    public int getWithdrawalLimt() {
        return this.withdrawalLimit;
    }

    /**
     * Given a client object, delete the private key.
     */
    public void deletePrivateKey() {
        this.privateKey = null;
    }

    /**
     * print the client info.
     */
    public void printInfo() {
        System.out.println("Client ID: \t" + this.clientID);
        System.out.println("Public key: \t" + this.publicKey[RSASignature.keyPart] +
                ", " +this.publicKey[RSASignature.publicPart]);
        System.out.println("Private key: \t" + this.privateKey[RSASignature.keyPart] +
                ", " + this.privateKey[RSASignature.publicPart]);
        System.out.println("Deposit limit: \t" + this.depositLimit);
        System.out.println("Withdrawal limit: \t" + this.withdrawalLimit);
    }


}
