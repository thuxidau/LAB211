import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        EmployeeList el = new EmployeeList();
        Validation v = new Validation();
        
        while (true){
            System.out.println( "1. Add employees \n" +
                                "2. Update employees\n" +
                                "3. Remove employees\n" +
                                "4. Search employees\n" +
                                "5. Sort employees by salary\n" +
                                "6. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    Employee e1 = new Employee();
                    boolean isAdded = el.checkExistedEmployee(e1.createEmployee());
                    if(isAdded){
                        el.addEmployee(e1);
                        System.out.println("Employee added successfully.");
                    } else {
                        System.out.println("ID already existed.");
                    }
                    break;
                case 2:
                    String findID;
                    while (true){
                        try {
                            System.out.print("Enter ID to find: ");
                            findID = v.checkInputString();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    Employee result = el.findEmployeeByID(findID);
                    if(result == null){
                        System.out.println("ID not found.");
                    } else {
                        Employee e2 = new Employee();
                        el.updateEmployee(e2.updateInfo(findID));
                        System.out.println("Employee updated successfully.");
                    }
                    break;
                case 3:
                    while (true){
                        try {
                            System.out.print("Enter ID to find: ");
                            findID = v.checkInputString();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    
                    Employee resultt = el.findEmployeeByID(findID);
                    if(resultt == null){
                        System.out.println("ID not found.");
                    } else {
                        el.deleteEmployee(findID);
                        System.out.println("Employee deleted successfully.");
                    }
                    break;
                case 4:
                    String name;
                    while (true){
                        try {
                            System.out.print("Enter name or part of name to find: ");
                            name = v.checkInputString();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    EmployeeList resulttt = el.findEmployeeByName(name);
                    if(resulttt == null){
                        System.out.println("Name not found.");
                    } else {
                        System.out.printf("%-5s%-15s%-15s%-15s%-25s%-15s%-15s%-10s%-15s%-10s\n", "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
                        resulttt.displayEmployee();
                    }
                    break;
                case 5:
                    el.sortEmployeeBySalary();
                    System.out.printf("%-5s%-15s%-15s%-15s%-25s%-15s%-15s%-10s%-15s%-10s\n", "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
                    el.displayEmployee();
                    break;
                case 6:
                    System.out.println("Program ended!");
                    System.exit(0);
                default: System.out.println("Invalid choice.");
            }
        }
    }
}