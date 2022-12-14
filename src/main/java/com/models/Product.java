package com.models;

import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@Getter
public abstract class Product {

    protected String id;
    protected String series;
    protected String screenType;
    protected double price;

    protected final ProductType type;

    public Product(String series, String screenType, double price, ProductType type) {
        id = UUID.randomUUID().toString();
        this.series = series;
        this.screenType = screenType;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "series='" + series + '\'' +
                ", screenType='" + screenType + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
