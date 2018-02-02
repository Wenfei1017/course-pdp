package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Class that generate patient.
 *
 * @author wenfei
 *
 * @version 2.0
 */

public class Generator {
    /**
     * empty constructor
     */
    public Generator() {
    }

    /**
     * Given a start time and duration, generate a time that is start time + random(0, duration).
     *
     * @return the random generated patient
     */
    public Patient newPatient(LocalDateTime localTime, int duration) throws Exception {
        Random random = new Random();
        int urgency = random.nextInt(Patient.MAX_Urgency) + 1;
        int randomTreatment = random.nextInt(Patient.MAX_Treatment / 4 + 1) + 1;
        int minuteDuration = random.nextInt((duration / 3 + 1)) + 1;

        LocalDateTime randomTime = localTime.plusSeconds(minuteDuration);
        Patient RandomPatient = new Patient(urgency, randomTime, randomTreatment);
        return RandomPatient;
    }

}
