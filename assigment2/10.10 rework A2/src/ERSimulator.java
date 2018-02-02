import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ERSimulator {
    private PriorityQueue patientList1;
    private PriorityQueue patientList2;
    private PriorityQueue roomList;
    private LocalDateTime endTime;

    public ERSimulator(){
        patientList1 = new PriorityQueue<Patient>();
        patientList2 = new PriorityQueue<Patient>();
        roomList = new PriorityQueue<TreatRoom>();
    }



    /**
     * treat patient emulator
     */
    public void emulator2(){//get enter time
        patientList2.insert(patientList1.front());
        LocalDateTime enterTime = LocalDateTime.now();
        Patient patientEnter = (Patient) patientList1.remove();//the patient in the patient queue get into treat room
        roomList.remove();//the first room in the treat room queue is occupied now
    }

    public void departure(){
        while(LocalDateTime.now().isBefore(endTime)){
            if(LocalDateTime.now().isEqual(this.emulator2().plusMinutes())){

            }
        }
    }
}
