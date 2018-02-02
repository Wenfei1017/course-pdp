package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {
    private Users users;
    @Before
    public void setUp() throws Exception {
        users = new Users(1,"1/1/09","F","22","Seattle");
    }

    @Test
    public void getUsersID() throws Exception {
        assertEquals(1, users.getUsersID());
    }

    @Test
    public void getCreatedDate() throws Exception {
        assertEquals("1/1/09", users.getCreatedDate());
    }

    @Test
    public void getGender() throws Exception {
        assertEquals("F", users.getGender());
    }

    @Test
    public void getAge() throws Exception {
        assertEquals("22",users.getAge());
    }

    @Test
    public void getCity() throws Exception {
        assertEquals("Seattle",users.getCity());
    }

}