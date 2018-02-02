package edu.neu.ccs.cs5010;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by xwenfei on 10/3/17.
 */
public class PatientInRoom implements Comparable<PatientInRoom>{
    public int TreatmentTime;
    public LocalDateTime LeavingTime;
    public Room room;

    public PatientInRoom(int Treatment, LocalDateTime LeavingTime, Room room){
        /**
         * Creates a patient that is going to be cured
         * given the patient's Treatment time, leaving time and room info.
         * Use LocalDateTime as date to mark time
         *
         * @param TreatTime the patient's treatment time
         * @param LeavingTime the patient's leaving time
         * @param room which room is the patient in
         */
        if(Treatment < 0 || Treatment > Patient.MAX_Treatment){
            throw new IllegalArgumentException("treatment time error");
        }
        this.TreatmentTime = Treatment;

        if(LeavingTime == null){
            throw new IllegalArgumentException("leaving time error");
        }
        this.LeavingTime = LeavingTime;

        if(room == null){
            throw new IllegalArgumentException("room error");
        }
        this.room = room;
    }

    @Override
    public int compareTo(PatientInRoom patient){

        return this.LeavingTime.compareTo(patient.LeavingTime);
    }

}