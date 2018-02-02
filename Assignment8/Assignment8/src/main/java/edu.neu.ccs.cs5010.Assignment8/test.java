package edu.neu.ccs.cs5010.Assignment8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class test {

	public static void main(String[] args) {
		try (Stream<String> lines = Files.lines(Paths.get("liftrides.csv"))) {
				String line = lines.skip(1).findFirst().get();
				System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
