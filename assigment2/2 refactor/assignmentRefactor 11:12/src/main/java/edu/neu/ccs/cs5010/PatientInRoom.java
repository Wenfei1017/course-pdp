package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;

/**
 * Class that change Patient into PatientInRoom.
 *
 * @author wenfei
 *
 * @version 2.0
 */

public class PatientInRoom implements Comparable<PatientInRoom> {
    public int treatmentTime;
    public LocalDateTime leavingTime;
    public Room room;

    /**
     * Creates a patient that is going to be cured
     * given the patient's treatment time, leaving time and room info.
     * Use LocalDateTime as date to mark time
     *
     * @param treatment the patient's treatment time
     * @param leavingTime the patient's leaving time
     * @param room which room is the patient in
     */
    public PatientInRoom(int treatment, LocalDateTime leavingTime, Room room) {
        if (treatment < 0 || treatment > Patient.MAX_Treatment) {
            throw new IllegalArgumentException("treatment time error");
        }
        this.treatmentTime = treatment;

        if (leavingTime == null) {
            throw new IllegalArgumentException("leaving time error");
        }
        this.leavingTime = leavingTime;

        if (room == null) {
            throw new IllegalArgumentException("room error");
        }
        this.room = room;
    }

    @Override
    public int compareTo(PatientInRoom patient) {
        return this.leavingTime.compareTo(patient.leavingTime);
    }

}
