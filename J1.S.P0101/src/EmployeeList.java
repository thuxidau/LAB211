import java.util.*;
public class EmployeeList {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
    
    public Employee findEmployeeByID(String id) {
        for (Employee employee : employeeList) {
            if(employee.getId().equalsIgnoreCase(id)){
               return employee;
            }
        }
        return null;
    }
    
    public void updateEmployee(Employee employee) throws Exception {
        for (Employee e : employeeList) {
            if(e.equals(findEmployeeByID(employee.getId()))){
                e.setFirstName(employee.getFirstName());
                e.setLastName(employee.getLastName());
                e.setPhone(employee.getPhone());
                e.setEmail(employee.getEmail());
                e.setAddress(employee.getAddress());
                e.setDob(employee.getDob());
                e.setSex(employee.getSex());
                e.setSalary(employee.getSalary());
                e.setAgency(employee.getAgency());
                break;
            }
        }
    }
    
    public void deleteEmployee(String id) {
        for (Employee employee : employeeList) {
            if(employee.equals(findEmployeeByID(id))){
                employeeList.remove(employee);
                break;
            }
        }
    }
    
    public EmployeeList findEmployeeByName(String name) {
        EmployeeList result = new EmployeeList();
        boolean check = true;
        for (Employee employee : employeeList) {
            if(employee.getFirstName().contains(name) || employee.getLastName().contains(name)){
                check = false;
                result.addEmployee(employee);
            }
        }
        if(check) return null;
        else return result;
    }
    
    public void displayEmployee(){
        for (Employee employee : employeeList) {
            employee.display();
        }
    }
    
    public void sortEmployeeBySalary() {
        Collections.sort(employeeList, Comparator.comparing(Employee::getSalary));
    }
    
    public boolean checkExistedEmployee(Employee employee){
        for (Employee e : employeeList) {
            if(e.getId().equalsIgnoreCase(employee.getId())){
                return false;
            }
        }
        return true;
    }
}