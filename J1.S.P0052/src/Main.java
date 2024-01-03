import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        ManageEastAsiaCountries m = new ManageEastAsiaCountries();
        Validation Validation = new Validation();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("\tMENU");
            System.out.println("=====================");
            System.out.println("1. Enter the information for 11 countries in Southeast Asia.\n" + "2. Display already information.\n" + "3. Search the country according to the entered country's name.\n" + "4. Display the information increasing with the country name.\n" + "5. Exit.");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1: 
                    EastAsiaCountries eas = new EastAsiaCountries();
                    m.addCountryInformation(eas.createCountry());
                    System.out.println("Country added successfully.");
                    break;
                case 2: 
                    if(m.checkEmptyList()) System.out.println("List empty.");
                    else {
                        System.out.printf("%-10s%-25s%-20s%-15s\n", "ID", "Name", "Total Area", "Terrain");
                        m.displayCountry();
                    }
                    break;
                case 3: 
                    if(m.checkEmptyList()) System.out.println("List empty.");
                    else {
                        System.out.print("Enter the country name you want to search: ");
                        String findName = Validation.checkInputString();
                        ManageEastAsiaCountries meas = m.searchInformationByName(findName);
                        if(meas == null){
                            System.out.println(findName + " not found");
                        } else {
                            System.out.printf("%-10s%-25s%-20s%-15s\n", "ID", "Name", "Total Area", "Terrain");
                            meas.displayAllCountry();
                        }
                    }
                    break;
                case 4: 
                    if(m.checkEmptyList()) System.out.println("List empty.");
                    else {
                        System.out.printf("%-10s%-25s%-20s%-15s\n", "ID", "Name", "Total Area", "Terrain");
                        m.sortInformationByAscendingOrder();
                        m.displayAllCountry();
                    }
                    break;
                case 5: System.err.println("Program ended."); System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}