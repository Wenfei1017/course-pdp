package edu.neu.ccs.cs5010.Assignment8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Skier data.
 */
public class SkierData implements Database{
	private String file = "skier.csv";
	private List<String> list;
	private Map<Integer, Integer> skierViews;


	/**
	 * Instantiates a new Skier data.
	 */
	public SkierData() {
		this.list = new ArrayList<>();
		this.skierViews = new HashMap<>();
	}

	public List<String> read(int skierId) {
		list.clear();
		try {
				synchronized (this) {
					String res = Files.readAllLines(Paths.get(file)).get(skierId);
					skierViews.put(skierId, skierViews.getOrDefault(skierId, 0) + 1);
					res = res + " " + skierViews.get(skierId);
					list.add(res);
				}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<>(list);
	}

	@Override
	public void write(int arg) {
	}
}
