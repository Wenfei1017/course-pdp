package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Client {

    double ID;
    int message;
    int depositLimit;
    int withdrawalLimit;
    RSAPublicKey publicKey;

    List<Client> clientList = new ArrayList<>();
    HashSet<Client> clientHashSet = new HashSet<>();

    public Client(Double ID){
        this.ID = ID;
    }



    /*public void createKeyPair(RSAKeyPair rsaKeyPair){
        this.rsaKeyPair = rsaKeyPair;
    }*/
    /**
     * print the whole client list
     */

    /**
     * set the client's deposit limitation randomly, the range is[0,2000]
     * @param client
     */
    public void setDeposit(Client client){
        Random random = new Random();
        client.depositLimit = random.nextInt(2000);
    }

    /**
     * set the client's withdrawal limitation randomly, the range is[0,3000]
     * @param client
     */
    public void setWithdrawal(Client client){
        Random random = new Random();
        client.withdrawalLimit = random.nextInt(3000);
    }

    /**
     * print the client list
     */
    public void printClientList(){
        System.out.println(this.clientList);
    }

    /**
     *
     * @return the client ID
     */
    public Double getClientID(){
        return this.ID;
    }

    /**
     *
     * @return the deposit limit
     */
    public int getDepositLimit(){
        return this.depositLimit;
    }

    public int getWithdrawalLimit(){
        return this.withdrawalLimit;
    }

    //create the message this client want to sent
    public void creatMessage(int message){
        this.message = message;
    }

    public int getMessage(){
        return this.message;
    }

    /*public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }*/

    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    //public RSAKeyPair getRsaKeyPair(){
        //return this.rsaKeyPair;

}
