package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xwenfei on 10/2/17.
 */
public class MyPriorityQueueTestPatient {

    private MyPriorityQueue<Patient> pqueue;
    private Patient patient1;
    private Patient patient2;
    private Patient patient3;

    @Before
    public void setUp() throws Exception {

        MyPriorityQueue<Patient> pqueue = new MyPriorityQueue<Patient>();
        Patient patient1 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );
        Patient patient2 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 33 );

    }

    @Test
    public void insert() throws Exception {

        MyPriorityQueue<Patient> pqueue = new MyPriorityQueue<Patient>();
        Patient patient1 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34);
        pqueue.insert(patient1);

    }

    @Test
    public void remove() throws Exception {

        MyPriorityQueue<Patient> pqueue = new MyPriorityQueue<Patient>();
        Patient patient1 = new Patient(4, LocalDateTime.of(2017, 4, 12, 10, 20, 30), 34 );
        Patient patient2 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 24 );
        pqueue.insert(patient1);
        pqueue.insert(patient2);
        assertEquals(pqueue.remove(), patient2);

    }

    @Test
    public void front() throws Exception {

        MyPriorityQueue<Patient> pqueue = new MyPriorityQueue<Patient>();
        Patient patient1 = new Patient(5, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );
        Patient patient2 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 34, 30), 32 );

        pqueue.insert(patient1);
        pqueue.insert(patient2);

        assertEquals(pqueue.front(), patient2);

        Patient patient3 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 15, 30), 33 );
        pqueue.insert(patient3);
        assertEquals(pqueue.front(), patient3);
    }

    @Test
    public void isEmpty() throws Exception {
        MyPriorityQueue<Patient> pqueue = new MyPriorityQueue<Patient>();
        assertEquals(pqueue.isEmpty(), true);

        Patient patient1 = new Patient(3, LocalDateTime.of(2017, 4, 12, 10, 20, 30), 34 );
        pqueue.insert(patient1);
        assertEquals(pqueue.isEmpty(), false);

        pqueue.remove();
        assertEquals(pqueue.isEmpty(), true);

    }

    @Test
    public void testForwardTraversal() throws Exception {

        MyPriorityQueue<Patient> pqueue = new MyPriorityQueue<Patient>();
        Patient patient1 = new Patient(5, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );
        Patient patient2 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 34, 30), 32 );
        Patient patient3 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 15, 30), 24 );
        pqueue.insert(patient1);
        pqueue.insert(patient2);
        pqueue.insert(patient3);


        List<Patient> forward;
        forward = pqueue.testForwardTraversal();
        Iterator<Patient> iter = forward.iterator();

        System.out.println("Forward traverse:");
        Patient patientTraverse;
        while (iter.hasNext()) {
            patientTraverse = iter.next();
            System.out.println(patientTraverse.UrgencyLevel);
            System.out.println(patientTraverse.ArriveTime);
            System.out.println(patientTraverse.TreatmentTime);
        }
    }

    @Test
    public void testReverseTraversal() throws Exception {

        MyPriorityQueue<Patient> pqueue = new MyPriorityQueue<Patient>();
        Patient patient1 = new Patient(4, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );
        Patient patient2 = new Patient(2, LocalDateTime.of(2017, 3, 12, 10, 34, 30), 32 );
        Patient patient3 = new Patient(4, LocalDateTime.of(2017, 3, 12, 10, 20, 20), 24 );
        pqueue.insert(patient1);
        pqueue.insert(patient2);
        pqueue.insert(patient3);

        List<Patient> backward;
        backward = pqueue.testReverseTraversal();
        Iterator<Patient> iter = backward.iterator();

        System.out.println("Reverse traverse:");
        Patient patientTraverse;
        while (iter.hasNext()) {
            patientTraverse = iter.next();
            System.out.println(patientTraverse.UrgencyLevel);
            System.out.println(patientTraverse.ArriveTime);
            System.out.println(patientTraverse.TreatmentTime);
        }

    }

}