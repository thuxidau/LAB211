import java.util.*;
public class StoreKeeperList {
    private ArrayList<StoreKeeper> skList = new ArrayList<>();

    public ArrayList<StoreKeeper> getSkList() {
        return skList;
    }
    
    public void addStoreKeeper(StoreKeeper sk) throws Exception {
        skList.add(sk);
    }
    
    public StoreKeeper findStoreKeeper(String name){
        for (StoreKeeper storeKeeper : skList) {
            if(storeKeeper.getStoreKeeperName().equalsIgnoreCase(name)){
                return storeKeeper;
            }
        }
        return null;
    }
    
    public void displayStoreKeeper(){
        for (StoreKeeper storeKeeper : skList) {
            storeKeeper.display();
        }
    }
}