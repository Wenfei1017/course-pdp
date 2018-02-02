package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {
    MyStack myStack;
    @Before
    public void setUp() throws Exception {
        myStack = new MyStack();
    }

    @Test
    public void push() throws Exception {
        myStack.push(2);
        myStack.push(7);
    }

    @Test
    public void pop() throws Exception {
        myStack.pop();
    }

    @Test
    public void top() throws Exception {
        assertEquals(2,myStack.top());
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(false,myStack.isEmpty());
    }

}