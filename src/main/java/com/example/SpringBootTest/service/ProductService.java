package com.example.SpringBootTest.service;

import com.example.SpringBootTest.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAll();
}
