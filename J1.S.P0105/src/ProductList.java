import java.util.*;
public class ProductList {
    private ArrayList<Product> productList = new ArrayList<>();

    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    public void addProduct(Product product) throws Exception {
        productList.add(product);
    }
    
    public Product findProductByID(String id){
        for (Product product : productList) {
            if(product.getId().equalsIgnoreCase(id)){
                return product;
            }
        }
        return null;
    }
    
    public void updateProduct(Product product) throws Exception {
        for (Product p : productList) {
            if(p.equals(findProductByID(product.getId()))){
                p.setName(product.getName());
                p.setLocation(product.getLocation());
                p.setPrice(product.getPrice());
                p.setExpiryDate(product.getExpiryDate());
                p.setDateOfManufacture(product.getDateOfManufacture());
                p.setCategory(product.getCategory());
                p.setStorekeeper(product.getStorekeeper());
                p.setReceiptDate(product.getReceiptDate());
                break;
            }
        }
    }
    
    public ProductList searchProduct(String str) throws Exception{
        ProductList pl = new ProductList();
        boolean check = true;
        for (Product p : productList) {
            if(p.getName().equalsIgnoreCase(str) || p.getCategory().equalsIgnoreCase(str)
            || p.getStorekeeper().equalsIgnoreCase(str) || p.getReceiptDate().equalsIgnoreCase(str)){
                check = false;
                pl.addProduct(p);
            }  
        }
        if(check) return null;
        return pl;
    }
    
    public void sortProduct(){
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
               if(o1.getExpiryDate().equalsIgnoreCase(o2.getExpiryDate())){
                   return o1.getDateOfManufacture().compareTo(o2.getDateOfManufacture());
               } else {
                   return o1.getExpiryDate().compareTo(o2.getExpiryDate());
               }
            }
        });
    }
    
    public void displayProduct(){
        for (Product product : productList) {
            product.display();
        }
    }
}