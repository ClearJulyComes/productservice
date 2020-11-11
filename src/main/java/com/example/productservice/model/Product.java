package com.example.productservice.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "price", nullable = false)
    private  int price;
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brandId;

    public Product(int id, String name, int price, int quantity, Brand brandId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.brandId = brandId;
    }

    public Product() {
    }
}
