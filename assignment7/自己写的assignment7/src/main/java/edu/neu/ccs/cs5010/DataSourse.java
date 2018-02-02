package edu.neu.ccs.cs5010;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DataSourse {
    private Queue KVPairQueue;
    private Queue liftQueue;
    private Queue hourQueue;
    private final int resort = 0;
    private final int day = 1;
    private final int skierID = 2;
    private final int liftID = 3;
    private final int timeStamp = 4;
    private static int skierIDinArray = 0;
    private static int liftIDinArray = 1;
    private static int hourInArray = 0;
    private static int liftIDinHourPair = 1;

    public DataSourse(Queue KVPairQueue,Queue liftQueue,Queue hourQueue){
        this.KVPairQueue = KVPairQueue;
        this.liftQueue = liftQueue;
        this.hourQueue = hourQueue;
    }

    public List<Queue> getKVQueueList(String csvFile) throws FileNotFoundException {
        List<Queue> queueList = new ArrayList<>();
        Queue<int[]> KVPairQueue = new LinkedList();
        Queue<Integer> liftQueue = new LinkedList();
        Queue<int[]> hourQueue = new LinkedList();
        InputStream inputStream = new FileInputStream(csvFile);
        Reader rder = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(rder);
        String[] info;
        String line = null;
        if(csvFile == null){
            throw new IllegalArgumentException("Template file should not be null");
        }
        try{
            while((line= reader.readLine())!=null && line.length() > 0){
                int[] IDPair = new int[2];
                int[] hourPair = new int[2];
                String[] rowInfo = line.split(",");
                info = new String[4];
                IDPair[skierIDinArray] = Integer.parseInt(rowInfo[skierID]);
                IDPair[liftIDinArray] = Integer.parseInt(rowInfo[liftID]);
                KVPairQueue.add(IDPair);
                hourPair[hourInArray] = getHour(rowInfo[timeStamp]);
                hourPair[liftIDinHourPair] = Integer.parseInt(rowInfo[liftID]);
                hourQueue.add(hourPair);
                liftQueue.add(Integer.parseInt(rowInfo[liftID]));

            }
            reader.close();
        }catch (Exception e) {
            e.printStackTrace();

        }
        queueList.add(KVPairQueue);
        queueList.add(liftQueue);
        queueList.add(hourQueue);
        return queueList;
    }

    public int getHour(String timeInFile) throws IOException{
        int hour;
        double time = Double.parseDouble(timeInFile);
        if(time < 1 || time > 360) throw new IllegalArgumentException(
                "time wrong in file"
        );
        if (time <= 60) hour = 1;
        else if (time > 60 && time <= 120) hour = 2;
        else if (time > 120 && time <= 180) hour = 3;
        else if (time > 180 && time <= 240) hour = 4;
        else if (time > 240 && time <= 300) hour = 5;
        else hour = 6;
        return hour;
    }

    public int hetVertical(String liftIDinCSV) throws IllegalArgumentException {
        int verticalNum;
        int liftID = Integer.parseInt(liftIDinCSV);
        if(liftID < 1 || liftID > 40) throw new IllegalArgumentException("invalid vertical");

        if(liftID >= 1 && liftID <= 10) verticalNum = 200;
        else if(liftID >= 11 && liftID <= 20) verticalNum = 300;
        else if(liftID >= 21 && liftID <= 30) verticalNum = 400;
        else  verticalNum = 500;
        return verticalNum;
    }

}
