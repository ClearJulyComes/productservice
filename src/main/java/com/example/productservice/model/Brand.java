package com.example.productservice.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 50, unique = true)
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "brandId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand() {
    }
}
