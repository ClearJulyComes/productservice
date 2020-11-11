package com.example.productservice.serviceinterface;

import com.example.productservice.view.ProductSave;
import com.example.productservice.view.ProductView;

import java.util.List;

public interface ProductService {
    void save (ProductSave productSave);
    void update (ProductView productView);
    void delete (int id);
    ProductView findByName (String name);
    List<ProductView> findByBrand (String brand);
    List<ProductView> findLeftovers ();
}
