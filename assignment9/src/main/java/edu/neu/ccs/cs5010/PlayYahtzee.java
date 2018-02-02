package edu.neu.ccs.cs5010;


import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * The type Play yahtzee.
 */
public class PlayYahtzee {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {

    try (
      Socket clientSocket = new Socket(args[0], Integer.parseInt(args[1]));
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    ) {
      BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
      InfoProcess playYahtzee = new InfoProcess(stdIn);
      String fromServer, fromUser;
      //System.out.println("come here");

      while ((fromServer = in.readLine()) != null) {
        fromUser = playYahtzee.getFeedBack(fromServer);

        System.out.println("fromServer= " + fromServer);
        if (fromServer.contains("GAME_OVER"))
          break;

        if (fromUser != null) {
          System.out.println("Client: " + fromUser);
          out.println(fromUser);
        }
      }

      clientSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
