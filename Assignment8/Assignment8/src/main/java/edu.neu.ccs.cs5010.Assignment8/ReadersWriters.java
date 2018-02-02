package edu.neu.ccs.cs5010.Assignment8;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * The type Readers writers.
 */
public class ReadersWriters extends Thread {
	private int id;
	private Database database;
	private String name;
	private List<String> blockingQueue;
	private BlockingQueue<int[]> queryQueue;
	private Database[] databases;

	/**
	 * Instantiates a new Readers writers.
	 *
	 * @param id         the id
	 * @param queryQueue the query queue
	 * @param databases  the databases
	 */
	public ReadersWriters(int id, BlockingQueue<int[]> queryQueue, Database[] databases) {
		this.id = id;
		this.database = null;
		this.name = "thread" + id;
		this.blockingQueue = new ArrayList<>();
		this.queryQueue = queryQueue;
		this.databases = databases;
	}

	public long getId() {
		return this.id;
	}

	@Override
	public void run() {

			while(!queryQueue.isEmpty()) {
				int[] query = queryQueue.poll();
				check(query);
				List<String> result = database.read(query[1]);
				Iterator<String> iterator = result.iterator();
				try {
					FileWriter fileWriter = new FileWriter(name, true);
					while(iterator.hasNext()) {
						String line = iterator.next();
						fileWriter.write(line);
						fileWriter.write("\n");
					}
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}

	private void check(int[] query) {
		if(query[0] == 1) {
			this.database = databases[0];
		}
		else if(query[0] == 2) {
			this.database = databases[1];
		}
		else if(query[0] == 3) {
			this.database = databases[2];
		}
		else {
			this.database = databases[3];
		}
	}
}
