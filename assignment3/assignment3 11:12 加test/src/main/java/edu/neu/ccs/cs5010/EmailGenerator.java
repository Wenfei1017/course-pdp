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
    public static final int FirstNameNo = 1;
    public static final int LastNameNo = 2;
    public static final int StreetNo = 3;
    public static final int CityNo = 4;
    public static final int CountyNo = 5;
    public static final int StateNo = 6;
    public static final int ZipNo=7;
    public static final int PhoNo = 8;
    public static final int EmailNo = 9;
    public static final int RewardsNo = 10;

    /**
     * create the output folder, if existed or failed, print the information
     */
    public static void createFileDir(String dirName) throws IOException {
        if(dirName == null){
            throw new IllegalArgumentException("Output direction name should not be null");
        }
        File OutFile = new File(dirName);
        if(OutFile.mkdir()){
            System.out.println("Completed Emails saved in " + dirName);
        }
        else{
            if(OutFile.exists()){
                System.out.println(dirName + "folder already exists");
            } else{
                throw new IOException("Fail creating the folder " + dirName);
            }
        }
    }
    /**
     * return the template file as String format
     */
    public static String getTemplateEmail(String templateFile) throws IOException {
        if(templateFile == null){
            throw new IllegalArgumentException("Template file should not be null");
        }
        BufferedReader reader = new BufferedReader(new FileReader (templateFile));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
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
    public static String matchEmail(Customer customer, String event, String templateFile, String csvFile) throws IOException {
        String TemplateEmail = getTemplateEmail(templateFile);
        String Email = TemplateEmail;
        Pattern DepartPattern = Pattern.compile("From.*To");
        Pattern DestPattern = Pattern.compile("To.*.csv");
        Matcher DepartMatcher = DepartPattern.matcher(csvFile);
        Matcher DestMatcher = DestPattern.matcher(csvFile);

        if(DepartMatcher.find() && DestMatcher.find()){
            String DepartCity = DepartMatcher.group();
            DepartCity = DepartCity.substring("From".length(), DepartCity.length() - "To".length());
            String DestCity = DestMatcher.group();
            DestCity = DestCity.substring("To".length(), DestCity.length() - ".csv".length());

            Pattern EmailPattern;
            Matcher EmailMatcher;
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
            String Date = sdf.format(date).toString();
            String[] ToReplace = {"Date", "email", "event", "first_name", "last_name",
                    "departure-city", "destination-city", "rewards"};
            String[] ToFill = {Date, customer.getEmail(), event, customer.getFirstName(),
                    customer.getLastName(), DepartCity, DestCity, customer.getRewards()};
            int index= 0;
            for(String str: ToReplace){
                EmailPattern = Pattern.compile("\\[\\[" + str + "\\]\\]");
                EmailMatcher = EmailPattern.matcher(Email);
                Email = EmailMatcher.replaceAll(ToFill[index]);
                index++;
            }
        }
        return Email;
    }

    /**
     * write the correct email and save it
     */
    public static void saveEmail(Customer customer, String dirName, String templateFile,
                                 int cusNo, String event, String csvFile) throws Exception {
        if(customer == null){
            throw new IllegalArgumentException("customer should not be null");
        }
        FileWriter Writer = null;
        String Email = null;

        try{
            Writer = new FileWriter(dirName + "/" + "Email_" + cusNo + "_" + customer.getFirstName() + ".txt");
            Email = matchEmail(customer, event, templateFile, csvFile);
            Writer.write(Email);

        } catch(IOException e){
            e.getStackTrace();
        } finally{
            if(Writer != null){
                try{
                    Writer.close();
                } catch (IOException e){
                    e.getStackTrace();
                }
            }
        }

    }

    /**
     * main process, get input and read customer info
     * and use saveEmail to create correct email
     */
    public static void mailAutomation(String csvFile, String dirName, String event, String templateFile) throws Exception{
        createFileDir(dirName);
        String line = "";

        Pattern pattern = Pattern.compile("\",\"|\"");//"," or "
        Customer customer;
        Address address;
        BufferedReader bufReader = null;
        String[] Info = null;
        bufReader = new BufferedReader(new FileReader(csvFile));

        try {
            line = bufReader.readLine();
            int CusNo = 1;
            while ((line = bufReader.readLine()) != null) {

                Info = pattern.split(line);
                if(Info.length > 11){
                    //the first element is space
                    System.out.println(Info.length);
                    throw new Exception("Wrong format of customer file");
                }
                address = new Address(Info[StreetNo], Info[CityNo], Info[CountyNo], Info[StateNo], Info[ZipNo]);
                customer = new Customer(Info[FirstNameNo],
                        Info[LastNameNo], address, Info[PhoNo], Info[EmailNo], Info[RewardsNo]);
                //customer.printCustomer();
                saveEmail(customer, dirName, templateFile, CusNo, event, csvFile);
                CusNo++;
            }

        } catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(bufReader != null){
                try{
                    bufReader.close();
                }catch(IOException e){
                    e.getStackTrace();
                }
            }
        }
    }
}
