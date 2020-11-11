package com.example.productservice.model.mapper;

import com.example.productservice.model.Product;
import com.example.productservice.view.ProductSave;
import com.example.productservice.view.ProductView;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomMapperFactory  {
    @Bean
    public MapperFactory mapperFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder()
                .constructorResolverStrategy(null)
                .build();
        mapperFactory.classMap(Product.class, ProductView.class)
                .field("brandId.name", "brand")
                .byDefault()
                .register();
        mapperFactory.classMap(ProductSave.class, Product.class)
                .byDefault()
                .register();
        return mapperFactory;
    }
}
