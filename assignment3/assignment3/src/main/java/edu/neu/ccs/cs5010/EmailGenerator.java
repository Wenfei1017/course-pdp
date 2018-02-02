package edu.neu.ccs.cs5010;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by xwenfei on 10/08
 */

public class EmailGenerator {
  // Constant that determines firstname, lastname,street,city,county,state,zip number, phone number
  //email and rewards.
  private static final int FIRSTNAMENO = 1;
  private static final int LASTNAMENO = 2;
  private static final int STREETNO = 3;
  private static final int CITYNO = 4;
  private static final int COUNTRYNO = 5;
  private static final int STATENO = 6;
  private static final int ZIPNO = 7;
  private static final int PHONO = 8;
  private static final int EMAILNO = 9;
  private static final int REWARDNO = 10;

  /**
   * create the output folder, if existed or failed, print the information
   */
  public static void createFileDir(String dirName) throws IOException {
    if (dirName == null) {
      throw new IllegalArgumentException("Output direction name should not be null");
    }
    File outFile = new File(dirName);
    if (outFile.mkdir()) {
      System.out.println("Completed Emails saved in " + dirName);
    } else {
      if (outFile.exists()) {
        System.out.println(dirName + "folder already exists");
      } else {
        throw new IOException("Fail creating the folder " + dirName);
      }
    }
  }

  /**
   * return the template file as String format
   */
  public static String getTemplateEmail(String templateFile) throws IOException {
    if (templateFile == null) {
      throw new IllegalArgumentException("Template file should not be null");
    }
    BufferedReader reader = new BufferedReader(new FileReader(templateFile));
    String line = null;
    StringBuilder stringBuilder = new StringBuilder();
    String lseperate = System.getProperty("line.separator");

    try {
      while ((line = reader.readLine()) != null) {
        stringBuilder.append(line);
        stringBuilder.append(lseperate );
      }
      return stringBuilder.toString();
    } finally {
      reader.close();
    }
  }

  /**
   * @return according to certain customer, change the email contents
   * and return the correct email in String format
   */
  public static String matchEmail(Customer customer, String event,
                                  String templateFile, String csvFile) throws IOException {
    String templateEmail = getTemplateEmail(templateFile);
    String email = templateEmail;
    Pattern departPattern = Pattern.compile("From.*To");
    Pattern destPattern = Pattern.compile("To.*.csv");
    Matcher departMatcher = departPattern.matcher(csvFile);
    Matcher destMatcher = destPattern.matcher(csvFile);

    if (departMatcher.find() && destMatcher.find()) {
      String departCity = departMatcher.group();
      departCity = departCity.substring("From".length(), departCity.length() - "To".length());
      String destCity = destMatcher.group();
      destCity = destCity.substring("To".length(), destCity.length() - ".csv".length());

      Pattern emailPattern;
      Matcher emailMatcher;
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
      String Date = sdf.format(date).toString();
      String[] toReplace = {"Date", "email", "event", "first_name", "last_name",
              "departure-city", "destination-city", "rewards"};
      String[] toFill = {Date, customer.getEmail(), event, customer.getFirstName(),
              customer.getLastName(), departCity, destCity, customer.getRewards()};
      int index = 0;
      for (String str : toReplace) {
        emailPattern = Pattern.compile("\\[\\[" + str + "\\]\\]");
        emailMatcher = emailPattern.matcher(email);
        email = emailMatcher.replaceAll(toFill[index]);
        index++;
      }
    }
    return email;
  }

  /**
   * write the correct email and save it
   */
  public static void saveEmail(Customer customer, String dirName, String templateFile,
                               int cusNo, String event, String csvFile) throws Exception {
    if (customer == null) {
      throw new IllegalArgumentException("customer should not be null");
    }
    FileWriter writer = null;
    String email = null;

    try {
      writer = new FileWriter(dirName + "/" + "Email_" + cusNo + "_" +
              customer.getFirstName() + ".txt");
      email = matchEmail(customer, event, templateFile, csvFile);
      writer.write(email);

    } catch (IOException e) {
      e.getStackTrace();
    } finally {
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          e.getStackTrace();
        }
      }
    }

  }

  /**
   * main process, get input and read customer info
   * and use saveEmail to create correct email
   */
  public static void mailAutomation(String csvFile, String dirName, String event,
                                    String templateFile) {

    BufferedReader bufReader = null;
    try {
      createFileDir(dirName);
      String line = "";

      Pattern pattern = Pattern.compile("\",\"|\"");//"," or "
      Customer customer;
      Address address;

      String[] info = null;
      bufReader = new BufferedReader(new FileReader(csvFile));
      line = bufReader.readLine();
      int cusNo = 1;
      while ((line = bufReader.readLine()) != null) {

        info = pattern.split(line);
        if (info.length > 11) {
          //the first element is space
          System.out.println(info.length);
          throw new Exception("Wrong format of customer file");
        }
        address = new Address(info[STREETNO], info[CITYNO], info[COUNTRYNO],
                info[STATENO], info[ZIPNO]);
        customer = new Customer(info[FIRSTNAMENO],
                info[LASTNAMENO], address, info[PHONO], info[EMAILNO], info[REWARDNO]);
        //customer.printCustomer();
        saveEmail(customer, dirName, templateFile, cusNo, event, csvFile);
        cusNo++;
      }

    } catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (bufReader != null) {
        try {
          bufReader.close();
        } catch (IOException e) {
          e.getStackTrace();
        }
      }
    }
  }
}
