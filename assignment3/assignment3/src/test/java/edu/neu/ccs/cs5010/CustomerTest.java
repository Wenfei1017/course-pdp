package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
  private Address address;
  private Customer customer;

  @Before
  public void setUp() throws Exception {
    address = new Address("6649 N Blue Gum St", "New Orleans", "Orleans", "LA", "70116");
    customer = new Customer("James", "Butt", address,
            "504-621-8927", "jbutt@gmail.com", "gold");
  }

  @Test
  public void printCustomer() throws Exception {
    customer.printCustomer();
  }

  @Test
  public void getFirstName() throws Exception {
    assertEquals(customer.getFirstName(), "James");
  }

  @Test
  public void getLastName() throws Exception {
    assertEquals(customer.getLastName(), "Butt");
  }

  @Test
  public void getLocation() throws Exception {
    assertEquals(customer.getLocation(), address);
  }

  @Test
  public void getPhoneNumber() throws Exception {
    assertEquals(customer.getPhoneNumber(), "504-621-8927");
  }

  @Test
  public void getEmail() throws Exception {
    assertEquals(customer.getEmail(), "jbutt@gmail.com");
  }

  @Test
  public void getRewards() throws Exception {
    assertEquals(customer.getRewards(), "gold");
  }

}