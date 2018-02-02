package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by wenfei on 10/29/17.
 */
public class ClientGenerator {
    public static final int clientIDBound = 1000000;
    public static final int depositBound = 2000;
    public static final int withdrawalBound = 3000;

    public HashMap<Integer, Client> clientData;
    public int clientNumber;

    /**
     * Client data constructor.
     */
    public ClientGenerator(int clientNum){
        this.clientNumber = clientNum;
    }

    /**
     * Generate the client data.
     */
    public HashMap<Integer, Client> generateClientData(){
        RandomNumber randomNum = new RandomNumber();
        HashSet<Integer> clientIDSet = new HashSet<>();
        RSAKeyGenerator keyGenerator = new RSAKeyGenerator();
        Client client;
        BigInteger[][] keyPair;
        BigInteger[] publicKey;
        BigInteger[] privateKey;

        int clientID;
        clientData = new HashMap();
        for (int i = 0; i < this.clientNumber; ) {
            clientID = randomNum.getRandom(clientIDBound) + 1;
            if (!clientIDSet.contains(clientID)) {
                keyPair = keyGenerator.generateKey();
                publicKey = keyPair[RSAKeyGenerator.publicKeyIndex];
                privateKey = keyPair[RSAKeyGenerator.privateKeyIndex];
                client = new Client(clientID, publicKey, privateKey,
                        randomNum.getRandom(depositBound + 1), randomNum.getRandom(withdrawalBound + 1));
                clientData.put(clientID, client);
                i++;
            }
        }
        return this.clientData;
    }
}
