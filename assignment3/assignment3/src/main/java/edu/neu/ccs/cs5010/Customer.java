package edu.neu.ccs.cs5010;

/**
 * created by xwenfei on 10/06
 */

public class Customer {
  private final String FIRSTNAME;
  private final String LASTNAME;
  private final Address LOCATION;
  private final String PHONENUMBER;
  private final String EMAIL;
  private final String REWARDS;

  /**
   * constructor
   *
   * @param firstName   the firstname of customer
   * @param lastName    the lastname of customer
   * @param location    the location(street) of customer
   * @param phoneNumber the phone number of customer
   * @param email       the email of customer
   * @param rewards     the rewards of customer
   */
  public Customer(String firstName, String lastName, Address location,
                  String phoneNumber, String email, String rewards) {
    this.FIRSTNAME = firstName;
    this.LASTNAME = lastName;
    this.LOCATION= location;
    this.PHONENUMBER = phoneNumber;
    this.EMAIL = email;
    this.REWARDS = rewards;
  }

  /**
   * print the customer information
   */
  public void printCustomer() {
    System.out.println("Name: " + this.FIRSTNAME + " " + LASTNAME);
    this.LOCATION.printAddress();
    System.out.println("Phone number: " + this.PHONENUMBER);
    System.out.println("Email: " + this.EMAIL);
    System.out.println("Rewards: " + this.REWARDS + "\n");
  }

  /**
   * @return the first name of customer
   */
  public String getFirstName() {
    return FIRSTNAME;
  }

  /**
   * @return the last name of customer
   */
  public String getLastName() {
    return LASTNAME;
  }

  /**
   * @return the location of customer
   */
  public Address getLocation() {
    return LOCATION;
  }

  /**
   * @return phone number of customer
   */
  public String getPhoneNumber() {
    return PHONENUMBER;
  }

  /**
   * @return email of customer
   */
  public String getEmail() {
    return EMAIL;
  }

  /**
   * @return rewards of customer
   */
  public String getRewards() {
    return REWARDS;
  }
}
