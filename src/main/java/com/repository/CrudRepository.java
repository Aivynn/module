package com.repository;

import com.models.Product;

import java.util.List;

public interface CrudRepository<T extends Product> {
    void save(T t);
    void update(T t);
    void get(T t);
    void delete(T t);
    List<T> getAll();
}
