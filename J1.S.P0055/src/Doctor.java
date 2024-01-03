public class Doctor {
    private String code, name, specialization;
    private int availability;

    public Doctor() {
    }

    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
    
    public Doctor inputDoctor(){
        Validation Validation = new Validation();
        System.out.print("Enter code: ");
        setCode(Validation.checkInputString());
        
        System.out.print("Enter name: ");
        setName(Validation.checkInputString());
        
        System.out.print("Enter specialization: ");
        setSpecialization(Validation.checkInputString());
        
        System.out.print("Enter availability: ");
        setAvailability(Validation.checkInputInt());
        
        return new Doctor(code, name, specialization, availability);
    }
    
    public Doctor updateInfo(String code){
        Validation Validation = new Validation();
        this.code = code;
        
        System.out.print("Enter new name: ");
        setName(Validation.checkInputString());
        
        System.out.print("Enter new specialization: ");
        setSpecialization(Validation.checkInputString());
        
        System.out.print("Enter new availability: ");
        setAvailability(Validation.checkInputInt());
        
        return new Doctor(code, name, specialization, availability);
    }
    
    public void display(){
        System.out.printf("%-15s%-20s%-25s%-20s\n", code, name, specialization, availability);
    }
}
