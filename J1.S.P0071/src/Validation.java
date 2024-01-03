import java.util.Scanner;
public class Validation {
    private Scanner sc = new Scanner(System.in);
    
    public int checkInputTaskType(){
        while (true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < 1 || result > 4){
                    throw new Exception("Must be between 1 and 4. Try again: ");
                } else return result;
            } catch (Exception e) {
                throw new NumberFormatException("Invalid. Try again.");
            }
        }
    }
    
    public int checkInputID(){
        while (true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < 0){
                    throw new Exception("ID cannot be negative");
                } else return result;
            } catch (Exception e) {
                throw new NumberFormatException("Invalid. Try again.");
            }
        }
    }
}