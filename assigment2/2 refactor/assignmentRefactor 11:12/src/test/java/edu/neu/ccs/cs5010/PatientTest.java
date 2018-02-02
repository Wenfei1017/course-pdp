package edu.neu.ccs.cs5010;

import java.time.LocalDateTime;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by xwenfei on 10/2/17.
 */
public class PatientTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Patient patient1;

    @Test
    public void constructorUrgent1Exception() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("patient urgency must be 0 - 10");
        Patient nullPatient = new Patient(-1, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 32);
    }

    @Test
    public void constructorUrgent2Exception() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("patient urgency must be 0 - 10");
        Patient nullPatient = new Patient(Patient.MAX_Urgency + 1,
                LocalDateTime.of(2017, 3, 12, 10, 20, 30), 32);
    }

    @Test
    public void constructorArriveException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Arrival time illegal");
        Patient nullPatient = new Patient(4, null, 32);
    }

    @Test
    public void constructorTreatException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Treatment time illegal");
        Patient nullPatient = new Patient(4, LocalDateTime.of(2017, 3, 12, 10, 20, 30),
                Patient.MAX_Treatment + 1);
    }

    @Test
    public void getArriveTime() throws Exception {
        patient1 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );
        assertEquals(patient1.getArriveTime(), LocalDateTime.of(2017, 3, 12, 10, 20, 30));
        System.out.println(patient1.arriveTime);
    }

    @Test
    public void getUrgencyLevel() throws Exception {
        Patient patient1 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );
        assertEquals(patient1.getUrgencyLevel(), 3);
    }

    @Test
    public void getTreatmentTime() throws Exception {
        Patient patient1 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );
        assertEquals(patient1.getTreatmentTime(), 34);
    }

    @Test
    public void compareException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("patient is null");
        Patient patient1 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );
        patient1.compareTo(null);
    }

    @Test
    public void compareTest() throws Exception {
        Patient patient1 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );
        Patient patient2 = new Patient(5, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 34 );
        Patient patient3 = new Patient(5, LocalDateTime.of(2017, 3, 12, 11, 20, 30), 34 );
        assertEquals(patient1.compareTo(patient2), -2);
        assertEquals(patient2.compareTo(patient3), patient2.arriveTime.compareTo(patient3.arriveTime));
    }

}