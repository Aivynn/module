package com.repository;

import com.models.Invoice;
import com.models.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ShopRepository implements IShop<Invoice>{

    private final List<Invoice> products;

    private static ShopRepository instance;

    public static ShopRepository getInstance() {
        if (instance == null) {
            instance = new ShopRepository();
        }
        return instance;
    }

    public ShopRepository() {
        products = new LinkedList<>();
    }

    @Override
    public void save(Invoice product) {
        if (Optional.ofNullable(product).isPresent()) {
            products.add(product);
        }
        else{
            throw new IllegalArgumentException("The object is null");
        }

    }

    @Override
    public List<Invoice> getAll() {
        return products;
    }

    @Override
    public void printAll() {
        for(Invoice p : products) {
            System.out.println(p);
        }
    }
}
