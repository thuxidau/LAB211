import java.util.*;

public class StudentList {
    private ArrayList<Student> studentList = new ArrayList<>();
    
    public void addStudent(Student student){
        studentList.add(student);
    }
    
    public StudentList findStudent (String name) {
        StudentList result = new StudentList();
        boolean check = true;
        for (Student s : studentList) {
            if (s.getName().contains(name)) {
                result.addStudent(s);
                check = false;
            }
        }
        if(!check) return result;
        else return null;
    }
    
    public void sortStudent () {
        Collections.sort(studentList, Comparator.comparing(Student::getName));
    }
    
    public void updateStudent (Student student) throws Exception {
        for (Student s : studentList) {
            if(s.equals(findStudentByID(student.getId()))){
                s.setName(student.getName());
                s.setSemester(student.getSemester());
                s.setCourse(student.getCourse());
                break;
            }
        }
    }
    
    public void deleteStudent(int id) {
        for (Student student : studentList) {
            if(student.equals(findStudentByID(id))){
                studentList.remove(student);
                break;
            }
        }
    }
    
    public Map<String, Map<String, Integer>> reportStudent() {
        Map<String, Map<String, Integer>> report = new HashMap<>();
        for (Student s : studentList) {
            String name = s.getName();
            String course = s.getCourse();
            if (!report.containsKey(name)) {
                report.put(name, new HashMap<>());
            }
            Map<String, Integer> courses = report.get(name);
            if (!courses.containsKey(course)) {
                courses.put(course, 0);
            }
            courses.put(course, courses.get(course) + 1);
        }
        return report;
    }
    
    public static void displayReport(Map<String, Map<String, Integer>> report){
        for (String nameKey : report.keySet()) {
            Map<String, Integer> courses = report.get(nameKey);
            for (String courseKey : courses.keySet()) {
                int totalCourses = courses.get(courseKey);
                System.out.printf("%-10s|%-10s|%-10s\n", nameKey, courseKey, totalCourses);
            }
        }
    }
    
    public void displayStudent(){
        for (Student student : studentList) {
            student.display();
        }
    }
    
    public boolean checkValidStudent(Student student){
        for (Student s : studentList) {
            if(s.equals(findStudentByID(student.getId())) || (s.getId() == student.getId() && !s.getName().equalsIgnoreCase(student.getName()))){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkValidStudentToUpdate(Student student, int id) throws Exception {
        for (Student s : studentList) {
            if(s.equals(findStudentByID(id))) continue;
            if(s.equals(findStudentByID(student.getId())) || s.getId() == student.getId() && !s.getName().equalsIgnoreCase(student.getName())){
                return false;
            }
        }
        return true;
    }
    
    public Student findStudentByID (int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}