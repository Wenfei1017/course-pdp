package edu.neu.ccs.cs5010;

import java.io.FileNotFoundException;
import java.util.AbstractCollection;
import java.util.ArrayList;

/**
 * Created by wenfei on 10/23/17.
 */
public class HalloweenNeighborhoodTraversal {
    public static final int childIndex = 0;
    public static final int fileIndex = 1;
    /**
     * Read command line and set the neighbor.
     * add all the candy from historical data
     */
    public static void setNeighbor(String[] commandLine) throws FileNotFoundException {
        int childNum = Integer.parseInt(commandLine[childIndex]);
        int childFileIndex = fileIndex; // the index of the child dream list file
        String childFile = null;
        CSVFileReader fileReader = new CSVFileReader();
        ArrayList<Candy> dreamList;
        
        for (int i = 0; i < childNum; i++, childFileIndex++) {
            childFile = commandLine[childFileIndex];
            dreamList = fileReader.getDreamList(fileReader.readFile(childFile));

            if (fileReader.checkList(dreamList)) {
                INeighborhood neighborhood = new Neighborhood(dreamList);
                neighborhood.accept(new NeighborhoodVisitor());
            } else {
                System.out.println("\nFile " + childFile + " is not a valid dream list.\n");
            }
            
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        String[] testLine = {"2", "DreamCandy2.csv", "DreamCandy1.csv"};
        setNeighbor(testLine);
    }
}
