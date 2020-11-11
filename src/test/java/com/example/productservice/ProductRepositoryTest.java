package com.example.productservice;

import com.example.productservice.dao.ProductRepository;
import com.example.productservice.model.Brand;
import com.example.productservice.model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByName_returnProduct(){
        Product actual = productRepository.findByName("Shoes");
        Assert.assertEquals(1000, actual.getPrice());
    }

    @Test
    public void whenFindLeftovers_returnList(){
        Brand brand1 = new Brand(1, "First brand");
        Brand brand2 = new Brand(2, "Second brand");
        Product product1 = new Product(1, "Shoes", 1000, 3, brand1);
        Product product2 = new Product(2, "Laptop", 20000, 2, brand2);
        List<Product> expected = new ArrayList<>();
        expected.add(product1);
        expected.add(product2);

        List<Product> actual = productRepository.findProductsByQuantityIsLessThan(5);

        Assert.assertEquals(expected.toString(), actual.toString());
    }
}
