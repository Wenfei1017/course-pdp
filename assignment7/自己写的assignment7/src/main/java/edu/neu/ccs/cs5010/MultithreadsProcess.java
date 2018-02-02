package edu.neu.ccs.cs5010;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MultithreadsProcess {
    private static int kvPairQueueinList = 0;
    private static int liftQueueinList = 1;
    private static int hourQueueinList = 2;
    private static MyPriorityQueue skierQueue = new MyPriorityQueue();
    private Queue<int[]> KVPair;
    private Queue<Integer> liftQueue;
    private Queue<int[]> hourQueue;
    private DataSourse dataSourse;

    public MultithreadsProcess(DataSourse dataSourse) {
        this.dataSourse = dataSourse;
    }

    public class QueueThread extends Thread{
        @Override
        public void run(){
            int[] pair = KVPair.poll();
            skierQueue.insert(KVPair.poll());
        }
    }

    public List<int[]> processData(String csvFile) throws FileNotFoundException {
        KVPair = dataSourse.getKVQueueList(csvFile).get(kvPairQueueinList);
        liftQueue = dataSourse.getKVQueueList(csvFile).get(liftQueueinList);
        hourQueue = dataSourse.getKVQueueList(csvFile).get(hourQueueinList);
    }
}
