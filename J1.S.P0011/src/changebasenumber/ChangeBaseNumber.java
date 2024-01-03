package changebasenumber;
import java.util.Scanner;
public class ChangeBaseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter the base of the input number");
            int inputBase = sc.nextInt();
            
            System.out.println("Enter the base of the output number");
            int outputBase = sc.nextInt();
            
            while(true){
                System.out.print("Input value: ");
                String inputValue = sc.next().toUpperCase();
                try{
                    Number num = new Number(inputValue, inputBase);
                    System.out.println("Output: " + num.conversion(outputBase));
                } catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
                System.out.println("Input another value? (y/n)");
                String choice1 = sc.next();
                if(choice1.equalsIgnoreCase("n")) break;
            }
            System.out.println("Continue?? (y/n)");
            String choice2 = sc.next();
            if(choice2.equalsIgnoreCase("n")) break;
        }
        
    }
}
