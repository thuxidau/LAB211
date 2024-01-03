import java.util.*;
public class Validation {
    private Scanner sc = new Scanner(System.in);
    
    public String checkInputString() throws Exception{
        while (true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                throw new Exception("Invalid");
            } else if(result.matches(".*[^a-zA-Z0-9 ].*")){
                throw new Exception("Cannot contain special character");
            } 
            else return result;
        }
    }
}