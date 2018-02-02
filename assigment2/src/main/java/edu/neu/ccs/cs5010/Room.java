package edu.neu.ccs.cs5010;

/**
 * created by xwenfei at 09/28/17
 */

public class Room implements Comparable<Room> {
    public int TimeOccupied;

    public Room(){
        this.TimeOccupied = 0;
    }

    public void updateTimeOccupied(int TreatmentTime){
        this.TimeOccupied = this.TimeOccupied + TreatmentTime;
    }

    public int compareTo(Room room) {
        if(room == null){
            throw new IllegalArgumentException("room to compare is null");
        }
        return this.TimeOccupied - room.TimeOccupied;
    }
}