package com.example.productservice.model.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReverseMapperFacadeImpl implements MapperFacade {
    private final MapperFactory mapperFactory;

    @Autowired
    public ReverseMapperFacadeImpl(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    @Override
    public <S, Product> Product map(S sourceObject, Class<Product> destinationClass) {
        mapperFactory.classMap(sourceObject.getClass(), destinationClass)
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade().map(sourceObject, destinationClass);
    }

    @Override
    public <Product, D> void map(Product sourceObject, D destinationObject) {
        mapperFactory.classMap(sourceObject.getClass(), destinationObject.getClass())
                .byDefault()
                .register();
        mapperFactory.getMapperFacade().map(sourceObject, destinationObject);
    }

    @Override
    public <Product, D> List<D> mapAsList(Iterable<Product> source, Class<D> destinationClass) {
        mapperFactory.classMap(source.getClass(), destinationClass)
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade().mapAsList(source, destinationClass);
    }
}
