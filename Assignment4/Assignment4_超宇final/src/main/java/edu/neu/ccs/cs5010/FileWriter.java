package edu.neu.ccs.cs5010;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by xwenfei on 10/23/17.
 */
public class FileWriter {

    /**
     * Get the current candy list and file name, create the file.
     *
     * @param currentCandy the fileName
     * @param fileName the fileName
     *
     * @throws IllegalArgumentException if file is not created successfully
     */
    public void writeFile(ArrayList<Candy> currentCandy, String fileName)
            throws IllegalArgumentException {
        if (fileName == null || currentCandy == null) {
            throw new IllegalArgumentException("filename and candylist should not be null");
        }
        java.io.FileWriter Writer = null;

        try {
            Writer = new java.io.FileWriter(fileName.replace("Candy", "Travesal"));
            Writer.write("Candy Type, Candy size, Household type\n");
            for (Candy candy: currentCandy) {
                Writer.write(candy.getCandySize() + " Size, ");
                Writer.write(candy.getCandyName() + ", ");
                Writer.write(candy.getCandyHouse() + "\n");
            }
        } catch(IOException e) {
            e.getStackTrace();
        } finally {
            if (Writer != null) {
                try {
                    Writer.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        }
    }
}
