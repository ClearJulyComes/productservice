package com.example.productservice.view;

import lombok.Data;

@Data
public class ProductView {
    private int id;
    private String name;
    private String brand;
    private int price;
    private int quantity;
}
