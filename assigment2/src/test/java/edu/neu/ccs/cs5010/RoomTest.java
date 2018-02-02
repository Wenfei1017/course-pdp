package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xwenfei on 10/2/17.
 */
public class RoomTest {
    @Test
    public void setTimeOccupied() throws Exception {

    }

    private Room room1;
    private Room room2;
    private Room room3;
    private MyPriorityQueue<Room> RoomQueue;

    @Before
    public void setUp() throws Exception {

        room1 = new Room();
        room2 = new Room();
        room3 = new Room();
        RoomQueue = new MyPriorityQueue<Room>();

        room1.updateTimeOccupied(30);
        room2.updateTimeOccupied(20);
        room3.updateTimeOccupied(40);

        RoomQueue.insert(room1);
        RoomQueue.insert(room2);
        RoomQueue.insert(room3);

        assertEquals(RoomQueue.front(), room2);

    }

}