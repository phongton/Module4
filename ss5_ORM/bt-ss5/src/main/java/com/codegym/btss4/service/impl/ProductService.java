package com.codegym.btss4.service.impl;

import com.codegym.btss4.model.Product;
import com.codegym.btss4.repository.IProductRepo;
import com.codegym.btss4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo repo;
    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public Product findById(int id) {
        return repo.findById(id);
    }

    @Override
    public void update(int id, Product product) {
            repo.update(id, product);
    }

    @Override
    public void remove(int id) {
        repo.remove(id);
    }

    @Override
    public Product findByName(String name) {
        return repo.findByName(name);
    }
}
