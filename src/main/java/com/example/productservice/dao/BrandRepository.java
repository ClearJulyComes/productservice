package com.example.productservice.dao;

import com.example.productservice.model.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Brand findByName (String name);
}
