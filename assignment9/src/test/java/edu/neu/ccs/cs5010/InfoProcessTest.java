package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * The type Info process test.
 */
public class InfoProcessTest {
  /**
   * The Info process.
   */
  InfoProcess infoProcess;
  /**
   * The Scanner.
   */
  Scanner scanner;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    infoProcess = new InfoProcess(bufferedReader);
  }

  /**
   * Gets feed back.
   *
   * @throws Exception the exception
   */
  @Test
  public void getFeedBack() throws Exception {
    infoProcess.getFeedBack("INFO");
    infoProcess.getFeedBack("START_GAME");
    infoProcess.getFeedBack("START_ROUND");
    infoProcess.getFeedBack("START_TURN");
//    infoProcess.getFeedBack("CHOOSE_DICE");
    infoProcess.getFeedBack("INVALID_DICE_CHOICE");
//    infoProcess.getFeedBack("CHOOSE_SCORE");
//    infoProcess.getFeedBack("SCORE_CHOICE_INVALID");
    infoProcess.getFeedBack("SCORE_CHOICE_VALID");
    infoProcess.getFeedBack("TURN_OVER");
    infoProcess.getFeedBack("ROUND_OVER");
    infoProcess.getFeedBack("GAME_OVER");
    infoProcess.getFeedBack("ACK");
  }

  /**
   * Process info.
   *
   * @throws Exception the exception
   */
  @Test
  public void processInfo() throws Exception {
    infoProcess.processInfo("testProcessInfo");
  }

  /**
   * Choose dice.
   *
   * @throws Exception the exception
   */
  @Test
  public void chooseDice() throws Exception {
    scanner = new Scanner(System.in);
    String dice = "2 3 4 5 1";
    //infoProcess.chooseDice();
  }

  /**
   * Choose score.
   *
   * @throws Exception the exception
   */
  @Test
  public void chooseScore() throws Exception {
//    String score = "1 2 3 4";
//    //BufferedReader bufferedReader = new BufferedReader();
//    //String userInput = bufferedReader.readLine();
//    infoProcess.chooseScore("2");

//    String input = "123";
//    InputStreamReader converter = new InputStreamReader(System.in);
//    BufferedReader in = new BufferedReader(converter);
//    System.out = new BufferedWriter();
    //chooseScore();
  }

}