import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentList sl = new StudentList();
        Validation v = new Validation();
        int choice, size = 0;
        while(true){
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    while (true){
                        while (true){
                            Student student = new Student();
                            boolean isAdded = sl.checkValidStudent(student.createStudent());
                            if(isAdded){
                                sl.addStudent(student);
                                System.out.println("Student added successfully.");
                                size++;
                            } else {
                                System.out.println("Student may be duplicated or has invalid ID and name");
                            }
                            if(size >= 3) break;
                        }
                        System.out.print("Do you want to continue (y/n)?: ");
                        if(!v.checkInputYN()) break;
                    }                                    
                    break;
                case 2:
                    String findName;
                    while (true){
                        try {
                            System.out.print("Enter student name or part of name: ");
                            findName = v.checkInputString();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    StudentList result = sl.findStudent(findName);
                    if(result == null){
                        System.out.println("Cannot find student.");
                    } else {
                        System.out.printf("%-5s|%-15s|%-10s|%-10s\n", "ID", "Name", "Semester", "Course");
                        result.sortStudent();
                        result.displayStudent();
                    }
                    break;
                case 3:
                    int studentId;
                    while (true){
                        try {
                            System.out.print("Enter student ID: ");
                            studentId = v.checkInputInt();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    Student resultt = sl.findStudentByID(studentId);
                    if(resultt == null){
                        System.out.println("Cannot find student.");
                    } else {
                        System.out.print("Do you want to update (U) or delete (D) student?: ");

                        if (v.checkInputUD()) {
                            Student s = new Student();
                            boolean isUpdated = sl.checkValidStudentToUpdate(s.updateStudent(studentId), studentId);
                            if(isUpdated){
                                sl.updateStudent(s);
                                System.out.println("Student updated successfully.");
                            } else {
                                System.out.println("Student may be duplicated or has invalid ID and name");
                            }
                        } else {
                            sl.deleteStudent(studentId);
                            System.out.println("Student deleted successfully.");
                        }
                    }
                    break;
                case 4:
                    System.out.printf("%-10s|%-10s|%-10s\n", "Name", "Course", "Total course");
                    Map<String, Map<String, Integer>> report = sl.reportStudent();
                    StudentList.displayReport(report);
                    break;
                case 5:
                    System.out.println("Program end!");
                    System.exit(0);
                default: 
                    System.out.println("Invalid choice");
            }
        }   
    }
}