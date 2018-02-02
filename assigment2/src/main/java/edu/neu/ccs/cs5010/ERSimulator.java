package edu.neu.ccs.cs5010;


import org.omg.CORBA.Current;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import static javafx.application.Platform.exit;

/**
 * Created by xwenfei on 10/2/17.
 */
public class ERSimulator {
    private static MyPriorityQueue<Patient> PatientQueue = new MyPriorityQueue<Patient>();
    private static MyPriorityQueue<Room> EmptyRoomQueue = new MyPriorityQueue<Room>();
    private static MyPriorityQueue<Room> OperateRoomQueue = new MyPriorityQueue<Room>();
    private static MyPriorityQueue<PatientInRoom> OperatePatientQueue = new MyPriorityQueue<PatientInRoom>();
    private final static int MAX_TIME = 480;
    private final static int newPatientInfo = 1;
    private final static int operatePatientInfo = 2;
    private final static int outPatientInfo = 3;

    /**
     * @return the room number user has input
     */
    public static int getRoomNum(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of room: (must be an integer and lager than 0)");
        try {
            if (scanner.hasNextInt()) {

                int RoomNum = scanner.nextInt();
                if(RoomNum <= 0){
                    throw new IllegalArgumentException("Room number must be bgger than 0");
                }
                System.out.println("Room number set: " + RoomNum);
                return RoomNum;

            } else {
                throw new IllegalArgumentException(" Input is invalid ");
            }
        } catch (IllegalArgumentException | IllegalStateException | ArithmeticException exception) {
            System.err.println(exception.toString());
        }
        System.exit(0);
        return -1;
    }

    /**
     * simulate the operating process
     * first patient get out of queue
     * then select the operating room
     * last put patient in the room
     */
    public static void operate(){
        //let patient from waiting queue to operating queue
        Patient OperatePatient = PatientQueue.remove();

        //get one of the empty room according to uesd time
        Room OperateRoom = EmptyRoomQueue.remove();

        //when moving room, the time this room is gonna used is updated right away
        OperateRoom.updateTimeOccupied(OperatePatient.TreatmentTime);
        OperateRoomQueue.insert(OperateRoom);

        PatientInRoom patientInRoom = new
                PatientInRoom(OperatePatient.TreatmentTime, OperatePatient.LeaveTime, OperateRoom);
        OperatePatientQueue.insert(patientInRoom);
    }

    /**
     * simulate the process of patient get cured and get out of hospital
     * first let patient get of ooperating queue
     * then let the room be empry again
     */
    public static void getOutofHospital(){
        //let the patient out of queue
        PatientInRoom patientToGo = OperatePatientQueue.remove();

        //let the room empty again
        Room emptyRoom = patientToGo.room;

        //insert empty room into empty room queue and remove it from operate queue
        EmptyRoomQueue.insert(emptyRoom);
        OperateRoomQueue.PQ.remove(emptyRoom);
    }

    /**
     * print the patient info
     */
    public static void printInfo(Patient patient, int info){
        if(info == newPatientInfo){
            System.out.println("\nnew patient arrives: ");

        }
        else if(info == operatePatientInfo){
            System.out.println("\npatient goes to operating room: ");
        }
        System.out.println("Urgency: \t" + patient.UrgencyLevel);
        System.out.println("Arrival: \t " + patient.ArriveTime);
        System.out.println("Treat Time: \t" + patient.TreatmentTime);
    }

    /**
     * print the patient info
     */
    public static void printInfo(PatientInRoom patient, int info){
        if(info == outPatientInfo){
            System.out.println("\npatient cured, go home: ");
            System.out.println("Treat Time: \t" + patient.TreatmentTime);
            System.out.println("Leaving time: \t" + patient.LeavingTime);
        }
    }

    public static void main(String[] args) throws Exception {

        Generator generator = new Generator();

        //first get the Room number and create the room queue
        int RoomNum = getRoomNum();
        for(int i = 0; i < RoomNum; i++){
            EmptyRoomQueue.insert(new Room());
        }

        //simualtion begins here, use 3 time to control the simulation
        LocalDateTime StartTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        LocalDateTime CurrentTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        LocalDateTime EndTime = StartTime.plusMinutes(MAX_TIME);
        Patient RandomPatient = generator.newPatient(CurrentTime, Patient.MAX_Treatment);

        //
        while(CurrentTime.isBefore(EndTime)){
            if(RandomPatient.ArriveTime.isBefore(EndTime)){
                PatientQueue.insert(RandomPatient);
                printInfo(RandomPatient, newPatientInfo);
            }


            if(!EmptyRoomQueue.isEmpty() && !PatientQueue.isEmpty()){
                printInfo(PatientQueue.front(), operatePatientInfo);
                operate();
            }

            CurrentTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            if(RandomPatient.ArriveTime.isBefore(EndTime)){
                RandomPatient = generator.newPatient(RandomPatient.ArriveTime, Patient.MAX_Treatment);
            }
            if(!OperatePatientQueue.isEmpty() && CurrentTime.isAfter(OperatePatientQueue.front().LeavingTime)){
                printInfo(OperatePatientQueue.front(), outPatientInfo);
                getOutofHospital();
            }

        }

    }


}