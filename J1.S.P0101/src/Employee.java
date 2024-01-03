import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Employee {
    private String id, firstName, lastName, phone, email, address, dob, sex, agency;
    private double salary;
    private Scanner sc = new Scanner(System.in);
    
    public Employee() {
    }

    public Employee(String id, String firstName, String lastName, String phone, String email, String address, String dob, String sex, double salary, String agency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
        this.agency = agency;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public String getSex() {
        return sex;
    }

    public String getAgency() {
        return agency;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(String id) throws Exception {
        if(id.isEmpty()){
            throw new Exception("ID cannot be empty");
        }
        if(id.matches(".*[^a-zA-Z0-9 ].*")){
            throw new Exception("ID cannot contain special character");
        }
        this.id = id;
    }

    public void setFirstName(String firstName) throws Exception {
        if(firstName.isEmpty()){
            throw new Exception("First name cannot be empty");
        }
        if(!firstName.matches("[a-zA-Z]+")){
            throw new Exception("First name cannot contain special character");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws Exception {
        if(lastName.isEmpty()){
            throw new Exception("Last name cannot be empty");
        }
        if(!lastName.matches("[a-zA-Z]+")){
            throw new Exception("Last name cannot contain special character");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) throws Exception {
        if(phone.isEmpty()){
            throw new Exception("Phone cannot be empty");
        }
        if(!phone.matches("\\d{10}")){
            throw new Exception("Invalid phone number");
        }
        this.phone = phone;
    }

    public void setEmail(String email) throws Exception {
        if(email.isEmpty()){
            throw new Exception("Email cannot be empty");
        }
        if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            throw new Exception("Invalid email. Email must be in format abc@abc.com");
        }
        this.email = email;
    }

    public void setAddress(String address) throws Exception {
        if(address.isEmpty()){
            throw new Exception("Address cannot be empty");
        }
        if(address.matches(".*[^a-zA-Z0-9 ].*")){
            throw new Exception("Address cannot contain special character");
        }
        this.address = address;
    }

    public void setDob(String dob) throws Exception {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = format.parse(dob);
            if(!dob.equalsIgnoreCase(format.format(date))){
                throw new Exception("Invalid DOB");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid DOB");
        } catch (ParseException e){
            throw new Exception("Invalid DOB");
        }
        this.dob = dob;
    }

    public void setSex(String sex) throws Exception {
        if(sex.isEmpty()){
            throw new Exception("Sex cannot be empty");
        }
        if(!sex.equalsIgnoreCase("M") && !sex.equalsIgnoreCase("F") && !sex.equalsIgnoreCase("Other")){
            throw new Exception("Invalid sex");
        }
        this.sex = sex;
    }

    public void setAgency(String agency) throws Exception {
        if(agency.isEmpty()){
            throw new Exception("Agency cannot be empty");
        }
        if(agency.matches(".*[^a-zA-Z0-9 ].*")){
            throw new Exception("Agency cannot contain special character");
        }
        this.agency = agency;
    }

    public void setSalary(double salary) throws Exception {
        if(salary < 0){
            throw new Exception("Salary must be positive");
        }
        this.salary = salary;
    }
    
    public Employee createEmployee() throws Exception {  
        while (true){
            try {
                System.out.print("Enter id: ");
                setId(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter first name: ");
                setFirstName(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter last name: ");
                setLastName(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter phone: ");
                setPhone(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter email: ");
                setEmail(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter address: ");
                setAddress(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter DOB (dd-MM-yyyy): ");
                setDob(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter sex (M/F/Other): ");
                setSex(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter salary: ");
                setSalary(Double.parseDouble(sc.nextLine().trim()));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter agency: ");
                setAgency(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency);
    }
    
    public Employee updateInfo(String id) throws Exception {
        this.id = id;
        
        while (true){
            try {
                System.out.print("Enter new first name: ");
                setFirstName(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter new last name: ");
                setLastName(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter new phone: ");
                setPhone(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter new email: ");
                setEmail(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter new address: ");
                setAddress(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter new DOB (dd-MM-yyyy): ");
                setDob(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter new sex (M/F/Other): ");
                setSex(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter new salary: ");
                setSalary(Double.parseDouble(sc.nextLine().trim()));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        while (true){
            try {
                System.out.print("Enter new agency: ");
                setAgency(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency);
    }
    
    public void display(){
        System.out.printf("%-5s%-15s%-15s%-15s%-25s%-15s%-15s%-10s%-15s%-10s\n", id, firstName, lastName, phone, email, address, dob, sex, salary, agency);
    }
}