import java.util.*;
public class DoctorHash {
    private HashMap<String, Doctor> doctorDatabase = new HashMap<>();
    
    public boolean addDoctor (Doctor doctor) throws Exception {
        if(doctorDatabase.isEmpty()){
            throw new Exception("Database does not exist");
        }
        if(doctor == null){
            throw new Exception("Data does not exist");
        }
        if(doctorDatabase.containsKey(doctor.getCode())){
            throw new Exception("Doctor code [" + doctor.getCode() + "] is duplicate");
        }
        doctorDatabase.put(doctor.getCode(), doctor);
        return true;
    }
    
    public boolean updateDoctor (Doctor doctor) throws Exception{
        if(doctorDatabase.isEmpty()){
            throw new Exception("Database does not exist");
        }
        if(doctor == null){
            throw new Exception("Data does not exist");
        }
        if(!doctorDatabase.containsKey(doctor.getCode())){
            throw new Exception("Doctor code doesn’t exist");
        }
        doctorDatabase.put(doctor.getCode(), doctor);
        return true;
    }
    
    public boolean deleteDoctor (String code) throws Exception{
        if(doctorDatabase.isEmpty()){
            throw new Exception("Database does not exist");
        }
        if(!doctorDatabase.containsKey(code)){
            throw new Exception("Doctor code doesn't exist.");
        }
        doctorDatabase.remove(code);
        return true;
    }
    
    public DoctorHash searchDoctor (String input) throws Exception{
        if(doctorDatabase.isEmpty()){
            throw new Exception("Database does not exist");
        }
        DoctorHash dh = new DoctorHash();
        boolean check = true;
        for (Doctor d : doctorDatabase.values()) {
            if(d.getName().contains(input) || d.getSpecialization().contains(input)){
                dh.addDoctor(d);
                check = false;
            }
        }
        if(check) return null;
        return dh;
    }
    
    public void displayDoctor(){
        for (Doctor d : doctorDatabase.values()) {
            d.display();
        }
    }
}