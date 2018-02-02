package edu.neu.ccs.cs5010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * The type Info process.
 */
public class InfoProcess {
  /**
   * The Info from client.
   */
  BufferedReader infoFromClient;

  /**
   * Instantiates a new Info process.
   *
   * @param infoFromClient the info from client
   */
  public InfoProcess(BufferedReader infoFromClient) {
    this.infoFromClient = infoFromClient;
  }

  /**
   * Gets feed back.
   *
   * @param readFromServer process info from sever and generate feedback
   * @return the feedback from player
   * @throws IOException the io exception
   */
  public String getFeedBack(String readFromServer) throws IOException {
    String[] readFromServerArray = readFromServer.split(":");
    //readFromServerArray[0]: the message's frame
    switch (readFromServerArray[0]) {
      case "START_GAME":
        processInfo(readFromServerArray[0]);
        return "";
      case "START_ROUND":
        processInfo(readFromServerArray[0]);
        return "";
      case "START_TURN":
        processInfo(readFromServerArray[0]);
        return "";
      case "CHOOSE_DICE":
        return chooseDice(readFromServerArray[1]);
      case "INVALID_DICE_CHOICE":
        return "Invalid,please choose again";
      case "CHOOSE_SCORE":
        System.out.println();
        return chooseScore(readFromServerArray[1]);
      case "SCORE_CHOICE_INVALID":
        System.out.println();
        return chooseScore(readFromServerArray[1]);
      case "SCORE_CHOICE_VALID":
        processInfo(readFromServerArray[0]);
        return "";
      case "TURN_OVER":
        processInfo(readFromServerArray[0]);
        return "";
      case "ROUND_OVER":
        processInfo(readFromServerArray[0]);
        return "";
      case "GAME_OVER":
        return "Game over";
      case "ACK":
        return "I've got the acknowledgement";
      case "INFO":
        return "";
    }
    return "not in the frame";
  }

  /**
   * Process info.
   *
   * @param infoFromServer process if server sent "INFO"
   */
  public void processInfo(String infoFromServer) {
    System.out.println(infoFromServer);
  }

  /**
   * Choose dice string.
   *
   * @param diceChose player choose dice he/she want to keep
   * @return the dice index player want to keep
   * @throws IOException the io exception
   */
  public String chooseDice(String diceChose) throws IOException {
    System.out.println("Your dice are " + diceChose);
    System.out.println("PLEASE CHOSE DICE YOU WANT TO KEEP");
    String diceToKeep = infoFromClient.readLine();
    StringBuilder outPut = new StringBuilder();
    outPut.append("KEEP_DICE: ");
    outPut.append(diceChose);
    String[] keepOrNot = diceToKeep.split(" ");
    //if the player doesn't want to keep any dice in this rolling
    if (diceToKeep.length() == 0) {
      for (int i = 1; i <= 5; i++) {
        outPut.append(" 0");
      }
      return outPut.toString();
    }

    int i = 0;
    for (int index = 1; index < 6; index++) {
      if (i < keepOrNot.length && index == Integer.parseInt(keepOrNot[i])) {
        outPut.append(" 1");
        i++;
      } else {
        outPut.append(" 0");
      }
    }
    System.out.println("return message= " + outPut.toString());
    return outPut.toString();
  }

  /**
   * Choose score string.
   *
   * @param scoreChose server sent several score to player to choose from
   * @return the score player choose
   * @throws IOException the io exception
   */
  public String chooseScore(String scoreChose) throws IOException {
    System.out.println("scoreChose= " + scoreChose);
    System.out.println("Please chose your score type here");

    StringBuilder chooseScore = new StringBuilder();
    StringBuilder playerChioce = new StringBuilder();
    String[] scoreChoseArray = scoreChose.split(" ");

    //according to the server frame, the score choose start from index 7
    int startIndex = 7;
    for (int i = startIndex; i < scoreChoseArray.length; i++) {
      chooseScore.append(" " + scoreChoseArray[i]);
    }
    BufferedReader soreChoseBr = new BufferedReader(new InputStreamReader(System.in));
    String userInput = soreChoseBr.readLine();

    playerChioce.append("SCORE_CHOICE:" + userInput);
    return playerChioce.toString();
  }

}
