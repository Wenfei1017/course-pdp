package edu.neu.ccs.cs5010;

/**
 * created by xwenfei on 10/06
 */

public class Address {
  private String street;
  private String city;
  private String county;
  private String state;
  private String zip;

  /**
   * constructor
   *
   * @param street the street of address
   * @param city   the city of address
   * @param county the county of address
   * @param state  the state of address
   * @param zip    the zip of address
   */
  public Address(String street, String city, String county, String state, String zip) {
    this.street = street;
    this.city = city;
    this.county = county;
    this.state = state;
    this.zip = zip;
  }

  /**
   * print the address infomation
   */
  public void printAddress() {
    System.out.println("Address: " + this.street + ", " + this.city + ", "
            + this.county + ", " + this.state + ", " + this.zip);
  }

  /**
   * @return the street of address
   */
  public String getStreet() {
    return street;
  }

  /**
   * @return the city of address
   */
  public String getCity() {
    return city;
  }

  /**
   * @return the county of address
   */
  public String getCounty() {
    return county;
  }

  /**
   * @return the state of address
   */
  public String getState() {
    return state;
  }

  /**
   * @return the zip of address
   */
  public String getZip() {
    return zip;
  }
}
