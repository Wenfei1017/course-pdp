package edu.neu.ccs.cs5010;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class WriteFile {
    public void WriteCandyFile(List<Candy> list,String fileName) throws IOException {
        Writer writer = new FileWriter("fileName.replace(\"Candy\", \"Travesal\")");
        writer.write("Candy Type, Candy size, Household type\n");
        for (Candy candy:list){
            writer.write(candy.getCandySize() + " Size, ");
            writer.write(candy.getCandyName() + ", ");
            writer.write(candy.getCandyHouse() + "\n");
        }
    }

}
