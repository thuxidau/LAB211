import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DoctorHash d = new DoctorHash();
        Validation Validation = new Validation();
        while (true){
            System.out.println("=========Doctor Management=========");
            System.out.println("1. Add Doctor\n" + "2. Update Doctor.\n" + "3. Delete Doctor\n" + "4. Search Doctor.\n" + "5. Display\n" + "6. Exit.");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            
            switch (choice){
                case 1:
                    try {
                        System.out.println("---------Add Doctor---------");
                        Doctor doc = new Doctor();
                        boolean isAdded = d.addDoctor(doc.inputDoctor());
                        if(isAdded){
                            System.out.println("Doctor added successfully.");
                        }
                        else {
                            System.out.println("Failed to add doctor.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        System.out.println("---------Update Doctor---------");
                        System.out.print("Enter code: ");
                        String checkCode = Validation.checkInputString();
                        Doctor doc = new Doctor();
                        boolean isUpdated = d.updateDoctor(doc.updateInfo(checkCode));
                        if(isUpdated){
                            System.out.println("Doctor updated successfully.");
                        } else {
                            System.out.println("Failed to update doctor.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }                    
                    break;
                case 3: 
                    try {
                        System.out.println("---------Delete Doctor---------");
                        System.out.print("Enter code: ");
                        String delCode = Validation.checkInputString();
                        boolean isDeleted = d.deleteDoctor(delCode);
                        if(isDeleted){
                            System.out.println("Doctor deleted successfully.");
                        } else {
                            System.out.println("Failed to delete doctor.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } 
                    break;
                case 4: 
                    try {
                        System.out.println("---------Search Doctor---------");
                        System.out.print("Enter text: ");
                        String searchCode = Validation.checkInputString();
                        
                        DoctorHash dh = d.searchDoctor(searchCode);
                        if(dh == null) System.out.println("Cannot find doctor.");
                        else {
                            System.out.printf("%-15s%-20s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
                            dh.displayDoctor();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 5: 
                    try {
                        System.out.printf("%-15s%-20s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
                        d.displayDoctor();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 6: System.out.println("Program ended!"); System.exit(0);
                default: System.out.println("Invalid chocie.");
            }
        }
    }
}