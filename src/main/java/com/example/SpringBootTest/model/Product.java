package com.example.SpringBootTest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "entryDate")
    private LocalDate entryDate;

    @Column(name = "itemCode")
    @Pattern(regexp = "^\\d{5}$", message = "Incorrect format of item code")
    private String itemCode;

    @Column(name = "itemName")
    @Size(min = 2, max = 30, message = "Item name have to contain  more than 2 symbols")
    private String itemName;

    @Column(name = "itemQuantity")
    private int itemQuantity;

    @Column(name = "status")
    private String status;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return itemQuantity == product.itemQuantity && Objects.equals(id, product.id) && Objects.equals(entryDate, product.entryDate) && Objects.equals(itemCode, product.itemCode) && Objects.equals(itemName, product.itemName) && Objects.equals(status, product.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entryDate, itemCode, itemName, itemQuantity, status);
    }
}
