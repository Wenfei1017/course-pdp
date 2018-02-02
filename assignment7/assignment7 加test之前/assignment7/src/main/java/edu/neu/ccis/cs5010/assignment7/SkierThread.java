package edu.neu.ccis.cs5010.assignment7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SkierThread implements Runnable {

	private Queue<int[]> skierQueue;
	private Map<Integer, Integer> map;

	public SkierThread(Queue<int[]> skierQueue) {
		this.skierQueue = skierQueue;
		this.map = new HashMap<>();
	}

	@Override
	public void run() {
		while(!skierQueue.isEmpty()) {
			int[] array = skierQueue.poll();
			int skierId = array[0];
			int liftId = array[1];
			if(map.containsKey(skierId)) {
				map.put(skierId, map.get(skierId) + getVertical(liftId));
			}
			else {
				map.put(skierId, getVertical(liftId));
			}
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});

			File file = new File("skier.csv");
			String header = "SkierID, Vertical";
			try (	BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getPath()))) {
				writer.write(header);
				writer.write("\n");
				for(int i=0; i<100; i++) {
					Map.Entry<Integer, Integer> entry = list.get(i);
					StringBuilder stringBuilder = new StringBuilder();
					int id = entry.getKey();
					int vertical = entry.getValue();
					stringBuilder.append(id);
					stringBuilder.append(" ");
					stringBuilder.append(vertical);
					writer.write(stringBuilder.toString());
					writer.write("\n");
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	private int getVertical(int liftId) {
		if(liftId <= 10) {
			return 200;
		}
		else if(liftId <= 20) {
			return 300;
		}
		else if(liftId <= 30) {
			return 400;
		}
		else {
			return 500;
		}
	}
}
