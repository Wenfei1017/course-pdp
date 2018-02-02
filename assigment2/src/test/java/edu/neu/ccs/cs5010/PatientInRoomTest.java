package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by bikegcy on 10/3/17.
 */
public class PatientInRoomTest {

    private MyPriorityQueue<PatientInRoom> pqueue;
    private Patient patient1;
    private Patient patient2;
    private PatientInRoom patientRoom1;
    private PatientInRoom patientRoom2;
    private Room room1;
    private Room room2;

    @Before
    public void setUp() throws Exception {
        pqueue = new MyPriorityQueue<PatientInRoom>();
        patient1 = new Patient(5, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );
        patient2 = new Patient(4, LocalDateTime.of(2017, 3, 10, 14, 32, 50), 20 );
        room1 = new Room();
        room1.updateTimeOccupied(patient1.TreatmentTime);
        room2 = new Room();
        room2.updateTimeOccupied(patient2.TreatmentTime);
        patientRoom1 = new PatientInRoom(patient1.TreatmentTime, patient1.LeaveTime, room1);
        patientRoom2 = new PatientInRoom(patient2.TreatmentTime, patient2.LeaveTime, room2);

        pqueue.insert(patientRoom1);
        pqueue.insert(patientRoom2);

        assertEquals(pqueue.front(), patientRoom2);
    }

    @Test
    public void setTimeOccupied() throws Exception {

    }

}