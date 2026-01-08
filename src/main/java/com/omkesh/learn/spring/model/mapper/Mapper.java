package com.omkesh.learn.spring.model.mapper;

public interface Mapper<V, T> {
    T mappingToEntity(V dao);

    V mappingFromEntity(T entity);
}
