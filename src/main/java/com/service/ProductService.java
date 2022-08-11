package com.service;

import com.models.Product;
import com.repository.ProductRepository;


public abstract class ProductService<T extends Product> {

    private ProductRepository<T> repository;

    public ProductService(ProductRepository<T> repository) {
        this.repository = repository;
    }

    public void createProduct(T t) {
        repository.save(t);
    }

    public void printAll() {
        repository.getAll().forEach(System.out::println);
    }
}
