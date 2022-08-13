package com.service;

import com.models.Product;
import com.repository.ProductRepository;

import java.util.Map;


public abstract class ProductService<T extends Product> {

    private ProductRepository<T> repository;

    public ProductService(ProductRepository<T> repository) {
        this.repository = repository;
    }

    public abstract T createAndSaveProducts(Map<String,String> map);
}

