package com.codegym.btss4.repository.impl;

import com.codegym.btss4.model.Product;
import com.codegym.btss4.repository.IProductRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    private List<Product> productList = new ArrayList<>();



    @Override
    public List<Product> findAll() {
        productList=BaseRepository.entityManager.createQuery("from products", Product.class).getResultList();
        return productList;
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();

    }

    @Override
    public Product findById(int id) {
       return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(int id, Product product) {
       EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
       transaction.begin();
       BaseRepository.entityManager.merge(product);
       transaction.commit();

    }

    @Override
    public void remove(int id) {
    EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
    transaction.begin();
    Product product = BaseRepository.entityManager.find(Product.class, id);
    BaseRepository.entityManager.remove(product);
    transaction.commit();

    }

    @Override
    public Product findByName(String name) {
   return BaseRepository.entityManager.find(Product.class, name);
    }

}
