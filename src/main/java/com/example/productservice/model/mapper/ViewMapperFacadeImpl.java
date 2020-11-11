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
    public <S, D> D map(S sourceObject, Class<D> destinationClass) {
        mapperFactory.classMap(sourceObject.getClass(), destinationClass)
                .field("brandId.name", "brand")
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade().map(sourceObject, destinationClass);
    }

    @Override
    public <S, D> void map(S sourceObject, D destinationObject) {
        mapperFactory.classMap(sourceObject.getClass(), destinationObject.getClass())
                .field("brandId.name", "brand")
                .byDefault()
                .register();
        mapperFactory.getMapperFacade().map(sourceObject, destinationObject);
    }

    @Override
    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
        mapperFactory.classMap(source.getClass(), destinationClass)
                .field("brandId.name", "brand")
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade().mapAsList(source, destinationClass);
    }
}
