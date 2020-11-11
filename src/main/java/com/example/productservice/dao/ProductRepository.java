package com.example.productservice.dao;

import com.example.productservice.model.Brand;
import com.example.productservice.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findByName(String name);
    List<Product> findAllByBrandId(Brand brand);
    List<Product> findProductsByQuantityIsLessThan(int f);
}
