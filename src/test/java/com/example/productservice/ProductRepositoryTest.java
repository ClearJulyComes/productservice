package com.example.productservice;

import com.example.productservice.dao.ProductRepository;
import com.example.productservice.model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
