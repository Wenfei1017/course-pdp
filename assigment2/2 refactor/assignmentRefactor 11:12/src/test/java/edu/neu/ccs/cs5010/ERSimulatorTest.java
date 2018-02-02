package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

/**
 * ERSumulate test.
 *
 * @author wenfei
 *
 * @version 2.0
 */
public class ERSimulatorTest {
    private static MyPriorityQueue<Patient> patientQueue = new MyPriorityQueue<>();
    private static MyPriorityQueue<Room> emptyRoomQueue = new MyPriorityQueue<>();
    private static MyPriorityQueue<Room> operateRoomQueue = new MyPriorityQueue<>();
    private static MyPriorityQueue<PatientInRoom> operatePatientQueue = new MyPriorityQueue<>();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    LocalDateTime currentTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    LocalDateTime endTime = currentTime.plusSeconds(50);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getRoomNum() throws Exception {
        ERSimulator erSimulator = new ERSimulator();
        InputStream inputStream = new ByteArrayInputStream("4".getBytes());

        int roomNum = erSimulator.getRoomNum(inputStream);
        assertEquals(roomNum, 4);
    }

    @Test
    public void createRoom() throws Exception {
        ERSimulator erSimulator = new ERSimulator();
        erSimulator.createRoom(2);
    }

    @Test
    public void operate() throws Exception {
        ERSimulator erSimulator = new ERSimulator();
        erSimulator.createRoom(2);

        Generator generator = new Generator();
        Patient RandomPatient = generator.newPatient(currentTime, Patient.MAX_Treatment);
        patientQueue.insert(RandomPatient);
        //erSimulator.operate();

        //assertEquals(operatePatientQueue.isEmpty(), false);
    }

    @Test
    public void getOutofHospital() throws Exception {
        ERSimulator erSimulator = new ERSimulator();
        erSimulator.createRoom(3);

        Generator generator = new Generator();
        Patient RandomPatient = generator.newPatient(currentTime, 3);
        patientQueue.insert(RandomPatient);
        //erSimulator.operate();

        //assertEquals(operatePatientQueue.isEmpty(), false);

        //erSimulator.getOutofHospital();
    }

    @Test
    public void printInfo1() throws Exception {
        ERSimulator erSimulator = new ERSimulator();
        Patient patient = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );

        erSimulator.printInfo(patient, ERSimulator.operatePatientInfo);
    }

    @Test
    public void printInfo2() throws Exception {
        ERSimulator erSimulator = new ERSimulator();
        Patient patient = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );

        erSimulator.printInfo(patient, ERSimulator.newPatientInfo);

    }

    @Test
    public void printInfo3() throws Exception {
        ERSimulator erSimulator = new ERSimulator();
        Room room = new Room();
        PatientInRoom patientInRoom = new PatientInRoom(4, LocalDateTime.of(2017, 3, 12, 10, 20, 30), room);
        erSimulator.printInfo(patientInRoom, ERSimulator.outPatientInfo);
    }

    @Test
    public void simulateTreating() throws Exception {
        ERSimulator erSimulator = new ERSimulator();
        erSimulator.createRoom(5);

        erSimulator.simulateTreating(currentTime, endTime);
    }

}