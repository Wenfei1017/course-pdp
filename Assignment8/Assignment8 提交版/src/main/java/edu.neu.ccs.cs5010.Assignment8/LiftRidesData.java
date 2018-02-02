package edu.neu.ccs.cs5010.Assignment8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * The type Lift rides data.
 */
public class LiftRidesData implements  Database{
	private List<String> list;
	//private String file = "PDPAssignment.csv";
	private String file = "liftrides.csv";
	private final static int startIndex = 1;
	private final static int number = 20;

	/**
	 * Instantiates a new Lift rides data.
	 */
	public LiftRidesData() {
		this.list = new ArrayList<>();
	}

	@Override
	public List<String> read(int skierId) {
		List<String> list = new ArrayList<>();
		int start = startIndex + number * (skierId -1);
		try (Stream<String> lines = Files.lines(Paths.get(file))) {
			for(int i=start; i<number; i++) {
				String line = lines.skip(i).findFirst().get();
				list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<>(list);
//		try {
//			InputStream inputStream = new FileInputStream(file);
//			Reader rder = new InputStreamReader(inputStream, "UTF-8");
//			BufferedReader reader = new BufferedReader(rder);
//			String line = reader.readLine();
//			while ((line = reader.readLine()) != null) {
//				String[] args = line.split(",");
//				int skId = Integer.parseInt(args[2]);
//				int liftId = Integer.parseInt(args[3]);
//				int time = Integer.parseInt(args[4]);
//				if(skId == skierId) {
//					list.add(time + " " + liftId);
//				}
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Collections.sort(list, new Comparator<String>() {
//			@Override
//			public int compare(String object1, String object2) {
//				String[] array1 = object1.split(" ");
//				String[] array2 = object2.split(" ");
//				return array1[0].compareTo(array2[0]);
//			}
//		});
	}

	@Override
	public void write(int arg) {

	}
}
