package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
  private Address address;

  @Before
  public void setUp() throws Exception {
    address = new Address("6649 N Blue Gum St", "New Orleans", "Orleans", "LA", "70116");
  }

  @Test
  public void printAddress() throws Exception {
    address.printAddress();
  }

  @Test
  public void getStreet() throws Exception {
    assertEquals(address.getStreet(), "6649 N Blue Gum St");
  }

  @Test
  public void getCity() throws Exception {
    assertEquals(address.getCity(), "New Orleans");
  }

  @Test
  public void getCounty() throws Exception {
    assertEquals(address.getCounty(), "Orleans");
  }

  @Test
  public void getState() throws Exception {
    assertEquals(address.getState(), "LA");
  }

  @Test
  public void getZip() throws Exception {
    assertEquals(address.getZip(), "70116");
  }

}