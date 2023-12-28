package com.example.SpringBootTest.service.implementation;

import com.example.SpringBootTest.exception.EntityErrorException;
import com.example.SpringBootTest.model.Product;
import com.example.SpringBootTest.repository.ProductRepository;
import com.example.SpringBootTest.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
            return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
