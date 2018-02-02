package edu.neu.ccis.cs5010.assignment7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LiftThread implements Runnable {
	private Queue<Integer> liftQueue;
	private Map<Integer, Integer> map;

	public LiftThread(Queue<Integer> liftQueue) {
		this.liftQueue = liftQueue;
		this.map = new TreeMap<>();
	}

	@Override
	public void run() {

		while(!liftQueue.isEmpty()) {
			int liftId = liftQueue.poll();
			if(map.containsKey(liftId)) {
				map.put(liftId, map.get(liftId) + 1);
			}
			else {
				map.put(liftId, 1);
			}
		}

		Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
		File file = new File("lift.csv");
		String header = "LiftID, Number of Rides";
		try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getPath()))) {
			writer.write(header);
			writer.write("\n");
			while(iterator.hasNext()) {
				Map.Entry<Integer, Integer> entry = iterator.next();
				StringBuilder stringBuilder = new StringBuilder();
				int id = entry.getKey();
				int rides = entry.getValue();
				stringBuilder.append(id);
				stringBuilder.append(" ");
				stringBuilder.append(rides);
				writer.write(stringBuilder.toString());
				writer.write("\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
