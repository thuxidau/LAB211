import java.util.Scanner;
public class Validation {
    private Scanner sc = new Scanner(System.in);
    
    public String checkInputString() throws Exception{
        while (true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                throw new Exception("Invalid.");
            } else if(!result.matches("[a-zA-Z ]+")){
                throw new Exception("Name cannot contain special character");
            }
            else return result;
        }
    }
    
    public int checkInputInt(){
        while (true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < 0){
                    throw new Exception("Invalid.");
                } else return result;
            } catch (Exception e) {
                throw new NumberFormatException("Invalid. Try again: ");
            }
        }
    }
    
    public boolean checkInputYN() throws Exception{
        while (true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("y")) return true;
            else if(result.equalsIgnoreCase("n")) return false;
            else throw new Exception("Invalid.");
        }
    }
    
    public boolean checkInputUD() throws Exception{
        while (true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("u")) return true;
            else if(result.equalsIgnoreCase("d")) return false;
            else throw new Exception("Invalid.");
        }
    }
}