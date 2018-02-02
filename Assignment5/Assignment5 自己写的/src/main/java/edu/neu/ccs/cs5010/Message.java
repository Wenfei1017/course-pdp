package edu.neu.ccs.cs5010;

import java.util.Random;

public class Message {
    int message;
    String requestType;

    //generate a message, if the last digit is 0-4,deposit;5-9,withdrawal
    public int creatMessage() {
        //int message;
        int i;
        Random random = new Random();
        this.message = random.nextInt(30000);

        return message;
    }

    public String creatType(int message) {
        int i;
        i = message % 10;
        //if m is a valid message? if true,determine the requesting type.
        if (i >= 0 && i <= 4) {
            this.requestType = "deposit";
        }
        if (i >= 5 && i <= 9) {
            this.requestType = "withdrawal";
        }
    }
}
