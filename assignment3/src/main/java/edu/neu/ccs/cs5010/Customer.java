package edu.neu.ccs.cs5010;

/**
 * created by xwenfei on 10/06
 */

public class Customer {
    private String FirstName;
    private String LastName;
    private Address Location;
    private String PhoneNumber;
    private String Email;
    private String Rewards;

    /**
     * constructor
     * @param firstName the firstname of customer
     * @param lastName the lastname of customer
     * @param location the location(street) of customer
     * @param phoneNumber the phone number of customer
     * @param email the email of customer
     * @param rewards the rewards of customer
     */
    public Customer(String firstName,String lastName,Address location,String phoneNumber,String email,String rewards){
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Location = location;
        this.PhoneNumber = phoneNumber;
        this.Email = email;
        this.Rewards = rewards;
    }

    /**
     * print the customer information
     */
    public void printCustomer() {
        System.out.println("Name: " + this.FirstName + " " + LastName);
        this.Location.printAddress();
        System.out.println("Phone number: " + this.PhoneNumber);
        System.out.println("Email: " + this.Email);
        System.out.println("Rewards: " + this.Rewards + "\n");
    }
    /**
     *
     * @return the first name of customer
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     *
     * @return the last name of customer
     */
    public String getLastName() {
        return LastName;
    }

    /**
     *
     * @return the location of customer
     */
    public Address getLocation() {
        return Location;
    }

    /**
     *
     * @return phone number of customer
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     *
     * @return email of customer
     */
    public String getEmail() {
        return Email;
    }

    /**
     *
     * @return rewards of customer
     */
    public String getRewards() {
        return Rewards;
    }
}
