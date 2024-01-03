import java.util.Scanner;
public class Validation {
    Scanner sc = new Scanner(System.in);
    ManageEastAsiaCountries meas = new ManageEastAsiaCountries();
    public String checkInputString(){
        while (true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.out.print("Invalid. Enter again: ");
            } else return result;
        }
    }
    
    public double checkInputDouble(){
        while (true){
            try{
                double result = Double.parseDouble(sc.nextLine().trim());
                if(result < 0) System.out.println("Total area must be greater than 0");
                else return result;
            } catch (NumberFormatException e) {
                System.out.print("Invalid. Enter again: ");
            }
        }
    }
}
