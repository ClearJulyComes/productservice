package com.example.productservice.view;

import lombok.Data;

@Data
public class ProductView {
    private int id;
    private String name;
    private String brand;
    private int price;
    private int quantity;

    public ProductView(int id, String name, String brand, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductView() {
    }
}
