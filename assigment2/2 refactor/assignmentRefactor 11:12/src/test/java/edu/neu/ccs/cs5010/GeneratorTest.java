package edu.neu.ccs.cs5010;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by by xwenfei at 09/28 on 10/2/17.
 */
public class GeneratorTest {

    private MyPriorityQueue<Patient> pqueue;
    private Generator generator;

    @Before
    public void setUp() throws Exception {
        MyPriorityQueue<Patient> pqueue = new MyPriorityQueue<Patient>();
        generator = new Generator();
    }

    @Test
    public void patientGenerator() throws Exception {
        MyPriorityQueue<Patient> pqueue = new MyPriorityQueue<Patient>();

        Random random = new Random();
        LocalDateTime StartTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

        Patient randomPatient = generator.newPatient(StartTime, Patient.MAX_Treatment);
        for(int i = 0; i < 50; i++){
            pqueue.insert(randomPatient);
            System.out.println("Urgency level: \t" + randomPatient.urgencyLevel);
            System.out.println("Arrival time: \t" + randomPatient.arriveTime);
            System.out.println("TreatmentTime: \t" + randomPatient.treatmentTime);
            System.out.println("Leaving time: \t" + randomPatient.leaveTime + "\n");
            int duration = randomPatient.treatmentTime;
            int randomDuration = random.nextInt(duration);
            randomPatient = generator.newPatient(randomPatient.arriveTime.plusMinutes(randomDuration), duration);
        }

    }

}