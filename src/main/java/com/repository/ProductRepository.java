package com.repository;

import com.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository<T extends Product> {
    void save(T t);
    List<T> getAll();
}
