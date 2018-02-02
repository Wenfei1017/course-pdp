package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class EmailGeneratorTest {
    EmailGenerator emailGenerator;
    String testString;
    String email;
    Customer customer;
    Address address;
    String event;
    String csvFile;
    String outPut;
    @Before
    public void setUp() throws Exception {
        emailGenerator = new EmailGenerator();
        address = new Address("6649 N Blue Gum St","New Orleans","Orleans","LA","70116");
        customer = new Customer("James","Butt", address,
                "504-621-8927","jbutt@gmail.com","gold");
        testString = "[[Date]]\n" +
                "\n" +
                "To: [[email]]\n" +
                "Subject: Please accept our apologies for the [[event]] of your flight\n" +
                "Dear [[first_name]] [[last_name]], \n" +
                "\n" +
                "We are very sorry for the [[event]] of your flight from [[departure-city]] to [[destination-city]]. As a valued [[rewards]] member of our club your time is important to us and we will strive to improve our service in the future, and make it on time! \n" +
                "   \n" +
                "Sincerely, \n" +
                "OnTime airline customer service \n";
        email = "2017.11.13\n" +
                "\n" +
                "To: jbutt@gmail.com\n" +
                "Subject: Please accept our apologies for the arrival of your flight\n" +
                "Dear James Butt, \n" +
                "\n" +
                "We are very sorry for the arrival of your flight from Seattle to Boston. As a valued gold  member of our club your time is important to us and we will strive to improve our service in the future, and make it on time! \n" +
                "   \n" +
                "Sincerely, \n" +
                "OnTime airline customer service \n";
        event = "arrival";
        csvFile = "Flight3FromVancouverToSeattle.csv";
    }

    @Test
    public void createFileDir() throws Exception {
        File testFile = new File("testFile");
        emailGenerator.createFileDir("testFile");
        assert(testFile.exists());
    }

    @Test
    public void getTemplateEmail() throws Exception {
        assertEquals(emailGenerator.getTemplateEmail("Email-template.txt"),testString);
    }

    @Test
    public void matchEmail() throws IOException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String Date = sdf.format(date).toString();
        outPut = emailGenerator.matchEmail(customer,event,"Email-template.txt","Flight3FromVancouverToSeattle.csv");
        //assertEquals(outPut,email);
    }

    @Test
    public void saveEmail() throws Exception {
        emailGenerator.saveEmail(customer,"testFile","Email-template.txt",1,"arrival",
                csvFile);
    }

    @Test
    public void mailAutomation() throws Exception {
        emailGenerator.mailAutomation("Flight3FromVancouverToSeattle.csv","emailtest",
                "arrival",testString);

    }

}