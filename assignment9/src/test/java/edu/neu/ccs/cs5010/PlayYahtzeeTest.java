package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static org.junit.Assert.*;

/**
 * The type Play yahtzee test.
 */
public class PlayYahtzeeTest {
  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    Socket clientSocket = new Socket("localhost", 1200);
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  }

  /**
   * Main.
   *
   * @throws Exception the exception
   */
  @Test
  public void main() throws Exception {
  }

}