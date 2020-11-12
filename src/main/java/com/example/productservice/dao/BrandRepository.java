package com.example.productservice.dao;

import com.example.productservice.model.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Optional<Brand> findByName (String name);
}
