package edu.neu.ccs.cs5010;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by xwenfei on 10/08
 */

public class Generator {
  /**
   * print input usage hint as the assignment requires
   */
  public static void printUsage() {
    System.out.println("Usage: ");
    System.out.println("--email-template <file> \t accepts a filename that holds the email template.\n");
    System.out.println("--output-dir <path>     \t accepts the name of a folder, all output is placed\n" +
            "                        \t in this folder\n");
    System.out.println("--csv-file <path>       \t accepts the name of the csv file to process, in\n" +
            "                        + \t a following format\n" +
            "                        \t Flight<id>From<departure-city>To<destination-city>.csv\n");
    System.out.println("--event <details>       \t specifies if the delay refers to " +
            "departure/arrival \n");
    System.out.println("For example: ");
    System.out.println("--email-template email-template.txt --output-dir emails " +
            "--csv-file Flight363FromSeattleToBoston.csv –-event arrival ");
  }

  /**
   * get input from command and judge if it's the right format
   * if not, print error message
   * prerequest is that both 4 --event, --output-dir and other 2 should be typed correctly
   */
  public static void getInput(String[] args) throws Exception {

    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder errorMessage = new StringBuilder();
    errorMessage.append("Error: ");

    String csvFile = null;
    String dirName = null;
    String templateFile = null;
    String event = null;

    for (int index = 0; index < args.length; index++) {
      if (args[index].contains("--") && index != 0) {
        stringBuilder.append("#");
      }
      stringBuilder.append(args[index]);
      stringBuilder.append(" ");
    }
    stringBuilder.append("#");
    String inputLine = stringBuilder.toString();

    Pattern evPattern = Pattern.compile("--.*?[ ]");
    Pattern paraPattern = Pattern.compile("--.*?[#]");
    Matcher paraMatcher = paraPattern.matcher(inputLine);
    Matcher evMatcher = evPattern.matcher(inputLine);
    String paraString;
    String realPara;

    while (evMatcher.find() && paraMatcher.find()) {
      paraString = inputLine.substring(evMatcher.start(), evMatcher.end() - 1);
      realPara = inputLine.substring(evMatcher.end(), paraMatcher.end() - 1);
      //-1 is to get rid of space (for parastring) and "#" (for realPara)

      //judge if the parameter is complete
      if ((evMatcher.end() + 1) == paraMatcher.end()) {
        errorMessage.append(paraString + " and ");
      }
      //if para is given, judge if the parameter is in the correct format
      else switch (paraString) {
          case "--output-dir":
          dirName = realPara.substring(0, realPara.length() - 1);
          //-1 is to get rid of space
          break;
          case "--event":
            if (!realPara.equals("departure ") && !realPara.equals("arrival ")) {
            errorMessage.append(paraString + " and ");
            } else {
            event = realPara.substring(0, realPara.length() - 1);
            }
            break;
          case "--csv-file": {
            Pattern csvFilePattern = Pattern.compile("Flight\\d+From.+To.+\\.csv");
            Matcher csvMatcher = csvFilePattern.matcher(realPara);
            if (!csvMatcher.find()) {
            errorMessage.append(paraString + " and ");
            } else {
              csvFile = realPara.substring(0, realPara.length() - 1);
            }
            break;
          }
          case "--email-template":
            templateFile = realPara.substring(0, realPara.length() - 1);
            break;
        }
    }

    String error = errorMessage.toString();
    if (error.equals("Error: ")) {
      //means the parameter is correct
      EmailGenerator.mailAutomation(csvFile, dirName, event, templateFile);
    } else {
      errorMessage.delete(errorMessage.length() - 4, errorMessage.length());
      errorMessage.append("were given without providing appropriate arguments:");
      System.out.println(errorMessage);
      printUsage();
    }
  }

  /**
   *
   * @param args input from user
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    if (args.length < 4) {
      printUsage();
      throw new IllegalArgumentException("Please follow the instruction.");
    } else {
      getInput(args);
    }
  }

}