package edu.neu.ccis.cs5010.assignment7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class SkiDataProcessor {
	private BlockingQueue<int[]> skierQueue;
	private BlockingQueue<Integer> liftQueue;
	private BlockingQueue<int[]> hourQueue;
	private Map<Integer, Skier> skierMap;
	private Map<Integer, Lift> liftMap;
	private Map<Integer, Hour> hourMap;

	public SkiDataProcessor() {
		this.skierMap = new HashMap<>();
		this.liftMap = new TreeMap<>();
		this.hourMap = new TreeMap<>();
		this.skierQueue = new LinkedBlockingDeque<>();
		this.liftQueue = new LinkedBlockingDeque<>();
		this.hourQueue = new LinkedBlockingDeque<>();
	}

	public void process(String file) {
		try {
			InputStream inputStream = new FileInputStream(file);
			Reader rder = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader reader = new BufferedReader(rder);
			String line = reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] args = line.split(",");
				int skierId = Integer.parseInt(args[2]);
				int liftId = Integer.parseInt(args[3]);
				int time = Integer.parseInt(args[4]);
				int section = getSection(time);
				checkSkier(skierId, liftId);
				checkLift(liftId);
				checkSection(section, liftId);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void process(String file, int flag) {
		try {
			InputStream inputStream = new FileInputStream(file);
			Reader rder = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader reader = new BufferedReader(rder);
			String line = reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] args = line.split(",");
				int skierId = Integer.parseInt(args[2]);
				int liftId = Integer.parseInt(args[3]);
				int time = Integer.parseInt(args[4]);
				int section = getSection(time);
				int[] array = new int[] {skierId, liftId};
				int[] array2 = new int[] {section, liftId};
				skierQueue.add(array);
				liftQueue.add(liftId);
				hourQueue.add(array2);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void output(int flag) {
		SkierThread skierThread = new SkierThread(skierQueue);
		Thread thread1 = new Thread(skierThread);
		LiftThread liftThread = new LiftThread(liftQueue);
		Thread thread2 = new Thread(liftThread);
		HourThread hourThread = new HourThread(hourQueue);
		Thread thread3 = new Thread(hourThread);
		Long time = System.currentTimeMillis();
		thread1.start();
		thread2.start();
		thread3.start();
		System.out.print("Concurrent Solution : " + (System.currentTimeMillis() - time) + " ms");
	}

	public void output() {
			String skierHeader = "SkierID, Vertical";
			String liftHeader = "LiftID, Number of Rides";
			String hourHeader = "LiftID, Number of Rides";
			Long time = System.currentTimeMillis();
			outputSkier(skierHeader);
			outputLift(liftHeader);
			outputHour(hourHeader);
			System.out.println("Sequential Solution :" + (System.currentTimeMillis() - time) + " ms");
	}

	private void outputSkier(String header) {
		File file = new File("skier.csv");
		List<Map.Entry<Integer, Skier>> list = new ArrayList<>(skierMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Skier>>() {
			@Override
			public int compare(Map.Entry<Integer, Skier> o1, Map.Entry<Integer, Skier> o2) {
				return o2.getValue().getVertical() - o1.getValue().getVertical();
			}
		});
		try {
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getPath()));
			writer.write(header);
			writer.write("\n");
			Iterator<Map.Entry<Integer, Skier>> iterator = list.iterator();
			int count = 0;
			while(iterator.hasNext()) {
				StringBuilder stringBuilder = new StringBuilder();
				Map.Entry<Integer, Skier> entry = iterator.next();
				int id = entry.getKey();
				int vertical = entry.getValue().getVertical();
				stringBuilder.append(id);
				stringBuilder.append(" ");
				stringBuilder.append(vertical);
				writer.write(stringBuilder.toString());
				writer.write("\n");
				count++;
				if(count == 100) break;
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void outputLift(String header) {
		File file = new File("lift.csv");
		try {
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getPath()));
			writer.write(header);
			writer.write("\n");
			Iterator<Map.Entry<Integer, Lift>> iterator = liftMap.entrySet().iterator();
			while(iterator.hasNext()) {
				StringBuilder stringBuilder = new StringBuilder();
				Map.Entry<Integer, Lift> entry = iterator.next();
				int id = entry.getKey();
				int rides = entry.getValue().getRides();
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

	private void outputHour(String header) {
		File file = new File("hour.csv");
		//List<Map.Entry<String, Hour>> list = new ArrayList<>(hourMap.entrySet());
		Iterator<Map.Entry<Integer, Hour>> iterator = hourMap.entrySet().iterator();
		try {
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getPath()));
			while(iterator.hasNext()) {
				Map.Entry<Integer, Hour> entry = iterator.next();
				writer.write("Hour" + entry.getValue().getHour());
				writer.write("\n");
				writer.write(header);
				writer.write("\n");
				Hour hour = entry.getValue();
				Map<Integer, Integer> map = hour.getMap();
				List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
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

	private void checkSkier(int skierId, int liftId) {
		if(skierMap.containsKey(skierId)) {
			Skier skier = skierMap.get(skierId);
			skier.increaseVertical(liftId);
			skierMap.put(skierId, skier);
		}
		else {
			Skier skier = new Skier(skierId);
			skier.increaseVertical(liftId);
			skierMap.put(skierId, skier);
		}
	}

	private void checkLift(int liftId) {
		if(liftMap.containsKey(liftId)) {
			Lift lift = liftMap.get(liftId);
			lift.addRide();
			liftMap.remove(liftId);
			liftMap.put(liftId, lift);
		}
		else {
			Lift lift = new Lift(liftId);
			lift.addRide();
			liftMap.put(liftId, lift);
		}
	}

	private void checkSection(int section, int liftId) {
		if(hourMap.containsKey(section)) {
			Hour hour = hourMap.get(section);
			hour.addLift(liftId);
		}
		else {
			Hour hour = new Hour(section);
			hour.addLift(liftId);
			hourMap.put(section, hour);
		}
	}

	private int getSection(int time) {
		if(time <= 60) {
			return 1;
		}
		else if(time <= 120) {
			return 2;
		}
		else if(time <= 180) {
			return 3;
		}
		else if(time <= 240) {
			return 4;
		}
		else if(time <= 300) {
			return 5;
		}
		else {
			return 6;
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
			String line;
			if((line=bufferedReader.readLine()) != null) {
				SkiDataProcessor skiDataProcessor = new SkiDataProcessor();
				skiDataProcessor.process(line);
				skiDataProcessor.output();
				int concurrent = 1;
				skiDataProcessor.process(line, concurrent);
				skiDataProcessor.output(concurrent);
			}
			else {
				throw  new NullPointerException();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
