package Service;

import Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductStorage {
    private static ArrayList<Product> products;
    public ProductStorage(){
        products = new ArrayList<>();
        products.add(new Product("PRD001","AK47","/images/AK-47.jpg",25000));
        products.add(new Product("PRD002","AK47","/images/AK-47.jpg",40000));
        products.add(new Product("PRD003","AK47","/images/AK-47.jpg",30000));
        products.add(new Product("PRD004","AK47","/images/AK-47.jpg",60000));
        products.add(new Product("PRD005","M4A1","/images/M4A1.jpg",50000));
        products.add(new Product("PRD006","M4A1","/images/M4A1.jpg",25000));
        products.add(new Product("PRD007","M60","/images/M60.jpg",50000));
        products.add(new Product("PRD008","RPK","/images/RPK.jpg",50000));
    }

    public List<Product> findAll(){
        return products;
    }
    public void save(Product product){
        products.add(product);
    }
    public Product findByID(String id){
        int index= 0;
        for(int i = 0; i < products.size();i++){
            if(products.get(i).getId().equals(id)){
                index=i;
                break;
            }
        }
        return products.get(index);
    }
    public void update(String id, Product product){
        int index= 0;
        for(int i = 0; i < products.size();i++){
            if(products.get(i).getId().equals(id)){
                index=i;
                break;
            }
        }
        products.set(index, product);
    }
    public void remove(String id){
        int index= 0;
        for(int i = 0; i < products.size();i++){
            if(products.get(i).getId().equals(id)){
                index=i;
                break;
            }
        }
        products.remove(index);
    }
}
