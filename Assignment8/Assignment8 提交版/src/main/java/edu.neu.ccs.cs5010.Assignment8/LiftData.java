package edu.neu.ccs.cs5010.Assignment8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Lift data.
 */
public class LiftData implements Database{

	private String file = "lift.csv";
	private List<String> list;

	/**
	 * Instantiates a new Lift data.
	 */
	public LiftData() {
		this.list = new ArrayList<>();
	}

	public List<String> read(int liftId) {
		list.clear();
		try {
			list.add(Files.readAllLines(Paths.get(file)).get(liftId));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<>(list);
	}

	public void write(int skierId) {

	}
}
