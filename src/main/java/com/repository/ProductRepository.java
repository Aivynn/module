package com.repository;

import com.models.Product;

import java.util.List;
public interface ProductRepository<T extends Product> {
    void save(T t);
    List<T> getAll();
}
