import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        TaskList tl = new TaskList();
        Validation v = new Validation();
        
        while (true){
            System.out.println("=========Task Program=========");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    Task newTask = new Task();
                    tl.addTask(newTask.createTask());
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    int id;
                    System.out.println("---------Del Task---------");
                    while (true){
                        try {
                            System.out.print("ID: ");
                            id = v.checkInputID();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    Task result = tl.findByID(id);

                    if(result == null){
                        System.out.println("ID not found");
                    } else {
                        tl.deleteTask(id);
                        System.out.println("Deleted successfully.");
                    }
                    break;
                case 3:
                    if(tl.checkEmpty()){
                        System.out.println("Nothing to show");
                    }
                    else {
                        System.out.println("---------------------Task---------------------");
                        System.out.printf("%-5s%-15s%-15s%-15s%-10s%-10s%-10s\n", "ID", "Name", "Task Type", "Date", "Time" ,"Assignee", "Reviewer");
                        tl.getDataTasks();
                    }
                    break;
                case 4:
                    System.out.println("Program ended!");
                    System.exit(0);
                default: System.out.println("Invalid choice.");
            }
        }
    }
}