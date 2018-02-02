

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TransferQueue;

/**
 * Created by xwenfei on 9/26
 */

public class Patient implements Comparable<Patient> {
    public int UrgencyLevel;
    public LocalDateTime ArriveTime;
    public int TreatmentTime;
    public LocalDateTime LeaveTime;
    public static final int MAX_Treatment = 10;
    public static final int MAX_Urgency = 10;
    /**
     * Creates a new patient given the patient's ArriveTime, condition and treatment time.
     * Use LocalDateTime as date to mark time
     * Condition has 10 levels from 1 to 10
     * TreatmentTime is in the unit of minutes, no longer than MAX_TIME minutes
     *
     * @param ArriveTime the patient's arrival time
     * @param UrgencyLevel the urgency of patient’s condition
     * @param TreatmentTime how long the treatment will take
     */
    public Patient(int UrgencyLevel, LocalDateTime ArriveTime, int TreatmentTime)throws Exception {
        if(UrgencyLevel < 0 || UrgencyLevel > MAX_Urgency){
            throw new IllegalArgumentException("patient urgency must be 0 - 10");
        }
        this.UrgencyLevel = UrgencyLevel;

        if(ArriveTime == null){
            throw new IllegalArgumentException("Arrival time illegal");
        }
        this.ArriveTime = ArriveTime;

        if(TreatmentTime > MAX_Treatment){
            throw new IllegalArgumentException("Treatment time illegal");
        }
        this.TreatmentTime = TreatmentTime;

        this.LeaveTime = ArriveTime.plusMinutes(TreatmentTime);
    }

    /**
     * @return the patient's arrival time
     */
    public LocalDateTime getArriveTime(){
        return this.ArriveTime;
    }

    /**
     * @return the patient's urgency
     */
    public int getUrgencyLevel(){
        return this.UrgencyLevel;
    }

    /**
     * @return the patient's treatment time
     */
    public int getTreatmentTime(){
        return this.TreatmentTime;
    }

    @Override
    public int compareTo(Patient patient) {
        if(patient == null){
            throw new IllegalArgumentException("patient is null");
        }
        if(patient.UrgencyLevel != this.UrgencyLevel){
            return this.UrgencyLevel - patient.UrgencyLevel;
        }
        else{
            return this.ArriveTime.compareTo(patient.ArriveTime);
        }
    }
}