package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;

/**
 * Class that implements patient.
 *
 * @author wenfei
 *
 * @version 2.0
 */

public class Patient implements Comparable<Patient> {
    public int urgencyLevel;
    public LocalDateTime arriveTime;
    public int treatmentTime;
    public LocalDateTime leaveTime;
    public static final int MAX_Treatment = 50;
    public static final int MAX_Urgency = 10;
    /**
     * Creates a new patient given the patient's arriveTime, condition and treatment time.
     * Use LocalDateTime as date to mark time
     * Condition has 10 levels from 1 to 10
     * treatmentTime is in the unit of minutes, no longer than MAX_TIME minutes
     *
     * @param arriveTime the patient's arrival time
     * @param urgencyLevel the urgency of patient's condition
     * @param treatmentTime how long the treatment will take
     */
    public Patient(int urgencyLevel, LocalDateTime arriveTime, int treatmentTime)throws Exception {
        if (urgencyLevel < 0 || urgencyLevel > MAX_Urgency) {
            throw new IllegalArgumentException("patient urgency must be 0 - 10");
        }
        this.urgencyLevel = urgencyLevel;

        if (arriveTime == null) {
            throw new IllegalArgumentException("Arrival time illegal");
        }
        this.arriveTime = arriveTime;

        if (treatmentTime > MAX_Treatment) {
            throw new IllegalArgumentException("Treatment time illegal");
        }
        this.treatmentTime = treatmentTime;

        this.leaveTime = arriveTime.plusSeconds(treatmentTime);
    }

    /**
     * @return the patient's arrival time
     */
    public LocalDateTime getArriveTime() {
        return this.arriveTime;
    }

    /**
     * @return the patient's urgency
     */
    public int getUrgencyLevel() {
        return this.urgencyLevel;
    }

    /**
     * @return the patient's treatment time
     */
    public int getTreatmentTime() {
        return this.treatmentTime;
    }

    @Override
    public int compareTo(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("patient is null");
        }
        if (patient.urgencyLevel != this.urgencyLevel) {
            return this.urgencyLevel - patient.urgencyLevel;
        } else {
            return this.arriveTime.compareTo(patient.arriveTime);
        }
    }
}
