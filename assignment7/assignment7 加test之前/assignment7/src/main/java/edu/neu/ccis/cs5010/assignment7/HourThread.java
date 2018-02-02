package edu.neu.ccis.cs5010.assignment7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class HourThread implements Runnable {
	private Queue<int[]> hourQueue;
	private Map<Integer, Map<Integer, Integer>> map;

	public HourThread(Queue<int[]> hourQueue) {
		this.hourQueue = hourQueue;
		this.map = new TreeMap<>();
	}

	@Override
	public void run() {
		while(!hourQueue.isEmpty()) {
			int[] array = hourQueue.poll();
			int section = array[0];
			int liftId = array[1];
			if(map.containsKey(section)) {
				Map<Integer, Integer> subMap = map.get(section);
				if(subMap.containsKey(liftId)) {
					subMap.put(liftId, subMap.get(liftId) + 1);
				}
				else {
					subMap.put(liftId, 1);
				}
			}
			else {
				Map<Integer, Integer> subMap = new HashMap<>();
				subMap.put(liftId, 1);
				map.put(section, subMap);
			}
		}

		File file = new File("hour.csv");
		String header = "LiftID, Number of Rides";
		Iterator<Map.Entry<Integer, Map<Integer, Integer>>> iterator = map.entrySet().iterator();
		try {
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getPath()));
			while(iterator.hasNext()) {
				Map.Entry<Integer, Map<Integer, Integer>> entry = iterator.next();
				writer.write("Hour" + entry.getKey());
				writer.write("\n");
				writer.write(header);
				writer.write("\n");
				Map<Integer, Integer> subMap = entry.getValue();
				List<Map.Entry<Integer, Integer>> list = new ArrayList<>(subMap.entrySet());
				Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
					@Override
					public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
						return o2.getValue() - o1.getValue();
					}
				});
				int count = 0;
				Iterator<Map.Entry<Integer, Integer>> iterator1 = list.iterator();
				while(iterator1.hasNext()) {
					Map.Entry<Integer, Integer> entry1 = iterator1.next();
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append(entry1.getKey());
					stringBuilder.append(" ");
					stringBuilder.append(entry1.getValue());
					writer.write(stringBuilder.toString());
					writer.write("\n");
					count++;
					if(count == 10) break;
				}
				writer.write("\n");
				writer.write("\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
