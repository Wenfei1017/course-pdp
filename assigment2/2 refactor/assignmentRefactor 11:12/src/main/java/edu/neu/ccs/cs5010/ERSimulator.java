package edu.neu.ccs.cs5010;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


/**
 * Class simulates the treating process.
 *
 * @author wenfei
 *
 * @version 2.0
 */

public class ERSimulator {
    private static MyPriorityQueue<Patient> patientQueue = new MyPriorityQueue<>();
    private static MyPriorityQueue<Room> emptyRoomQueue = new MyPriorityQueue<>();
    private static MyPriorityQueue<Room> operateRoomQueue = new MyPriorityQueue<>();
    private static MyPriorityQueue<PatientInRoom> operatePatientQueue = new MyPriorityQueue<>();

    public static final int MAX_TIME = 480;
    public static final int newPatientInfo = 1;
    public static final int operatePatientInfo = 2;
    public static final int outPatientInfo = 3;

    /**
     * Get the number of Room from user.
     * 
     * @return the room number user has input
     */
    public static int getRoomNum(InputStream inputStream) throws Exception {
        Scanner scanner = new Scanner(inputStream);
        System.out.println("Please input the number of room: " +
                "(must be an integer and lager than 0)");
        try {
            if (scanner.hasNextInt()) {
                int roomNum = scanner.nextInt();
                if (roomNum <= 0) {
                    throw new IllegalArgumentException("Room number must be bigger than 0");
                }
                System.out.println("Room number set: " + roomNum);
                return roomNum;
            } else {
                throw new IllegalArgumentException(" Input is invalid ");
            }
        } catch (IllegalArgumentException | IllegalStateException | ArithmeticException exception) {
            System.err.println(exception.toString());
        }
        return 0;
    }

    /**
     * Create rooms according to the room number.
     */
    public static void createRoom(int roomNum) {
        for (int i = 0; i < roomNum; i++) {
            emptyRoomQueue.insert(new Room());
        }
    }

    /**
     * Simulate the operating process.
     * 
     * first patient get out of queue
     * then select the operating room
     * last put patient in the room
     */
    public static void operate() {
        //let patient from waiting queue to operating queue
        Patient operatePatient = patientQueue.remove();

        //get one of the empty room according to uesd time
        Room OperateRoom = emptyRoomQueue.remove();

        //when moving room, the time this room is gonna occupied is updated right away
        OperateRoom.updateTimeOccupied(operatePatient.treatmentTime);
        operateRoomQueue.insert(OperateRoom);

        PatientInRoom patientInRoom = new
                PatientInRoom(operatePatient.treatmentTime, operatePatient.leaveTime, OperateRoom);
        operatePatientQueue.insert(patientInRoom);
    }

    /**
     * simulate the process of patient get cured and get out of hospital.
     * 
     * first let patient get of ooperating queue
     * then let the room be empry again
     */
    public static void getOutofHospital() {
        //let the patient out of queue
        PatientInRoom patientToGo = operatePatientQueue.remove();

        //let the room empty again
        Room emptyRoom = patientToGo.room;

        //insert empty room into empty room queue and remove it from operate queue
        emptyRoomQueue.insert(emptyRoom);
        operateRoomQueue.priorityQueue.remove(emptyRoom);
    }

    /**
     * print the patient info.
     */
    public static void printInfo(Patient patient, int info) {
        if (info == newPatientInfo) {
            System.out.println("\nnew patient arrives: ");

        } else if (info == operatePatientInfo) {
            System.out.println("\npatient goes to operating room: ");
        }
        System.out.println("Urgency: \t" + patient.urgencyLevel);
        System.out.println("Arrival: \t " + patient.arriveTime);
        System.out.println("Treat Time: \t" + patient.treatmentTime);
    }

    /**
     * print the patient info who is in the Room.
     */
    public static void printInfo(PatientInRoom patient, int info) {
        if (info == outPatientInfo) {
            System.out.println("\npatient cured, go home: ");
            System.out.println("Treat Time: \t" + patient.treatmentTime);
            System.out.println("Leaving time: \t" + patient.leavingTime);
        }
    }

    /**
     * Simulate the treating process.
     *
     * @param currentTime the current time
     * @param endTime the ending time
     */
    public static void simulateTreating(LocalDateTime currentTime,
                                        LocalDateTime endTime) throws Exception {
        Generator generator = new Generator();
        Patient randomPatient = generator.newPatient(currentTime, Patient.MAX_Treatment);

        while (currentTime.isBefore(endTime)) {
            if (randomPatient.arriveTime.isBefore(endTime)) {
                patientQueue.insert(randomPatient);
                printInfo(randomPatient, newPatientInfo);
            }
            if (!emptyRoomQueue.isEmpty() && !patientQueue.isEmpty()) {
                printInfo(patientQueue.front(), operatePatientInfo);
                operate();
            }
            currentTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            if (randomPatient.arriveTime.isBefore(endTime)) {
                randomPatient = generator.newPatient(randomPatient.arriveTime,
                        Patient.MAX_Treatment);
            }
            if (!operatePatientQueue.isEmpty() &&
                    currentTime.isAfter(operatePatientQueue.front().leavingTime)) {
                printInfo(operatePatientQueue.front(), outPatientInfo);
                getOutofHospital();
            }
        }
        while (!operatePatientQueue.isEmpty()) {
            currentTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            if (currentTime.isAfter(operatePatientQueue.front().leavingTime)) {
                printInfo(operatePatientQueue.front(), outPatientInfo);
                getOutofHospital();
            }
        }
    }

    /**
     * Get room number and execute simulation.
     */
    public static void main(String[] args) throws Exception {
        int roomNum = getRoomNum(System.in);
        createRoom(roomNum);
        
        LocalDateTime currentTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        LocalDateTime endTime = currentTime.plusMinutes(MAX_TIME);

        simulateTreating(currentTime, endTime);

    }

}
