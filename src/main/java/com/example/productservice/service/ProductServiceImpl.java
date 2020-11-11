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
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        Product product = mapperFacade.map(productSave, Product.class);
        Brand brand = brandRepository.findByName(productSave.getBrand());
        product.setBrandId(brand);
        productRepository.save(product);
    }

    @Override
    public void update(ProductView productView) {
        Product product = mapperFacade.map(productView, Product.class);
        Brand brand = brandRepository.findByName(productView.getBrand());
        product.setBrandId(brand);
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductView findByName(String name) {
        Product product = productRepository.findByName(name);
        return mapperFacade.map(product, ProductView.class);
    }

    @Override
    public List<ProductView> findByBrand(String brand) {
        Brand brand1 = brandRepository.findByName(brand);
        List<Product> products = productRepository.findAllByBrandId(brand1);
        return mapperFacade.mapAsList(products, ProductView.class);
    }

    @Override
    public List<ProductView> findLeftovers() {
        List<Product> products = productRepository.findProductsByQuantityIsLessThan(5);
        return mapperFacade.mapAsList(products, ProductView.class);
    }
}
