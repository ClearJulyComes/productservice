package com.example.productservice.model.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewMapperFacadeImpl implements MapperFacade {

    private final MapperFactory mapperFactory;

    @Autowired
    public ViewMapperFacadeImpl(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    @Override
    public <Product, D> D map(Product sourceObject, Class<D> destinationClass) {
        mapperFactory.classMap(sourceObject.getClass(), destinationClass)
                .field("brandId.name", "brand")
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade().map(sourceObject, destinationClass);
    }

    @Override
    public <Product, D> void map(Product sourceObject, D destinationObject) {
        mapperFactory.classMap(sourceObject.getClass(), destinationObject.getClass())
                .field("brandId.name", "brand")
                .byDefault()
                .register();
        mapperFactory.getMapperFacade().map(sourceObject, destinationObject);
    }

    @Override
    public <Product, D> List<D> mapAsList(Iterable<Product> source, Class<D> destinationClass) {
        mapperFactory.classMap(source.getClass(), destinationClass)
                .field("brandId.name", "brand")
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade().mapAsList(source, destinationClass);
    }
}
