package edu.neu.ccs.cs5010;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by xwenfei on 10/2/17.
 */
public class RoomTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

    @Test
    public void compareException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("room to compare is null");
        Room room = new Room();
        room.compareTo(null);
    }

    @Test
    public void compareTest() throws Exception {
        room1 = new Room();
        room2 = new Room();
        room1.updateTimeOccupied(30);
        room2.updateTimeOccupied(20);
        assertEquals(room1.compareTo(room2), room1.timeOccupied - room2.timeOccupied);
        assertEquals(room1.compareTo(room2), 10);
    }

}