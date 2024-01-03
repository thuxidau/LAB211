import java.util.Scanner;

public class StoreKeeper {
    private String storeKeeperName;
    private Scanner sc = new Scanner(System.in);
    private Validation v = new Validation();

    public StoreKeeper() {
    }

    public StoreKeeper(String storeKeeperName) {
        this.storeKeeperName = storeKeeperName;
    }

    public String getStoreKeeperName() {
        return storeKeeperName;
    }

    public void setStoreKeeperName(String storeKeeperName) throws Exception {
        if(storeKeeperName.isEmpty()){
            throw new Exception("Store keeper name cannot be empty");
        }
        if(!storeKeeperName.matches("[a-zA-Z]+")){
            throw new Exception("Store keeper name cannot contain special character");
        }
        this.storeKeeperName = storeKeeperName;
    }
    
    public StoreKeeper createStoreKeeper(StoreKeeperList sklist) throws Exception {
        while (true){
            try {
                System.out.print("Enter store keeper name: ");
                setStoreKeeperName(v.getSkName(sklist));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new StoreKeeper(storeKeeperName);
    }
    
    public void display(){
        System.out.printf("%-15s\n", storeKeeperName);
    }
}
