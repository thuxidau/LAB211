import java.util.Scanner;

public class Student {
    private String name;
    private int semester;
    private String course;
    private int id;
    
    private Scanner sc = new Scanner(System.in);
    public Student() {
    }
    
    public Student(int id, String name, int semester, String course) {
        this.name = name;
        this.semester = semester;
        this.course = course;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourse() {
        return course;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) throws Exception {
        if(name.isEmpty()){
            throw new Exception("Name cannot be empty");
        }
        if(!name.matches("[a-zA-Z ]+")){
            throw new Exception("Name cannot contain special character");
        }
        this.name = name;
    }

    public void setSemester(int semester) throws Exception {
        if(semester <= 0){
            throw new Exception("Semester must be positive");
        }
        this.semester = semester;
    }

    public void setCourse(String course) throws Exception {
        if(course.isEmpty()){
            throw new Exception("ID cannot be empty");
        }
        if(!course.equalsIgnoreCase("java") && !course.equalsIgnoreCase(".net") && !course.equalsIgnoreCase("c/c++")){
            throw new Exception("Course doesn't exist");
        }
        this.course = course;
    }

    public void setId(int id) throws Exception {
        if(id <= 0){
            throw new Exception("ID must be positive");
        }
        this.id = id;
    }
    
    public Student createStudent() throws Exception{
        while (true){
            try {
                System.out.print("Enter ID: ");
                setId(Integer.parseInt(sc.nextLine().trim()));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter name: ");
                setName(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter semester: ");
                setSemester(Integer.parseInt(sc.nextLine().trim()));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter course (Java, .Net, C/C++): ");
                setCourse(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return new Student(id, name, semester, course);
    }
    
    public Student updateStudent(int id) throws Exception {
        this.id = id;
        
        while (true){
            try {
                System.out.print("Enter new name: ");
                setName(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter new semester: ");
                setSemester(Integer.parseInt(sc.nextLine().trim()));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter new course (Java, .Net, C/C++): ");
                setCourse(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return new Student(id, name, semester, course);
    }
    
    public void display(){
        System.out.printf("%-5s|%-15s|%-10s|%-10s\n", id, name, semester, course);
    }
}