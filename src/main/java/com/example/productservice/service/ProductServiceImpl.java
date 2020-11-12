package com.example.productservice.service;

import com.example.productservice.dao.BrandRepository;
import com.example.productservice.dao.ProductRepository;
import com.example.productservice.model.Brand;
import com.example.productservice.model.Product;
import com.example.productservice.model.mapper.MapperFacade;
import com.example.productservice.serviceinterface.ProductService;
import com.example.productservice.view.ProductSave;
import com.example.productservice.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final MapperFacade mapperFacade;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, BrandRepository brandRepository,
                              MapperFacade mapperFacade) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public void save(ProductSave productSave) {
        try {
            Product product = mapperFacade.map(productSave, Product.class);
            Brand brand = brandRepository.findByName(productSave.getBrand())
                    .orElseThrow(() -> new NoSuchElementException("Brand not found."));
            product.setBrandId(brand);
            productRepository.save(product);
        }catch (NoSuchElementException e) {
            throw new RuntimeException("Brand non found", e);
        }
    }

    @Override
    public void update(ProductView productView) {
        try {
            Product product = mapperFacade.map(productView, Product.class);
            Brand brand = brandRepository.findByName(productView.getBrand())
                    .orElseThrow(() -> new NoSuchElementException("Brand not found."));
            product.setBrandId(brand);
            productRepository.save(product);
        }catch (NoSuchElementException e){
            throw new RuntimeException("Brand non found", e);
        }
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductView findByName(String name) {
        try{
        Product product = productRepository.findByName(name)
                .orElseThrow(()->new NoSuchElementException("Product not found."));
        return mapperFacade.map(product, ProductView.class);
        }catch (NoSuchElementException e){
            throw new RuntimeException("Product non found", e);
        }
    }

    @Override
    public List<ProductView> findByBrand(String brand) {
        try {
            Brand brand1 = brandRepository.findByName(brand)
                    .orElseThrow(() -> new NoSuchElementException("Brand not found."));
            List<Product> products = productRepository.findAllByBrandId(brand1)
                    .orElseThrow(() -> new NoSuchElementException("Products by this brand not found."));
            return mapperFacade.mapAsList(products, ProductView.class);
        }catch (NoSuchElementException e){
            throw new RuntimeException("Value non found", e);
        }
    }

    @Override
    public List<ProductView> findLeftovers() {
        try {
            List<Product> products = productRepository.findProductsByQuantityIsLessThan(5)
                    .orElseThrow(() -> new NoSuchElementException("No leftovers found."));
            return mapperFacade.mapAsList(products, ProductView.class);
        }catch (NoSuchElementException e){
            throw new RuntimeException("Leftovers non found", e);
        }
    }
}
