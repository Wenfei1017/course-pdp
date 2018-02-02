package edu.neu.ccs.cs5010;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapGenerator {
    private static HashMap<Client,RSAKeyPair> clientMap = new HashMap<>();
    private static HashMap<Client, RSAPrivateKey> privateKeyHashMap = new HashMap<>();
    private static HashMap<Client,RSAPublicKey> publicKeyHashMap = new HashMap<>();
    //private Client client;
    private static List<Client> clientList = new ArrayList<>();
    private static RSAPairCreator rsaPairCreator = new RSAPairCreator();

    public HashMap<Client,RSAKeyPair> creatMap() throws NoSuchAlgorithmException {
        //clientList = new ArrayList<>();
        for(Client thisclient:clientList) {
            clientMap.put(thisclient,rsaPairCreator.createKeys(thisclient));
        }return clientMap;
    }

    public static HashMap<Client, RSAPrivateKey> getPrivateKeyHashMap() throws NoSuchAlgorithmException {

        for(Client thisclient:clientList){
            privateKeyHashMap.put(thisclient, (RSAPrivateKey) rsaPairCreator.createKeys(thisclient).getPrivateKey());
        }
        return privateKeyHashMap;
    }

    public static HashMap<Client,RSAPublicKey> getPublicKeyHashMap() throws NoSuchAlgorithmException {

        for(Client thisclient:clientList){
            publicKeyHashMap.put(thisclient, rsaPairCreator.createKeys(thisclient).getPublicKey());
        }
        return publicKeyHashMap;
    }
}
