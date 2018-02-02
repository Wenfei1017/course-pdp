package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class SecureBankVerificationSimulator {
    private static int clientNumber = 0;
    private static int verificationsNumber = 1;
    private static int validFraction = 2;
    private static int fileName = 3;
    private static HashSet<Client> clientSet;
    private static List<Client> verifyList;

    public static void Simulator(String[] commandLine) throws NoSuchAlgorithmException {
        int clientNum = Integer.parseInt(commandLine[clientNumber]);
        int verificationNum = Integer.parseInt(commandLine[verificationsNumber]);
        double fraction = Double.parseDouble(commandLine[validFraction]);
        String savePath = commandLine[fileName];



        Message messageGenerater = new Message();
        RSAPairCreator clientkeys = new RSAPairCreator();
        SignatureGeneration signatureGeneration = new SignatureGeneration();
        Verifacation verifacation = new Verifacation();
        RSAPublicKey publicKey;
        RSAPrivateKey privateKey;
        BigInteger signedMessage;
        BigInteger status;
        int message;

        //clientList = new ClientGenerator().createClient(clientNum);

        for(Client thisclient : getVerifyList(verificationNum)){
            message = messageGenerater.message;
            thisclient.creatMessage(message);//set the message this client request
            //message = thisclient.getMessage();
            //generate key pair by createkey method and get the private key
            privateKey = clientkeys.createKeys(thisclient).getPrivateKey();
            //generate key pair by createkey method and get the public key
            publicKey = clientkeys.createKeys(thisclient).getPublicKey();
            signedMessage = signatureGeneration.sign(thisclient, privateKey);
            status = verifacation.verify(message,signedMessage,publicKey);
            if(status.equals(message)){
                CreatFile writeFile = new CreatFile();
                writeFile.creatFile(thisclient.ID,message,signedMessage,);
            }
        }
    }


    //determine if the signature generated successfully according to fraction
    public boolean checkIfValid(float fraction){
        int i;
        Random random = new Random();
        i = random.nextInt(10);
        if(i<=fraction*10){
            return true;
        }return false;
    }

    //pick client from client hashset randomly
    public static Client pickClient() {
        ClientGenerator clientGenerator = new ClientGenerator();
        clientSet = new HashSet<>();
        clientSet = clientGenerator.getClientHashSet();
        int size = clientSet.size();
        int item = new Random().nextInt(size);
        int count = 0;
        for (Client pickthis : clientSet) {
            if (count == item)
                return pickthis;
                count = count+1;
        }return null;
    }

    //return verify list that contains clients needed to be verified.
    public static List<Client> getVerifyList(int verificationsNumber){
        verifyList = new ArrayList<>();
        for (int i = 0;i<verificationsNumber;i++){
            verifyList.add(pickClient());
        }
        return verifyList;
    }

}
