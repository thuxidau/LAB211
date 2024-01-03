import java.util.Scanner;
public class Validation {
    DoctorHash dh = new DoctorHash();
    Scanner sc = new Scanner(System.in);
    
    public String checkInputString(){
        while (true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.out.print("Invalid. Enter again: ");
            } else return result;
        }
    }
    
    public int checkInputInt(){
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < 0) System.out.println("Availability must be greater than 0.");
                else return result;
            } catch (NumberFormatException e) {
                System.out.print("Invalid. Enter again: ");
            }
        }
    }
}