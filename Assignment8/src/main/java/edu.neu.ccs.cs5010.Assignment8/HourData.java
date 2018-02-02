package edu.neu.ccs.cs5010.Assignment8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Hour data.
 */
public class HourData implements Database{
	private int[] lineIndex;
	private List<String> list;
	private String file = "hour.csv";
	private final static int startIndex = 2;

	/**
	 * Instantiates a new Hour data.
	 */
	public HourData() {
		this.lineIndex = new int[6];
		for(int i=0; i<lineIndex.length; i++) {
			lineIndex[i] = startIndex + i * 14;
		}
		this.list = new ArrayList<>();
	}

	@Override
	public List<String> read(int section) {
		list.clear();
		try {
			switch (section - 1) {
				case (0): {
					for (int i = 0; i < 10; i++) {
						list.add(Files.readAllLines(Paths.get(file)).get(lineIndex[0]+ i));
					}
				}
				case (1): {
					for (int i = 0; i < 10; i++) {
						list.add(Files.readAllLines(Paths.get(file)).get(lineIndex[1]+ i));
					}
				}
				case (2): {
					for (int i = 0; i < 10; i++) {
						list.add(Files.readAllLines(Paths.get(file)).get(lineIndex[2]+ i));
					}
				}
				case (3): {
					for (int i = 0; i < 10; i++) {
						list.add(Files.readAllLines(Paths.get(file)).get(lineIndex[3]+ i));
					}
				}
				case (4): {
					for (int i = 0; i < 10; i++) {
						list.add(Files.readAllLines(Paths.get(file)).get(lineIndex[4]+ i));
					}
				}
				case (5): {
					for (int i = 0; i < 10; i++) {
						list.add(Files.readAllLines(Paths.get(file)).get(lineIndex[5]+ i));
					}
				}
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
