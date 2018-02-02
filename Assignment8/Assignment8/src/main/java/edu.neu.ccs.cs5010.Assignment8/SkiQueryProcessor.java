package edu.neu.ccs.cs5010.Assignment8;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * The type Ski query processor.
 */
public class SkiQueryProcessor {

	private final static int factor = 20;
	private Queue<ReadersWriters> blockingQueue;
	private Database[] databases;
	private BlockingQueue<int[]> queue;
	private final static int segment = 2000;
	private ExecutorService executorService;

	/**
	 * Instantiates a new Ski query processor.
	 */
	public SkiQueryProcessor() {
		this.blockingQueue = new LinkedList<>();
		databases = new Database[4];
		databases[0] = new SkierData();
		databases[1] = new LiftRidesData();
		databases[2] = new HourData();
		databases[3] = new LiftData();
		this.queue = new LinkedBlockingQueue<>();
		this.executorService = Executors.newFixedThreadPool(20);
	}

	/**
	 * Query.
	 *
	 * @param file    the file
	 * @param queries the queries
	 */
	public void query(String file, int queries) {
		try {
			InputStream inputStream = new FileInputStream(file);
			Reader rder = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader reader = new BufferedReader(rder);
			String line;
			while((line = reader.readLine()) != null) {
				String[] args = line.split(",");
				int[] query = new int[2];
				query[0] = Integer.parseInt(args[0]);
				query[1] = Integer.parseInt(args[1]);
				queue.add(query);
			}
			reader.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0; i<factor; i++) {
			BlockingQueue<int[]> temporary = new LinkedBlockingQueue<>();
			for(int j=0; j<segment; j++) {
					temporary.add(queue.poll());
			}
			ReadersWriters readersWriters = new ReadersWriters(i+1, temporary, databases);
			executorService.execute(readersWriters);
		}
		long startTime = System.currentTimeMillis();
		executorService.shutdown();
		while(true) {
			if(executorService.isTerminated()) {
				long finishTime = System.currentTimeMillis();
				System.out.println("Total time is " + (finishTime - startTime) + " ms");
				break;
			}
		}
	}

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
			String line;
			if((line=bufferedReader.readLine()) != null) {
				SkiQueryProcessor skiQueryProcessor = new SkiQueryProcessor();
				String[] arguments = line.split(" ");
				String file = arguments[0];
				int queries = Integer.parseInt(arguments[1]);
				if(queries % factor != 0) throw new Exception("The 20 is not a factor of query number");
				skiQueryProcessor.query(file, queries);
			}
			else {
				throw  new NullPointerException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
