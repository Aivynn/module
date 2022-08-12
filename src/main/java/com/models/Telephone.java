package com.models;

import lombok.Getter;

@Getter
public class Telephone extends Product {

    private final String model;

    public Telephone(String series, String screenType, double price, String model) {
        super(series, screenType, price, ProductType.TELEPHONE);
        this.model = model;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "series='" + series + '\'' +
                ", screenType='" + screenType + '\'' +
                ", price=" + price +
                ", type=" + type +
                "model='" + model + '\'' +
                '}';
    }
}
