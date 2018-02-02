package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by xwenfei on 10/2/17.
 */
public class PatientTest {

    private Patient patient1;

    @Before
    public void setUp() throws Exception {
        Patient patient1 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 100 );

    }

    @Test
    public void getArriveTime() throws Exception {
        Patient patient1 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 100 );
        assertEquals(patient1.getArriveTime(), LocalDateTime.of(2017, 3, 12, 10, 20, 30));
        System.out.println(patient1.ArriveTime);
    }

    @Test
    public void getUrgencyLevel() throws Exception {
        Patient patient1 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 100 );
        assertEquals(patient1.getUrgencyLevel(), 3);
    }

    @Test
    public void getTreatmentTime() throws Exception {
        Patient patient1 = new Patient(3, LocalDateTime.of(2017, 3, 12, 10, 20, 30), 100 );
        assertEquals(patient1.getTreatmentTime(), 100);
    }

}