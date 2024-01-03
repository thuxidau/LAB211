import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task {
    private int id;
    private String requireName, taskTypeID, date, assignee, reviewer;
    private double planFrom, planTo;
    
    private static int countID = 0;
    private Scanner sc = new Scanner(System.in);
    private Validation v = new Validation();
    public Task() {
    }

    public Task(int id, String requireName, String taskTypeID, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.requireName = requireName;
        this.taskTypeID = taskTypeID;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public String getRequireName() {
        return requireName;
    }

    public String getTaskTypeID() {
        return taskTypeID;
    }

    public String getDate() {
        return date;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setId(int id) throws Exception {
        if(id < 0){
            throw new Exception("ID cannot be negative");
        }
        this.id = id;
    }

    public void setRequireName(String requireName) throws Exception {
        if(requireName.isEmpty()){
            throw new Exception("Name cannot be empty");
        }
        if(!requireName.matches("[a-zA-Z ]+")){
            throw new Exception("Name cannot contain special character");
        }
        this.requireName = requireName;
    }

    public void setTaskTypeID(String taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public void setDate(String date) throws Exception {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date d = format.parse(date);
            if(!date.equalsIgnoreCase(format.format(d))){
                throw new Exception("Invalid date");
            } 
        } catch (NumberFormatException e) {
            throw new Exception("Invalid date");
        } catch (ParseException e){
            throw new Exception("Invalid date");
        }
        this.date = date;
    }

    public void setAssignee(String assignee) throws Exception {
        if(assignee.isEmpty()){
            throw new Exception("Assignee cannot be empty");
        }
        if(!assignee.matches("[a-zA-Z ]+")){
            throw new Exception("Assignee cannot contain special character");
        }
        this.assignee = assignee;
    }

    public void setReviewer(String reviewer) throws Exception {
        if(reviewer.isEmpty()){
            throw new Exception("Reviewer cannot be empty");
        }
        if(reviewer.matches(".*[^a-zA-Z0-9 ].*")){
            throw new Exception("Reviewer cannot contain special character");
        }
        this.reviewer = reviewer;
    }

    public void setPlanFrom(double planFrom) throws Exception {
        if(planFrom < 8.0 || planFrom > 17.5){
            throw new Exception("Must be between 8.0 and 17.5");
        }
        this.planFrom = planFrom;
    }

    public void setPlanTo(double planTo) throws Exception {
        if(planTo < 8.0 || planTo > 17.5){
            throw new Exception("Must be between 8.0 and 17.5");
        }
        if(planTo < planFrom){
            throw new Exception("Must be greater than plan from");
        }
        this.planTo = planTo;
    }
    
    public Task createTask() throws Exception {
        setId(++countID);
        
        while (true){
            try {
                System.out.print("Requirement Name: ");
                setRequireName(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.println("1	Code\n" + "2	Test\n" + "3	Design\n" + "4	Review ");
                System.out.print("Task Type: ");
                int choice = v.checkInputTaskType();
                switch(choice){
                    case 1: setTaskTypeID("Code"); break;
                    case 2: setTaskTypeID("Test"); break;
                    case 3: setTaskTypeID("Design"); break;
                    case 4: setTaskTypeID("Review"); break;
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Date: ");
                setDate(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("From (Must be between 8.0 and 17.5): ");
                setPlanFrom(Double.parseDouble(sc.nextLine().trim()));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("To (Must be between 8.0 and 17.5 and greater than from): ");
                setPlanTo(Double.parseDouble(sc.nextLine().trim()));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Assignee: ");
                setAssignee(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Reviewer: ");
                setReviewer(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return new Task(id, requireName, taskTypeID, date, planFrom, planTo, assignee, reviewer);
    }
    
    public void display(){
        System.out.printf("%-5s%-15s%-15s%-15s%-10s%-10s%-10s\n", id, requireName, taskTypeID, date, planTo - planFrom ,assignee, reviewer);
    }
}