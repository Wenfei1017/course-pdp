package edu.neu.ccs.cs5010;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by xwenfei on 10/3/17.
 */
public class PatientInRoomTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private MyPriorityQueue<PatientInRoom> pqueue;
    private Patient patient1;
    private Patient patient2;
    private PatientInRoom patientRoom1;
    private PatientInRoom patientRoom2;
    private Room room1;
    private Room room2;

    @Test
    public void mainTest() throws Exception {
        pqueue = new MyPriorityQueue<PatientInRoom>();
        patient1 = new Patient(5, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );
        patient2 = new Patient(4, LocalDateTime.of(2017, 3, 10, 14, 32, 50), 20 );
        room1 = new Room();
        room1.updateTimeOccupied(patient1.treatmentTime);
        room2 = new Room();
        room2.updateTimeOccupied(patient2.treatmentTime);
        patientRoom1 = new PatientInRoom(patient1.treatmentTime, patient1.leaveTime, room1);
        patientRoom2 = new PatientInRoom(patient2.treatmentTime, patient2.leaveTime, room2);

        pqueue.insert(patientRoom1);
        pqueue.insert(patientRoom2);

        assertEquals(pqueue.front(), patientRoom2);
    }

    @Test
    public void treatment1Exception() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("treatment time error");
        Room room = new Room();
        PatientInRoom patient = new PatientInRoom(-1, LocalDateTime.of(2017, 3, 12, 10, 20, 30), room);
    }

    @Test
    public void treatment2Exception() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("treatment time error");
        Room room = new Room();
        PatientInRoom patient = new PatientInRoom(Patient.MAX_Treatment + 1, LocalDateTime.of(2017, 3, 12, 10, 20, 30), room);
    }

    @Test
    public void leaveTimeException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("leaving time error");
        Room room = new Room();
        PatientInRoom patient = new PatientInRoom(3, null, room);
    }

    @Test
    public void roomException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("room error");
        PatientInRoom patient1 = new PatientInRoom(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), null);
    }

    @Test
    public void setTimeOccupied() throws Exception {

    }

}