package com.service;

import com.models.Product;
import com.repository.CrudRepository;


public abstract class ProductService<T extends Product> {

    private CrudRepository<T> repository;

    public ProductService(CrudRepository<T> repository) {
        this.repository = repository;
    }

    public void createProduct(T t) {
        repository.save(t);
    }

    public void printAll() {
        repository.getAll().forEach(System.out::println);
    }
}
