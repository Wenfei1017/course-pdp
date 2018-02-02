import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;


public class PatientGenerator{
    private LocalDateTime currentTime;
    private PriorityQueue<Patient> patientList1;

    public PatientGenerator(){
        currentTime = LocalDateTime.now();
    }

    public Patient getPatient() throws Exception {
        Random random = new Random();
        long interval = Math.abs(random.nextLong());
        int level = random.nextInt(10);
        long treattime = random.nextInt(480);
        Patient patient = new Patient(this.currentTime,level,treattime);
        return patient;
    }
}
