import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String id, name, location, expiryDate, dateOfManufacture, category, storekeeper, ReceiptDate;
    private int price;
    private Scanner sc = new Scanner(System.in);
    private Validation v = new Validation();

    public Product() {
    }

    public Product(String id, String name, String location, int price, String expiryDate, String dateOfManufacture, String category, String storekeeper, String ReceiptDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.expiryDate = expiryDate;
        this.dateOfManufacture = dateOfManufacture;
        this.category = category;
        this.storekeeper = storekeeper;
        this.ReceiptDate = ReceiptDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public String getCategory() {
        return category;
    }

    public String getStorekeeper() {
        return storekeeper;
    }

    public String getReceiptDate() {
        return ReceiptDate;
    }

    public int getPrice() {
        return price;
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

    public void setName(String name) throws Exception {
        if(name.isEmpty()){
            throw new Exception("Name cannot be empty");
        }
        if(!name.matches("[a-zA-Z]+")){
            throw new Exception("Name cannot contain special character");
        }
        this.name = name;
    }

    public void setLocation(String location) throws Exception{
        if(location.isEmpty()){
            throw new Exception("Location cannot be empty");
        }
        if(!location.matches("[a-zA-Z]+")){
            throw new Exception("Location cannot contain special character");
        }
        this.location = location;
    }

    public void setExpiryDate(String expiryDate) throws Exception{
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = format.parse(expiryDate);
            if(!expiryDate.equalsIgnoreCase(format.format(date))){
                throw new Exception("Invalid date");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid date");
        } catch (ParseException e){
            throw new Exception("Invalid date");
        }
        this.expiryDate = expiryDate;
    }

    public void setDateOfManufacture(String dateOfManufacture) throws Exception{
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = format.parse(dateOfManufacture);
            if(!dateOfManufacture.equalsIgnoreCase(format.format(date))){
                throw new Exception("Invalid date");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid date");
        } catch (ParseException e){
            throw new Exception("Invalid date");
        }
        this.dateOfManufacture = dateOfManufacture;
    }

    public void setCategory(String category) throws Exception{
        if(category.isEmpty()){
            throw new Exception("Category cannot be empty");
        }
        if(!category.matches("[a-zA-Z]+")){
            throw new Exception("Category cannot contain special character");
        }
        this.category = category;
    }

    public void setStorekeeper(String storekeeper) throws Exception{
        if(storekeeper.isEmpty()){
            throw new Exception("Store keeper name cannot be empty");
        }
        if(!storekeeper.matches("[a-zA-Z]+")){
            throw new Exception("ID cannot contain special character");
        }
        this.storekeeper = storekeeper;
    }

    public void setReceiptDate(String ReceiptDate) throws Exception{
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = format.parse(ReceiptDate);
            if(!ReceiptDate.equalsIgnoreCase(format.format(date))){
                throw new Exception("Invalid date");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid date");
        } catch (ParseException e){
            throw new Exception("Invalid date");
        }
        this.ReceiptDate = ReceiptDate;
    }

    public void setPrice(int price) throws Exception{
        if(price < 0){
            throw new Exception("Price must be positive");
        }
        this.price = price;
    }
    
    public Product createProduct(ProductList plist, StoreKeeperList sklist) throws Exception {
        while (true){
            try {
                System.out.print("Enter id: ");
                setId(v.getID(plist));
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
                System.out.print("Enter location: ");
                setLocation(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print("Enter price: ");
                setPrice(Integer.parseInt(sc.nextLine().trim()));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print("Enter expiry date: ");
                setExpiryDate(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print("Enter date of manufacture: ");
                setDateOfManufacture(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print("Enter category: ");
                setCategory(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print("Enter storekeeper: ");
                setStorekeeper(v.getStorekeeperName(sklist));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print("Enter receipt date: ");
                setReceiptDate(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return new Product(id, name, location, price, expiryDate, dateOfManufacture, category, storekeeper, ReceiptDate);
    }
    
    public Product updateInfor(StoreKeeperList sklist, String id) throws Exception {
        this.id = id;
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
                System.out.print("Enter location: ");
                setLocation(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print("Enter price: ");
                setPrice(Integer.parseInt(sc.nextLine().trim()));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print("Enter expiry date: ");
                setExpiryDate(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print("Enter date of manufacture: ");
                setDateOfManufacture(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print("Enter category: ");
                setCategory(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print("Enter storekeeper: ");
                setStorekeeper(v.getStorekeeperName(sklist));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print("Enter receipt date: ");
                setReceiptDate(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return new Product(id, name, location, price, expiryDate, dateOfManufacture, category, storekeeper, ReceiptDate);
    }
    
    public void display(){
        System.out.printf("%-5s%-15s%-15s%-10s%-15s%-25s%-10s%-15s%-15s\n", id, name, location, price, expiryDate, dateOfManufacture, category, storekeeper, ReceiptDate);
    }
}