package edu.neu.ccs.cs5010;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Created by wenfei on 10/30/17.
 */
public class OutputFile {

    /**
     * Get the file writer.
     */
    public FileWriter getFileWriter(String fileName) throws IllegalArgumentException {
        if (fileName == null) {
            throw new IllegalArgumentException("filename should not be null");
        }
        FileWriter writer = null;

        try {
            writer = new java.io.FileWriter(fileName);
            return writer;
        } catch(IOException e) {
            e.getStackTrace();
        }
        return writer;
    }

    /**
     * Get the file writer.
     */
    public void closeFile(FileWriter writer) throws IllegalArgumentException {
        if (writer == null) {
            throw new IllegalArgumentException("writer should not be null");
        } else {
            try {
                writer.close();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    /**
     * Get the transaction parameters and output the file.
     *
     * @param message the message
     * @param client the client from bank dataset
     * @param signature the signature
     * @param verified whether the signature is verified
     *
     * @throws IllegalArgumentException if file is not created successfully
     */
    public void writeFile(int message, Client client, BigInteger signature, String status, boolean verified, FileWriter writer)
            throws IllegalArgumentException, IOException {
        LocalDateTime currentTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        writer.write(message / 10 + ", ");
        writer.write(currentTime.toLocalDate().toString() + ", ");
        writer.write(currentTime.toLocalTime().toString() + ", ");
        writer.write(client.clientID + ", ");
        writer.write(message + ", ");
        writer.write(signature.toString() + ", ");
        if (verified) {
            writer.write("yes, ");
        } else {
            writer.write("no, ");
        }
        writer.write(status);
    }
}
