import java.util.List;

public class TreatRoom implements Comparable<TreatRoom> {
    public int TimeOccupied;

    public TreatRoom(){
        this.TimeOccupied = 0;
    }

    public void updateTimeOccupied(int TreatmentTime){
        this.TimeOccupied = this.TimeOccupied + TreatmentTime;
    }

    public int compareTo(TreatRoom room) {
        if(room == null){
            throw new IllegalArgumentException("room to compare is null");
        }
        return this.TimeOccupied - room.TimeOccupied;
    }
}
