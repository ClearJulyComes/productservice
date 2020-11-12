package com.example.productservice.dao;

import com.example.productservice.model.Brand;
import com.example.productservice.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Optional<Product> findByName(String name);
    Optional<List<Product>> findAllByBrandId(Brand brand);
    Optional<List<Product>> findProductsByQuantityIsLessThan(int f);
}
