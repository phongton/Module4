package com.codegym.cart.service;

import com.codegym.cart.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);


}
