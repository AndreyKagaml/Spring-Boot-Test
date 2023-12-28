package com.example.SpringBootTest.controller;

import com.example.SpringBootTest.dto.ProductResponse;
import com.example.SpringBootTest.dto.UserResponse;
import com.example.SpringBootTest.model.Product;
import com.example.SpringBootTest.model.User;
import com.example.SpringBootTest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse save(@RequestBody Product product) {
        return new ProductResponse(productService.addProduct(product));
    }

    @GetMapping("/all")
    public List<ProductResponse> getAll() {
        return productService.getAll().stream()
                .map(ProductResponse::new)
                .toList();
    }
}