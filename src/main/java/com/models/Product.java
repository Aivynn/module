package com.models;

import lombok.Getter;

@Getter
public abstract class Product {
    private String series;
    private String screenType;
    private double price;
    private final ProductType type;

    public Product(String series, String screenType, double price, ProductType type) {
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
