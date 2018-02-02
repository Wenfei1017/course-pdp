package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ClientGenerator {
    Client client;
    HashSet<Client> clientHashSet;
    List<Client> clientList;
    /**
     * create num number of clients
     * @param num the number of client users want to create
     */
    public List<Client> createClient(int num){
        clientHashSet = new HashSet<>();
        clientList = new ArrayList<>();
        Double IDNumber;
        Random random = new Random();
        //generate client ID
        for(int i = 0; i< num; i++){
            IDNumber = random.nextDouble() * 10000;
            if(!clientHashSet.contains(new Client(IDNumber))){
                Client client = new Client(IDNumber);
                client.ID = IDNumber;
                clientHashSet.add(client);
                clientList.add(client);
            }
            else i--;
        }
        return clientList;
    }

    public HashSet<Client> getClientHashSet(){
        return this.clientHashSet;
    }

}
