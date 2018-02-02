package edu.neu.ccs.cs5010;

/**
 * Class that implements room.
 *
 * @author wenfei
 *
 * @version 2.0
 */

public class Room implements Comparable<Room> {
    public int timeOccupied;

    /**
     * Empty constructor, set timeOccupied to 0 at first.
     */
    public Room() {
        this.timeOccupied = 0;
    }

    /**
     * Update the time this room has been used.
     *
     * @param treatmentTime add this treatTime to the timeOccupied
     */
    public void updateTimeOccupied(int treatmentTime) {
        this.timeOccupied = this.timeOccupied + treatmentTime;
    }

    @Override
    public int compareTo(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("room to compare is null");
        }
        return this.timeOccupied - room.timeOccupied;
    }
}
