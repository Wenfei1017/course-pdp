package edu.neu.ccs.cs5010;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenfei on 10/30/17.
 */
public class SecureBankVerificationSimulator {

    public static final int clientsNumberIndex = 0;
    public static final int verificationNumbertIndex = 1;
    public static final int fractionIndex = 2;

    private static HashMap<Integer, Client> clientData;
    private static HashMap<Integer, Client> clientBankData;
    private static ArrayList<BigInteger[]> rawPairs;
    private static ArrayList<Integer> clientIDArray;

    /**
     * Generate and store all clients, both clients itself and the clients in bank.
     * Also, store all the ID information in an array.
     *
     */
    public static void generateClients(int clientsNumber) {
        ClientGenerator clientGenerator = new ClientGenerator(clientsNumber);
        clientData = clientGenerator.generateClientData();
        Client client;
        for (Map.Entry<Integer, Client> entry: clientData.entrySet()) {
            client = entry.getValue();
            client.deletePrivateKey();
            clientBankData.put(entry.getKey(), client);
            clientIDArray.add(client.getClientID());
        }

    }

    /**
     * Generate message & signature pairs
     */
    public static void generatePairs(int pairNumber, float fraction) {
        BigInteger[] pair;
        Client client = null;
        PairGenerator pairGenerator = new PairGenerator();
        for (int i = 0; i < pairNumber; i++) {
            pair = pairGenerator.generatePairs(fraction, client);
            rawPairs.add(pair);
        }
    }

    /**
     * Read command line and set the neighbor.
     * add all the candy from historical data
     */
    public static void simulate(String[] commandLine) {
        int clientsNumber = Integer.parseInt(commandLine[clientsNumberIndex]);
        int pairNumber = Integer.parseInt(commandLine[verificationNumbertIndex]);
        float fraction = Integer.parseInt(commandLine[fractionIndex]);
        generateClients(clientsNumber);
        generatePairs(pairNumber, fraction);

    }

    /**
     * Main method, get command line from the user.
     */
    public static void main(String[] args) {
        String[] testLine = {"200", "200", "0.2", "output.txt"};
        simulate(testLine);
    }

}
