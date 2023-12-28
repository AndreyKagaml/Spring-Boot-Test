package com.example.SpringBootTest.dto;

import com.example.SpringBootTest.model.Product;
import com.example.SpringBootTest.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.format.DateTimeFormatter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductResponse {
    Long id;
    String entryDate;
    String itemCode;

    String itemName;

    String itemQuantity;

    String status;
    public ProductResponse(Product product) {
        id = product.getId();
        entryDate = product.getEntryDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        itemCode = product.getItemCode();
        itemName = product.getItemName();
        itemQuantity = product.getItemQuantity() + "";
        status = product.getStatus();
    }
}
