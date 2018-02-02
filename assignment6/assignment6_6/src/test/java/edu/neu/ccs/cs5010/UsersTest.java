package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The type Users test.
 */
public class UsersTest {
    private Users users;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        users = new Users(1,"1/1/09","F","22","Seattle");
    }

    /**
     * Gets users id.
     *
     * @throws Exception the exception
     */
    @Test
    public void getUsersID() throws Exception {
        assertEquals(1, users.getUsersID());
    }

    /**
     * Gets created date.
     *
     * @throws Exception the exception
     */
    @Test
    public void getCreatedDate() throws Exception {
        assertEquals("1/1/09", users.getCreatedDate());
    }

    /**
     * Gets gender.
     *
     * @throws Exception the exception
     */
    @Test
    public void getGender() throws Exception {
        assertEquals("F", users.getGender());
    }

    /**
     * Gets age.
     *
     * @throws Exception the exception
     */
    @Test
    public void getAge() throws Exception {
        assertEquals("22",users.getAge());
    }

    /**
     * Gets city.
     *
     * @throws Exception the exception
     */
    @Test
    public void getCity() throws Exception {
        assertEquals("Seattle",users.getCity());
    }

}