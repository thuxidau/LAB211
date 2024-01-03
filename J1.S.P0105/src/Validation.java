import java.util.Scanner;
public class Validation {
    private Scanner sc = new Scanner(System.in);
    
    public String checkInputString() throws Exception{
        while (true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                throw new Exception("Invalid");
            } else if(result.matches(".*[^a-zA-Z0-9 ].*")){
                throw new Exception("Cannot contain special character");
            } 
            else return result;
        }
    }
    
    public String getID(ProductList product) throws Exception{
        while (true){
            String id = checkInputString();
            boolean check = true;
            for (Product p : product.getProductList()) {
                if(p.getId().equalsIgnoreCase(id)){
                    check = false;
                    System.out.print("ID already existed. Try again: ");
                }
            }
            if(check) return id;
        }
    }
    
    public String getStorekeeperName(StoreKeeperList sklist) throws Exception{
        while (true){
            String name = checkInputString();
            boolean check = true;
            for (StoreKeeper p : sklist.getSkList()) {
                if(sklist.findStoreKeeper(name) == null){
                    check = false;
                    System.out.print("Name is not existed. Try again: ");
                }
            }
            if(check) return name;
        }
    }
    
    public String getSkName(StoreKeeperList sklist) throws Exception{
        while (true){
            String name = checkInputString();
            boolean check = true;
            for (StoreKeeper p : sklist.getSkList()) {
                if(sklist.findStoreKeeper(name) != null){
                    check = false;
                    System.out.print("Name is existed. Try again: ");
                }
            }
            if(check) return name;
        }
    }
}
