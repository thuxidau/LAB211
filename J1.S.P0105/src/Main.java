import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        ProductList pl = new ProductList();
        StoreKeeperList skl = new StoreKeeperList();
        Scanner sc = new Scanner(System.in);
        Validation v = new Validation();
        
        while (true){
            System.out.println("1. Add Storekeeper\n" +
                               "2. Add product\n" +
                               "3. Update product\n" +
                               "4. Search product by Name, Category, Storekeeper, ReceiptDate\n" +
                               "5. Sort product by Expiry date, Date of manufacture\n" + 
                               "6. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    StoreKeeper sk = new StoreKeeper();
                    skl.addStoreKeeper(sk.createStoreKeeper(skl));
                    System.out.println("Store keeper added successfully.");
                    System.out.println("Store keeper list");
                    skl.displayStoreKeeper();
                    break;
                case 2:
                    Product p = new Product();
                    pl.addProduct(p.createProduct(pl,skl));
                    System.out.println("Product added successfully.");
                    break;
                case 3:
                    String id;
                    while (true){
                        try {
                            System.out.print("Enter ID to update: ");
                            id = v.checkInputString();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    Product foundID = pl.findProductByID(id);
                    if(foundID == null){
                        System.out.println(id + " not found");
                    } else {
                        Product pro = new Product();
                        pl.updateProduct(pro.updateInfor(skl,id));
                        System.out.println("Product updated successfully.");
                    }
                    break;
                case 4:
                    String str;
                    while (true){
                        try {
                            System.out.print("Enter Name, Category, Storekeeper or ReceiptDate: ");
                            str = v.checkInputString();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    ProductList found = pl.searchProduct(str);
                    if(found == null){
                        System.out.println("Cannot find anything about " + str);
                    } else {
                        System.out.printf("%-5s%-15s%-15s%-10s%-15s%-25s%-10s%-15s%-15s\n", "ID", "Name", "Location", "Price", "Expiry Date", "Date of Manufacture", "Category", "Storekeeper", "Receipt Date");
                        found.displayProduct();
                    }
                    break;
                case 5:
                    pl.sortProduct();
                    System.out.printf("%-5s%-15s%-15s%-10s%-15s%-25s%-10s%-15s%-15s\n", "ID", "Name", "Location", "Price", "Expiry Date", "Date of Manufacture", "Category", "Storekeeper", "Receipt Date");
                    pl.displayProduct();
                    break;
                case 6:
                    System.out.println("Program ended.");
                    System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}