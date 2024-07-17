package com.codegym.btss4.repository.impl;

import com.codegym.btss4.model.Product;
import com.codegym.btss4.repository.IProductRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    private static List<Product> productList = new ArrayList<>();
    static {

        productList.add(new Product(1, "Product 1", 10.99, "Description for product 1", "Manufacturer A"));
        productList.add(new Product(2, "Product 2", 12.49, "Description for product 2", "Manufacturer B"));
        productList.add(new Product(3, "Product 3", 8.99, "Description for product 3", "Manufacturer C"));
        productList.add(new Product(4, "Product 4", 15.99, "Description for product 4", "Manufacturer D"));
        productList.add(new Product(5, "Product 5", 9.49, "Description for product 5", "Manufacturer E"));
        productList.add(new Product(6, "Product 6", 14.99, "Description for product 6", "Manufacturer F"));
        productList.add(new Product(7, "Product 7", 7.99, "Description for product 7", "Manufacturer G"));
        productList.add(new Product(8, "Product 8", 11.99, "Description for product 8", "Manufacturer H"));
        productList.add(new Product(9, "Product 9", 13.49, "Description for product 9", "Manufacturer I"));
        productList.add(new Product(10, "Product 10", 16.99, "Description for product 10", "Manufacturer J"));
    }


    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        product.setId(productList.get(productList.size()-1).getId() + 1);
        productList.add(product);

    }

    @Override
    public Product findById(int id) {
        for(Product product : productList){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (Product product1 : productList) {
            if (product.getId() == id) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setDescription(product.getDescription());
                product1.setProducer(product.getProducer());
                break;
            }
        }

    }

    @Override
    public void remove(int id) {
//        Iterator<Product> iterator = productList.iterator();
//        while (iterator.hasNext()) {
//            Product product = iterator.next();
//            if (product.getId() == id) {
//                iterator.remove();
//            }
//        }
        productList.removeIf(product -> product.getId() == id);

    }

    @Override
    public Product findByName(String name) {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                return product;

            }
        }
        return null;
    }

}
