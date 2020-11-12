package com.example.productservice;

import com.example.productservice.dao.BrandRepository;
import com.example.productservice.dao.ProductRepository;
import com.example.productservice.model.Brand;
import com.example.productservice.model.Product;
import com.example.productservice.model.mapper.CustomMapperFactory;
import com.example.productservice.model.mapper.MapperFacade;
import com.example.productservice.model.mapper.ViewMapperFacadeImpl;
import com.example.productservice.service.ProductServiceImpl;
import com.example.productservice.view.ProductSave;
import com.example.productservice.view.ProductView;
import ma.glasnost.orika.MapperFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CustomMapperFactory.class, ProductServiceImpl.class, ViewMapperFacadeImpl.class})
public class ProductServiceTest {

    @TestConfiguration
    static class TestConfigProductService {
        @Bean
        @Primary
        public ProductRepository productRepository(){
            return Mockito.mock(ProductRepository.class);
        }
        @Bean
        @Primary
        public BrandRepository brandRepository(){
            return Mockito.mock(BrandRepository.class);
        }

        @Bean
        public MapperFacade mapperFacade(MapperFactory mapperFactory){
            return new ViewMapperFacadeImpl(mapperFactory);
        }
    }

    @MockBean
    private BrandRepository brandRepository;
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Test
    public void whenSave_returnSuccess (){
        ProductSave productSave = new ProductSave();
        productSave.setName("Socks");
        productSave.setBrand("First brand");
        productSave.setPrice(400);
        productSave.setQuantity(4);
        Brand brand = new Brand();
        brand.setId(1);
        brand.setName("First brand");
        Product expected = new Product();
        expected.setName("Socks");
        expected.setBrandId(brand);
        expected.setPrice(400);
        expected.setQuantity(4);
        Mockito.when(brandRepository.findByName(productSave.getBrand())).thenReturn(Optional.of(brand));
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(expected);

        productServiceImpl.save(productSave);

        Mockito.verify(productRepository).save(expected);
    }

    @Test
    public void whenGetByName_returnProduct() {
        Brand brand = new Brand(1, "Test brand");
        Product product = new Product(1, "Test", 1000, 3, brand);
        ProductView expected = new ProductView(1, "Test", "Test brand", 1000, 3);
        Mockito.when(productRepository.findByName("Test")).thenReturn(Optional.of(product));
        ProductView actual = productServiceImpl.findByName("Test");
        Assert.assertEquals(expected, actual);
    }
}
